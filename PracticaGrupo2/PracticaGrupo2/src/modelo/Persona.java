
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

  
    
    
    @Override
    public String toString(){
        return apellidos;
    }
    
}
