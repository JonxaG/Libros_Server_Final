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
public class CompraException extends Exception {
        /**
     * Creates a new instance of <code>CompraException</code> without
     * detail message.
     */
    public CompraException() {
    }

    /**
     * Constructs an instance of <code>CompraException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CompraException(String msg) {
        super(msg);
    }
}
