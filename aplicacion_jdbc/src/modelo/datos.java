
package modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;


public class datos extends AbstractTableModel {
    private ResultSet registro,re;
    private ResultSetMetaData meta;
    ArrayList<String> Nombres =new ArrayList<String>();
    
    public datos (ResultSet resulset ){
        try {
            
            registro=resulset;
            meta = registro.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        try {
            registro.last();
        } catch (SQLException ex) {
            Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("getRow");
        }
        try {
            //System.out.println(registro.getRow()+"filas");
            return registro.getRow()+1;
        } catch (SQLException ex) {
            Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        try {
            
            //System.out.println(meta.getColumnCount()+"columnas");
            return meta.getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
       
        try{
            if (registro.getRow()>i){
            registro.absolute(i+1);
            System.out.println(registro.getObject(i1+1));
            return registro.getObject(i1+1);
            }
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error en datos");
                  
            return null;
            
        }
        return null;
    
    }
    public String getColumnName(int column){
        
        try {
            Nombres.add(meta.getColumnName(column+1));
            return meta.getColumnName(column+1);
        } catch (SQLException ex) {
            Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    
    
    
}
