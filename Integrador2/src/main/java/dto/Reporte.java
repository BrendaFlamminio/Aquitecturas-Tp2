package dto;

import java.math.BigInteger;

public class Reporte {
    private String carrera;
    private Integer anio;
    private Long inscriptos;
    private Long graduados;

    public Reporte() {
    }

    public Reporte(String carrera, Integer anio, Long inscriptos, Long graduados) {
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

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Long getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(Long inscriptos) {
        this.inscriptos = inscriptos;
    }

    public Long getGraduados() {
        return graduados;
    }

    public void setGraduados(Long graduados) {
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
