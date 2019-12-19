/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.REST;

import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import libros.ejb.GestorUserBeanLocal;
import libros.entity.User;

/**
 *
 * @author Iker Iglesias
 */
@Path("user")
public class UserFacadeREST {

    private static final Logger logger = Logger.getLogger("libros.REST.UserFacadeREST");

    @EJB
    private GestorUserBeanLocal ejb;

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(User entity) {

    }

    @PUT

    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void update(User entity) {

    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {

    }
    /*
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User find() {
        return null;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findAll() {
        return null;
    }

  
     */

}
