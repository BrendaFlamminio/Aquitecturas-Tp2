package services;

import entidades.Carrera;
import entidades.Estudiante;
import entidades.Matricula;
import interfaces.CarreraRepository;
import interfaces.EstudianteRepository;
import interfaces.MatriculaRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;

public class DataLoader {
    private final EstudianteRepository estudianteRepository;
    private final CarreraRepository carreraRepository;
    private final MatriculaRepository matriculaRepository;

    public DataLoader(EstudianteRepository estudianteRepository, CarreraRepository carreraRepository, MatriculaRepository matriculaRepository) {
        this.estudianteRepository = estudianteRepository;
        this.carreraRepository = carreraRepository;
        this.matriculaRepository = matriculaRepository;
    }

    /**
     * inserta en la base de datos Estudiantes
     * @param f recibe un objeto de tipo String con la ruta del archivo .csv
     */
    public void insertEstudiantesFromCSV(String f) {
        CSVParser parser = null;

        try {
            FileReader csvFile = new FileReader(f);
            parser = CSVFormat.DEFAULT.builder().setHeader().build().parse(csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CSVRecord row : parser) {
            Estudiante estudiante = new Estudiante(
                    Integer.parseInt(row.get("numero_libreta")), row.get("nombre"), row.get("apellido"),
                    Integer.parseInt(row.get("edad")), row.get("genero"), Integer.parseInt(row.get("dni")),
                    row.get("ciudad_residencia"));
            estudianteRepository.insert(estudiante);
        }
    }

    /**
     * inserta en la base de datos Carreras
     * @param f recibe un objeto de tipo String con la ruta del archivo .csv
     */
    public void insertCarrerasFromCSV(String f) {
        CSVParser parser = null;

        try {
            FileReader csvFile = new FileReader(f);
            parser = CSVFormat.DEFAULT.builder().setHeader().build().parse(csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CSVRecord row : parser) {
            Carrera carrera = new Carrera(
                    Integer.parseInt(row.get("id_carrera")), row.get("nombre_carrera"));
            carreraRepository.insert(carrera);
        }
    }

    /**
     * inserta en la base de datos Matriculas
     * @param f recibe un objeto de tipo String con la ruta del archivo .csv
     */
    public void insertMatriculasFromCSV(String f) {
        CSVParser parser = null;
        Date fechaG = null;
        try {
            FileReader csvFile = new FileReader(f);
            parser = CSVFormat.DEFAULT.builder().setHeader().build().parse(csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CSVRecord row : parser) {
            Estudiante estudiante = estudianteRepository.get(Integer.parseInt(row.get("id_estudiante")));
            Carrera carrera = carreraRepository.get(Integer.parseInt(row.get("id_carrera")));

            if (row.get("fecha_graduacion").equals("")) {
                fechaG = null;
            } else {
                fechaG = Date.valueOf(row.get("fecha_graduacion"));
            }

            Matricula matricula = new Matricula(
                    estudiante,
                    carrera,
                    Date.valueOf(row.get("fecha_inscripcion")),
                    fechaG,
                    Boolean.valueOf(row.get("finalizo"))
            );

            matriculaRepository.insert(matricula);
        }

    }

    /**
     * cierra la conexión
     */
    public void complete() {
        if(estudianteRepository != null) {
            estudianteRepository.close();
        }
        if(carreraRepository != null) {
            carreraRepository.close();
        }
        if(matriculaRepository != null) {
            matriculaRepository.close();
        }
    }
}
