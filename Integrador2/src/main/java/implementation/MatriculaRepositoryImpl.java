package implementation;

import entidades.Matricula;
import interfaces.MatriculaRepository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Encargada de la implementación de las operaciones sobre Matricula
 */
public class MatriculaRepositoryImpl implements MatriculaRepository {
    private final EntityManager em;

    public MatriculaRepositoryImpl() {
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
    }
    /**
     * Consulta en la base de datos el listado de matricula y lo devuelve en una lista
     * @return lista de objetos de tipo Matricula
     */
    @Override
    public List<Matricula> getAll() {
        Matricula m = em.find(Matricula.class, 1);
        System.out.println(m);
        List<Matricula> matriculas = em.createQuery("SELECT m FROM Matricula m").getResultList();
        matriculas.forEach(p -> System.out.println(m));
        return matriculas;
    }

    @Override
    public Matricula get(Integer nro_libreta) {
            return null;

    }

    /**
     * cierra la conexión
     */
    @Override
    public void close() {
        if(em != null) {
            em.close();
        }
    }
}
