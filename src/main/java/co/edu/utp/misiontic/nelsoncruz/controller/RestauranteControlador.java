package co.edu.utp.misiontic.nelsoncruz.controller;

import java.util.Arrays;
import java.util.List;

import co.edu.utp.misiontic.nelsoncruz.exception.EfectivoInsuficienteException;
import co.edu.utp.misiontic.nelsoncruz.model.Mesa;
import co.edu.utp.misiontic.nelsoncruz.model.OpcionCarne;
import co.edu.utp.misiontic.nelsoncruz.model.OpcionEnsalada;
import co.edu.utp.misiontic.nelsoncruz.model.OpcionJugo;
import co.edu.utp.misiontic.nelsoncruz.model.OpcionPrincipio;
import co.edu.utp.misiontic.nelsoncruz.model.OpcionSopa;
import co.edu.utp.misiontic.nelsoncruz.view.PedidoView;
// import co.edu.utp.misiontic.nelsoncruz.view.PrincipalVista;

public class RestauranteControlador {

    private PedidoView pedidoView;

    private List<Mesa> mesas = null;
    private List<OpcionSopa> sopas = null;
    private List<OpcionPrincipio> principios = null;
    private List<OpcionCarne> carnes = null;
    private List<OpcionEnsalada> ensaladas = null;
    private List<OpcionJugo> jugos = null;

    public RestauranteControlador() {
        this.pedidoView = new PedidoView();
    }

    public void agregarPedidoAMesa() {
        // Seleccionar una mesa
        var mesa = pedidoView.seleccionarMesa(listarMesas());

        // Pedir la información del pedido
        var pedido = pedidoView.pedirInformacionPedido(listarSopas(), listarPrincipios(), listarCarnes(),
                listarEnsaladas(), listarJugos());

        // Agregar el pedido a la mesa
        mesa.adicionarPedido(pedido);
        pedidoView.mostrarMensaje("Pedido ingresado correctamente");
    }

    private List<OpcionJugo> listarJugos() {
        // TODO: Traerlos de la base de datos
        return jugos;
    }

    private List<OpcionEnsalada> listarEnsaladas() {
        // TODO: Traerlos de la base de datos
        return ensaladas;
    }

    private List<OpcionCarne> listarCarnes() {
        // TODO: Traerlos de la base de datos
        return carnes;
    }

    private List<OpcionPrincipio> listarPrincipios() {
        // TODO: Traerlos de la base de datos
        return principios;
    }

    private List<OpcionSopa> listarSopas() {
        // TODO: Traerlos de la base de datos
        return sopas;
    }

    private List<Mesa> listarMesas() {
        // TODO: Traerlos de la base de datos
        return mesas;
    }

    public void agregarAdicionalAPedido() {
    }

    public void entregarPedidoDeMesa() {
           // Seleccionar una mesa
           var mesa = pedidoView.seleccionarMesa(listarMesas());

           //Seleccionar pedio de la mesa a entregar
           var pedido = pedidoView.seleccionarPedidoEntrega(mesa);
           pedido.entregar();
    }

    public void pagarCuentaMesa() {
        // Seleccionar una mesa
        var mesa = pedidoView.seleccionarMesa(listarMesas());

        var total = mesa.calcularValorPagar();
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

            // Retorno la devuelta
            pedidoView.mostrarMensaje(String.format("La devuelta es: $ %,d.", efectivo - total));
        } catch (EfectivoInsuficienteException ex) {
            pedidoView.mostrarError("El valor ingresado no es suficiente para cubrir la deuda.");
        }
    }

    public void consultarEstadoMesa() {
        // Seleccionar una mesa
        var mesa = pedidoView.seleccionarMesa(listarMesas());

        pedidoView.mostrarEstadoMesa(mesa);
    }

}
