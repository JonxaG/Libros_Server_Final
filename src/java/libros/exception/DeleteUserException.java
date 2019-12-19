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
public class DeleteUserException extends Exception {

    /**
     * Creates a new instance of <code>DeleteUserException</code> without detail
     * message.
     */
    public DeleteUserException() {
    }

    /**
     * Constructs an instance of <code>DeleteUserException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DeleteUserException(String msg) {
        super(msg);
    }
}
