package interfaces;

import entidades.Matricula;

public interface MatriculaRepository extends Repository<Matricula, Integer> {
    void close();
}
