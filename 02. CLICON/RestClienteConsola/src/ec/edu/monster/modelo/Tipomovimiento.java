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
@Table(name = "tipomovimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipomovimiento.findAll", query = "SELECT t FROM Tipomovimiento t")
    , @NamedQuery(name = "Tipomovimiento.findByChrTipocodigo", query = "SELECT t FROM Tipomovimiento t WHERE t.chrTipocodigo = :chrTipocodigo")
    , @NamedQuery(name = "Tipomovimiento.findByVchTipodescripcion", query = "SELECT t FROM Tipomovimiento t WHERE t.vchTipodescripcion = :vchTipodescripcion")
    , @NamedQuery(name = "Tipomovimiento.findByVchTipoaccion", query = "SELECT t FROM Tipomovimiento t WHERE t.vchTipoaccion = :vchTipoaccion")
    , @NamedQuery(name = "Tipomovimiento.findByVchTipoestado", query = "SELECT t FROM Tipomovimiento t WHERE t.vchTipoestado = :vchTipoestado")})
public class Tipomovimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "chr_tipocodigo")
    private String chrTipocodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "vch_tipodescripcion")
    private String vchTipodescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "vch_tipoaccion")
    private String vchTipoaccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "vch_tipoestado")
    private String vchTipoestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chrTipocodigo")
    private Collection<Movimiento> movimientoCollection;

    public Tipomovimiento() {
    }

    public Tipomovimiento(String chrTipocodigo) {
        this.chrTipocodigo = chrTipocodigo;
    }

    public Tipomovimiento(String chrTipocodigo, String vchTipodescripcion, String vchTipoaccion, String vchTipoestado) {
        this.chrTipocodigo = chrTipocodigo;
        this.vchTipodescripcion = vchTipodescripcion;
        this.vchTipoaccion = vchTipoaccion;
        this.vchTipoestado = vchTipoestado;
    }

    public String getChrTipocodigo() {
        return chrTipocodigo;
    }

    public void setChrTipocodigo(String chrTipocodigo) {
        this.chrTipocodigo = chrTipocodigo;
    }

    public String getVchTipodescripcion() {
        return vchTipodescripcion;
    }

    public void setVchTipodescripcion(String vchTipodescripcion) {
        this.vchTipodescripcion = vchTipodescripcion;
    }

    public String getVchTipoaccion() {
        return vchTipoaccion;
    }

    public void setVchTipoaccion(String vchTipoaccion) {
        this.vchTipoaccion = vchTipoaccion;
    }

    public String getVchTipoestado() {
        return vchTipoestado;
    }

    public void setVchTipoestado(String vchTipoestado) {
        this.vchTipoestado = vchTipoestado;
    }

    @XmlTransient
    public Collection<Movimiento> getMovimientoCollection() {
        return movimientoCollection;
    }

    public void setMovimientoCollection(Collection<Movimiento> movimientoCollection) {
        this.movimientoCollection = movimientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chrTipocodigo != null ? chrTipocodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipomovimiento)) {
            return false;
        }
        Tipomovimiento other = (Tipomovimiento) object;
        if ((this.chrTipocodigo == null && other.chrTipocodigo != null) || (this.chrTipocodigo != null && !this.chrTipocodigo.equals(other.chrTipocodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Tipomovimiento[ chrTipocodigo=" + chrTipocodigo + " ]";
    }
    
}
