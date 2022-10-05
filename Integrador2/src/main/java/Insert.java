import implementation.CarreraDaoImpl;
import implementation.EstudianteDaoImpl;
import implementation.MatriculaDaoImpl;
import interfaces.CarreraDao;
import interfaces.EstudianteDao;
import interfaces.MatriculaDao;
import services.DataLoader;

public class Insert {
    public static void main(String[] args) {
        EstudianteDao estudiantes = new EstudianteDaoImpl();
        MatriculaDao matriculas = new MatriculaDaoImpl();
        CarreraDao carreras = new CarreraDaoImpl();

        DataLoader dataLoader = new DataLoader(estudiantes, carreras, matriculas);

        //carga de datos a la base, generación de estudiantes y matriculación a carreras
        dataLoader.insertEstudiantesFromCSV("src/main/java/csv/estudiantes.csv");
        dataLoader.insertCarrerasFromCSV("src/main/java/csv/carreras.csv");
        dataLoader.insertMatriculasFromCSV("src/main/java/csv/matriculas.csv");


    }
}
