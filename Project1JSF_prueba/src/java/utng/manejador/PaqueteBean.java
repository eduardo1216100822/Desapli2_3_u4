package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.PaqueteDAO;
import utng.modelo.Paquete;


@ManagedBean @SessionScoped
public class PaqueteBean implements Serializable{
    private List<Paquete>paquetes;
    private Paquete paquete;
    public PaqueteBean(){}

    public Paquete getPaquete() {
        return paquete;
    }
    
    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
    
    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public String listar(){
        PaqueteDAO dao = new PaqueteDAO();
        try {
            paquetes=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Paquetes";
    }
    
    public String eliminar(){
         PaqueteDAO dao = new PaqueteDAO();
        try {
            dao.delete(paquete);
            paquetes=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    
    public String iniciar(){
        paquete= new Paquete();
        return "Iniciar";
    }
    
    public String guardar(){
        PaqueteDAO dao = new PaqueteDAO();
        try {
            if(paquete.getIdPaquete()!= 0){
                dao.update(paquete);
            }else {
                dao.insert(paquete);
            }
            paquetes=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
    return "Cancelar";
    }
    
    public String editar(Paquete paquete){
        this.paquete=paquete;
        return "Editar";
    }
    
}