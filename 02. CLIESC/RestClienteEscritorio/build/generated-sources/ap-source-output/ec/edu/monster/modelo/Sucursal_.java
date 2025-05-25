package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Cuenta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-25T12:46:05")
@StaticMetamodel(Sucursal.class)
public class Sucursal_ { 

    public static volatile SingularAttribute<Sucursal, String> vchSucunombre;
    public static volatile SingularAttribute<Sucursal, Integer> intSucucontcuenta;
    public static volatile SingularAttribute<Sucursal, String> vchSucuciudad;
    public static volatile SingularAttribute<Sucursal, String> chrSucucodigo;
    public static volatile SingularAttribute<Sucursal, String> vchSucudireccion;
    public static volatile CollectionAttribute<Sucursal, Cuenta> cuentaCollection;

}