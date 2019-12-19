/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.exception;

/**
 * This class represents an error or incompletion deleting a Book entity operation.
 * @author Jon Xabier Gimenez
 */
public class BorrarLibroException extends Exception { 
     /**
     * Creates a new instance of <code>BorrarLibroException</code> without
     * detail message.
     */
    public BorrarLibroException() {
    }

    /**
     * Constructs an instance of <code>BorrarLibroException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BorrarLibroException(String msg) {
        super(msg);
    }
}
