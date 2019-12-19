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
import libros.entity.Gender;
import libros.exception.BusquedaGeneroException;


/**
 * Stateless EJB for managing operations with Gender entities.
 * @author Jon Xabier Gimenez
 */
@Stateless
public class GestorGenerosBean implements GestorGenerosBeanLocal {
    
    @PersistenceContext
    private EntityManager em;
    //Logger
    private static final Logger logger=Logger.getLogger("libros.ejb.GestorGenerosBean");

    @Override
    public Collection <Gender> getAllGeneros() throws BusquedaGeneroException{
          logger.info("Cogiendo todos los libros de la base de datos");
           Collection <Gender> datos;
       try{
          datos= em.createNamedQuery("findAllGeneros").getResultList();
       }catch(Exception e){
           logger.severe("Fallo al devolver los generos");
           logger.severe(e.getMessage());
           throw new BusquedaGeneroException(e.getMessage());
       }
       return datos;
    }
    
}
