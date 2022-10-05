package implementation;

import dto.ReporteCarreraInscriptosDto;
import entidades.Carrera;
import entidades.Estudiante;
import interfaces.CarreraRepository;
import dto.Reporte;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Encargada de las implementaciones de las operaciones en Matricula
 */
public class CarreraRepositoryImpl implements CarreraRepository {
    private final EntityManager em;

    public CarreraRepositoryImpl() {
        this.em = PersistenceManager.getInstance().createEntityManager();
    }

    /**
     * Inserta una Carrera dado en la tabla Carerra
     * @param c objeto de tipo Carrera
     */
    @Override
    public void insert(Carrera c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
    /**
     * Consulta en la base de datos el listado de carreras y lo devuelve en una lista
     * @return lista de objetos de tipo Carrera
     */
    @Override
    public List<Carrera> getAll() {
        Estudiante e = em.find(Estudiante.class, 1);
        System.out.println(e);
        List<Carrera> carreras = em.createQuery("SELECT c FROM Carrera c").getResultList();
        carreras.forEach(p -> System.out.println(e));
        return carreras;
    }

    /**
     * Consulta y devuelve la Carrera correspondiente al id pasado por parámetro
     * @param id correspondiente a una Carrera
     * @return un objeto de tipo Carrera
     */
    @Override
    public Carrera get(Integer id) {
        List<Carrera> carrera = em
                .createQuery("SELECT C FROM Carrera C WHERE C.carrera_id =:carrera_id ", Carrera.class)
                .setParameter("carrera_id", id).getResultList();
        if (carrera.size() == 0) {
            return null;
        } else {
            return carrera.get(0);
        }
    }
    /**
     * Recupera todas las carreras que tienen inscriptos, y las ordena por cantidad de estudiantes inscriptos
     * @return lista de objetos de tipo Estudiante
     */
    @Override
    public List<ReporteCarreraInscriptosDto> getCarrerasOrdenadasPorCantidadInscriptos  () {
        String query = "SELECT new dto.ReporteCarreraInscriptosDto(c.nombre,COUNT(m.estudiante))"
                + "FROM Carrera c JOIN c.estudiantes m "
                + "WHERE m.fecha_graduacion IS NULL "
                + "GROUP BY c.carrera_id "
                + "ORDER BY COUNT(m.estudiante) DESC";
        List<ReporteCarreraInscriptosDto> carreras = em.createQuery(query).getResultList();
        return carreras;
    }

    @Override
    public List<Reporte> getReporte() {
        String query = "SELECT new dto.Reporte(c.nombre, YEAR(m.fecha_inscripcion), COUNT(YEAR(m.fecha_inscripcion)), COUNT(YEAR(m.fecha_graduacion))) " +
                "FROM Matricula m " +
                "JOIN m.carrera c " +
                "GROUP BY c.carrera_id, YEAR(m.fecha_inscripcion) " +
                "ORDER BY YEAR(m.fecha_inscripcion), c.nombre";
        List<Reporte> reportes = em.createQuery(query).getResultList();
        return reportes;
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
