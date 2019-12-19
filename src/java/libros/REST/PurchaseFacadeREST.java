/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.REST;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import libros.ejb.GestorComprasBeanLocal;
import libros.entity.Purchase;
import libros.exception.CompraException;
import libros.exception.CreateCompraException;
import libros.exception.DeleteCompraException;
import libros.exception.UpdateCompraException;

/**
 *
 * @author Iker Iglesias
 */
@Path("purchase")
public class PurchaseFacadeREST {

    private static final Logger logger = Logger.getLogger("libros.REST.PurchaseFacadeREST");

    @EJB
    private GestorComprasBeanLocal ejb;

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    public void create(Purchase entity) {
        logger.info("Creating purchase");
        try {
            ejb.createCompra(entity);
        } catch (CreateCompraException ex) {
            logger.severe("Error al crear compra");
            logger.severe(ex.getMessage());

        }
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void update(Purchase entity) {
        logger.info("Updating purchase");
        try {
            ejb.updateCompra(entity);
        } catch (UpdateCompraException ex) {
            logger.severe("Error al modificar compra");
            logger.severe(ex.getMessage());
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        logger.info("Deleting purchase");
        try {
            ejb.deleteCompra(ejb.getCompraById(id));
        } catch (CompraException ex) {
            logger.severe("Error al cargar compra");
            logger.severe(ex.getMessage());

        } catch (DeleteCompraException ex) {
            logger.severe("Error al borrar compra");
            logger.severe(ex.getMessage());
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Purchase find(@PathParam("id") Integer id) {
        Purchase pur = null;
        logger.info("Buscando comjpra por id");
        try {
            pur = ejb.getCompraById(id);
            logger.info("Procediendo a devolver compra");
        } catch (CompraException ex) {
            logger.severe("Fallo en la busqueda de compra");
            logger.severe(ex.getMessage());
        }
        return pur;

    }

    @GET
    @Path("usuario/{usuario}")
    @Produces({MediaType.APPLICATION_XML})
    public List<Purchase> findAll(@PathParam("usuario") String usuario) {
        logger.info("Finding user purchases");
        List<Purchase> p = null;
        try {
            p = (List<Purchase>) ejb.getAllCompras(ejb.getUserById(usuario));
        } catch (CompraException ex) {
            logger.severe("Fallo en la consulta");
            logger.severe(ex.getMessage());

        }
        return p;
    }

}
