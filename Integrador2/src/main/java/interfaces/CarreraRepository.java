package interfaces;

import dto.ReporteCarreraInscriptosDto;
import entidades.Carrera;
import dto.Reporte;

import java.util.List;

public interface CarreraRepository extends Repository<Carrera,Integer > {
     List<ReporteCarreraInscriptosDto> getCarrerasOrdenadasPorCantidadInscriptos();
     List<Reporte> getReporte();
     void close();
}
