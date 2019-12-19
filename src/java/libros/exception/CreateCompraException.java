/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.exception;

/**
 * This class represents an error or incompletion in a Purchase object properties.
 * @author Iker Iglesias
 */
public class CreateCompraException extends Exception {

    /**
     * Creates a new instance of <code>CreateCompraException</code> without
     * detail message.
     */
    public CreateCompraException() {
    }

    /**
     * Constructs an instance of <code>CreateCompraException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CreateCompraException(String msg) {
        super(msg);
    }
}
