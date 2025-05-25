package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Movimiento;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-25T12:46:05")
@StaticMetamodel(Tipomovimiento.class)
public class Tipomovimiento_ { 

    public static volatile SingularAttribute<Tipomovimiento, String> chrTipocodigo;
    public static volatile SingularAttribute<Tipomovimiento, String> vchTipodescripcion;
    public static volatile SingularAttribute<Tipomovimiento, String> vchTipoestado;
    public static volatile CollectionAttribute<Tipomovimiento, Movimiento> movimientoCollection;
    public static volatile SingularAttribute<Tipomovimiento, String> vchTipoaccion;

}