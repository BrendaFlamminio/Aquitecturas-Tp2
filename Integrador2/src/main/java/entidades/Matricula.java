package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Matricula implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "nro_libreta", referencedColumnName = "nro_libreta")
    Estudiante estudiante;
    @Id
    @ManyToOne
    @JoinColumn(name = "carrera_id", referencedColumnName = "carrera_id")
    Carrera carrera;
    @Column (nullable = false)
    Date fecha_inscripcion;
    @Column(nullable = true)
    Date fecha_graduacion;
    @Column(nullable = false)
    boolean finalizo;

    public Matricula() {
    }

    public Matricula(Estudiante estudiante, Carrera carrera, Date fecha_inscripcion, Date fecha_graduacion, boolean finalizo) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.fecha_inscripcion = fecha_inscripcion;
        this.fecha_graduacion = fecha_graduacion;
        this.finalizo = finalizo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Date getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(Date fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public Date getFecha_graduacion() {
        return fecha_graduacion;
    }

    public void setFecha_graduacion(Date fecha_graduacion) {
        this.fecha_graduacion = fecha_graduacion;
    }

    public boolean isFinalizo() {
        return finalizo;
    }

    public void setFinalizo(boolean finalizo) {
        this.finalizo = finalizo;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "estudiante=" + estudiante +
                ", carrera=" + carrera +
                ", fecha_inscripcion=" + fecha_inscripcion +
                ", fecha_graduacion=" + fecha_graduacion +
                ", finalizo=" + finalizo +
                '}';
    }
}
