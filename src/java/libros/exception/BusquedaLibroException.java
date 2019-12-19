/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.exception;

/**
 * This class represents an error on a query into a Book entities.
 * @author Jon Xabier Gimenez
 */
public class BusquedaLibroException extends Exception {
    /**
     * Creates a new instance of <code>BusquedaLibroException</code> without
     * detail message.
     */
    public BusquedaLibroException() {
    }

    /**
     * Constructs an instance of <code>BusquedaLibroException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BusquedaLibroException(String msg) {
        super(msg);
    }
}
