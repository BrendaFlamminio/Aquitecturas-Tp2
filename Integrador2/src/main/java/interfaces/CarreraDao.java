package interfaces;

import entidades.Carrera;
import utilities.Reporte;
import utilities.ReporteCarreraInscriptos;

import java.util.List;

public interface CarreraDao extends Dao <Carrera,Integer > {
     List<Carrera> getEstudiantesInscriptosOrderByCantidad();
     List<Carrera> getEstudiantesInscriptosOrderByCarreraAnio();
     List<Carrera> getEstudiantesGraduadosOrderByCarreraAnio();
     List<ReporteCarreraInscriptos> getCarrerasOrdenadasPorCantidadInscriptos();
     List <Reporte> getReporte();
}
