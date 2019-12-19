/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity class to store our users data.
 * <ul>
 * <li><strong>usuario:</strong> Login name of the user.</li>
 * <li><strong>nombre:</strong> Name of the user. </li>
 * <li><strong>apellidos:</strong> Last names of the user. </li>
 * <li><strong>direccion:</strong> Direction of the user. </li>
 * <li><strong>telefono:</strong> Phone number of the user </li>
 * <li><strong>email:</strong> Email of the user </li>
 * </ul>
 *
 * @author Discos S.L Corporation
 */
@Entity
@Table(name = "User", schema = "LibrosSL")
@NamedQueries({
    @NamedQuery(
            name = "findUserData",
            query = "select u from User u where u.usuario=:usuario "
    )
})

@XmlRootElement
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String usuario;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String email;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    /**
     * Compares the codigo and email
     *
     * @param object
     * @return boolean
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario)) || (this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libros.entity.User[ usuario=" + usuario + " ]";
    }

}
