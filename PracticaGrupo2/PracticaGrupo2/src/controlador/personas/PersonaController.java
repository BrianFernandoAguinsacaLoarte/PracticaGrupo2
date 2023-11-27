
package controlador.personas;

import controlador.TDA.listas.LinkedList;
import controlador.dao.DataAccessObject;
import modelo.Persona;


public class PersonaController extends DataAccessObject<Persona>{
    
    //Objectos
    private Persona persona = new Persona();
    private LinkedList<Persona> listaPersona = new LinkedList<>();
    private Integer index = -1; //Index para el Update

    //Constructor
    public PersonaController() {
        super(Persona.class);
    }
    
    
    //Metodos
    
    public boolean save(){
        persona.setId(generated_id());//BDD Esto desaparece
        return save(persona);
    }
    
    public boolean update(Integer index){
        return update(persona,index);
    }
    
    
    
    //Getter and Setter

    public Persona getPersona() {
        
        if(persona == null){
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public LinkedList<Persona> getListaPersona() {
        
        if(listaPersona.isEmpty()){
            listaPersona = listAll();
            
        }
        return listaPersona;
    }

    public void setListaPersona(LinkedList<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    
    //COmpruebo Funcionamiento de la lista
    public static void main(String[] args){
        PersonaController pc = new PersonaController();
       
        System.out.println(pc.listAll().getSize());
        System.out.println(pc.listAll().imprimir());
        
    }
    
}
