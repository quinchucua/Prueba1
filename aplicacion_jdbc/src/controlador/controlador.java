
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Agregar;
import modelo.Eliminar;
import modelo.modelo;
import vista.vista;

public class controlador implements ActionListener {
    modelo modelo;
    vista vista;
    Agregar agregar;
    Eliminar eliminar;
    private String tabla;
    
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
    public void Eliminard(){
        if(eliminar == null){
            eliminar = new Eliminar(vista,modelo);
        }
        eliminar.DeleteData();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== vista.boton1){
            ObtenerAgregar();
        }else if (ae.getSource()==vista.boton2){
            Eliminard();
        }else if (ae.getSource()== vista.boton3){
            System.out.println("boton3");
        }
        
        tabla=(String)(vista.getDesplegable().getSelectedItem());
        if (tabla.equals("estado")){
            
            vista.TablaEstado();
            cont++;
            
        }
        if (tabla.equals("tipo_recurso")){
            vista.TablaTipoRecur();
        }
        if (tabla.equals("tipo_responsable")){
            vista.TablaTipoRespo();
        }
        if (tabla.equals("responsable")){
            vista.TablaResponsable();
        }
        if (tabla.equals("recursos")){
            vista.TablaRecursos();
        }
        this.modelo.mostrarDatos(tabla);
        
    }

    
    
    
    
    
}
