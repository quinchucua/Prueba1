
package vista;

import com.sun.org.apache.xml.internal.security.Init;
import controlador.controlador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javax.swing.*;
import modelo.modelo;


public class vista extends JFrame {
    private JComboBox desplegable;
    private JTextArea area;
    private JTable tabla;
    public  JPanel panel2, panel,panel3,panel4;
    public JButton boton1,boton2,boton3;
    public JTextField campo1, campo2,campo3,campo4,campo5,campo6,campo7,campo8;
    
    modelo modelo;
    controlador controlador;
    
    
    public JTable getTabla(){
        return tabla;
    }
    public void setTabla(JTable tabla){
        this.tabla=tabla;
    }
    public controlador getControlador(){
        return controlador;
    }

    public JComboBox getDesplegable() {
        return desplegable;
    }

    public void setDesplegable(JComboBox desplegable) {
        this.desplegable = desplegable;
    }

    public JTextArea getArea() {
        return area;
    }

    public void setArea(JTextArea area) {
        this.area = area;
    }
    public void Eventos(){
        this.desplegable.addActionListener(ObtenerControlador());
        this.boton1.addActionListener(ObtenerControlador());
        this.boton2.addActionListener(ObtenerControlador());
        this.boton3.addActionListener(ObtenerControlador());
        
        
        

    }
    public controlador ObtenerControlador(){
        if (controlador == null){
            controlador = new controlador(this,this.modelo);
        }
        return controlador;
    }
    

    public vista(modelo modelo) {
        this.modelo=modelo;
        setBounds(300, 150, 700, 500);
        setTitle("conexion a bases de datos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        componentes();
        setVisible(true);
        
        
                 
    }


    public void componentes(){
        panel = new JPanel();
        
        add(panel,BorderLayout.NORTH);
        panel.setLayout(new BorderLayout());
        desplegable = new JComboBox();
        panel.add(desplegable, BorderLayout.NORTH);
        tabla = new JTable();
        panel2 = new JPanel();
        add(panel2,BorderLayout.SOUTH);
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel3.setLayout(new GridLayout(1,2));
        //panel.add(panel2,BorderLayout.SOUTH);
        boton1= new JButton("Agregar");
        boton2 = new JButton("Eliminar");
        boton3 = new JButton("Editar"); 
        panel.add(new JScrollPane(tabla),BorderLayout.CENTER);
        panel2.setLayout(new BorderLayout());
        panel2.add(panel3,BorderLayout.NORTH);        
        panel2.add(panel4,BorderLayout.SOUTH);
        panel4.add(boton1);
        panel4.add(boton2);
        panel4.add(boton3);
        campo1= new JTextField("",15);
        campo2= new JTextField("",15);
        campo3= new JTextField("",15);
        campo4= new JTextField("",15);
        campo5= new JTextField("",15);
        campo6= new JTextField("",15);
        campo7= new JTextField("",15);
        campo8= new JTextField("",15);
        add(panel);
        Eventos();
                
        
                 
    }
    public void TablaEstado(){
        panel3.removeAll();
        panel3.add(campo1);
        panel3.add(campo2);
        panel3.updateUI();
        
    }
    public void TablaTipoRecur(){
        panel3.removeAll();
        panel3.add(campo1);
        panel3.add(campo2);
        campo1.setText("");
        campo2.setText("");
        panel3.updateUI();
       
    }
    public void TablaTipoRespo(){
        panel3.removeAll();
        panel3.add(campo1);
        panel3.add(campo2);
        campo1.setText("");
        campo2.setText("");
        panel3.updateUI();
       
    }
    public void TablaResponsable(){
        panel3.removeAll();
        panel3.add(campo1);
        panel3.add(campo2);
        panel3.add(campo3);
        panel3.add(campo4);
        panel3.add(campo5);
        campo1.setText("");
        campo2.setText("");
        campo3.setText("");
        campo4.setText("");
        campo5.setText("");
        panel3.updateUI();
        }
     public void TablaRecursos(){
        panel3.removeAll();
        panel3.add(campo1);
        panel3.add(campo2);
        panel3.add(campo3);
        panel3.add(campo4);
        panel3.add(campo5);
        panel3.add(campo6);
        panel3.add(campo7);
        panel3.add(campo8);
        campo1.setText("");
        campo2.setText("");
        campo3.setText("");
        campo4.setText("");
        campo5.setText("");
        campo6.setText("");
        campo7.setText("");
        campo8.setText("");
        panel3.updateUI();
        }
    
}
    
    
   
    
    

