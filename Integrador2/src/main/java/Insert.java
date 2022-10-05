import implementation.CarreraRepositoryImpl;
import implementation.EstudianteRepositoryImpl;
import implementation.MatriculaRepositoryImpl;
import interfaces.CarreraRepository;
import interfaces.EstudianteRepository;
import interfaces.MatriculaRepository;
import services.DataLoader;

public class Insert {
    public static void main(String[] args) {
        EstudianteRepository estudiantes = new EstudianteRepositoryImpl();
        MatriculaRepository matriculas = new MatriculaRepositoryImpl();
        CarreraRepository carreras = new CarreraRepositoryImpl();

        DataLoader dataLoader = new DataLoader(estudiantes, carreras, matriculas);

        //carga de datos a la base, generación de estudiantes y matriculación a carreras
        dataLoader.insertEstudiantesFromCSV("src/main/java/csv/estudiantes.csv");
        dataLoader.insertCarrerasFromCSV("src/main/java/csv/carreras.csv");
        dataLoader.insertMatriculasFromCSV("src/main/java/csv/matriculas.csv");

        dataLoader.complete();
    }
}
