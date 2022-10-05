package services;

import entidades.Carrera;
import entidades.Estudiante;
import entidades.Matricula;
import interfaces.CarreraDao;
import interfaces.EstudianteDao;
import interfaces.MatriculaDao;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;

public class DataLoader {
    private final EstudianteDao estudianteDao;
    private final CarreraDao carreraDao;
    private final MatriculaDao matriculaDao;

    public DataLoader(EstudianteDao estudianteDao, CarreraDao carreraDao, MatriculaDao matriculaDao) {
        this.estudianteDao = estudianteDao;
        this.carreraDao = carreraDao;
        this.matriculaDao = matriculaDao;
    }
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
            estudianteDao.insert(estudiante);
        }
    }

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
            carreraDao.insert(carrera);
        }
    }

    public void insertMatriculasFromCSV(String f) {
        CSVParser parser = null;
        Date fechaG= null;
        try {
            FileReader csvFile = new FileReader(f);
            parser = CSVFormat.DEFAULT.builder().setHeader().build().parse(csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CSVRecord row : parser) {
            Estudiante estudiante = estudianteDao.get(Integer.parseInt(row.get("id_estudiante")));
            Carrera carrera = carreraDao.get(Integer.parseInt(row.get("id_carrera")));

        if(row.get("fecha_graduacion").equals("")){
        fechaG=null;
        }else{
            fechaG=  Date.valueOf(row.get("fecha_graduacion"));
        }

            Matricula matricula = new Matricula(
                    estudiante,
                    carrera,
                    Date.valueOf(row.get("fecha_inscripcion")),
                    fechaG,
                    Boolean.valueOf(row.get("finalizo"))
            );

            matriculaDao.insert(matricula);
        }

    }
}
