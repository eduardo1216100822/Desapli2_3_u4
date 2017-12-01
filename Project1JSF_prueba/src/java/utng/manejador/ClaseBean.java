package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import utng.datos.ClaseDAO;
import utng.datos.PaqueteDAO;
import utng.modelo.Clase;
import utng.modelo.Paquete;


@ManagedBean(name="claseBean") 
@SessionScoped
public class ClaseBean implements Serializable{
    private List<Clase> clases;
    private Clase clase;
    private List<Paquete> paquetes;
    public ClaseBean(){
        clase = new Clase();
        clase.setPaquete(new Paquete());
    }

     public List<Paquete> getPaquetes() {
        return paquetes;
    }
    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }
    
     public Clase getClase() {
        return clase;
    }
     
     public void setClase(Clase clase) {
        this.clase = clase;
    }
     
    public List<Clase> getClases() {
        return clases;
    }
    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }
    
     public String listar(){
        ClaseDAO dao = new ClaseDAO();
        try {
            clases=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Clases";
    }
    
    public String eliminar(){
         ClaseDAO dao = new ClaseDAO();
        try {
            dao.delete(clase);
            clases=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";//no me queda claro si este es es lo que devuelve 
    }
    
    public String iniciar(){
        clase= new Clase();
        clase.setPaquete(new Paquete());
        try {
            paquetes= new PaqueteDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Iniciar";
    }
    
    public String guardar(){
        ClaseDAO dao = new ClaseDAO();
        try {
            if(clase.getIdClase()!= 0){
                dao.update(clase);
            }else {
                dao.insert(clase);
            }
            clases=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
    return "Cancelar";
    }
    
    public String editar(Clase clase){
        this.clase=clase;
        try {
            paquetes = new PaqueteDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Editar";
    }
    
    public String login(){
        clase = new ClaseDAO().login(this.clase);
        if(clase != null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clase",clase);
            return "Correcto";
        }else {
            clase = new Clase();
            return "Incorrecto";
        }
    }  
}
