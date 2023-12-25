
package vista.listas.tablas;

import controlador.TDA.listas.LinkedList;
import javax.swing.table.AbstractTableModel;
import modelo.Persona;


public class ModeloTablaRegistro extends AbstractTableModel {

    LinkedList<Persona> listaTablaPersona = new LinkedList<>();
    
    @Override
    public int getRowCount() {
        return listaTablaPersona.getSize();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

     @Override
    public Object getValueAt(int fila, int column) {

        Persona persona = null;
        try {
       
            persona = listaTablaPersona.get(fila);

        } catch (Exception e) {
        }
        
        switch (column) {
            case 0: 
                    return (persona != null)? persona.getId(): "";
            case 1:
                    return (persona != null)? persona.getNombres(): "";
            case 2:
                    return (persona != null)? persona.getApellidos(): "";
            case 3:
                    return (persona != null)? persona.getRol(): "";
            case 4: 
                    return (persona != null)? persona.getGenero(): "";
            case 5: 
                    return (persona != null)? persona.getEdad(): "";
            case 6: 
                    return (persona != null)? persona.getDireccion(): "";
            case 7: 
                    return (persona != null)? persona.getCorreo(): "";
            case 8: 
                    return (persona != null)? persona.getCedula(): "";
            case 9: 
                    return (persona != null)? persona.getTelefono(): "";
            
            default:
                return null;
        }
    }
   
    @Override
    public String getColumnName(int column){
        switch(column){
             case 0: 
                 return "Id";
             case 1: 
                 return "Nombres";
             case 2: 
                 return "Apellidos";
             case 3:
                 return "Rol";
             case 4: 
                 return "Genero";
             case 5: 
                 return "Edad";         
             case 6: 
                 return "Dirección";
             case 7: 
                 return "Correo";
             case 8:
                 return "Cedula";
             case 9: 
                 return "Telefono";
           
              
             default: 
                 return null;
         }
    }
    
    //Getter and Setter

    public LinkedList<Persona> getListaTablaPersona() {
        return listaTablaPersona;
    }

    public void setListaTablaPersona(LinkedList<Persona> listaTablaPersona) {
        this.listaTablaPersona = listaTablaPersona;
    }
    
    
}
