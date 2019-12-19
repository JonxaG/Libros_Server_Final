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
 * Entity class to store our users passwords.
 * <ul>
 * <li><strong>usuario:</strong> Name that identifies the user.</li>
 * <li><strong>password:</strong> Password for the user. </li>
 * </ul>
 *
 * @author Discos S.L Corporation
 */
@Entity
@Table(name = "Passwords", schema = "LibrosSL")
@NamedQueries({
    @NamedQuery(
            name = "findPasswordByUser",
            query = "select p from Password p where p.usuario=:usuario and p.password=:password"
    )
})
@XmlRootElement
public class Password implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String usuario;
    private String password;

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Password)) {
            return false;
        }
        Password other = (Password) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libros.entity.Password[ usuario=" + usuario + " ]";
    }

}
