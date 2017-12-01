package utng.modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="clase")
public class Clase implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_clase")
    private Long idClase;
    @Column(name="nombre_clase", length=10)
    private String nombreClase;
    @Column(name="tipo_clase", length=10)
    private String tipoClase;
    @Column(length=40)
    private String clave;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="id_paquete")
    private Paquete paquete;

    public Clase(Long idClase, String nombreClase,String tipoClase,String clave, Paquete paquete) {
        super();
        this.idClase = idClase;
        this.nombreClase = nombreClase;
        this.tipoClase=tipoClase;
        this.clave = clave;
        this.paquete = paquete;
    }

    public Clase() {
        this.idClase=0L;
    }

    public String getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(String tipoClase) {
        this.tipoClase = tipoClase;
    }
    
    public Long getIdClase() {
        return idClase;
    }
    public void setIdClase(Long idClase) {
        this.idClase = idClase;
    }
    public String getNombreClase() {
        return nombreClase;
    }
    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public Paquete getPaquete() {
        return paquete;
    }
    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
    
    
}

