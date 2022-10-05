package entidades;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carrera {
    @Id
    int carrera_id;
    @Column
    String nombre;
    @OneToMany(mappedBy = "carrera")
    List<Matricula> estudiantes;

    public Carrera() {
    }

    public Carrera(int carrera_id, String nombre) {
        this.carrera_id = carrera_id;
        this.nombre = nombre;
    }

    public Carrera(int carrera_id, String nombre, List<Matricula> estudiantes) {
        this.carrera_id = carrera_id;
        this.nombre = nombre;
    }

    public int getCarrera_id() {
        return carrera_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Carrera{" +
                "carrera_id=" + carrera_id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
