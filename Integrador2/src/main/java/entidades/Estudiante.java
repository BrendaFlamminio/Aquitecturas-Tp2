package entidades;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estudiante {
    @Id
    int nro_libreta;
    @Column(nullable = false)
    String nombre;
    @Column(nullable = false)
    String apellido;
    @Column(nullable = false)
    int edad;
    @Column(nullable = false)
    String genero;
    @Column(nullable = false)
    int dni;
    @Column(nullable = false)
    String ciudad_residencia;
    @OneToMany (mappedBy = "estudiante")
    List<Matricula> carreras;

    public Estudiante() {
    }

    public Estudiante(int nro_libreta, String nombre, String apellido, int edad, String genero, int dni, String ciudad_residencia, List<Matricula> carreras) {
        this.nro_libreta = nro_libreta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.dni = dni;
        this.ciudad_residencia = ciudad_residencia;
    }

    public Estudiante(int nro_libreta, String nombre, String apellido, int edad, String genero, int dni, String ciudad_residencia) {
        this.nro_libreta = nro_libreta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.dni = dni;
        this.ciudad_residencia = ciudad_residencia;
    }

    public int getNro_libreta() {
        return nro_libreta;
    }

    public void setNro_libreta(int nro_libreta) {
        this.nro_libreta = nro_libreta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCiudad_residencia() {
        return ciudad_residencia;
    }

    public void setCiudad_residencia(String ciudad_residencia) {
        this.ciudad_residencia = ciudad_residencia;
    }

    public List<Matricula> getCarreras() {
        return carreras;
    }

    public void addCarreras(Matricula m) {
        if(!carreras.contains(m)){
            carreras.add(m);
        }
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nro_libreta=" + nro_libreta +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", dni=" + dni +
                ", ciudad_residencia='" + ciudad_residencia + '\'' +
                '}';
    }
}
