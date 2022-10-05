package implementation;

import entidades.Carrera;
import entidades.Estudiante;
import interfaces.CarreraDao;
import utilities.Reporte;
import utilities.ReporteCarreraInscriptos;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Encargada de las implementaciones de las operaciones en Matricula
 */
public class CarreraDaoImpl implements CarreraDao {
    private final EntityManager em;

    public CarreraDaoImpl() {
        this.em = PersistenceManager.getInstance().createEntityManager();
    }

    @Override
    public List<Carrera> getEstudiantesInscriptosOrderByCantidad() {
        return null;
    }

    @Override
    public List<Carrera> getEstudiantesInscriptosOrderByCarreraAnio() {
        return null;
    }

    @Override
    public List<Carrera> getEstudiantesGraduadosOrderByCarreraAnio() {
        return null;
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
        //em.close();
    }
    /**
     * Consulta en la base de datos el listado de carreras y lo devuelve en una lista
     * @return lista de objetos de tipo Carrera
     */
    @Override
    public List<Carrera> getAll() {
        em.getTransaction().begin();
        Estudiante e = em.find(Estudiante.class, 1);
        System.out.println(e);
        List<Carrera> carreras = em.createQuery("SELECT c FROM Carrera c").getResultList();
        carreras.forEach(p -> System.out.println(e));
        em.getTransaction().commit();
        //em.close();
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
    public List<ReporteCarreraInscriptos> getCarrerasOrdenadasPorCantidadInscriptos  () {
        String query = "SELECT c.nombre AS carrera, COUNT(m.estudiante) AS cantAlumnos "
                + "FROM Carrera c JOIN Matricula m "
                + "ON c.carrera_id = m.carrera "
                + "WHERE m.fecha_graduacion IS NULL "
                + "GROUP BY c.carrera_id "
                + "ORDER BY COUNT(m.estudiante) DESC";
        List<Object[]> result = em.createQuery(query).getResultList();
        List<ReporteCarreraInscriptos> carreras = result.stream().map(o -> new ReporteCarreraInscriptos((String)o[0], (Long)o[1])).collect(Collectors.toList());
        return carreras;
    }
    @Override
    public List<Reporte> getReporte() {
        String queryNative = "SELECT YEAR(m.fecha_inscripcion) AS anio, c.nombre AS carrera, COUNT(YEAR(m.fecha_inscripcion)) AS inscriptos, COUNT(YEAR(m.fecha_graduacion)) AS graduados " +
            "FROM Matricula m " +
            "JOIN Carrera c " +
            "ON m.carrera_id = c.carrera_id " +
            "GROUP BY c.carrera_id, anio " +
            "ORDER BY YEAR(m.fecha_inscripcion), c.nombre";
        List<Object[]> query = em.createNativeQuery(queryNative).getResultList();
        List<Reporte> reportes = query.stream().map(o -> new Reporte((String)o[1], (int)o[0], (BigInteger) o[2], (BigInteger)o[3])).collect(Collectors.toList());

        return reportes;
    }
}
