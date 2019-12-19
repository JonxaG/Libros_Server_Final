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
public class UpdateCompraException extends Exception {

    /**
     * Creates a new instance of <code>UpdateCompraException</code> without
     * detail message.
     */
    public UpdateCompraException() {
    }

    /**
     * Constructs an instance of <code>UpdateCompraException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UpdateCompraException(String msg) {
        super(msg);
    }
}
