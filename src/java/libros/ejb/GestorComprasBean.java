/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import java.util.Collection;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import libros.entity.Purchase;
import libros.entity.User;
import libros.exception.CompraException;
import libros.exception.CreateCompraException;
import libros.exception.DeleteCompraException;
import libros.exception.UpdateCompraException;

/**
 * Stateless EJB for managing operations with Purchase entities.
 *
 * @author Iker Iglesias
 */
@Stateless
public class GestorComprasBean implements GestorComprasBeanLocal {

    private static final Logger logger = Logger.getLogger("libros.ejb.GestorComprasBean");
    @PersistenceContext
    private EntityManager em;

    /**
     * Method that returns every book purchased by an user.
     *
     * @param usuario
     * @return compras collection of user purchases.
     * @throws CompraException
     */
    @Override
    public Collection getAllCompras(User usuario) throws CompraException {
        logger.info("Getting all the purchases");
        Collection<Purchase> datos;
        try {
            // se busca al usuario a partir del nombre de usuario
            datos = em.createNamedQuery("findPurchasesByUser").setParameter("usuario", usuario).getResultList();
        } catch (Exception e) {
            logger.severe("Fallo en la consulta");
            logger.severe(e.getMessage());
            throw new CompraException(e.getMessage());
        }
        return datos;
    }

    /**
     * Method that saves user purchases
     *
     * @param purchases
     * @throws CreateCompraException
     */
    @Override
    public void createCompra(Purchase purchases) throws CreateCompraException {
        logger.info("Doing a purchase");

        try {
            em.persist(purchases);
            logger.info("Compra creada");
        } catch (Exception e) {
            logger.severe("Error al crear compra");
            logger.severe(e.getMessage());
            throw new CreateCompraException(e.getMessage());
        }
    }

    /**
     * Method that deletes user purchases
     *
     * @param purchases
     * @throws DeleteCompraException
     */
    @Override
    public void deleteCompra(Purchase purchases) throws DeleteCompraException {
        logger.info("Deleting purchase");

        try {
            purchases = em.merge(purchases);
            em.remove(purchases);
            logger.info("Compra borrada");
        } catch (Exception e) {
            logger.severe("Error al borrar compra");
            logger.severe(e.getMessage());
            throw new DeleteCompraException(e.getMessage());
        }
    }

    /**
     * Method that updates user purchases
     *
     * @param purchases
     * @throws UpdateCompraException
     */
    @Override
    public void updateCompra(Purchase purchases) throws UpdateCompraException {
        logger.info("Updating purchase");
        try {
            if (!em.contains(purchases)) {
                em.merge(purchases);
                logger.info("Compra modificada");
            }

        } catch (Exception e) {
            logger.severe("Error al modificar compra");
            logger.severe(e.getMessage());
            throw new UpdateCompraException(e.getMessage());
        }
    }

    /**
     * Method that gets a Purchase by id
     *
     * @param id
     * @return
     * @throws CompraException
     */
    @Override
    public Purchase getCompraById(Integer id) throws CompraException {

        logger.info("Getting purchase by id");
        Purchase dato;
        try {
            // se busca al usuario a partir del nombre de usuario
            dato = em.find(Purchase.class, id);
            //dato=(Purchase) em.createNamedQuery("findVentaById").setParameter("codigo", id).getSingleResult();
            logger.info("devoviendo compras del usuario");
        } catch (Exception e) {
            logger.severe("Fallo en la consulta");
            logger.severe(e.getMessage());
            throw new CompraException(e.getMessage());
        }
        return dato;

    }

    @Override
    public User getUserById(String usuario) throws CompraException {
        User u = null;
        logger.info("Buscando usuario");
        try {
            u = em.find(User.class, usuario);
            logger.info("devolviendo usuario");
        } catch (Exception e) {
            logger.severe("Fallo en la consulta");
            logger.severe(e.getMessage());
            throw new CompraException(e.getMessage());
        }

        return u;
    }

}
