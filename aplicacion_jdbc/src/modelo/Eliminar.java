/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.vista;

/**
 *
 * @author Alfonso
 */
public class Eliminar {
    vista vista ;
    modelo modelo;
    String sentencia,dato1,dato2,dato3,dato4,dao5;
    ResultSet resul;
    PreparedStatement senten;
    
    
    public Eliminar(vista vista, modelo modelo){
        this.modelo= modelo;
        this.vista= vista;
        
        
                
    }
    
    public void DeleteData(){
        String tabla = modelo.datosTabla;
        if (tabla.equalsIgnoreCase("estado")){
            int fila = vista.getTabla().getSelectedRow();
            int colum = vista.getTabla().getSelectedColumn();
            System.out.println("la fila es: "+fila+" la columna es: "+colum);
            int seleccion = (int)vista.getTabla().getValueAt(fila, colum);
            System.out.println(seleccion+" esta es la seleccion ");
            sentencia ="delete from estado where idEstado = ?";
        try {
                senten = modelo.com.prepareStatement(sentencia);
                senten.setInt(1, seleccion);
                senten.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Eliminar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }else if (tabla.equalsIgnoreCase("responsable")){
            
            try {
                int fila = vista.getTabla().getSelectedRow();
                int colum = vista.getTabla().getSelectedColumn();
                System.out.println("la fila es: "+fila+" la columna es: "+colum);
                long seleccion = (long)vista.getTabla().getValueAt(fila, colum);
                System.out.println(seleccion+" esta es la seleccion ");
                sentencia ="delete from responsable where Codigo = ?";
                PreparedStatement senten = modelo.com.prepareStatement(sentencia);
                senten.setLong(1, seleccion);
                senten.execute();
            } catch (SQLException ex) {
                Logger.getLogger(Eliminar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if (tabla.equalsIgnoreCase("recursos")){
            
            try {
                int fila = vista.getTabla().getSelectedRow();
                int colum = vista.getTabla().getSelectedColumn();
                System.out.println("la fila es: "+fila+" la columna es: "+colum);
                long seleccion = (long)vista.getTabla().getValueAt(fila, colum);
                System.out.println(seleccion+" esta es la seleccion ");
                sentencia ="delete from recursos where Serial = ?";
                PreparedStatement senten = modelo.com.prepareStatement(sentencia);
                senten.setLong(1, seleccion);
                senten.execute();
            } catch (SQLException ex) {
                Logger.getLogger(Eliminar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if (tabla.equalsIgnoreCase("tipo_recurso")){
            
            try {
                int fila = vista.getTabla().getSelectedRow();
                int colum = vista.getTabla().getSelectedColumn();
                System.out.println("la fila es: "+fila+" la columna es: "+colum);
                int seleccion = (int)vista.getTabla().getValueAt(fila, colum);
                System.out.println(seleccion+" esta es la seleccion ");
                sentencia ="delete from tipo_recurso where Tipo_Recurso = ?";
                PreparedStatement senten = modelo.com.prepareStatement(sentencia);
                senten.setInt(1, seleccion);
                senten.execute();
            } catch (SQLException ex) {
                Logger.getLogger(Eliminar.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }else if (tabla.equalsIgnoreCase("tipo_responsable")){
            
            try {
                int fila = vista.getTabla().getSelectedRow();
                int colum = vista.getTabla().getSelectedColumn();
                System.out.println("la fila es: "+fila+" la columna es: "+colum);
                int seleccion = (int)vista.getTabla().getValueAt(fila, colum);
                System.out.println(seleccion+" esta es la seleccion ");
                sentencia ="delete from tipo_responsable where Tipo_Res = ?";
                PreparedStatement senten = modelo.com.prepareStatement(sentencia);
                senten.setInt(1, seleccion);
                senten.execute();
            } catch (SQLException ex) {
                Logger.getLogger(Eliminar.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
}
}
