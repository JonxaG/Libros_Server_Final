/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.exception;

/**
 * This class represents an error or incompletion creating a Book entity operation.
 * @author Jon Xabier Gimenez
 */
public class CreateLibroException extends Exception { 
     /**
     * Creates a new instance of <code>CreateLibroException</code> without
     * detail message.
     */
    public CreateLibroException() {
    }

    /**
     * Constructs an instance of <code>CreateLibroException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CreateLibroException(String msg) {
        super(msg);
    }
}
