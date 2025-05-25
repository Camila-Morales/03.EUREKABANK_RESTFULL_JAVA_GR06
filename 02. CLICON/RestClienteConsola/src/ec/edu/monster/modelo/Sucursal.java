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
@Table(name = "sucursal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s")
    , @NamedQuery(name = "Sucursal.findByChrSucucodigo", query = "SELECT s FROM Sucursal s WHERE s.chrSucucodigo = :chrSucucodigo")
    , @NamedQuery(name = "Sucursal.findByVchSucunombre", query = "SELECT s FROM Sucursal s WHERE s.vchSucunombre = :vchSucunombre")
    , @NamedQuery(name = "Sucursal.findByVchSucuciudad", query = "SELECT s FROM Sucursal s WHERE s.vchSucuciudad = :vchSucuciudad")
    , @NamedQuery(name = "Sucursal.findByVchSucudireccion", query = "SELECT s FROM Sucursal s WHERE s.vchSucudireccion = :vchSucudireccion")
    , @NamedQuery(name = "Sucursal.findByIntSucucontcuenta", query = "SELECT s FROM Sucursal s WHERE s.intSucucontcuenta = :intSucucontcuenta")})
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "chr_sucucodigo")
    private String chrSucucodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "vch_sucunombre")
    private String vchSucunombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "vch_sucuciudad")
    private String vchSucuciudad;
    @Size(max = 50)
    @Column(name = "vch_sucudireccion")
    private String vchSucudireccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "int_sucucontcuenta")
    private int intSucucontcuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chrSucucodigo")
    private Collection<Cuenta> cuentaCollection;

    public Sucursal() {
    }

    public Sucursal(String chrSucucodigo) {
        this.chrSucucodigo = chrSucucodigo;
    }

    public Sucursal(String chrSucucodigo, String vchSucunombre, String vchSucuciudad, int intSucucontcuenta) {
        this.chrSucucodigo = chrSucucodigo;
        this.vchSucunombre = vchSucunombre;
        this.vchSucuciudad = vchSucuciudad;
        this.intSucucontcuenta = intSucucontcuenta;
    }

    public String getChrSucucodigo() {
        return chrSucucodigo;
    }

    public void setChrSucucodigo(String chrSucucodigo) {
        this.chrSucucodigo = chrSucucodigo;
    }

    public String getVchSucunombre() {
        return vchSucunombre;
    }

    public void setVchSucunombre(String vchSucunombre) {
        this.vchSucunombre = vchSucunombre;
    }

    public String getVchSucuciudad() {
        return vchSucuciudad;
    }

    public void setVchSucuciudad(String vchSucuciudad) {
        this.vchSucuciudad = vchSucuciudad;
    }

    public String getVchSucudireccion() {
        return vchSucudireccion;
    }

    public void setVchSucudireccion(String vchSucudireccion) {
        this.vchSucudireccion = vchSucudireccion;
    }

    public int getIntSucucontcuenta() {
        return intSucucontcuenta;
    }

    public void setIntSucucontcuenta(int intSucucontcuenta) {
        this.intSucucontcuenta = intSucucontcuenta;
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
        hash += (chrSucucodigo != null ? chrSucucodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.chrSucucodigo == null && other.chrSucucodigo != null) || (this.chrSucucodigo != null && !this.chrSucucodigo.equals(other.chrSucucodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Sucursal[ chrSucucodigo=" + chrSucucodigo + " ]";
    }
    
}
