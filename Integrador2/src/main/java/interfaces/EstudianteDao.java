package interfaces;

import entidades.Estudiante;

import java.util.List;

public interface EstudianteDao extends Dao<Estudiante, Integer> {
    List<Estudiante> orderByEdad();

    Estudiante getEstudianteByNumeroLibreta(int nro_libreta);

    List<Estudiante> getEstudiantesByGenero(String genero);

    List<Estudiante> getEstudiantesByCarreraOrderByCiudad(String carrera, String ciudad_residencia);


}
