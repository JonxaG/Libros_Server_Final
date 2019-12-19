/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity class to store our purchases.
 * <ul>
 * <li><strong>codigo:</strong> Autonumeric Integer to identify the
 * purchase.</li>
 * <li><strong>usuario:</strong> {@link User} that purchases . </li>
 * <li><strong>fechaCompra:</strong> Date of the purchase. </li>
 * <li><strong>precioTotal:</strong> Total price. </li>
 * <li><strong>ejemplares:</strong> Collection of {@link Book}s of the purchase
 * </li>
 * </ul>
 *
 * @author Discos S.L Corporation
 */
@Entity
@Table(name = "purchase", schema = "LibrosSL")
@NamedQueries({
    /*    @NamedQuery(
            name="findVentaById",
            query="select p from Purchase p where p.codigo=:codigo order by p.fechaCompra"
    ),*/
    @NamedQuery(
            name = "findVentasByUser",
            query = "select p from Purchase p where p.usuario=:usuario order by p.fechaCompra"
    )
    ,
      @NamedQuery(
            name = "findPurchasesByUser",
            query = "select p from Purchase p where p.usuario=:usuario order by p.fechaCompra"
    )

})
@XmlRootElement
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(name = "fechaCompra", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    //insertable = false,updatable = false
    private Date fechaCompra;
    @ManyToOne
    private User usuario;
    private Float precioTotal;
    private Integer unidades;
    @ManyToOne
    private Book book;

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Float precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchase)) {
            return false;
        }
        Purchase other = (Purchase) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libros.entity.Purchase[ codigo=" + codigo + " ]";
    }

}
