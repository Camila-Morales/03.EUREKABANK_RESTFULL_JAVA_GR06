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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByChrEmplcodigo", query = "SELECT e FROM Empleado e WHERE e.chrEmplcodigo = :chrEmplcodigo")
    , @NamedQuery(name = "Empleado.findByVchEmplpaterno", query = "SELECT e FROM Empleado e WHERE e.vchEmplpaterno = :vchEmplpaterno")
    , @NamedQuery(name = "Empleado.findByVchEmplmaterno", query = "SELECT e FROM Empleado e WHERE e.vchEmplmaterno = :vchEmplmaterno")
    , @NamedQuery(name = "Empleado.findByVchEmplnombre", query = "SELECT e FROM Empleado e WHERE e.vchEmplnombre = :vchEmplnombre")
    , @NamedQuery(name = "Empleado.findByVchEmplciudad", query = "SELECT e FROM Empleado e WHERE e.vchEmplciudad = :vchEmplciudad")
    , @NamedQuery(name = "Empleado.findByVchEmpldireccion", query = "SELECT e FROM Empleado e WHERE e.vchEmpldireccion = :vchEmpldireccion")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "chr_emplcodigo")
    private String chrEmplcodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "vch_emplpaterno")
    private String vchEmplpaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "vch_emplmaterno")
    private String vchEmplmaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "vch_emplnombre")
    private String vchEmplnombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "vch_emplciudad")
    private String vchEmplciudad;
    @Size(max = 50)
    @Column(name = "vch_empldireccion")
    private String vchEmpldireccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chrEmplcodigo")
    private Collection<Movimiento> movimientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chrEmplcreacuenta")
    private Collection<Cuenta> cuentaCollection;

    public Empleado() {
    }

    public Empleado(String chrEmplcodigo) {
        this.chrEmplcodigo = chrEmplcodigo;
    }

    public Empleado(String chrEmplcodigo, String vchEmplpaterno, String vchEmplmaterno, String vchEmplnombre, String vchEmplciudad) {
        this.chrEmplcodigo = chrEmplcodigo;
        this.vchEmplpaterno = vchEmplpaterno;
        this.vchEmplmaterno = vchEmplmaterno;
        this.vchEmplnombre = vchEmplnombre;
        this.vchEmplciudad = vchEmplciudad;
    }

    public String getChrEmplcodigo() {
        return chrEmplcodigo;
    }

    public void setChrEmplcodigo(String chrEmplcodigo) {
        this.chrEmplcodigo = chrEmplcodigo;
    }

    public String getVchEmplpaterno() {
        return vchEmplpaterno;
    }

    public void setVchEmplpaterno(String vchEmplpaterno) {
        this.vchEmplpaterno = vchEmplpaterno;
    }

    public String getVchEmplmaterno() {
        return vchEmplmaterno;
    }

    public void setVchEmplmaterno(String vchEmplmaterno) {
        this.vchEmplmaterno = vchEmplmaterno;
    }

    public String getVchEmplnombre() {
        return vchEmplnombre;
    }

    public void setVchEmplnombre(String vchEmplnombre) {
        this.vchEmplnombre = vchEmplnombre;
    }

    public String getVchEmplciudad() {
        return vchEmplciudad;
    }

    public void setVchEmplciudad(String vchEmplciudad) {
        this.vchEmplciudad = vchEmplciudad;
    }

    public String getVchEmpldireccion() {
        return vchEmpldireccion;
    }

    public void setVchEmpldireccion(String vchEmpldireccion) {
        this.vchEmpldireccion = vchEmpldireccion;
    }

    @XmlTransient
    public Collection<Movimiento> getMovimientoCollection() {
        return movimientoCollection;
    }

    public void setMovimientoCollection(Collection<Movimiento> movimientoCollection) {
        this.movimientoCollection = movimientoCollection;
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
        hash += (chrEmplcodigo != null ? chrEmplcodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.chrEmplcodigo == null && other.chrEmplcodigo != null) || (this.chrEmplcodigo != null && !this.chrEmplcodigo.equals(other.chrEmplcodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Empleado[ chrEmplcodigo=" + chrEmplcodigo + " ]";
    }
    
}
