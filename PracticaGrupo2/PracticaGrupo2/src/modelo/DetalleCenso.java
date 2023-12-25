
package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

   //Metodo Comparar
    public boolean compareTo(DetalleCenso c, String field, Integer type) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        switch (type) {
            
            case 1:  
                if (field.equalsIgnoreCase("fechaCenso")) {
                    try {
                        Date thisDate = sdf.parse(this.getFechaCenso());
                        Date otherDate = sdf.parse(c.getFechaCenso());
                        return thisDate.compareTo(otherDate) > 0;
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return false;
                    }
                }else if (field.equalsIgnoreCase("id")) {
                    return getId().intValue() > c.getId().intValue();
                
                }else if (field.equalsIgnoreCase("id_persona")) {
                    return getId_persona().compareTo(c.getId_persona()) > 0;
                
                }else if (field.equalsIgnoreCase("motivo")) {
                    return getMotivo().compareTo(c.getMotivo()) > 0;
                
                }else if (field.equalsIgnoreCase("fechaDivorcio")) {
                    try {
                        Date thisDate = sdf.parse(this.getFechaDivorcio());
                        Date otherDate = sdf.parse(c.getFechaDivorcio());
                        return thisDate.compareTo(otherDate) > 0;
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return false;
                    }
                }else if (field.equalsIgnoreCase("estadoCivilAnterior")) {
                    return getEstadoCivilAnterior().compareTo(c.getEstadoCivilAnterior()) > 0;
                
                }else if (field.equalsIgnoreCase("estadoCivilActual")) {
                    return getEstadoCivilActual().compareTo(c.getEstadoCivilActual()) > 0;
                
                }
            case 0:
                 if (field.equalsIgnoreCase("fechaCenso")) {
                    try {
                        Date thisDate = sdf.parse(this.getFechaCenso());
                        Date otherDate = sdf.parse(c.getFechaCenso());
                        return thisDate.compareTo(otherDate) < 0;
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return false;
                    }
                }else if (field.equalsIgnoreCase("id")) {
                    return getId().intValue() < c.getId().intValue();
                
                }else if (field.equalsIgnoreCase("id_persona")) {
                    return getId_persona().compareTo(c.getId_persona()) < 0;
                
                }else if (field.equalsIgnoreCase("motivo")) {
                    return getMotivo().compareTo(c.getMotivo()) < 0;
                
                } else if (field.equalsIgnoreCase("fechaDivorcio")) {
                    try {
                        Date thisDate = sdf.parse(this.getFechaDivorcio());
                        Date otherDate = sdf.parse(c.getFechaDivorcio());
                        return thisDate.compareTo(otherDate) < 0;
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return false;
                    }
                }else if (field.equalsIgnoreCase("estadoCivilAnterior")) {
                    return getEstadoCivilAnterior().compareTo(c.getEstadoCivilAnterior()) < 0;
                
                }else if (field.equalsIgnoreCase("estadoCivilActual")) {
                    return getEstadoCivilActual().compareTo(c.getEstadoCivilActual()) < 0;
                
                }
            default:
                break;
        }
        return false;
    }
    
    public Integer compareQuickSort(DetalleCenso c, Integer type, String field) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        switch (type) {
        case 0:
            if (field.equalsIgnoreCase("fechaCenso")) {
                    try {
                        Date thisDate = sdf.parse(this.getFechaCenso());
                        Date otherDate = sdf.parse(c.getFechaCenso());
                        return thisDate.compareTo(otherDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
            }else if (field.equalsIgnoreCase("id")) {
                return this.getId().compareTo(c.getId());
            }else if (field.equalsIgnoreCase("id_persona")) {
                return this.getId_persona().compareTo(c.getId_persona());
            }else if (field.equalsIgnoreCase("motivo")) {
                return this.getMotivo().compareTo(c.getMotivo());
            }else if (field.equalsIgnoreCase("fechaDivorcio")) {
                    try {
                        Date thisDate = sdf.parse(this.getFechaDivorcio());
                        Date otherDate = sdf.parse(c.getFechaDivorcio());
                        return thisDate.compareTo(otherDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
            }else if (field.equalsIgnoreCase("estadoCivilAnterior")) {
                return this.getEstadoCivilAnterior().compareTo(c.getEstadoCivilAnterior());
            }else if (field.equalsIgnoreCase("estadoCivilActual")) {
                return this.getEstadoCivilActual().compareTo(c.getEstadoCivilActual());
            }
        case 1:
            if (field.equalsIgnoreCase("fechaCenso")) {
                    try {
                        Date thisDate = sdf.parse(this.getFechaCenso());
                        Date otherDate = sdf.parse(c.getFechaCenso());
                        return otherDate.compareTo(thisDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
            }else if (field.equalsIgnoreCase("id")) {
                return c.getId().compareTo(this.getId());
            }else if (field.equalsIgnoreCase("id_persona")) {
                return c.getId_persona().compareTo(this.getId_persona());
            }else if (field.equalsIgnoreCase("motivo")) {
                return c.getMotivo().compareTo(this.getMotivo());
            }else if (field.equalsIgnoreCase("fechaDivorcio")) {
                    try {
                        Date thisDate = sdf.parse(this.getFechaDivorcio());
                        Date otherDate = sdf.parse(c.getFechaDivorcio());
                        return otherDate.compareTo(thisDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
            }else if (field.equalsIgnoreCase("estadoCivilAnterior")) {
                return c.getEstadoCivilAnterior().compareTo(this.getEstadoCivilAnterior());
            }else if (field.equalsIgnoreCase("estadoCivilActual")) {
                return c.getEstadoCivilActual().compareTo(this.getEstadoCivilActual());
            }
        default:
            throw new AssertionError();
        }
    }
    
     @Override
    public String toString(){
        return fechaDivorcio;
    }
    
    
    
}
