
package controlador;

import controlador.TDA.listas.LinkedList;
import controlador.Excepcion.VacioExcepcion;
import modelo.Persona;


public class PersonaController {
    
    //Objectos
    private Persona persona = new Persona();
    private LinkedList<Persona> listaPersona = new LinkedList<>();
    
    
    //Constructor
    public PersonaController(){
        /*
        listaPersona.add(new Persona("Brian", "Aguinsaca", "1106017716", persona.getTipoEstado().SEPARADO));
        listaPersona.add(new Persona("Baek", "SY", "1106015646", persona.getTipoEstado().SEPARADO));
        listaPersona.add(new Persona("Weeknd", "Xo", "1124017716", persona.getTipoEstado().SEPARADO));
        */
    }
   
    
    //Getter and Setter

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LinkedList<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(LinkedList<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }
    
    
    //Otros
     public Boolean guardar(){
        persona.setId(generar_Id());
        listaPersona.add(persona);
        return true;
    }
     
    public Integer generar_Id(){
        return listaPersona.getSize() +1;
    }
    //Compruebo Funcionamiento De la lista.
    public static void main(String[] args) throws VacioExcepcion{
        PersonaController pc = new PersonaController();
        
        for(int i=0; i< pc.getListaPersona().getSize(); i++){
            System.out.println(pc.getListaPersona().get(i).toString());
        }
        
    }
    
}
