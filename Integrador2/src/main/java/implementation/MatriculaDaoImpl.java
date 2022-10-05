package implementation;

import entidades.Estudiante;
import entidades.Matricula;
import interfaces.MatriculaDao;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Encargada de la implementación de las operaciones sobre Matricula
 */
public class MatriculaDaoImpl implements MatriculaDao {
    private final EntityManager em;

    public MatriculaDaoImpl() {
        this.em = PersistenceManager.getInstance().createEntityManager();
    }

    /**
     * Inserta una Matricula dada en la tabla Matricula
     * @param m objeto de tipo Matricula
     */
    @Override
    public void insert(Matricula m) {
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        //em.close();
    }
    /**
     * Consulta en la base de datos el listado de matricula y lo devuelve en una lista
     * @return lista de objetos de tipo Matricula
     */
    @Override
    public List<Matricula> getAll() {
        em.getTransaction().begin();
        Matricula m = em.find(Matricula.class, 1);
        System.out.println(m);
        List<Matricula> matriculas = em.createQuery("SELECT m FROM Matricula m").getResultList();
        matriculas.forEach(p -> System.out.println(m));
        em.getTransaction().commit();
        //em.close();
        return matriculas;
    }

    @Override
    public Matricula get(Integer nro_libreta) {
            return null;

    }
}
