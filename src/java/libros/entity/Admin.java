/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *Entity class to store our admin. 
 * <ul>
  * <li><strong>admin:</strong> Name that identifies the admin.</li>
  * <li><strong>password:</strong> Password for the admin. </li>
  * </ul>
 * @author Discos S.L Corporation
 */
@Entity
@Table(name="Admin",schema="LibrosSL")
@NamedQuery(
        name="findByCredential",
        query="select s from Admin s where s.admin=:admin and s.password=:password"
)
@XmlRootElement
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String admin;
    private String password;

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (admin != null ? admin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.admin == null && other.admin != null) || (this.admin != null && !this.admin.equals(other.admin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libros.entity.Admin[ admin=" + admin + " ]";
    }
    
}
