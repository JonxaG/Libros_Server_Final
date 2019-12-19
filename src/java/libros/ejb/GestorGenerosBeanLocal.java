/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.ejb;

import java.util.Collection;
import javax.ejb.Local;
import libros.entity.Gender;
import libros.exception.BusquedaGeneroException;

/**
 *
 * @author Jon Xabier Gimenez
 */
@Local
public interface GestorGenerosBeanLocal {
    
     public Collection <Gender> getAllGeneros() throws BusquedaGeneroException;
}
