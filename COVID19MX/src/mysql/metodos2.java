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
public class metodos2 {
     private static Connection conexion1;
    private static PreparedStatement sentenica_preparada;
    private static ResultSet resultado;
    
           public void guardar_direccionPc(String calle1, String numext1, String clvmun, String cpnum, String clvcol, String idpa) {

        try {
            conexion1 = conexion.conectar();
            String consulta = "CALL INSERTARDIREC(NULL,?,?,?,?,?,?)";
            sentenica_preparada = conexion1.prepareStatement(consulta);
            sentenica_preparada.setString(1, calle1);
            sentenica_preparada.setString(2, numext1);
            sentenica_preparada.setString(3, clvmun);
            sentenica_preparada.setString(4, cpnum);
            sentenica_preparada.setString(5, clvcol);
            sentenica_preparada.setString(6, idpa);
   
            int i = sentenica_preparada.executeUpdate();

            if (i > 0) {
                Component cmpnt;

                JOptionPane.showMessageDialog(null, "DIRECCION AÑADIDA CORRECTAMENTE");

            } else {

                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR DATOS DE LA DIRECCION");

            }
            
            conexion1.close();

        } catch (HeadlessException | SQLException e) {
           JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR DATOS DE LA DIRECCION"+ e);
        } finally{
            try {
                   conexion1.close();
            } catch (SQLException e) {
            }
       
            
        }

    }
}
