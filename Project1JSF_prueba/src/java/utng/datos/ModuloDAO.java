package utng.datos;

import org.hibernate.HibernateException;
import utng.datos.DAO;
import utng.modelo.Modulo;


public class ModuloDAO extends DAO<Modulo> {

    public ModuloDAO() {
        super(new Modulo());
    }

    
    public Modulo getOneById(Modulo modulo) throws HibernateException {
        return super.getOneById(modulo.getIdModulo()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
