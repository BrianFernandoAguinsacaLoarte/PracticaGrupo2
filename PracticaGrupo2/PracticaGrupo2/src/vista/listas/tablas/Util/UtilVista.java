
package vista.listas.tablas.Util;

import controlador.Excepcion.VacioExcepcion;
import controlador.personas.DetalleController;
import controlador.personas.PersonaController;
import javax.swing.JComboBox;
import modelo.Persona;


public class UtilVista {
    
    public static void cargarComboCliente(JComboBox cbxPersonas) throws VacioExcepcion{
        PersonaController pc = new PersonaController();
        cbxPersonas.removeAllItems();
        
        for(int i=0; i< pc.getListaPersona().getSize(); i++){
            cbxPersonas.addItem(pc.getListaPersona().get(i).getApellidos());
        }
    }
    
    //Cargo Objeto de tipo String
    public static String getComboBoxCliente(JComboBox cbxPersonas){
        return (String) cbxPersonas.getSelectedItem();
    }
    
    //Comprobando funcionamiento 
    public static void main(String[] args){
        PersonaController mc = new PersonaController();
        for (int i = 0; i < mc.getListaPersona().getSize(); i++){
            try {
                System.out.println(mc.getListaPersona().get(i).getApellidos());
            } catch (Exception e) {
            }
        }
       
    }
}
