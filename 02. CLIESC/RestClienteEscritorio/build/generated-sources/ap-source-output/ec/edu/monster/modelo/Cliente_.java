package ec.edu.monster.modelo;

import ec.edu.monster.modelo.Cuenta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-25T12:46:05")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> chrCliedni;
    public static volatile SingularAttribute<Cliente, String> vchCliematerno;
    public static volatile SingularAttribute<Cliente, String> vchCliepaterno;
    public static volatile SingularAttribute<Cliente, String> vchClienombre;
    public static volatile SingularAttribute<Cliente, String> vchClietelefono;
    public static volatile SingularAttribute<Cliente, String> vchClieemail;
    public static volatile SingularAttribute<Cliente, String> chrCliecodigo;
    public static volatile SingularAttribute<Cliente, String> vchCliedireccion;
    public static volatile CollectionAttribute<Cliente, Cuenta> cuentaCollection;
    public static volatile SingularAttribute<Cliente, String> vchClieciudad;

}