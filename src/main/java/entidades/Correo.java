package entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Correo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "proveedor")
    private String proveedor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    public Correo(String direccion, String proveedor) {
        this.direccion = direccion;
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Correo{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", proveedor='" + proveedor + '\'' +
                ", profesor=" + profesor +
                '}';
    }

    public Correo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
