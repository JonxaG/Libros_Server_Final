/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.REST;

import libros.ejb.GestorGenerosBeanLocal;
import libros.entity.Gender;
import libros.exception.BusquedaGeneroException;
import java.util.Collection;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jon Xabier Gimenez
 */
@Path("gender")
public class GenderFacadeREST {

    private static final Logger logger = Logger.getLogger("libros.REST.GenderFacadeREST");

    @EJB
    private GestorGenerosBeanLocal ejb;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Gender> findAll() {
        Collection generos = null;
        logger.info("Buscando todos los generos");
        try {
            generos = ejb.getAllGeneros();
            logger.info("Procediendo a devolver generos");
        } catch (BusquedaGeneroException ex) {
            logger.severe("Fallo en la busqueda de generos");
            logger.severe(ex.getMessage());
        }
        return generos;
    }
}
