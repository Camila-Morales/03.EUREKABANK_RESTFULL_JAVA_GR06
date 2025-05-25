package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Cuenta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-25T12:46:05")
@StaticMetamodel(Moneda.class)
public class Moneda_ { 

    public static volatile SingularAttribute<Moneda, String> vchMonedescripcion;
    public static volatile SingularAttribute<Moneda, String> chrMonecodigo;
    public static volatile CollectionAttribute<Moneda, Cuenta> cuentaCollection;

}