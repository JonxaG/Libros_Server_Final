/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import java.util.Collection;
import javax.ejb.Local;
import libros.entity.Purchase;
import libros.entity.User;
import libros.exception.CompraException;
import libros.exception.CreateCompraException;
import libros.exception.DeleteCompraException;
import libros.exception.UpdateCompraException;

/**
 *
 * @author Iker Iglesias
 */
@Local
public interface GestorComprasBeanLocal {

    public Collection<Purchase> getAllCompras(User usuario) throws CompraException;

    public Purchase getCompraById(Integer id) throws CompraException;

    public User getUserById(String usuario) throws CompraException;

    public void createCompra(Purchase purchases) throws CreateCompraException;

    public void deleteCompra(Purchase purchases) throws DeleteCompraException;

    public void updateCompra(Purchase purchases) throws UpdateCompraException;

}
