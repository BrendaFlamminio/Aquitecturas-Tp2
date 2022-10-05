import dto.Reporte;
import dto.ReporteCarreraInscriptosDto;
import entidades.Estudiante;
import implementation.CarreraRepositoryImpl;
import implementation.EstudianteRepositoryImpl;
import implementation.MatriculaRepositoryImpl;
import interfaces.CarreraRepository;
import interfaces.EstudianteRepository;
import interfaces.MatriculaRepository;

import java.util.List;

public class Select {
    public static void main(String[] args) {
        EstudianteRepository estudiantes = new EstudianteRepositoryImpl();
        MatriculaRepository matriculas = new MatriculaRepositoryImpl();
        CarreraRepository carreras = new CarreraRepositoryImpl();

        //--------------------------------------------------------------------------------------
        //recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
        List<Estudiante> estudiantesList = estudiantes.orderByEdad();
        System.out.println("Lista de estudiantes ordenados por edad---------------------------");
        for (Estudiante estudiante : estudiantesList) {
            System.out.println(estudiante.toString());
        }
        //--------------------------------------------------------------------------------------
        //recuperar un estudiante, en base a su número de libreta universitaria
        System.out.println("Estudiante dado un número de libreta--------------------------------");
        Estudiante e = estudiantes.getEstudianteByNumeroLibreta(25);
        System.out.println(e.toString());
        //--------------------------------------------------------------------------------------
        //recuperar todos los estudiantes, en base a su género
        List<Estudiante> estudiantesGenero = estudiantes.getEstudiantesByGenero("Femenino");
        System.out.println("Lista de estudiantes dado un género----------------------------------");
        for (Estudiante estudiante : estudiantesGenero) {
            System.out.println(estudiante.toString());
        }
        //---------------------------------------------------------------------------------------
        //recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
        List<ReporteCarreraInscriptosDto> carrerasOrdenadasPorCantidadDeInscriptos = carreras.getCarrerasOrdenadasPorCantidadInscriptos();
        System.out.println("Lista de carreras con estudiantes inscriptos ordenado por cantidad de alumnos----------------------------------");
        for (ReporteCarreraInscriptosDto carrera : carrerasOrdenadasPorCantidadDeInscriptos) {
            System.out.println(carrera.toString());
        }

        //-------------------------------------------------------------------------------------
        //recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
        List<Estudiante> estudiantesCarreraCiudad = estudiantes.getEstudiantesByCarreraOrderByCiudad("Tudai", "Cambridge");
        System.out.println("Lista de estudiantes dada una carrera y ciudad----------------------------------");
        for (Estudiante estudiante : estudiantesCarreraCiudad) {
            System.out.println(estudiante.toString());
        }
        
        //-------------------------------------------------------------------------------------
        // Reporte de carreras de inscriptos y egresados ordenados por año y alfabeticamente
        List<Reporte> reportes = carreras.getReporte();
        System.out.println("Reporte de carreras---------------------------------------------");
        for (Reporte reporte : reportes) {
            System.out.println(reporte.toString());
        }
    }
}
