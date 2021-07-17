/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.MunicipioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import mysql.conexion;

/**
 *
 * @author JUAN100CORR
 */
public class MunicipioDAO {

  
    private static Connection conexionaso;
    private static PreparedStatement sentenica_preparadaaso;
    private static Statement sentencia;
    private static ResultSet resultadoaso;
    
    
    public void listar_municipios(JComboBox box) {
        
        DefaultComboBoxModel value;
        conexion conectar = new conexion();
        
        try {
            
          
          conexionaso = conexion.conectar();
          
          sentencia = conexionaso.createStatement();
          
          resultadoaso = sentencia.executeQuery("SELECT * FROM municipios");
          
          value = new DefaultComboBoxModel();
          
          box.setModel(value);
          
            while (resultadoaso.next()) {
           
                value.addElement(new MunicipioVO(resultadoaso.getInt(1),resultadoaso.getString(2)));
                
                
            }
        } catch (Exception e) {
         
        }finally{
            try {
                conexionaso.close();
                
            } catch (Exception e) {
            }
        }
        
    }

    public void listar_municipios(String seleccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
