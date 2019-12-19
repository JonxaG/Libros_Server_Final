/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import java.util.ArrayList;
import libros.exception.CreateLibroException;
import libros.exception.BusquedaLibroException;
import libros.exception.CreateLibroException;
import libros.exception.ActualizarLibroException;
import libros.exception.BorrarLibroException;
import java.util.Collection;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
import libros.entity.Book;

/**
 * Stateless EJB for managing operations with Book entities.
 * @author Jon Xabier Gimenez
 */
@Stateless
public class GestorLibrosBean implements GestorLibrosBeanLocal {
    
    @PersistenceContext
    private EntityManager em;
    //Logger
    private static final Logger logger=Logger.getLogger("libros.ejb.GestorLibrosBean");
    
    
    
    /**
     * Get all the books stored on the database.
     * @return Book Collection
     * @throws BusquedaLibroException
     */
    @Override
    public Collection <Book> getAllLibros() throws BusquedaLibroException{
        logger.info("Cogiendo todos los libros de la base de datos");
         Collection <Book> datos;
       try{
           //Ejecuta La busqueda de todos los libros
          datos= em.createNamedQuery("findAllLibros").getResultList();
       }catch(Exception e){
           logger.severe("Fallo al devolver los libros");
           logger.severe(e.getMessage());
           throw new BusquedaLibroException(e.getMessage());
       }
       return datos;
    }

    /**
     * Introduces a new book into the database 
     * @param create
     * @throws CreateLibroException
     * @throws EntityExistsException 
     */
    @Override
    public void createLibro(Book create) throws CreateLibroException,EntityExistsException {
        logger.info("Creando libro");
        try{
              //Introduce el Libro en la base de datos
              em.persist(create);
              logger.info("Libro creado");
        }catch(IllegalArgumentException e){
            logger.severe("Error al crear libro");
            logger.severe(e.getMessage());
            throw new CreateLibroException(e.getMessage());
        }catch(TransactionRequiredException w){
            logger.severe("Error al crear libro");
            logger.severe(w.getMessage());
            throw new CreateLibroException(w.getMessage());
        }
    }
    /**
     * Delete a Book from the database
     * @param delete
     * @throws BorrarLibroException 
     */
    @Override
    public void deleteLibro(Book delete) throws BorrarLibroException{
        logger.info("Borrando libro");
        try{
            delete = em.merge(delete);
            em.remove(delete);
            logger.info("Libro borrado");
        }catch(Exception e){
            logger.severe("Error al borrar libro");
            logger.severe(e.getMessage());
            throw new BorrarLibroException(e.getMessage());
        }
        
    }
    /**
     * Update a book in the database
     * @param update
     * @throws ActualizarLibroException 
     */
    @Override
    public void updateLibro(Book update) throws ActualizarLibroException {
        logger.info("Actualizando libro");
        try{
            if(!em.contains(update)){
                 em.merge(update);
                logger.info("Libro Actualizado");  
            }else{
                logger.info("Fallo al Actualizar");
                  throw new ActualizarLibroException("Libro no existente");
            }
        }catch(Exception e){
            logger.severe("Fallo al actualizar");
            logger.severe(e.getMessage());
            throw new ActualizarLibroException(e.getMessage());
        }
    }
    /**
     * Find a book with an specific ID(ISBN)
     * @param id
     * @return Book
     * @throws BusquedaLibroException 
     */
    public Book findById(String id)throws BusquedaLibroException{
        logger.info("Busqueda exacta por ISBN");
        Book libro;
        try{
            libro=em.find(Book.class, id);
            logger.info("Encontrado");
        }catch(Exception ex){
            logger.severe("Fallo en la busqueda");
            logger.severe(ex.getMessage());
            throw new BusquedaLibroException(ex.getMessage());
        }

        return libro;
    }
    
    
    /**
     * Find a book that contains the partial isbn(String) 
     * @param isbn
     * @return Collection book
     * @throws BusquedaLibroException 
     */
    @Override
    public Collection <Book> busquedaPorISBN(String isbn)throws BusquedaLibroException {
        logger.info("Buscando parcial por isbn");
         Collection <Book> datos;
        try{
            //funcion contains en mysql si no funciona
            datos= em.createNamedQuery("findLibrosContainsIsbn").setParameter("isbn","%"+isbn.toLowerCase()+"%").getResultList();
        }catch(Exception e){
             logger.severe("Fallo en la consulta");
             logger.severe(e.getMessage());
             throw new BusquedaLibroException(e.getMessage());
        }
        return datos;
      
    }
    /**
     * Find a book that constains the partial titulo(String)
     * @param titulo
     * @return Collection book
     * @throws BusquedaLibroException 
     */
    @Override
    public Collection <Book> busquedaPorTitulo(String titulo) throws BusquedaLibroException {
        logger.info("Buscando por nombre");
         Collection <Book> datos;
        try{
            datos= em.createNamedQuery("findLibrosByTitulo").setParameter("titulo","%"+titulo.toLowerCase()+"%").getResultList();
        }catch(Exception e){
             logger.severe("Fallo en la consulta");
             logger.severe(e.getMessage());
             throw new BusquedaLibroException(e.getMessage());
        }
        return datos;
    }
    /**
     * Find a book that constains the partial autor(String) 
     * @param autor
     * @return Collection book
     * @throws BusquedaLibroException 
     */
    @Override
    public Collection <Book> busquedaPorAutor(String autor) throws BusquedaLibroException {
         logger.info("Buscando por autor");
         Collection <Book> datos;
         try{
           datos= em.createNamedQuery("findLibrosByAutor").setParameter("autor","%"+autor.toLowerCase()+"%").getResultList();
         }catch(Exception e){
             logger.severe("Fallo en la consulta");
             logger.severe(e.getMessage());
             throw new BusquedaLibroException(e.getMessage());
        }
         return datos;
    }
}
