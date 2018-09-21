/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextField;
import vista.vista;


public class Agregar {
    vista vista;
    modelo modelo;
    String sentencia, dato1,dato2,dato3,dato4,dato5,dato6,dato7,dato8;
    ResultSet resul;
    ResultSetMetaData meta;
    ArrayList<String> Datos ;
    
    public Agregar(vista vista, modelo modelo ){
        this.modelo = modelo;
        this.vista = vista;
        
         
    }
    
    public void Consulta(){
        String tabla = modelo.datosTabla;
        if (tabla.equalsIgnoreCase("estado")){
            try {
                sentencia = "insert into estado (Estado,idEstado) values (?,?)";
                dato1= vista.campo1.getText();
                dato2 = vista.campo2.getText();
                PreparedStatement esta = modelo.com.prepareStatement(sentencia);
                esta.setString(1, dato2);
                esta.setInt(2, Integer.parseInt(dato1));
                esta.executeUpdate();
                System.out.println("ejecuto ok");
            } catch (SQLException ex) {
                Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }else if (tabla.equalsIgnoreCase("tipo_recurso")){
            
            try {
                sentencia = "insert into tipo_recurso (Recurso,Tipo_Recurso) values (?,?)";
                dato1= vista.campo1.getText();
                dato2 = vista.campo2.getText();
                PreparedStatement esta = modelo.com.prepareStatement(sentencia);
                esta.setString(1, dato2);
                esta.setInt(2, Integer.parseInt(dato1));
                esta.executeUpdate();
                System.out.println("ejecuto ok");
            } catch (SQLException ex) {
                Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }else if (tabla.equalsIgnoreCase("tipo_responsable")){
            
            try {
                sentencia = "insert into tipo_responsable (Area,Tipo_Res) values (?,?)";
                dato1= vista.campo1.getText();
                dato2 = vista.campo2.getText();
                PreparedStatement esta = modelo.com.prepareStatement(sentencia);
                esta.setString(1, dato2);
                esta.setString(2, dato1);
                esta.executeUpdate();
                System.out.println("ejecuto ok");
            } catch (SQLException ex) {
                Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (tabla.equalsIgnoreCase("responsable")){
            
            try {
                sentencia = "insert into responsable (Codigo,Nombre, Apellido, Telefono, Tipo_Res) values (?,?,?,?,?)";
                dato1 = vista.campo1.getText();
                dato2 = vista.campo2.getText();
                dato3 = vista.campo3.getText();
                dato4 = vista.campo4.getText();
                dato5 = vista.campo5.getText();
                PreparedStatement esta = modelo.com.prepareStatement(sentencia);
                esta.setInt(1, Integer.parseInt(dato1));
                esta.setString(2, dato2);
                esta.setString(3, dato3);
                esta.setLong(4, Long.parseLong(dato4));
                esta.setInt(5, Integer.parseInt(dato5));                
                esta.executeUpdate();
                System.out.println("ejecuto ok");
            } catch (SQLException ex) {
                Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if (tabla.equalsIgnoreCase("recursos")){
            
            try {
                sentencia = "insert into recursos (Serial,Marca, Provedor,Valor_Comercial,Fecha_compra,Estado,Tipo_recurso,Codigo) values (?,?,?,?,?,?,?,?)";
                dato1 = vista.campo1.getText();
                dato2 = vista.campo2.getText();
                dato3 = vista.campo3.getText();
                dato4 = vista.campo4.getText();
                dato5 = vista.campo5.getText();
                dato6 = vista.campo6.getText();
                dato7 = vista.campo7.getText();
                dato8 = vista.campo8.getText();
                PreparedStatement esta = modelo.com.prepareStatement(sentencia);
                esta.setLong(1, Long.parseLong(dato1));
                esta.setString(2, dato2);
                esta.setString(3, dato3);
                esta.setLong(4, Long.parseLong(dato4));
                esta.setString(5, dato5);
                esta.setInt(6, Integer.parseInt(dato6));
                esta.setInt(7, Integer.parseInt(dato7));
                esta.setInt(8, Integer.parseInt(dato8));
                esta.executeUpdate();
                System.out.println("ejecuto ok");
            } catch (SQLException ex) {
                Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if (modelo.datosTabla=="recursos"){
            sentencia = "insert into recursos (Codigo,Estado,Fecha_compra,Marca,Provedor,Serial,Tipo_recurso,Valor_Comercial) values (?,?,?,?,?,?,?,?)";
        }else if (modelo.datosTabla=="responsable"){
            sentencia = "insert into responsable (Codigo,Nombre,Apellido,Telefono,Tipo_Res) values (?,?,?,?,?)";
        }else if (modelo.datosTabla=="tipo_recurso"){
            sentencia = "insert into tipo_recurso (Tipo_Recurso,Recurso) values (?,?)";
        }else if (modelo.datosTabla=="tipo_responsable"){
            sentencia = "insert into tipo_responsable (Tipo_Res,Area) values (?,?)";   
        }else if (modelo.datosTabla=="estao"){
            sentencia = "insert into tipo_responsable (idEstado,Estado) values (?,?)";
        /*int c = meta.getColumnCount();
        for(int i=1; i<c ;i++)
        meta.getColumnName(c+1);
        switch (c){
        case 2:
        sentencia = "insert into "+modelo.datosTabla+" ( ?,?,?,?,?) values (?,?,?,?,?)";
        break;
        
        }*/
        sentencia = "insert into "+modelo.datosTabla+" ( ?,?,?,?,?) values (?,?,?,?,?)";
        
        
    }
    
}
}
