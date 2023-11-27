
package controlador;

import controlador.Excepcion.VacioExcepcion;
import controlador.TDA.listas.LinkedList;
import modelo.DetalleCenso;


public class DetalleController {
    
    //Objectos
    private DetalleCenso dt= new DetalleCenso();
    private LinkedList<DetalleCenso> detalles = new LinkedList<>();
    
    //Constructor
    public DetalleController(){
        detalles.add(new DetalleCenso("14-20-23","Problemas","14-05-22","Casado","Separado"));
    }
    
    //Getter and Setter

    public DetalleCenso getDt() {
        return dt;
    }

    public void setDt(DetalleCenso dt) {
        this.dt = dt;
    }

    public LinkedList<DetalleCenso> getDetalles() {
        return detalles;
    }

    public void setDetalles(LinkedList<DetalleCenso> detalles) {
        this.detalles = detalles;
    }
    
    
    //Otros
     public Boolean guardar(){
        dt.setId(generar_Id());
        detalles.add(dt);
        return true;
    }
     
    public Integer generar_Id(){
        return detalles.getSize() +1;
    }
    
    //Compruebo Funcionamiento de la lista
    public static void main(String[] args) throws VacioExcepcion{
        DetalleController dt = new DetalleController();
        
        for(int i=0; i< dt.getDetalles().getSize(); i++){
            System.out.println(dt.getDetalles().get(i).toString());
        }
    }
}
