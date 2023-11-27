
package controlador.personas;

import controlador.TDA.listas.LinkedList;
import controlador.dao.DataAccessObject;
import modelo.DetalleCenso;

public class DetalleController<T> extends DataAccessObject<DetalleCenso> {
    
    //Objectos
    private DetalleCenso dt = new DetalleCenso();
    private LinkedList<DetalleCenso> detalles = new LinkedList<>();
    private Integer index = -1;
    
    //Constructor
    public DetalleController() {
        super(DetalleCenso.class);
    }
    
    //Metodos
    
    public boolean save(){
        dt.setId(generated_id());//BDD Esto desaparece
        return save(dt);
    }
    
    public boolean update(Integer index){
        return update(dt,index);
    }
    
    //Getter and Setter

    public DetalleCenso getDt() {
        if(dt == null){
            dt = new DetalleCenso();
        }
        return dt;
    }

    public void setDt(DetalleCenso dt) {
        this.dt = dt;
    }

    public LinkedList<DetalleCenso> getDetalles() {
        if(detalles.isEmpty()){
            detalles = listAll();
        }
        return detalles;
    }

    public void setDetalles(LinkedList<DetalleCenso> detalles) {
        this.detalles = detalles;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
    
    //Compruebo Funciomamiento de la Lista
    public static void main(String[] args){
        DetalleController dtc = new DetalleController();
        
        System.out.println(dtc.getDetalles().getSize());
    }
    
}
