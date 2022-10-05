package utilities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ReporteCarreraInscriptos {
    private String carrera;
    private Long cantAlumnos;



    public ReporteCarreraInscriptos(String carrera, Long cantAlumnos) {
        this.carrera = carrera;
        this.cantAlumnos = cantAlumnos;
    }

    public Long getCantAlumnos() {
        return cantAlumnos;
    }

    public void setCantAlumnos(Long cantAlumnos) {
        this.cantAlumnos = cantAlumnos;
    }

    public String getCarrera() {
        return carrera;
    }

    @Override
    public String toString() {
        return "ReporteCarrera [carrera=" + carrera + ", cantAlumnos=" + cantAlumnos + "]";
    }
}
