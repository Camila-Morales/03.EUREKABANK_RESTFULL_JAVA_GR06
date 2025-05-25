package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Cliente;
import ec.edu.monster.modelo.Empleado;
import ec.edu.monster.modelo.Moneda;
import ec.edu.monster.modelo.Movimiento;
import ec.edu.monster.modelo.Sucursal;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-25T12:46:05")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, Date> dttCuenfechacreacion;
    public static volatile SingularAttribute<Cuenta, String> vchCuenestado;
    public static volatile SingularAttribute<Cuenta, Empleado> chrEmplcreacuenta;
    public static volatile SingularAttribute<Cuenta, Sucursal> chrSucucodigo;
    public static volatile SingularAttribute<Cuenta, BigDecimal> decCuensaldo;
    public static volatile CollectionAttribute<Cuenta, Movimiento> movimientoCollection;
    public static volatile SingularAttribute<Cuenta, Cliente> chrCliecodigo;
    public static volatile SingularAttribute<Cuenta, Moneda> chrMonecodigo;
    public static volatile SingularAttribute<Cuenta, String> chrCuencodigo;
    public static volatile SingularAttribute<Cuenta, String> chrCuenclave;
    public static volatile SingularAttribute<Cuenta, Integer> intCuencontmov;

}