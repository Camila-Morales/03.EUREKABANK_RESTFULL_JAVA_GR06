package ec.edu.monster.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class MovimientoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "chr_cuencodigo")
    private String chrCuencodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "int_movinumero")
    private int intMovinumero;

    public MovimientoPK() {
    }

    public MovimientoPK(String chrCuencodigo, int intMovinumero) {
        this.chrCuencodigo = chrCuencodigo;
        this.intMovinumero = intMovinumero;
    }

    public String getChrCuencodigo() {
        return chrCuencodigo;
    }

    public void setChrCuencodigo(String chrCuencodigo) {
        this.chrCuencodigo = chrCuencodigo;
    }

    public int getIntMovinumero() {
        return intMovinumero;
    }

    public void setIntMovinumero(int intMovinumero) {
        this.intMovinumero = intMovinumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chrCuencodigo != null ? chrCuencodigo.hashCode() : 0);
        hash += (int) intMovinumero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimientoPK)) {
            return false;
        }
        MovimientoPK other = (MovimientoPK) object;
        if ((this.chrCuencodigo == null && other.chrCuencodigo != null) || (this.chrCuencodigo != null && !this.chrCuencodigo.equals(other.chrCuencodigo))) {
            return false;
        }
        if (this.intMovinumero != other.intMovinumero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.monster.modelo.MovimientoPK[ chrCuencodigo=" + chrCuencodigo + ", intMovinumero=" + intMovinumero + " ]";
    }
    
}
