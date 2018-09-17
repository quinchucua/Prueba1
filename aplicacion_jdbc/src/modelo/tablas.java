/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.vista;

public class tablas  {
    vista vista;
    ResultSet re = null;
    Connection conexion=null;
    public tablas (Connection miconexion,vista vista){
        conexion=miconexion;
        this.vista=vista;
        cargatablas();
    }
    public void cargatablas(){
        try {
            DatabaseMetaData datos = conexion.getMetaData();
            re = datos.getTables(null, null, null, null);
            while(re.next()){
                vista.getDesplegable().addItem(re.getString("table_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(tablas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
