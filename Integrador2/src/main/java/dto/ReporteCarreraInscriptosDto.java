package dto;

public class ReporteCarreraInscriptosDto {
    private String carrera;
    private Long cantAlumnos;

    public ReporteCarreraInscriptosDto() {
    }

    public ReporteCarreraInscriptosDto(String carrera, Long cantAlumnos) {
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
