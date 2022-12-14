package co.edu.utp.misiontic.nelsoncruz.controller;

import java.sql.SQLException;
import java.util.List;

import co.edu.utp.misiontic.nelsoncruz.exception.EfectivoInsuficienteException;
import co.edu.utp.misiontic.nelsoncruz.model.EstadoPedido;
import co.edu.utp.misiontic.nelsoncruz.model.Mesa;
import co.edu.utp.misiontic.nelsoncruz.model.OpcionCarne;
import co.edu.utp.misiontic.nelsoncruz.model.OpcionEnsalada;
import co.edu.utp.misiontic.nelsoncruz.model.OpcionJugo;
import co.edu.utp.misiontic.nelsoncruz.model.OpcionPrincipio;
import co.edu.utp.misiontic.nelsoncruz.model.OpcionSopa;
import co.edu.utp.misiontic.nelsoncruz.model.dao.MesaDao;
import co.edu.utp.misiontic.nelsoncruz.model.dao.OpcionAlimentoDao;
import co.edu.utp.misiontic.nelsoncruz.model.dao.PedidoDao;
import co.edu.utp.misiontic.nelsoncruz.view.MesaView;
import co.edu.utp.misiontic.nelsoncruz.view.PedidoView;

public class RestauranteControlador {

    private PedidoView pedidoView;
    private MesaView mesaView;

    private MesaDao mesaDao;
    private OpcionAlimentoDao<OpcionSopa> sopaDao;
    private OpcionAlimentoDao<OpcionPrincipio> principioDao;
    private OpcionAlimentoDao<OpcionCarne> carneDao;
    private OpcionAlimentoDao<OpcionEnsalada> ensaladaDao;
    private OpcionAlimentoDao<OpcionJugo> jugoDao;
    private PedidoDao pedidoDao;

    public RestauranteControlador() {
        this.pedidoView = new PedidoView();
        this.mesaView = new MesaView();

        this.mesaDao = new MesaDao();
        this.sopaDao = new OpcionAlimentoDao<>("OpcionSopa");
        this.principioDao = new OpcionAlimentoDao<>("OpcionPrincipio");
        this.carneDao = new OpcionAlimentoDao<>("OpcionCarne");
        this.ensaladaDao = new OpcionAlimentoDao<>("OpcionEnsalada");
        this.jugoDao = new OpcionAlimentoDao<>("OpcionJugo");
        this.pedidoDao = new PedidoDao();
    }

    public void agregarPedidoAMesa() {
        try {
            // Seleccionar una mesa
            var mesa = pedidoView.seleccionarMesa(listarMesas());

            // Pedir la informacion del pedido
            var pedido = pedidoView.pedirInformacionPedido(listarSopas(), listarPrincipios(), listarCarnes(),
                    listarEnsaladas(), listarJugos());

            // Agregar el pedido a la mesa
            pedidoDao.adicionarPedidoMesa(mesa, pedido);
            pedidoView.mostrarMensaje("Pedido ingresado de forma correcta.");
        } catch (SQLException e) {
            mesaView.mostrarError("Problemas gestionando la base de datos: " + e.getMessage());
        }
    }

    private List<OpcionJugo> listarJugos() throws SQLException {
        return jugoDao.listar(rset -> {
            try {
                var opcion = new OpcionJugo(rset.getString("nombre"));
                opcion.setId(rset.getInt("id"));

                return opcion;
            } catch (SQLException e) {
                return null;
            }
        });
    }

    private List<OpcionEnsalada> listarEnsaladas() throws SQLException {
        return ensaladaDao.listar(rset -> {
            try {
                var opcion = new OpcionEnsalada(rset.getString("nombre"));
                opcion.setId(rset.getInt("id"));

                return opcion;
            } catch (SQLException e) {
                return null;
            }
        });
    }

    private List<OpcionCarne> listarCarnes() throws SQLException {
        return carneDao.listar(rset -> {
            try {
                var opcion = new OpcionCarne(rset.getString("nombre"));
                opcion.setId(rset.getInt("id"));

                return opcion;
            } catch (SQLException e) {
                return null;
            }
        });
    }

