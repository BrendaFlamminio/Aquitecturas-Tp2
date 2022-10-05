import entidades.Carrera;
import entidades.Estudiante;
import implementation.CarreraDaoImpl;
import implementation.EstudianteDaoImpl;
import implementation.MatriculaDaoImpl;
import interfaces.CarreraDao;
import interfaces.EstudianteDao;
import interfaces.MatriculaDao;
import utilities.Reporte;
import utilities.ReporteCarreraInscriptos;

import java.util.List;

public class Select {
    public static void main(String[] args) {
        EstudianteDao estudiantes = new EstudianteDaoImpl();
        MatriculaDao matriculas = new MatriculaDaoImpl();
        CarreraDao carreras = new CarreraDaoImpl();

        //--------------------------------------------------------------------------------------
        //recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
        List<Estudiante> estudiantesList = estudiantes.orderByEdad();
        System.out.println("Lista de estudiantes ordenados por edad---------------------------");
        for (Estudiante estudiante : estudiantesList) {
            System.out.println(estudiante.toString());
        }
        //--------------------------------------------------------------------------------------
        //recuperar un estudiante, en base a su número de libreta universitaria
        System.out.println("Estudiante según número de libreta--------------------------------");
        Estudiante e = estudiantes.getEstudianteByNumeroLibreta(25);
        System.out.println(e.toString());
        //--------------------------------------------------------------------------------------
        //recuperar todos los estudiantes, en base a su género
        List<Estudiante> estudiantesGenero = estudiantes.getEstudiantesByGenero("Femenino");
        System.out.println("Lista de estudiantes por género----------------------------------");
        for (Estudiante estudiante : estudiantesGenero) {
            System.out.println(estudiante.toString());
        }
        //---------------------------------------------------------------------------------------
        //recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.

        List<ReporteCarreraInscriptos> carrerasOrdenadasPorCantidadDeInscriptos = carreras.getCarrerasOrdenadasPorCantidadInscriptos();
        System.out.println("Lista de carreras ordenadas por cantidad de alumnos----------------------------------");
        for (ReporteCarreraInscriptos carrera : carrerasOrdenadasPorCantidadDeInscriptos ) {
            System.out.println(carrera.toString());
        }


        //-------------------------------------------------------------------------------------
        //recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
        List<Estudiante> estudiantesCarreraCiudad = estudiantes.getEstudiantesByCarreraOrderByCiudad("Tudai", "Cambridge");
        System.out.println("Lista de estudiantes por carrera y ciudad----------------------------------");
        for (Estudiante estudiante : estudiantesCarreraCiudad ) {
            System.out.println(estudiante.toString());
        }
        //-------------------------------------------------------------------------------------
        // Reporte de carreras de inscriptos y egresados ordenados por año y alfabeticamente

        List<Reporte> reportes = carreras.getReporte();
        System.out.println("Reporte de carreras");
        for (Reporte reporte : reportes ) {
            System.out.println(reporte.toString());
        }

    }


}
