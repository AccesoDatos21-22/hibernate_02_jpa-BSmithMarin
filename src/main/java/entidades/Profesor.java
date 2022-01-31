package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "profesor",
        uniqueConstraints= @UniqueConstraint(columnNames = {"id"}))
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ape1")
    private String ape1;

    @Column(name = "ape2")
    private String ape2;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dir_id", foreignKey = @ForeignKey(name = "DIRECCION_ID_FK"))
    private Direccion direccion;

    @ManyToOne
    @JoinColumn(name = "MODULO_ID",foreignKey = @ForeignKey(name = "MODULO_ID_FK"))
    private Modulo modulo;

    public Profesor(){}

    public Profesor(String nombre, String ape1, String ape2, Direccion direccion) {
        //this.id = id;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ape1='" + ape1 + '\'' +
                ", ape2='" + ape2 + '\'' +
                ", direccion=" + direccion +
                ", modulo=" + modulo +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
}
