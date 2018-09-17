
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Agregar;
import modelo.modelo;
import vista.vista;

public class controlador implements ActionListener {
    modelo modelo;
    vista vista;
    private String tabla;
    Agregar agregar;
    public controlador(vista vista, modelo modelo){
        
        this.vista= vista;
        this.modelo= modelo;
        
    }
    public void ObtenerAgregar(){
        if (agregar == null){
            agregar = new Agregar(vista,modelo);
        }
        agregar.Consulta();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== vista.boton1){
            ObtenerAgregar();
        }else if (ae.getSource()==vista.boton2){
            System.out.println("boton2");
        }else if (ae.getSource()== vista.boton3){
            System.out.println("boton3");
        }
        
        tabla=(String)(vista.getDesplegable().getSelectedItem());
        this.modelo.mostrarDatos(tabla);
        
    }

    
    
    
    
    
}
