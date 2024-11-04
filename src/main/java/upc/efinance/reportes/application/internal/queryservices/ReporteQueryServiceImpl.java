package upc.efinance.reportes.application.internal.queryservices;


import org.springframework.stereotype.Service;
import upc.efinance.reportes.domain.model.aggregates.Reporte;
import upc.efinance.reportes.domain.model.queries.GetReportesByDniClienteQuery;
import upc.efinance.reportes.domain.model.queries.GetReportesByIdReporteQuery;
import upc.efinance.reportes.domain.services.ReporteQueryService;
import upc.efinance.reportes.infrastructure.persistence.jpa.ReporteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReporteQueryServiceImpl implements ReporteQueryService {
    private final ReporteRepository reporteRepository;

    public ReporteQueryServiceImpl(ReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }

    @Override
    public Optional<Reporte> handle (GetReportesByIdReporteQuery query){
        return reporteRepository.findById(query.idReporte());
    }

    @Override
    public List<Reporte> handle(GetReportesByDniClienteQuery query) {
        return reporteRepository.findAllByDniCliente(query.dniCliente());
    }
}
