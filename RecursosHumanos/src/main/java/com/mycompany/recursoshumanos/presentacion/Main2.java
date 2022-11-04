
package com.mycompany.recursoshumanos.presentacion;

/**
 *
 * @author jdcar
 */

import com.mycompany.recursoshumanos.controller.FuncionarioController;
import com.mycompany.recursoshumanos.dominio.Funcionarios;

import java.io.ObjectInputFilter.Config;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.postgresql.copy.CopyIn;


public class Main2 extends javax.swing.JFrame {

    private final FuncionarioController funcionarioController;
    private static final String[] COLUMNS = {"id", "Tipo ID", "Nombre", "Apellido", "Estado", "Sexo", "Direccion", "Telefono", "Fecha de nacimiento"};
    private static final String SELECCIONE = "-- SELECCIONE --";
    private String Funcionarios;

    /**
     * Creates new form Main2
     */
    public Main2() {
        initComponents();
        txtTipoID.setEditable(false);
        funcionarioController = new FuncionarioController();
        ListFuncionarios();
        addListener();
    }


   
    /**
     * 
     */
    private void ListFuncionarios(){
        cbxFuncionarios.removeAllItems();
        Funcionarios funcionarios1 = new Funcionarios();
        funcionarios1.setTipoid_fun(SELECCIONE);
        funcionarios1.setNombre_fun("") ;
        funcionarios1.setApellido_fun("");
        tblFuncionarios.removeAll();


        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNS) {
            defaultTableModel.addColumn(COLUMN);
        }


