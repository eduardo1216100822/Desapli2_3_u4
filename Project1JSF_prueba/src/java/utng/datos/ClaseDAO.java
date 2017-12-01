package utng.datos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utng.modelo.Clase;


public class ClaseDAO  extends DAO<Clase>{

    public ClaseDAO() {
        super(new Clase());
    }
    public Clase getOneById(Clase clase) 
            throws HibernateException {
        return super.getOneById(clase.getIdClase()); 
    }
    public Clase login (Clase clase){
        List<String> parametros= 
                new ArrayList<String>();
        List<Object>valores= 
                new ArrayList<Object>();
        parametros.add("nombreClase");
        parametros.add("clave");
        valores.add(clase.getNombreClase());
        valores.add(clase.getClave());
        
        clase = query(
                "SELECT u FROM "
                +modelo.getClass().getName()
                +" u WHERE u.nombreUsuario =:nombreUsuario "
                +"AND u.contrasenia=:contrasenia",
                        parametros, valores);
        return clase;
    }
    
}