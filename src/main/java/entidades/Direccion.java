package entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "direccion",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Direccion implements Serializable {

    @Column(name = "calle")
    private String calle;

    @Column(name = "poblacion")
    private String poblacion;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "numero")
    private int numero;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Direccion(){}

    public Direccion(String calle, String poblacion, String provincia, int numero) {
        //this.id = id;
        this.calle = calle;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", poblacion='" + poblacion + '\'' +
                ", provincia='" + provincia + '\'' +
                ", numero=" + numero +
                ", id=" + id +
                '}';
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
