
package modelo;

import java.util.Date;


public class DetalleCenso {
    
    //Atributos
    private Integer id;
    private String id_persona;
    private String fechaCenso;
    private String motivo;
    private String fechaDivorcio;
    private String estadoCivilAnterior;
    private String estadoCivilActual;
    
    //Constructor
    
    public DetalleCenso(){
    }
    
    public DetalleCenso(String fechaCenso, String motivo, String fechaDivorcio, String estadoCivilAnterior, String estadoCivilActual) {
        this.fechaCenso = fechaCenso;
        this.motivo = motivo;
        this.fechaDivorcio = fechaDivorcio;
        this.estadoCivilAnterior = estadoCivilAnterior;
        this.estadoCivilActual = estadoCivilActual;
    }
    

    //Getter and Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    

    public String getFechaCenso() {
        return fechaCenso;
    }

    public void setFechaCenso(String fechaCenso) {
        this.fechaCenso = fechaCenso;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFechaDivorcio() {
        return fechaDivorcio;
    }

    public void setFechaDivorcio(String fechaDivorcio) {
        this.fechaDivorcio = fechaDivorcio;
    }

    public String getEstadoCivilAnterior() {
        return estadoCivilAnterior;
    }

    public void setEstadoCivilAnterior(String estadoCivilAnterior) {
        this.estadoCivilAnterior = estadoCivilAnterior;
    }

    public String getEstadoCivilActual() {
        return estadoCivilActual;
    }

    public void setEstadoCivilActual(String estadoCivilActual) {
        this.estadoCivilActual = estadoCivilActual;
    }

    public String toString(){
        return fechaCenso+"--"+motivo+"--"+fechaDivorcio+"--"+estadoCivilAnterior+"--"+estadoCivilActual+"";
    }
    
    
    
}
