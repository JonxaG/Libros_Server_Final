/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.exception;

/**
 * This class represents an error or incompletion updating a Book entity operation.
 * @author Jon Xabier Gimenez
 */
public class ActualizarLibroException extends Exception { 
     /**
     * Creates a new instance of <code>ActualizarLibroException</code> without
     * detail message.
     */
    public ActualizarLibroException() {
    }

    /**
     * Constructs an instance of <code>ActualizarLibroException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ActualizarLibroException(String msg) {
        super(msg);
    }
}
