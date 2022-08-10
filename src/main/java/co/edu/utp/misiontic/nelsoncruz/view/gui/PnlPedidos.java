package co.edu.utp.misiontic.nelsoncruz.view.gui;

import co.edu.utp.misiontic.nelsoncruz.controller.ResturanteGUIControlador;
import co.edu.utp.misiontic.nelsoncruz.exception.EfectivoInsuficienteException;
import co.edu.utp.misiontic.nelsoncruz.model.Bandeja;
import co.edu.utp.misiontic.nelsoncruz.model.Completo;
import co.edu.utp.misiontic.nelsoncruz.model.EstadoPedido;
import co.edu.utp.misiontic.nelsoncruz.model.Mesa;
import co.edu.utp.misiontic.nelsoncruz.model.OpcionCarne;
import co.edu.utp.misiontic.nelsoncruz.model.OpcionEnsalada;
import co.edu.utp.misiontic.nelsoncruz.model.OpcionJugo;
import co.edu.utp.misiontic.nelsoncruz.model.OpcionPedido;
import co.edu.utp.misiontic.nelsoncruz.model.OpcionPrincipio;
import co.edu.utp.misiontic.nelsoncruz.model.OpcionSopa;
import co.edu.utp.misiontic.nelsoncruz.model.Pedido;
import co.edu.utp.misiontic.nelsoncruz.view.gui.tablemodel.PedidoTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
// import java.util.logging.Level;
// import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
// import javax.swing.ListSelectionModel;


public class PnlPedidos extends javax.swing.JPanel {

    private ResturanteGUIControlador controlador;

    private PedidoTableModel pedidoTableModel;

