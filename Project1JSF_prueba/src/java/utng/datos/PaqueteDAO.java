package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Paquete;



public class PaqueteDAO extends DAO<Paquete> {
     public PaqueteDAO() {
        super(new Paquete());
    }

    
    public Paquete getOneById(Paquete paquete) 
            throws HibernateException {
        return super.getOneById(
                paquete.getIdPaquete()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
