package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Cuenta;
import ec.edu.monster.modelo.Movimiento;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-25T12:46:05")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> vchEmplnombre;
    public static volatile SingularAttribute<Empleado, String> vchEmplmaterno;
    public static volatile SingularAttribute<Empleado, String> vchEmplciudad;
    public static volatile SingularAttribute<Empleado, String> chrEmplcodigo;
    public static volatile SingularAttribute<Empleado, String> vchEmpldireccion;
    public static volatile CollectionAttribute<Empleado, Movimiento> movimientoCollection;
    public static volatile CollectionAttribute<Empleado, Cuenta> cuentaCollection;
    public static volatile SingularAttribute<Empleado, String> vchEmplpaterno;

}