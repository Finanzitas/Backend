package upc.efinance.reportes.domain.services;

import upc.efinance.reportes.domain.model.aggregates.Reporte;
import upc.efinance.reportes.domain.model.queries.GetReportesByDniClienteQuery;
import upc.efinance.reportes.domain.model.queries.GetReportesByIdReporteQuery;

import java.util.List;
import java.util.Optional;

public interface ReporteQueryService {
    Optional<Reporte> handle(GetReportesByIdReporteQuery query);
    List<Reporte> handle(GetReportesByDniClienteQuery query);
}
