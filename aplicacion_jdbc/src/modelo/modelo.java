/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.awt.BorderLayout;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import vista.vista;


public class modelo {
    conexion conexion;
    vista vista;
    Connection com;
    datos datos;
    public String datosTabla;
    ResultSet resultado;
    
    public modelo(){
        vista = new vista(this);
        iniciar();
        
    }
    
    public void iniciar(){
        conexion = new conexion(this,vista);
        com =conexion.conectar();
        tablas tabla = new tablas(conexion.miconexion,vista);
        
    }
    public TableModel mostrarDatos2 (){
        
            datos = new datos(resultado);
        
        return datos;
    }
    
    public void mostrarDatos(String tabla){
        datosTabla=tabla;
        ArrayList<String> campos = new ArrayList<String>();
        String consulta="select * from "+tabla;
        try{
            //vista.getArea().setText("");
            Statement sentencia = com.createStatement();
            resultado = sentencia.executeQuery(consulta);
            vista.getTabla().setModel(mostrarDatos2());
            //vista.validate();
            /*ResultSetMetaData resulbd=resultado.getMetaData();
            for (int i=1;i<=resulbd.getColumnCount();i++){
                campos.add(resulbd.getColumnLabel(i));
            }
            while(resultado.next()){
                for(String nombrecampo:campos){
                   vista.getArea().append(resultado.getString(nombrecampo)+" ");
                }
                vista.getArea().append("\n");
                
            }*/
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("mostrar datos");
        }
        
    }
   
    
    
    
}
