
package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import vista.vista;

public class conexion {
    modelo modelo;
    vista vista;
    Connection miconexion;
    FileReader entrada;
    String archivo[]=new String[3];
    
    public conexion(modelo modelo,vista vista){
        this.modelo=modelo;
        this.vista=vista;
        
    }
    public Connection conectar(){
        try {
            
            /*try {
                //entrada = new FileReader("C:/Users/Alfonso/Documents/tutoriales_java/configuracion2.txt");
                
            }catch(IOException e){
                
                JFileChooser seleccion= new JFileChooser();
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("archivos .txt", "txt");
                seleccion.setFileFilter(filtro);
                int retorno = seleccion.showOpenDialog(vista);
                if(retorno==JFileChooser.APPROVE_OPTION){
                    try {
                        entrada=new FileReader(seleccion.getSelectedFile().getAbsolutePath());
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
            }
            }
                
                BufferedReader bufer = new BufferedReader(entrada);
                for(int i=0;i<=2;i++){
                    try {
                        archivo[i]=bufer.readLine();
                    } catch (IOException ex) {
                        Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }*/
             
            //miconexion = DriverManager.getConnection(archivo[0],archivo[1],archivo[2]);
            miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/api?zeroDateTimeBehavior=convertToNull","root","");
            
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error de conexion");
        }
        return miconexion;
    }
    
}
