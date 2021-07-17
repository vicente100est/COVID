/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JUAN100CORR
 */
public class metodos {

    private static Connection conexion1;
    private static PreparedStatement sentenica_preparada;
    private static ResultSet resultado;

    public void guardar_datos_paciente(String nombre1, String curp1, String apellidop1, String apellidom1, int edad1, String sexo1, int año1, int nohijos1, String estcivil1, String escolaridad1,
            String hrtrabajo1, String Ocupacion1, String Religion1, int tel_cas1, String tel_mov1, String correo1) {

        try {
            conexion1 = conexion.conectar();
            String consulta = "CALL INSERTARCOVID19(NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            sentenica_preparada = conexion1.prepareStatement(consulta);
            sentenica_preparada.setString(1, nombre1);
            sentenica_preparada.setString(2, curp1);
            sentenica_preparada.setString(3, apellidop1);
            sentenica_preparada.setString(4, apellidom1);
            sentenica_preparada.setInt(5, edad1);
            sentenica_preparada.setString(6, sexo1);
            sentenica_preparada.setInt(7, año1);
            sentenica_preparada.setInt(8, nohijos1);
            sentenica_preparada.setString(9, estcivil1);
            sentenica_preparada.setString(10, escolaridad1);
            sentenica_preparada.setString(11, hrtrabajo1);
            sentenica_preparada.setString(12, Ocupacion1);
            sentenica_preparada.setString(13, Religion1);
            sentenica_preparada.setInt(14, tel_cas1);
            sentenica_preparada.setString(15, tel_mov1);
            sentenica_preparada.setString(16, correo1);
            int i = sentenica_preparada.executeUpdate();

            if (i > 0) {
                Component cmpnt;

                JOptionPane.showMessageDialog(null, "DATOS GUARDADOS");

            } else {

                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR DATOS");

            }
            
            conexion1.close();

        } catch (HeadlessException | SQLException e) {
           JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR DATOS"+ e);
        } finally{
            try {
                   conexion1.close();
            } catch (SQLException e) {
            }
       
            
        }

    }
 

    
  
}
