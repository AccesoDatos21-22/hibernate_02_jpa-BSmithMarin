package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "modulos")
    private Set<Profesor> profesores = new HashSet<>();

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

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }
}