    /**
     * Creates new form PnlPedidos
     */
    public PnlPedidos() {
        controlador = new ResturanteGUIControlador();

        initComponents();

        this.pedidoTableModel = new PedidoTableModel();
        tblPedidos.setModel(pedidoTableModel);
        tblPedidos.getSelectionModel()
                .addListSelectionListener(evt -> seleccionarPedido());

        cargarListaMesas();
        cargarOpcionesAlimentos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTotalMesa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        spnEfectivo = new javax.swing.JSpinner();
        btnPagar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtDevuelta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstMesas = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnAgregarPedido = new javax.swing.JButton();
        btnEntregarPedido = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rbCompleto = new javax.swing.JRadioButton();
        rbBandeja = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        cmbSopa = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmbPrincipio = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbCarne = new javax.swing.JComboBox<>();
        chkEnsalada = new javax.swing.JCheckBox();
        cmbEnsalada = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbJugo = new javax.swing.JComboBox<>();
        btnCrearPedido = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cmbAdicionales = new javax.swing.JComboBox<>();
        btnAgregarAdicional = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAdicionales = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtTotalPedido = new javax.swing.JTextField();

        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Mesas"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        java.awt.GridBagLayout jPanel4Layout = new java.awt.GridBagLayout();
        jPanel4Layout.columnWidths = new int[] {0, 5, 0};
        jPanel4Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel4.setLayout(jPanel4Layout);

        jLabel1.setText("Total Mesa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel4.add(jLabel1, gridBagConstraints);

        txtTotalMesa.setEditable(false);
        txtTotalMesa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalMesa.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel4.add(txtTotalMesa, gridBagConstraints);

        jLabel2.setText("Efectivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel4.add(jLabel2, gridBagConstraints);

        spnEfectivo.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 500));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel4.add(spnEfectivo, gridBagConstraints);

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel4.add(btnPagar, gridBagConstraints);

        jLabel3.setText("Devuelta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        jPanel4.add(jLabel3, gridBagConstraints);

        txtDevuelta.setEditable(false);
        txtDevuelta.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtDevuelta.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        jPanel4.add(txtDevuelta, gridBagConstraints);

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        lstMesas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstMesas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstMesasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstMesas);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedidos"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        btnAgregarPedido.setText("Agregar Pedido");
        btnAgregarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPedidoActionPerformed(evt);
            }
        });
        jPanel5.add(btnAgregarPedido);

        btnEntregarPedido.setText("Entregar pedido");
        btnEntregarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregarPedidoActionPerformed(evt);
            }
        });
        jPanel5.add(btnEntregarPedido);

        jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cliente", "Entregado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPedidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(tblPedidos);

        jPanel2.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        add(jPanel2);

        jLabel4.setText("Cliente");

        jLabel5.setText("Tipo");

        buttonGroup1.add(rbCompleto);
        rbCompleto.setSelected(true);
        rbCompleto.setText("Completo");
        rbCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCompletoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbBandeja);
        rbBandeja.setText("Bandeja");
        rbBandeja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCompletoActionPerformed(evt);
            }
        });

        jLabel6.setText("Sopa");

        jLabel7.setText("Principio");

        jLabel8.setText("Carne");

        chkEnsalada.setSelected(true);
        chkEnsalada.setText("Ensalada");
        chkEnsalada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEnsaladaActionPerformed(evt);
            }
        });

        jLabel9.setText("Jugo");

        btnCrearPedido.setText("Crear Pedido");
        btnCrearPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPedidoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Adicionales");

        cmbAdicionales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAgregarAdicional.setText("Agregar");

        tblAdicionales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblAdicionales);

        jLabel11.setText("Total Pedido");

        txtTotalPedido.setEditable(false);
        txtTotalPedido.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txtTotalPedido.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCliente))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbSopa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbJugo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(chkEnsalada))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPrincipio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbCarne, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbEnsalada, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCrearPedido))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(cmbAdicionales, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarAdicional))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbCompleto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbBandeja)
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalPedido)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {chkEnsalada, jLabel11, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rbCompleto)
                    .addComponent(rbBandeja))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbSopa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbPrincipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbCarne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkEnsalada)
                    .addComponent(cmbEnsalada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbJugo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrearPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAdicionales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarAdicional))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(jPanel3);
    }// </editor-fold>//GEN-END:initComponents

    private void lstMesasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstMesasValueChanged
        if (lstMesas.getSelectedIndex() != -1) {
            var mesa = lstMesas.getSelectedValue();
            cargarDatosMesa(mesa);
        } else {
            limpiarDatosMesa();
        }
    }//GEN-LAST:event_lstMesasValueChanged

    private void btnEntregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregarPedidoActionPerformed
        if (tblPedidos.getSelectedRowCount() == 0) {
            mostrarAdvertencia("No se ha seleccionado un pedido a entregar");
        } else {
            entregarPedido();
        }
    }//GEN-LAST:event_btnEntregarPedidoActionPerformed

    private void rbCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCompletoActionPerformed
        if (rbCompleto.isSelected()) {
            cmbSopa.setEnabled(true);
        } else {
            cmbSopa.setEnabled(false);
            cmbSopa.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_rbCompletoActionPerformed

    private void chkEnsaladaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEnsaladaActionPerformed
        if (chkEnsalada.isSelected()) {
            cmbEnsalada.setEnabled(true);
        } else {
            cmbEnsalada.setEnabled(false);
            cmbEnsalada.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_chkEnsaladaActionPerformed

    private void btnAgregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPedidoActionPerformed
        if (lstMesas.getSelectedIndex() == -1) {
            mostrarAdvertencia("Debe seleccionar la mesa a la cual va a agregar el pedido");
        } else {
            tblPedidos.clearSelection();
            limpiarCamposPedido();
            txtCliente.requestFocus();
        }
    }//GEN-LAST:event_btnAgregarPedidoActionPerformed

    private void btnCrearPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPedidoActionPerformed
        if (tblPedidos.getSelectedRowCount() != 0) {
            mostrarAdvertencia("No puedes modificar un pedido");
        } else {
            crearPedido();
        }
    }//GEN-LAST:event_btnCrearPedidoActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        if (lstMesas.getSelectedIndex() == -1) {
            mostrarAdvertencia("Debe seleccionar una mesa a pagar");
        } else {
            pagarMesa();
        }
    }//GEN-LAST:event_btnPagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAdicional;
    private javax.swing.JButton btnAgregarPedido;
    private javax.swing.JButton btnCrearPedido;
    private javax.swing.JButton btnEntregarPedido;
    private javax.swing.JButton btnPagar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkEnsalada;
    private javax.swing.JComboBox<String> cmbAdicionales;
    private javax.swing.JComboBox<OpcionCarne> cmbCarne;
    private javax.swing.JComboBox<OpcionEnsalada> cmbEnsalada;
    private javax.swing.JComboBox<OpcionJugo> cmbJugo;
    private javax.swing.JComboBox<OpcionPrincipio> cmbPrincipio;
    private javax.swing.JComboBox<OpcionSopa> cmbSopa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<Mesa> lstMesas;
    private javax.swing.JRadioButton rbBandeja;
    private javax.swing.JRadioButton rbCompleto;
    private javax.swing.JSpinner spnEfectivo;
    private javax.swing.JTable tblAdicionales;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDevuelta;
    private javax.swing.JTextField txtTotalMesa;
    private javax.swing.JTextField txtTotalPedido;
    // End of variables declaration//GEN-END:variables

    private void mostrarError(String error, Exception ex) {
        JOptionPane.showMessageDialog(this, error + ": " + ex.getMessage(),
                "Restaurante El Corrientazo", JOptionPane.ERROR_MESSAGE);
    }

    private void mostrarAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje,
                "Restaurante El Corrientazo", JOptionPane.WARNING_MESSAGE);
    }

    private void mostrarInformacion(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje,
                "Restaurante El Corrientazo", JOptionPane.INFORMATION_MESSAGE);
    }

    private void cargarListaMesas() {
        try {
            lstMesas.removeAll();

            var modelo = new DefaultListModel<Mesa>();
            modelo.addAll(controlador.listarMesas());
            lstMesas.setModel(modelo);
        } catch (SQLException ex) {
            mostrarError("Error listando mesas", ex);
        }
    }

    private void cargarDatosMesa(Mesa mesa) {
        try {
            // Cargar el total a pagar de la mesa
            var total = controlador.calcularTotalMesa(mesa);
            txtTotalMesa.setText(String.format("$ %,d", total));
            spnEfectivo.setValue(0);
            txtDevuelta.setText(String.format("$ %,d", 0));

            // TODO: Cargar los datos de los pedidos de la mesa
            var pedidos = controlador.listarPedidosMesa(mesa);
            this.pedidoTableModel.setPedidos(pedidos);
        } catch (SQLException ex) {
            mostrarError("Error al cargar datos de mesa", ex);
        }
    }

    private void limpiarDatosMesa() {
        // Limpiar el total a pagar de la mesa
        txtTotalMesa.setText(String.format("$ %,d", 0));
        spnEfectivo.setValue(0);
        txtDevuelta.setText(String.format("$ %,d", 0));

        // Limpiar los datos de los pedidos de la mesa
        this.pedidoTableModel.setPedidos(new ArrayList<>());
    }

    private void entregarPedido() {
        try {
            var row = tblPedidos.getSelectedRow();
            var pedido = this.pedidoTableModel.getPedido(row);
            if (pedido.getEstado() != EstadoPedido.PENDIENTE_ENTREGAR) {
                mostrarAdvertencia("El pedido ya ha sido entregado");
            } else {
                controlador.entregarPedido(pedido);

                this.pedidoTableModel.setPedido(row, pedido);
                lstMesasValueChanged(null);

                mostrarInformacion("Se ha entregado el pedido");
            }
        } catch (SQLException ex) {
            mostrarError("Error al entregar el pedido", ex);
        }
    }

    private void cargarOpcionesAlimentos() {
        try {
            cmbSopa.removeAllItems();
            controlador.listarSopas().forEach(cmbSopa::addItem);
            cmbSopa.setSelectedIndex(-1);

            cmbPrincipio.removeAllItems();
            controlador.listarPrincipios().forEach(cmbPrincipio::addItem);
            cmbPrincipio.setSelectedIndex(-1);

            cmbCarne.removeAllItems();
            controlador.listarCarnes().forEach(cmbCarne::addItem);
            cmbCarne.setSelectedIndex(-1);

            cmbEnsalada.removeAllItems();
            controlador.listarEnsaladas().forEach(cmbEnsalada::addItem);
            cmbEnsalada.setSelectedIndex(-1);

            cmbJugo.removeAllItems();
            controlador.listarJugos().forEach(cmbJugo::addItem);
            cmbJugo.setSelectedIndex(-1);
        } catch (SQLException ex) {
            mostrarError("Error cargando opciones de alimentos", ex);
        }
    }

    private void limpiarCamposPedido() {
        txtCliente.setText("");
        rbCompleto.setSelected(true);
        rbCompletoActionPerformed(null);
        cmbSopa.setSelectedIndex(-1);
        cmbPrincipio.setSelectedIndex(-1);
        cmbCarne.setSelectedIndex(-1);
        chkEnsalada.setSelected(true);
        chkEnsaladaActionPerformed(null);
        cmbEnsalada.setSelectedIndex(-1);
        cmbJugo.setSelectedIndex(-1);

        // TODO Falta limpiar la tabla de adicionales 
        // Mostrar total del pedido
        txtTotalPedido.setText(String.format("$ %,d", 0));
    }

    private void cargarCamposPedido(Pedido pedido) {
        txtCliente.setText(pedido.getCliente());

        if (pedido.getOpcion() instanceof Completo) {
            rbCompleto.setSelected(true);

            var completo = (Completo) pedido.getOpcion();
            cmbSopa.setSelectedItem(completo.getSopa());
        } else {
            rbBandeja.setSelected(true);
        }
        rbCompletoActionPerformed(null);

        cmbPrincipio.setSelectedItem(pedido.getOpcion().getPrincipio());
        cmbCarne.setSelectedItem(pedido.getOpcion().getCarne());

        if (pedido.getOpcion().getEnsalada() != null) {
            chkEnsalada.setSelected(true);
            cmbEnsalada.setSelectedItem(pedido.getOpcion().getEnsalada());
        } else {
            chkEnsalada.setSelected(false);
        }
        chkEnsaladaActionPerformed(null);

        cmbJugo.setSelectedItem(pedido.getOpcion().getJugo());

        // TODO Falta limpiar la tabla de adicionales 
        // Mostrar total del pedido
        txtTotalPedido.setText(String.format("$ %,d", pedido.calcularTotal()));
    }

    private void crearPedido() {
        // TODO Validar campos

        try {
            // Agregar el pedido a la base de datos
            var mesa = lstMesas.getSelectedValue();
            var pedido = new Pedido(txtCliente.getText());

            OpcionPedido opcion;
            if (rbCompleto.isSelected()) {
                var completo = new Completo(12_000);
                completo.setSopa((OpcionSopa) cmbSopa.getSelectedItem());

                opcion = completo;
            } else {
                opcion = new Bandeja(10_000);
            }
            opcion.setPrincipio((OpcionPrincipio) cmbPrincipio.getSelectedItem());
            opcion.setCarne((OpcionCarne) cmbCarne.getSelectedItem());
            if (chkEnsalada.isSelected()) {
                opcion.setEnsalada((OpcionEnsalada) cmbEnsalada.getSelectedItem());
            }
            opcion.setJugo((OpcionJugo) cmbJugo.getSelectedItem());

            pedido.setOpcion(opcion);

            controlador.agregarPedidoAMesa(mesa, pedido);

            // Agregar pedido a la tabla en la vista
            this.pedidoTableModel.addPedido(pedido);

            mostrarInformacion("Se ha agregado exitosamente el pedido");
        } catch (SQLException ex) {
            mostrarError("Error al crear el pedido", ex);
        }
    }

    private void seleccionarPedido() {
        if (tblPedidos.getSelectedRowCount() == 1) {
            var row = tblPedidos.getSelectedRow();
            var pedido = this.pedidoTableModel.getPedido(row);
            cargarCamposPedido(pedido);
        } else {
            limpiarCamposPedido();
        }
    }

    private void pagarMesa() {
        try {
            var mesa = lstMesas.getSelectedValue();
            var efectivo = (Integer) spnEfectivo.getValue();
            var devuelta = controlador.pagarCuentaMesa(mesa, efectivo);
            
            txtDevuelta.setText(String.format("$ %,d", devuelta));
            
            mostrarInformacion("Se ha pagado por completo la cuenta");
            lstMesasValueChanged(null);

        } catch (SQLException | EfectivoInsuficienteException ex) {
            mostrarError("Error al pagar la cuenta", ex);
        }
    }

}