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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByChrCliecodigo", query = "SELECT c FROM Cliente c WHERE c.chrCliecodigo = :chrCliecodigo")
    , @NamedQuery(name = "Cliente.findByVchCliepaterno", query = "SELECT c FROM Cliente c WHERE c.vchCliepaterno = :vchCliepaterno")
    , @NamedQuery(name = "Cliente.findByVchCliematerno", query = "SELECT c FROM Cliente c WHERE c.vchCliematerno = :vchCliematerno")
    , @NamedQuery(name = "Cliente.findByVchClienombre", query = "SELECT c FROM Cliente c WHERE c.vchClienombre = :vchClienombre")
    , @NamedQuery(name = "Cliente.findByChrCliedni", query = "SELECT c FROM Cliente c WHERE c.chrCliedni = :chrCliedni")
    , @NamedQuery(name = "Cliente.findByVchClieciudad", query = "SELECT c FROM Cliente c WHERE c.vchClieciudad = :vchClieciudad")
    , @NamedQuery(name = "Cliente.findByVchCliedireccion", query = "SELECT c FROM Cliente c WHERE c.vchCliedireccion = :vchCliedireccion")
    , @NamedQuery(name = "Cliente.findByVchClietelefono", query = "SELECT c FROM Cliente c WHERE c.vchClietelefono = :vchClietelefono")
    , @NamedQuery(name = "Cliente.findByVchClieemail", query = "SELECT c FROM Cliente c WHERE c.vchClieemail = :vchClieemail")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "chr_cliecodigo")
    private String chrCliecodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "vch_cliepaterno")
    private String vchCliepaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "vch_cliematerno")
    private String vchCliematerno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "vch_clienombre")
    private String vchClienombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "chr_cliedni")
    private String chrCliedni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "vch_clieciudad")
    private String vchClieciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "vch_cliedireccion")
    private String vchCliedireccion;
    @Size(max = 20)
    @Column(name = "vch_clietelefono")
    private String vchClietelefono;
    @Size(max = 50)
    @Column(name = "vch_clieemail")
    private String vchClieemail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chrCliecodigo")
    private Collection<Cuenta> cuentaCollection;

    public Cliente() {
    }

    public Cliente(String chrCliecodigo) {
        this.chrCliecodigo = chrCliecodigo;
    }

    public Cliente(String chrCliecodigo, String vchCliepaterno, String vchCliematerno, String vchClienombre, String chrCliedni, String vchClieciudad, String vchCliedireccion) {
        this.chrCliecodigo = chrCliecodigo;
        this.vchCliepaterno = vchCliepaterno;
        this.vchCliematerno = vchCliematerno;
        this.vchClienombre = vchClienombre;
        this.chrCliedni = chrCliedni;
        this.vchClieciudad = vchClieciudad;
        this.vchCliedireccion = vchCliedireccion;
    }

    public String getChrCliecodigo() {
        return chrCliecodigo;
    }

    public void setChrCliecodigo(String chrCliecodigo) {
        this.chrCliecodigo = chrCliecodigo;
    }

    public String getVchCliepaterno() {
        return vchCliepaterno;
    }

    public void setVchCliepaterno(String vchCliepaterno) {
        this.vchCliepaterno = vchCliepaterno;
    }

    public String getVchCliematerno() {
        return vchCliematerno;
    }

    public void setVchCliematerno(String vchCliematerno) {
        this.vchCliematerno = vchCliematerno;
    }

    public String getVchClienombre() {
        return vchClienombre;
    }

    public void setVchClienombre(String vchClienombre) {
        this.vchClienombre = vchClienombre;
    }

    public String getChrCliedni() {
        return chrCliedni;
    }

    public void setChrCliedni(String chrCliedni) {
        this.chrCliedni = chrCliedni;
    }

    public String getVchClieciudad() {
        return vchClieciudad;
    }

    public void setVchClieciudad(String vchClieciudad) {
        this.vchClieciudad = vchClieciudad;
    }

    public String getVchCliedireccion() {
        return vchCliedireccion;
    }

    public void setVchCliedireccion(String vchCliedireccion) {
        this.vchCliedireccion = vchCliedireccion;
    }

    public String getVchClietelefono() {
        return vchClietelefono;
    }

    public void setVchClietelefono(String vchClietelefono) {
        this.vchClietelefono = vchClietelefono;
    }

    public String getVchClieemail() {
        return vchClieemail;
    }

    public void setVchClieemail(String vchClieemail) {
        this.vchClieemail = vchClieemail;
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
        hash += (chrCliecodigo != null ? chrCliecodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.chrCliecodigo == null && other.chrCliecodigo != null) || (this.chrCliecodigo != null && !this.chrCliecodigo.equals(other.chrCliecodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.Cliente[ chrCliecodigo=" + chrCliecodigo + " ]";
    }
    
}
