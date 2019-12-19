/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.REST;

import java.util.Collection;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.persistence.EntityExistsException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import libros.ejb.GestorLibrosBeanLocal;
import libros.entity.Book;
import libros.exception.ActualizarLibroException;
import libros.exception.BorrarLibroException;
import libros.exception.BusquedaLibroException;
import libros.exception.CreateLibroException;

/**
 *
 * @author Jon Xabier Gimenez
 */
@Path("book")
public class BookFacadeREST {

    private static final Logger logger = Logger.getLogger("libros.REST.BookFacadeREST");

    @EJB
    private GestorLibrosBeanLocal ejb;

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Book entity) {
        logger.info("Creando Libro");
        try {
            ejb.createLibro(entity);
            logger.info("Libro creado");
        } catch (CreateLibroException ex) {
            logger.severe("Fallo en la creacion");
            logger.severe(ex.getMessage());
        } catch (EntityExistsException ex)   {
            logger.info("Entidad existente");
            logger.severe(ex.getMessage());
        }
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void update(Book entity) {
        logger.info("Actualizando libro");
        try {
            ejb.updateLibro(entity);
            logger.info("Libro actualizado");
        } catch (ActualizarLibroException ex) {
            logger.severe("Fallo al actualizar libro");
            logger.severe(ex.getMessage());
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        logger.info("Borrando libro");
        try {
            ejb.deleteLibro(ejb.findById(id));
            logger.info("Libro Borrado");
        } catch (BusquedaLibroException ex) {
            logger.severe("No se encontro el libro");
            logger.severe(ex.getMessage());
        } catch (BorrarLibroException ex) {
            logger.severe("No se pudo borrar el libro");
            logger.severe(ex.getMessage());
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Book findByID(@PathParam("id") String id) {
        Book libro = null;
        logger.info("Buscando libro por ISBN");
        try {
            libro = ejb.findById(id);
            logger.info("Procediendo a devolver libros");
        } catch (BusquedaLibroException ex) {
            logger.severe("Fallo en la busqueda de libros");
            logger.severe(ex.getMessage());
        }
        return libro;
    }

    @GET
    @Path("isbn/{isbn}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Book> findIsbn(@PathParam("isbn") String isbn) {
        Collection<Book> libros = null;
        logger.info("Buscando libro por ISBN");
        try {
            libros = ejb.busquedaPorISBN(isbn);
            logger.info("Procediendo a devolver libros");
        } catch (BusquedaLibroException ex) {
            logger.severe("Fallo en la busqueda de libros");
            logger.severe(ex.getMessage());
        }
        return libros;
    }

    @GET
    @Path("titulo/{titulo}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Book> findTitulo(@PathParam("titulo") String titulo) {
        Collection<Book> libros = null;
        logger.info("Buscando libro por titulo");
        try {
            libros = ejb.busquedaPorTitulo(titulo);
            logger.info("Procediendo a devolver libros");
        } catch (BusquedaLibroException ex) {
            logger.severe("Fallo en la busqueda de libros");
            logger.severe(ex.getMessage());
        }
        return libros;
    }

    @GET
    @Path("autor/{autor}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Book> findAutor(@PathParam("autor") String autor) {
        Collection<Book> discos = null;
        logger.info("Buscando libro por Autor");
        try {
            discos = ejb.busquedaPorAutor(autor);
            logger.info("Procediendo a devolver libros");
        } catch (BusquedaLibroException ex) {
            logger.severe("Fallo en la busqueda de libros");
            logger.severe(ex.getMessage());
        }
        return discos;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Book> findAll() {
        Collection discos = null;
        logger.info("Buscando todos los libros");
        try {
            discos = ejb.getAllLibros();
            logger.info("Procediendo a devolver libros");
        } catch (BusquedaLibroException ex) {
            logger.severe("Fallo en la busqueda de libros");
            logger.severe(ex.getMessage());
        }
        return discos;
    }

}
