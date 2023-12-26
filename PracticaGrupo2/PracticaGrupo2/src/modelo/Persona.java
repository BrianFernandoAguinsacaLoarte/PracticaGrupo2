
package modelo;

import modelo.rol.TipoEstado;


public class Persona {
    
    //Atributos
    
    private Integer id;
    private Integer id_Censador;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String rol;
    private Integer edad;
    private String genero;
    private String correo;
    private String cedula;
    private String telefono;
    
    
    //Constructor

    public Persona(String nombres, String apellidos,Integer edad, String cedula) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.cedula = cedula;
    }
    
    public Persona(){
        
    }

    //Getter and Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_Censador() {
        return id_Censador;
    }

    public void setId_Censador(Integer id_Censador) {
        this.id_Censador = id_Censador;
    }
    
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

  
    
    
    //Metodo Comparar
    public boolean compareTo(Persona c, String field, Integer type) {
        
        switch (type) {
            
            case 1:     
                if (field.equalsIgnoreCase("nombres")) {
                    return getNombres().compareTo(c.getNombres()) > 0;
                
                }else if (field.equalsIgnoreCase("id")) {
                    return getId().intValue() > c.getId().intValue();
                
                }else if (field.equalsIgnoreCase("apellidos")) {
                    return getApellidos().compareTo(c.getApellidos()) > 0;
                
                }else if (field.equalsIgnoreCase("direccion")) {
                    return getDireccion().compareTo(c.getDireccion()) > 0;
                
                }else if (field.equalsIgnoreCase("rol")) {
                    return getRol().compareTo(c.getRol()) > 0;
               
                }else if (field.equalsIgnoreCase("edad")) {
                    return getEdad().intValue() > c.getEdad().intValue();
                
                }else if (field.equalsIgnoreCase("genero")) {
                    return getGenero().compareTo(c.getGenero()) > 0;
                
                }else if (field.equalsIgnoreCase("correo")) {
                    return getCorreo().compareTo(c.getCorreo()) > 0;
                
                }else if (field.equalsIgnoreCase("cedula")) {
                    return getCedula().compareTo(c.getCedula()) > 0;
                
                }else if (field.equalsIgnoreCase("telefono")) {
                    return getTelefono().compareTo(c.getTelefono()) > 0;
                
                }else if (field.equalsIgnoreCase("id_Censador")) {
                    return getId_Censador().intValue() > c.getId_Censador().intValue();
                }
            
            case 0:
                if (field.equalsIgnoreCase("nombres")) {
                    return getNombres().compareTo(c.getNombres()) < 0;
                
                } else if (field.equalsIgnoreCase("id")) {
                    return getId().intValue() < c.getId().intValue();
                
                }else if (field.equalsIgnoreCase("apellidos")) {
                    return getApellidos().compareTo(c.getApellidos()) < 0;
                
                }else if (field.equalsIgnoreCase("direccion")) {
                    return getDireccion().compareTo(c.getDireccion()) < 0;
                
                }else if (field.equalsIgnoreCase("rol")) {
                    return getRol().compareTo(c.getRol()) < 0;
                
                }else if (field.equalsIgnoreCase("edad")) {
                    return getEdad().intValue() < c.getEdad().intValue();
                
                }else if (field.equalsIgnoreCase("genero")) {
                    return getGenero().compareTo(c.getGenero()) < 0;
                
                }else if (field.equalsIgnoreCase("correo")) {
                    return getCorreo().compareTo(c.getCorreo()) < 0;
                
                }else if (field.equalsIgnoreCase("cedula")) {
                    return getCedula().compareTo(c.getCedula()) < 0;
                
                }else if (field.equalsIgnoreCase("telefono")) {
                    return getTelefono().compareTo(c.getTelefono()) < 0;
                
                }else if (field.equalsIgnoreCase("id_Censador")) {
                    return getId_Censador().intValue() < c.getId_Censador().intValue();
                }
            default:
                break;
        }
        return false;
    }
    
    //Metodo Comparar para el QuickSort
    public Integer compareQuickSort(Persona c, Integer type, String field) {
    switch (type) {
        case 0:
            if (field.equalsIgnoreCase("nombres")) {
                return this.getNombres().compareTo(c.getNombres());
            } else if (field.equalsIgnoreCase("id")) {
                return this.getId().compareTo(c.getId());
            } else if (field.equalsIgnoreCase("apellidos")) {
                return this.getApellidos().compareTo(c.getApellidos());
            } else if (field.equalsIgnoreCase("direccion")) {
                return this.getDireccion().compareTo(c.getDireccion());
            } else if (field.equalsIgnoreCase("rol")) {
                return this.getRol().compareTo(c.getRol());
            }else if (field.equalsIgnoreCase("edad")) {
                return this.getEdad().compareTo(c.getEdad());
            }else if (field.equalsIgnoreCase("genero")) {
                return this.getGenero().compareTo(c.getGenero());
            }else if (field.equalsIgnoreCase("correo")) {
                return this.getCorreo().compareTo(c.getCorreo());
            }else if (field.equalsIgnoreCase("cedula")) {
                return this.getCedula().compareTo(c.getCedula());
            }else if (field.equalsIgnoreCase("telefono")) {
                return this.getTelefono().compareTo(c.getTelefono());
            }else if (field.equalsIgnoreCase("id_Censador")) {
                return this.getId_Censador().compareTo(c.getId_Censador());
            }
        case 1:
            if (field.equalsIgnoreCase("nombres")) {
                return c.getNombres().compareTo(this.getNombres());
            } else if (field.equalsIgnoreCase("id")) {
                return c.getId().compareTo(this.getId());
            } else if (field.equalsIgnoreCase("apellidos")) {
                return c.getApellidos().compareTo(this.getApellidos());
            } else if (field.equalsIgnoreCase("direccion")) {
                return c.getDireccion().compareTo(this.getDireccion());
            } else if (field.equalsIgnoreCase("rol")) {
                return c.getRol().compareTo(this.getRol());
            }else if (field.equalsIgnoreCase("edad")) {
                return c.getEdad().compareTo(this.getEdad());
            }else if (field.equalsIgnoreCase("genero")) {
                return c.getGenero().compareTo(this.getGenero());
            }else if (field.equalsIgnoreCase("correo")) {
                return c.getCorreo().compareTo(this.getCorreo());
            }else if (field.equalsIgnoreCase("cedula")) {
                return c.getCedula().compareTo(this.getCedula());
            }else if (field.equalsIgnoreCase("telefono")) {
                return c.getTelefono().compareTo(this.getTelefono());
            }else if (field.equalsIgnoreCase("id_Censador")) {
                return c.getId_Censador().compareTo(this.getId_Censador());
            }
        default:
            throw new AssertionError();
        }
    }
    
    //Criterios para las busquedas
    public static String criterio(Persona persona, String field) {
        switch (field.toLowerCase()) {
            case "nombres":
                return persona.getNombres();
            case "apellidos":
                return persona.getApellidos();
            case "direccion":
                return persona.getDireccion();
            case "rol":
                return persona.getRol();
            case "genero":
                return persona.getGenero();
            case "correo":
                return persona.getCorreo();
            case "cedula":
                return persona.getCedula();
            case "telefono":
                return persona.getTelefono();
            default:
                throw new IllegalArgumentException("Opcion invalida");
        }
    }
    
    //Para casos con valor Int
    public static Integer criterioEntero(Persona persona, String field) {
        switch (field.toLowerCase()) {
            case "id":
                return persona.getId();
            case "edad":
                return persona.getEdad();
            default:
                throw new IllegalArgumentException("Opcion invalida");
        }
    }
    
    @Override
    public String toString(){
        return apellidos;
    }
    
}
