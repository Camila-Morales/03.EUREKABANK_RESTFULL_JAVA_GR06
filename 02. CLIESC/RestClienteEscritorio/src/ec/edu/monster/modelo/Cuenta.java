package ec.edu.monster.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")
    , @NamedQuery(name = "Cuenta.findByChrCuencodigo", query = "SELECT c FROM Cuenta c WHERE c.chrCuencodigo = :chrCuencodigo")
    , @NamedQuery(name = "Cuenta.findByDecCuensaldo", query = "SELECT c FROM Cuenta c WHERE c.decCuensaldo = :decCuensaldo")
    , @NamedQuery(name = "Cuenta.findByDttCuenfechacreacion", query = "SELECT c FROM Cuenta c WHERE c.dttCuenfechacreacion = :dttCuenfechacreacion")
    , @NamedQuery(name = "Cuenta.findByVchCuenestado", query = "SELECT c FROM Cuenta c WHERE c.vchCuenestado = :vchCuenestado")
    , @NamedQuery(name = "Cuenta.findByIntCuencontmov", query = "SELECT c FROM Cuenta c WHERE c.intCuencontmov = :intCuencontmov")
    , @NamedQuery(name = "Cuenta.findByChrCuenclave", query = "SELECT c FROM Cuenta c WHERE c.chrCuenclave = :chrCuenclave")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "chr_cuencodigo")
    private String chrCuencodigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "dec_cuensaldo")
    private BigDecimal decCuensaldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtt_cuenfechacreacion")
    @Temporal(TemporalType.DATE)
    private Date dttCuenfechacreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "vch_cuenestado")
    private String vchCuenestado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "int_cuencontmov")
    private int intCuencontmov;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "chr_cuenclave")
    private String chrCuenclave;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
    private Collection<Movimiento> movimientoCollection;
    @JoinColumn(name = "chr_cliecodigo", referencedColumnName = "chr_cliecodigo")
    @ManyToOne(optional = false)
    private Cliente chrCliecodigo;
    @JoinColumn(name = "chr_monecodigo", referencedColumnName = "chr_monecodigo")
    @ManyToOne(optional = false)
    private Moneda chrMonecodigo;
    @JoinColumn(name = "chr_sucucodigo", referencedColumnName = "chr_sucucodigo")
    @ManyToOne(optional = false)
    private Sucursal chrSucucodigo;
    @JoinColumn(name = "chr_emplcreacuenta", referencedColumnName = "chr_emplcodigo")
    @ManyToOne(optional = false)
    private Empleado chrEmplcreacuenta;

    public Cuenta() {
    }

    public Cuenta(String chrCuencodigo) {
        this.chrCuencodigo = chrCuencodigo;
    }

    public Cuenta(String chrCuencodigo, BigDecimal decCuensaldo, Date dttCuenfechacreacion, String vchCuenestado, int intCuencontmov, String chrCuenclave) {
        this.chrCuencodigo = chrCuencodigo;
        this.decCuensaldo = decCuensaldo;
        this.dttCuenfechacreacion = dttCuenfechacreacion;
        this.vchCuenestado = vchCuenestado;
        this.intCuencontmov = intCuencontmov;
        this.chrCuenclave = chrCuenclave;
    }

    public String getChrCuencodigo() {
        return chrCuencodigo;
    }

    public void setChrCuencodigo(String chrCuencodigo) {
        this.chrCuencodigo = chrCuencodigo;
    }

    public BigDecimal getDecCuensaldo() {
        return decCuensaldo;
    }

    public void setDecCuensaldo(BigDecimal decCuensaldo) {
        this.decCuensaldo = decCuensaldo;
    }

    public Date getDttCuenfechacreacion() {
        return dttCuenfechacreacion;
    }

    public void setDttCuenfechacreacion(Date dttCuenfechacreacion) {
        this.dttCuenfechacreacion = dttCuenfechacreacion;
    }

    public String getVchCuenestado() {
        return vchCuenestado;
    }

    public void setVchCuenestado(String vchCuenestado) {
        this.vchCuenestado = vchCuenestado;
    }

    public int getIntCuencontmov() {
        return intCuencontmov;
    }

    public void setIntCuencontmov(int intCuencontmov) {
        this.intCuencontmov = intCuencontmov;
    }

    public String getChrCuenclave() {
        return chrCuenclave;
    }

    public void setChrCuenclave(String chrCuenclave) {
        this.chrCuenclave = chrCuenclave;
    }

    @XmlTransient
    public Collection<Movimiento> getMovimientoCollection() {
        return movimientoCollection;
    }

    public void setMovimientoCollection(Collection<Movimiento> movimientoCollection) {
        this.movimientoCollection = movimientoCollection;
    }

    public Cliente getChrCliecodigo() {
        return chrCliecodigo;
    }

    public void setChrCliecodigo(Cliente chrCliecodigo) {
        this.chrCliecodigo = chrCliecodigo;
    }

    public Moneda getChrMonecodigo() {
        return chrMonecodigo;
    }

    public void setChrMonecodigo(Moneda chrMonecodigo) {
        this.chrMonecodigo = chrMonecodigo;
    }

    public Sucursal getChrSucucodigo() {
        return chrSucucodigo;
    }

    public void setChrSucucodigo(Sucursal chrSucucodigo) {
        this.chrSucucodigo = chrSucucodigo;
    }

    public Empleado getChrEmplcreacuenta() {
        return chrEmplcreacuenta;
    }

    public void setChrEmplcreacuenta(Empleado chrEmplcreacuenta) {
        this.chrEmplcreacuenta = chrEmplcreacuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chrCuencodigo != null ? chrCuencodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.chrCuencodigo == null && other.chrCuencodigo != null) || (this.chrCuencodigo != null && !this.chrCuencodigo.equals(other.chrCuencodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Cuenta[ chrCuencodigo=" + chrCuencodigo + " ]";
    }
    
}
