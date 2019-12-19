/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import javax.ejb.Local;
import libros.entity.User;
import libros.exception.CreateUserException;
import libros.exception.DeleteUserException;
import libros.exception.UpdateUserException;
import libros.exception.UserException;

/**
 *
 * @author 2dam
 */
@Local
public interface GestorUserBeanLocal {

    public boolean getUser(String user, String password) throws UserException;

    public void createUser(User user) throws CreateUserException;

    public void deleteUser(User user) throws DeleteUserException;

    public void updateUser(User user) throws UpdateUserException;
}
