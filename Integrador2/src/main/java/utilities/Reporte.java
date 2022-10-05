package utilities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor

public class Reporte {
    private String carrera;
    private int anio;
    private BigInteger inscriptos;
    private BigInteger graduados;

    public Reporte(String carrera, int anio, BigInteger inscriptos, BigInteger graduados) {
        super();
        this.carrera = carrera;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.graduados = graduados;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public BigInteger getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(BigInteger inscriptos) {
        this.inscriptos = inscriptos;
    }

    public BigInteger getGraduados() {
        return graduados;
    }

    public void setGraduados(BigInteger graduados) {
        this.graduados = graduados;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                ", anio=" + anio +
                "carrera='" + carrera + '\'' +
                ", inscriptos='" + inscriptos + '\'' +
                ", graduados='" + graduados + '\'' +
                '}';
    }
}
