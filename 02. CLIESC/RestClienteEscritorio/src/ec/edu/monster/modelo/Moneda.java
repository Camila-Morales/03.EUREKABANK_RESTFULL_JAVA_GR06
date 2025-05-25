package ec.edu.monster.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "moneda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moneda.findAll", query = "SELECT m FROM Moneda m")
    , @NamedQuery(name = "Moneda.findByChrMonecodigo", query = "SELECT m FROM Moneda m WHERE m.chrMonecodigo = :chrMonecodigo")
    , @NamedQuery(name = "Moneda.findByVchMonedescripcion", query = "SELECT m FROM Moneda m WHERE m.vchMonedescripcion = :vchMonedescripcion")})
public class Moneda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "chr_monecodigo")
    private String chrMonecodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "vch_monedescripcion")
    private String vchMonedescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chrMonecodigo")
    private Collection<Cuenta> cuentaCollection;

    public Moneda() {
    }

    public Moneda(String chrMonecodigo) {
        this.chrMonecodigo = chrMonecodigo;
    }

    public Moneda(String chrMonecodigo, String vchMonedescripcion) {
        this.chrMonecodigo = chrMonecodigo;
        this.vchMonedescripcion = vchMonedescripcion;
    }

    public String getChrMonecodigo() {
        return chrMonecodigo;
    }

    public void setChrMonecodigo(String chrMonecodigo) {
        this.chrMonecodigo = chrMonecodigo;
    }

    public String getVchMonedescripcion() {
        return vchMonedescripcion;
    }

    public void setVchMonedescripcion(String vchMonedescripcion) {
        this.vchMonedescripcion = vchMonedescripcion;
    }

    @XmlTransient
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }

    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chrMonecodigo != null ? chrMonecodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moneda)) {
            return false;
        }
        Moneda other = (Moneda) object;
        if ((this.chrMonecodigo == null && other.chrMonecodigo != null) || (this.chrMonecodigo != null && !this.chrMonecodigo.equals(other.chrMonecodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Moneda[ chrMonecodigo=" + chrMonecodigo + " ]";
    }
    
}
