package upc.efinance.reportes.domain.services;

import upc.efinance.reportes.domain.model.aggregates.Reporte;
import upc.efinance.reportes.domain.model.commands.CreateReporteCommand;
import upc.efinance.reportes.domain.model.commands.UpdateReporteCommand;

import java.util.Optional;

public interface ReporteCommandService {
    Optional<Reporte> handle(CreateReporteCommand command);
    Optional<Reporte> updateReporte(UpdateReporteCommand command);
    void deleteById(Long idReporte);
}
