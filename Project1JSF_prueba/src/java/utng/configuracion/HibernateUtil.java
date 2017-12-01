package utng.configuracion;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
    //Atributo para almacenar la sesion en de la configuracion.
    private static final SessionFactory sessionFactory;
    private static Session session;
    static{
        try {
            sessionFactory= new AnnotationConfiguration().configure("/utng/"
            +"configuracion/hibernate.cfg.xml").buildSessionFactory();
            session=sessionFactory.openSession();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError(
            "ocurrio un error al inicializar"
                    +"SessionFactory"+e);
        }
    
    }

    public static Session getSession() {
        return session;
    }
    
    @Override
    protected void finalize()throws Throwable{
        session.close();
        session=null;
    }
    public static void main(String[] args) {
        new HibernateUtil().getSession();
    }
}