        tblFuncionarios.setModel(defaultTableModel);
        try {
            List<Funcionarios> funcionario = FuncionarioController.obtener();
            if (funcionario.isEmpty()){
                return;
            }
            defaultTableModel.setRowCount(funcionario.size());
            int row = 0;
            for (Funcionarios funcionarios : funcionario) {
                defaultTableModel.setValueAt(funcionarios.getId_fun(), row, 0);
                defaultTableModel.setValueAt(funcionarios.getTipoid_fun(), row, 1);
                defaultTableModel.setValueAt(funcionarios.getNombre_fun(), row, 2);
                defaultTableModel.setValueAt(funcionarios.getApellido_fun(), row, 3);
                defaultTableModel.setValueAt(funcionarios.getEstado_fun(), row, 4);
                defaultTableModel.setValueAt(funcionarios.getSexo_fun(), row, 5);
                defaultTableModel.setValueAt(funcionarios.getDireccion_fun(), row, 6);
                defaultTableModel.setValueAt(funcionarios.getTelefono_fun(), row, 7);
                defaultTableModel.setValueAt(funcionarios.getNacimiento_fun(), row, 8);
                row++;

                cbxFuncionarios.addItem(Funcionarios);
            }
        } catch (SQLException e) { 
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addListener() {
        cbxFuncionarios.addActionListener(e -> {
            Funcionarios funcionarios = (Funcionarios) cbxFuncionarios.getSelectedItem();
            if (funcionarios.getTipoid_fun().equals(SELECCIONE)) {
                txtTipoID.setText("");
                txtNombre.setText("");
                txtApellido.setText("");
                txtEstado.setText("");
                txtSexo.setText("");
                txtDireccion.setText("");
                txtTel.setText("");
                txtNacimiento.setText("");
            } else {
                txtTipoID.setText(funcionarios.getTipoid_fun());
                txtNombre.setText(funcionarios.getNombre_fun());
                txtApellido.setText(funcionarios.getApellido_fun());
                txtEstado.setText(funcionarios.getEstado_fun());
                txtSexo.setText(funcionarios.getSexo_fun());
                txtDireccion.setText(funcionarios.getDireccion_fun());
                txtNacimiento.setText(funcionarios.getNacimiento_fun());
            }
            System.out.println("Selected: " + funcionarios.getTipoid_fun());
        });
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTPanels = new javax.swing.JTabbedPane();
        jPFuncionario = new javax.swing.JPanel();
        jPFuncionario1 = new javax.swing.JPanel();
        lblTipeID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        lblMarital = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblTel = new javax.swing.JLabel();
        lblNac = new javax.swing.JLabel();
        txtTipeID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtMarital = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtNac = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblTipoID = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblSex = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblNacimiento = new javax.swing.JLabel();
        txtTipoID = new javax.swing.JTextField();
        lblFuncionarios = new javax.swing.JLabel();
        cbxFuncionarios = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        txtSex = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        txtNacimiento = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 1, 18)); // NOI18N
        jLabel1.setText("GESTION DE RECURSOS HUMANOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 330, 30));

        jPFuncionario1.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite los siguientes campos"));

        lblTipeID.setText("Tipo ID");

        lblName.setText("Nombre");

        lblSurname.setText("Apellido");

        lblMarital.setText("Estado Civil");

        lblSexo.setText("Sexo");

        lblAddress.setText("Direccion");

        lblTel.setText("Telefono");

        lblNac.setText("Fecha Nacimiento");

        txtTipeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipeIDActionPerformed(evt);
            }
        });

        txtMarital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaritalActionPerformed(evt);
            }
        });

        txtSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSexoActionPerformed(evt);
            }
        });

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "Tipo ID", "Nombre", "Apellido", "Estado Civil", "Sexo", "Direccion", "Telefono", "Fecha Nacimiento"
            }
        ));

        jScrollPane1.setViewportView(tblFuncionarios);

        javax.swing.GroupLayout jPFuncionario1Layout = new javax.swing.GroupLayout(jPFuncionario1);
        jPFuncionario1.setLayout(jPFuncionario1Layout);
        jPFuncionario1Layout.setHorizontalGroup(
            jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPFuncionario1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTipeID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(lblTipeID, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtName)))
                        .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                                .addComponent(lblMarital, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                                .addComponent(txtMarital, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPFuncionario1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNac, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                                .addComponent(lblTel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(lblNac)))
                        .addGap(95, 95, 95)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPFuncionario1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jPFuncionario1Layout.setVerticalGroup(
            jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipeID)
                    .addComponent(lblName)
                    .addComponent(lblSurname)
                    .addComponent(lblMarital)
                    .addComponent(lblAddress)
                    .addComponent(lblSexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPFuncionario1Layout.createSequentialGroup()
                        .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTel)
                            .addComponent(lblNac))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPFuncionarioLayout = new javax.swing.GroupLayout(jPFuncionario);
        jPFuncionario.setLayout(jPFuncionarioLayout);
        jPFuncionarioLayout.setHorizontalGroup(
            jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                .addComponent(jPFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPFuncionarioLayout.setVerticalGroup(
            jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTPanels.addTab("Crear", jPFuncionario);

        lblTipoID.setText("Tipo ID");

        lblNombre.setText("Nombre");

        lblApellido.setText("Apellido");

        lblEstado.setText("Estado civil");

        lblSex.setText("Sexo");

        lblDireccion.setText("Direccion");

        lblTelefono.setText("Telefono");

        lblNacimiento.setText("Fecha Nacimiento");

        lblFuncionarios.setText("Funcionarios");

        cbxFuncionarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFuncionariosActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSexActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");

        btnEliminar.setText("Eliminar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblTipoID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(37, 37, 37))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTipoID, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre)
                            .addComponent(lblDireccion)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addGap(32, 32, 32))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSex, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtApellido)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addComponent(jTextField6))
                .addGap(86, 86, 86)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEstado)
                    .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(lblNacimiento)
                    .addComponent(txtNacimiento))
                .addGap(89, 89, 89))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblFuncionarios)
                        .addGap(18, 18, 18)
                        .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionarios)
                    .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(lblApellido)
                    .addComponent(lblEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEstado)
                        .addComponent(txtApellido))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTipoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSex)
                    .addComponent(lblDireccion)
                    .addComponent(lblTelefono)
                    .addComponent(lblNacimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addGap(25, 25, 25))
        );

        jTPanels.addTab("Editar", jPanel2);

        getContentPane().add(jTPanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 700, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTipeIDActionPerformed(java.awt.event.ActionEvent evt) {                                          
        JOptionPane.showMessageDialog(null, "Debe digitar Modelo");
        txtTipeID.requestFocus();
        return;
    }

    private void txtSexoActionPerformed(java.awt.event.ActionEvent evt) {                                        
        JOptionPane.showMessageDialog(null, "Debe digitar Modelo");
            txtSexo.requestFocus();
            return;
        }

    private void txtMaritalActionPerformed(java.awt.event.ActionEvent evt) {                                           
       JOptionPane.showMessageDialog(null, "Debe digitar Modelo");
            txtMarital.requestFocus();
            return;
        }

        private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

            if (txtTipoID.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccionar un Funcionario");
                txtTipoID.requestFocus();
                return;
            }
    
            if (txtNombre.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el Nombre");
                txtNombre.requestFocus();
                return;
            }
    
            if (txtApellido.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Debe digitar apellido");
                txtApellido.requestFocus();
                return;
            }
    
            if (txtAddress.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite la direccion");
                txtAddress.requestFocus();
                return;
            }
    
            if (txtSexo.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite el sexo");
                txtSexo.requestFocus();
                return;
            }
    
            if (txtEstado.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digite tipo Transmisión");
                txtEs.requestFocus();
                return;
            }
    
            Funcionarios funcionario = new Funcionarios();
            funcionario.setTipoid_fun(txtTipoID.getText());
            funcionario.setNombre_fun(txtNombre.getText());
            funcionario.setApellido_fun(txtApellido.getText());
            funcionario.setDireccion_fun(txtAddress.getText());
            funcionario.setSexo_fun(txtSexo.getText());
            funcionario.setEstado_fun(txtEstado.getText());

    
            int opt = JOptionPane.showConfirmDialog(null, "Desea actualizar el funcionario", "Confirmar salida",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opt == 0) {
    
                try { // en este metodo actualizar hacemos el casteo de string a integer, recibe dos parametros el id y el carro
                    funcionario.actualizar(Integer.parseInt(txtTipoID.getText()), funcionario);
                    JOptionPane.showMessageDialog(null, "Funcionario actualizado");
                    limpiar();
                    cargarTabla();
                } catch (SQLException ex) {
                    Logger.getLogger(Funcionarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    








    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
            if (txtTipoID.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccionar un registro");
                txtTipoID.requestFocus();
                return;
            }

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    String sql = "DELETE FROM funcionarios WHERE id = ?";
                    PreparedStatement ps = Con.prepareStatement(sql);
                    ps.setString(1, txtTipoID.getText());
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Registro eliminado");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
                }
            }
        }//GEN-LAST:event_btnEliminarActionPerformed

    


    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cbxFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFuncionariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFuncionariosActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_txtNombreActionPerformed

        private void txtSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSexActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_txtSexActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxFuncionarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPFuncionario;
    private javax.swing.JPanel jPFuncionario1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTPanels;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFuncionarios;
    private javax.swing.JLabel lblMarital;
    private javax.swing.JLabel lblNac;
    private javax.swing.JLabel lblNacimiento;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblTel;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipeID;
    private javax.swing.JLabel lblTipoID;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtMarital;
    private javax.swing.JTextField txtNac;
    private javax.swing.JTextField txtNacimiento;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSex;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtTipeID;
    private javax.swing.JTextField txtTipoID;
    // End of variables declaration//GEN-END:variables
}
