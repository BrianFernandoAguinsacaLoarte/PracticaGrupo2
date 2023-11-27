/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package controlador.Excepcion;

/**
 *
 * @author Usuario iTC
 */
public class VacioExcepcion extends Exception {

    /**
     * Creates a new instance of <code>VacioExcepcion</code> without detail
     * message.
     */
    public VacioExcepcion() {
    }

    /**
     * Constructs an instance of <code>VacioExcepcion</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public VacioExcepcion(String msg) {
        super(msg);
    }
}
