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
public class DeleteCompraException extends Exception {

    /**
     * Creates a new instance of <code>DeleteCompraException</code> without
     * detail message.
     */
    public DeleteCompraException() {
    }

    /**
     * Constructs an instance of <code>DeleteCompraException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DeleteCompraException(String msg) {
        super(msg);
    }
}
