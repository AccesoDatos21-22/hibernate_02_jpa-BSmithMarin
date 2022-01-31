package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "modulo",uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class Modulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private int curso;

    @Column
    private float creditos;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "modulo")
    List<Profesor> listaProfesores = new ArrayList<>();

    public Modulo(String nombre, int curso, float creditos) {
        this.nombre = nombre;
        this.curso = curso;
        this.creditos = creditos;
    }

    public Modulo() {
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", curso=" + curso +
                ", creditos=" + creditos +
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

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public float getCreditos() {
        return creditos;
    }

    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }

    public List<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(List<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }
}