    private List<OpcionPrincipio> listarPrincipios() throws SQLException {
        return principioDao.listar(rset -> {
            try {
                var opcion = new OpcionPrincipio(rset.getString("nombre"));
                opcion.setId(rset.getInt("id"));

                return opcion;
            } catch (SQLException e) {
                return null;
            }
        });
    }

    private List<OpcionSopa> listarSopas() throws SQLException {
        return sopaDao.listar(rset -> {
            try {
                var opcion = new OpcionSopa(rset.getString("nombre"));
                opcion.setId(rset.getInt("id"));

                return opcion;
            } catch (SQLException e) {
                return null;
            }
        });
    }

    private List<Mesa> listarMesas() throws SQLException {
        return mesaDao.listar();
    }

    public void agregarAdicionalAPedido() {
    }

    public void entregarPedidoDeMesa() {
        try {
            // Seleccionar una mesa
            var mesa = pedidoView.seleccionarMesa(listarMesas());

            // Seleccionar pedido de la mesa a entregar
            var pedidos = pedidoDao.listar(mesa);
            var pedido = pedidoView.seleccionarPedidoEntrega(pedidos);

            pedido.entregar();
            pedidoDao.entregarPedido(pedido);
        } catch (SQLException e) {
            mesaView.mostrarError("Problemas gestionando la base de datos: " + e.getMessage());
        }
    }

    public Integer calcularValorPagarMesa(Mesa mesa) throws SQLException {
        var pedidos = pedidoDao.listar(mesa);
        return pedidos.stream()
                .filter(p -> p.getEstado() == EstadoPedido.PENDIENTE_COBRAR)
                .map(p -> p.calcularTotal())
                .reduce((a, b) -> a + b)
                .orElse(0);
    }


    public void pagarCuentaMesa() {
        try {
            // Seleccionar una mesa
            var mesa = pedidoView.seleccionarMesa(listarMesas());

            var total = calcularValorPagarMesa(mesa);
            pedidoView.mostrarMensaje(String.format("La cuenta de mesa es: $ %,d.", total));

            var efectivo = pedidoView.leerEfectivo();

            try {
                // Valido los datos
                if (efectivo < total) {
                    // Devolver error de fondos insuficientes
                    throw new EfectivoInsuficienteException("El valor entregado no cubre el total a pagar");
                }

                // Limpiar pedidos
                mesa.limpiarPedidos();
                pedidoDao.eliminarPedidosDeMesa(mesa);

                // Retorno la devuelta
                pedidoView.mostrarMensaje(String.format("La devuelta es: $ %,d.", efectivo - total));
            } catch (EfectivoInsuficienteException ex) {
                pedidoView.mostrarError("El valor ingresado no es suficiente para cubrir la deuda.");
            }
        } catch (SQLException e) {
            mesaView.mostrarError("Problemas gestionando la base de datos: " + e.getMessage());
        }
    }

    public void consultarEstadoMesa() {
        try {
            // Seleccionar una mesa
            var mesa = pedidoView.seleccionarMesa(listarMesas());
            var pedidos = pedidoDao.listar(mesa);

            pedidoView.mostrarEstadoMesa(mesa, pedidos);
        } catch (SQLException e) {
            mesaView.mostrarError("Problemas gestionando la base de datos: " + e.getMessage());
        }
    }

    public void agregarMesa() {
        // Pedir los datos de la mesa
        var mesa = mesaView.leerDatosMesa();

        // Agregarla a la base de datos
        try {
            mesaDao.guardar(mesa);

            mesaView.mostrarMensaje("Mesa guardada exitosamente!");

            // Listar las mesas que se encuentran en la base de datos
            mesaView.mostrarMesas(listarMesas());
        } catch (SQLException e) {
            mesaView.mostrarError("Problemas gestionando la base de datos: " + e.getMessage());
        }

    }
}
