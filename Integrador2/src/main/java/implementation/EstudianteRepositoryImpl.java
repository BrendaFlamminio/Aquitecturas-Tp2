package implementation;

import entidades.Estudiante;
import interfaces.EstudianteRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Encargada de la implemntación de las operaciones sobre estudiante
 */
public class EstudianteRepositoryImpl implements EstudianteRepository {
    private final EntityManager em;

    public EstudianteRepositoryImpl() {
        this.em = PersistenceManager.getInstance().createEntityManager();
    }

    /**
     * Inserta un Estudiante dadoe n la tabla estudiante
     * @param e objeto de tipo Estudiante
     */
    @Override
    public void insert(Estudiante e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }
    /**
     * Consulta en la base de datos el listado de estduaintes y lo devuelve en una lista
     * @return lista de objetos de tipo Estudiante
     */
    @Override
    public List<Estudiante> getAll() {
        Estudiante e = em.find(Estudiante.class, 1);
        System.out.println(e);
        List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e").getResultList();
        estudiantes.forEach(p -> System.out.println(e));
        return estudiantes;
    }

    /**
     * Consulta y devuelve el estudiante correspondiente al id pasado por parámetro
     * @param id id correspondiente a un Estudiante
     * @return objeto de tipo Estudiante
     */
    @Override
    public Estudiante get(Integer id) {
            List<Estudiante> estudiante = em
                    .createQuery("SELECT E FROM Estudiante E WHERE E.nro_libreta =:nro_libreta", Estudiante.class)
                    .setParameter("nro_libreta", id).getResultList();
            if (estudiante.size() == 0) {
                return null;
            } else {
                return estudiante.get(0);
            }
        }

    /**
     * Recupera todos los estudiantes, y ordena por edad de manera descendente
     * @return lista de objetos de tipo Estudiante
     */
    @Override
    public List<Estudiante> orderByEdad() {
        List<Estudiante> estudiantes = em.createQuery("SELECT E FROM Estudiante E ORDER BY E.edad DESC", Estudiante.class).getResultList();
        return estudiantes;
    }

    /**
     * recupera un estudiante, en base a su número de libreta universitaria.
     * @param nro_libreta número de libreta correspondiente a un Estudiante
     * @return objeto de tipo Estudiante
     */
    @Override
    public Estudiante getEstudianteByNumeroLibreta(int nro_libreta) {
        List<Estudiante> estudiantes = em.createQuery("SELECT E FROM Estudiante E WHERE E.nro_libreta =:nro_libreta", Estudiante.class)
                .setParameter("nro_libreta", nro_libreta)
                .getResultList();
        if (estudiantes.size() == 0) {
            return null;
        } else {
            return estudiantes.get(0);
        }
    }

    /**
     * recupera todos los estudiantes, en base a su género
     * @param genero género de estudiante
     * @return lista de objetos de tipo Estudiante
     *
     */
    @Override
    public List<Estudiante> getEstudiantesByGenero(String genero) {
        List<Estudiante> estudiantes = em.createQuery("SELECT E FROM Estudiante E WHERE E.genero =:genero", Estudiante.class)
                .setParameter("genero", genero).getResultList();
        return estudiantes;
    }

    /**
     * recupera los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
     * @param carrera carrera de estudiante
     * @param ciudad_residencia ciudad de residencia de estudiante
     * @return lista de objetos de tipo Estudiante
     */
    //
    @Override
    public List<Estudiante> getEstudiantesByCarreraOrderByCiudad(String carrera, String ciudad_residencia) {
        List<Estudiante> estudiantes;
        Query query = em.createQuery("SELECT E FROM Estudiante E JOIN E.carreras M JOIN M.carrera C WHERE E.ciudad_residencia =:ciudad_residencia AND  C.nombre =:carrera", Estudiante.class)
                .setParameter("carrera", carrera)
                .setParameter("ciudad_residencia", ciudad_residencia);
        estudiantes = query.getResultList();
        return estudiantes;
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
