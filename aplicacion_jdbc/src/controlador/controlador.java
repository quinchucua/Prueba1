
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
    int cont=1;
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
        if (tabla.equals("estado")){
            if (cont==1){
            cont = vista.TablaEstado();
            cont++;
            }
        }
        if (tabla.equals("tipo_recurso")){
            vista.TablaTipoRecur();
        }
        if (tabla.equals("tipo_responsable")){
            vista.TablaTipoRespo();
        }
        this.modelo.mostrarDatos(tabla);
        
    }

    
    
    
    
    
}
