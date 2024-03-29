/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.exception;

/**
 * This class represents an error or incompletion in an User object properties.
 * @author Iker Iglesias
 */
public class UpdateUserException extends Exception {

    /**
     * Creates a new instance of <code>UpdateUserException</code> without detail
     * message.
     */
    public UpdateUserException() {
    }

    /**
     * Constructs an instance of <code>UpdateUserException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UpdateUserException(String msg) {
        super(msg);
    }
}
