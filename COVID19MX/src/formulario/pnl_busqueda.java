/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import mysql.conexion;

/**
 *
 * @author JUAN100CORR
 */
public final class pnl_busqueda extends javax.swing.JPanel {

    /**
     * Creates new form pnl_alta
     */
    public pnl_busqueda() {
        initComponents();
        cargardatostabla();
        ancho();
         
        
    }
    
    
    
    
    DefaultTableModel tabla;
    /*
    MUESTRA DATOS IMPORTANTES
    String titulo_columnas[] = {"ID","NOMBRE COMPLETO","EDAD","SEXO","AÑO","HIJOS","ESTADO CIVIL","ESCOLARIDAD","TELEFONO","MOVIL","CORREO"};*/
   /*MUESTRA TODOS LOS DATOS*/
    String titulo_columnas[] = {"CURP","NOMBRE","APELLIDOP","APELLIDOM","EDAD","MOVIL","CORREO","MUNICPIO","CP","COLONIA"};
    
    
    String filas[] = new String [10]; 
   
    Connection conexion1;
    PreparedStatement sentencia_preparada;
    ResultSet resultado;
    
    
    public void ancho(){
    
    tbl_busquedapaciente.getColumnModel().getColumn(0).setPreferredWidth(90);
    tbl_busquedapaciente.getColumnModel().getColumn(1).setPreferredWidth(30);
    tbl_busquedapaciente.getColumnModel().getColumn(2).setPreferredWidth(30);
    tbl_busquedapaciente.getColumnModel().getColumn(3).setPreferredWidth(30);
    tbl_busquedapaciente.getColumnModel().getColumn(4).setPreferredWidth(0);
    tbl_busquedapaciente.getColumnModel().getColumn(5).setPreferredWidth(30);
    tbl_busquedapaciente.getColumnModel().getColumn(6).setPreferredWidth(30);
    tbl_busquedapaciente.getColumnModel().getColumn(7).setPreferredWidth(150);
    }
    
   
       
  
    public void cargardatostabla(){
        
        
    
    tabla = new DefaultTableModel(null,titulo_columnas);
    
        try {
            conexion1 = conexion.conectar();
            
           String consulta_tabla = "SELECT CURP,NOMBRE_PAC,APELLIDOP,APELLIDOM,EDAD_PAC,TEL_MOV,CORREO,MUNICIPIO,CP_NOMBRE,COLONIA_NOMBRE\n" +
"                   FROM covid19mexico, direccion_paciente, municipios, colonia, codigopostal WHERE direccion_paciente.CLAVE_MUNICIPIO = municipios.CLAVE_MUNICIPIO AND \n" +
"                   covid19mexico.IDENTIFICADOR_PAC = direccion_paciente.IDENTIFICADOR_PAC AND colonia.CLAVE_COLONIA=direccion_paciente.CLAVE_COLONIA AND codigopostal.CP=direccion_paciente.CP"; 
           /* String consulta_tabla = "SELECT * FROM covid19mexico";*/
            sentencia_preparada = conexion1.prepareStatement(consulta_tabla);
            resultado = sentencia_preparada.executeQuery();
          
            while(resultado.next()){
            filas[0] = resultado.getString(1);
            filas[1] = resultado.getString(2);
            filas[2] = resultado.getString(3);
            filas[3] = resultado.getString(4);
            filas[4] = resultado.getString(5);
            filas[5] = resultado.getString(6);
            filas[6] = resultado.getString(7);
            filas[7] = resultado.getString(8);
            filas[8] = resultado.getString(9);
            filas[9] = resultado.getString(10);
            

           
            
            tabla.addRow(filas);
            
            }
            
            tbl_busquedapaciente.setModel(tabla);
            
            conexion1.close();
            
            
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally{
            try {
            conexion1.close();
                
            } catch (Exception ex) {
                
                Logger.getLogger(pnl_busqueda.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: " + ex);
            }
        
        }
    }
    
 
 
    public void busqueda(String CURP){
    
    tabla = new DefaultTableModel(null,titulo_columnas);
    
        try {
            conexion1 = conexion.conectar();
            String consulta_tabla = "SELECT CURP,NOMBRE_PAC,APELLIDOP,APELLIDOM,EDAD_PAC,TEL_MOV,CORREO,MUNICIPIO,CP_NOMBRE,COLONIA_NOMBRE\n" +
"                   FROM covid19mexico, direccion_paciente, municipios, colonia, codigopostal WHERE direccion_paciente.CLAVE_MUNICIPIO = municipios.CLAVE_MUNICIPIO AND \n" +
"                   covid19mexico.IDENTIFICADOR_PAC = direccion_paciente.IDENTIFICADOR_PAC AND colonia.CLAVE_COLONIA=direccion_paciente.CLAVE_COLONIA "
                    + "AND codigopostal.CP=direccion_paciente.CP and covid19mexico.CURP LIKE '"+CURP+"%'";
            sentencia_preparada = conexion1.prepareStatement(consulta_tabla);
            resultado = sentencia_preparada.executeQuery();
            
          
            while(resultado.next()){
            filas[0] = resultado.getString(1);
            filas[1] = resultado.getString(2);
            filas[2] = resultado.getString(3);
            filas[3] = resultado.getString(4);
            filas[4] = resultado.getString(5);
            filas[5] = resultado.getString(6);
            filas[6] = resultado.getString(7);
            filas[7] = resultado.getString(8);
            filas[8] = resultado.getString(9);
            filas[9] = resultado.getString(10);

         
            
            tabla.addRow(filas);
            
            }
            
            tbl_busquedapaciente.setModel(tabla);
            
            conexion1.close();
            
            
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally{
            try {
            conexion1.close();
                
            } catch (Exception ex) {
                
                Logger.getLogger(pnl_busqueda.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: " + ex);
            }
        
        }
    }
   
   
   
   

  public void mensajefiltro(String CURP){
    
    tabla = new DefaultTableModel(null,titulo_columnas);
    
        try {
            conexion1 = conexion.conectar();
             String consulta_tabla = "SELECT CURP,NOMBRE_PAC,APELLIDOP,APELLIDOM,EDAD_PAC,TEL_MOV,CORREO,MUNICIPIO,CP_NOMBRE,COLONIA_NOMBRE\n" +
"                   FROM covid19mexico, direccion_paciente, municipios, colonia, codigopostal WHERE direccion_paciente.CLAVE_MUNICIPIO = municipios.CLAVE_MUNICIPIO AND \n" +
"                   covid19mexico.IDENTIFICADOR_PAC = direccion_paciente.IDENTIFICADOR_PAC AND colonia.CLAVE_COLONIA=direccion_paciente.CLAVE_COLONIA "
                     + "AND codigopostal.CP=direccion_paciente.CP and covid19mexico.CURP LIKE '"+CURP+"%'";
            sentencia_preparada = conexion1.prepareStatement(consulta_tabla);
            resultado = sentencia_preparada.executeQuery();
    
            if(resultado.next()){
            
            lbmensajebusqueda.setText("RESULTADOS POSIBLES");
            }else{
            
            lbmensajebusqueda.setText("SIN RESULTADOS");
            }
            
            
            
            conexion1.close();
            
            
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally{
            try {
            conexion1.close();
                
            } catch (Exception ex) {
                
                Logger.getLogger(pnl_busqueda.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: " + ex);
            }
        
        }
    }
  
  
  
  
  
  
  
  
  public void limpiar(){
      if (ins_curp.getText().isEmpty()) {
      lbmensajebusqueda.setText("");
      
          
      }
  
  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_busquedapaciente = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lbmensajebusqueda = new javax.swing.JLabel();
        ins_curp = new javax.swing.JTextField();
        jLabel4W = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("BUSCAR PACIENTE");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "DATOS DEL PACIENTE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 1, 14))); // NOI18N

        tbl_busquedapaciente.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbl_busquedapaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null", "null", "null", "null", "null", "null"
            }
        ));
        tbl_busquedapaciente.setColumnSelectionAllowed(true);
        tbl_busquedapaciente.setRowHeight(40);
        tbl_busquedapaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_busquedapacienteKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_busquedapaciente);
        tbl_busquedapaciente.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tbl_busquedapaciente.getColumnModel().getColumnCount() > 0) {
            tbl_busquedapaciente.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbl_busquedapaciente.getColumnModel().getColumn(5).setMinWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(5).setPreferredWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(5).setMaxWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(6).setMinWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(6).setPreferredWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(6).setMaxWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(7).setMinWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(7).setPreferredWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(7).setMaxWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(8).setMinWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(8).setPreferredWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(8).setMaxWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(9).setMinWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(9).setPreferredWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(9).setMaxWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(10).setMinWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(10).setPreferredWidth(0);
            tbl_busquedapaciente.getColumnModel().getColumn(10).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(636, 636, 636))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(541, 541, 541))))
        );

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setText("INGRESA EL CURP DEL PACIENTE PARA UNA BUSQUEDA EXACTA ");

        lbmensajebusqueda.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        ins_curp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ins_curpActionPerformed(evt);
            }
        });
        ins_curp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ins_curpKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ins_curpKeyTyped(evt);
            }
        });

        jLabel4W.setFont(new java.awt.Font("Calibri", 1, 10)); // NOI18N
        jLabel4W.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4W.setText("LA BUSQUEDA EXACTA DEL PACIENTE SOLO SE PUEDE REALIZAR CON EL CURP");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ins_curp, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbmensajebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4W))
                .addContainerGap(532, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbmensajebusqueda)
                    .addComponent(ins_curp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel4W)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ins_curpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ins_curpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ins_curpActionPerformed

    private void ins_curpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ins_curpKeyTyped
Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
        } 
         if (ins_curp.getText().length() >= 40) {
            evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_ins_curpKeyTyped

    private void ins_curpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ins_curpKeyReleased
        busqueda(ins_curp.getText());
        mensajefiltro(ins_curp.getText());
        limpiar();
        // TODO add your handling code here:
    }//GEN-LAST:event_ins_curpKeyReleased

    private void tbl_busquedapacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_busquedapacienteKeyReleased
   // TODO add your handling code here:
    }//GEN-LAST:event_tbl_busquedapacienteKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JTextField ins_curp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4W;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbmensajebusqueda;
    public javax.swing.JTable tbl_busquedapaciente;
    // End of variables declaration//GEN-END:variables
}
