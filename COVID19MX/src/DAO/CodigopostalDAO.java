/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.CodigopostalVO;
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
public class CodigopostalDAO {
    
    private static Connection conexionaso;
    private static PreparedStatement sentenica_preparadaaso;
    private static Statement sentencia;
    private static ResultSet resultadoaso;
    
    public void listar_codigopostal(JComboBox box, int id) {
        DefaultComboBoxModel value;
        conexion conectar = new conexion();
        
        try {
          conexionaso = conexion.conectar();
          sentenica_preparadaaso = conexionaso.prepareStatement("SELECT * FROM codigopostal WHERE CLAVE_MUNICIPIO = ? ");
          sentenica_preparadaaso.setInt(1, id);
          resultadoaso = sentenica_preparadaaso.executeQuery();
          value = new DefaultComboBoxModel();
          box.setModel(value);
          
            while (resultadoaso.next()) {
           
                value.addElement(new CodigopostalVO(resultadoaso.getInt(1),resultadoaso.getString(2)));
                
                
            }
        } catch (Exception e) {
         
        }finally{
            try {
                conexionaso.close();
            } catch (Exception e) {
            }
        }
        
    }
    
}
