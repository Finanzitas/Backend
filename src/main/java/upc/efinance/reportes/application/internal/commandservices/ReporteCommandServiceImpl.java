package upc.efinance.reportes.application.internal.commandservices;

import upc.efinance.reportes.domain.model.aggregates.Reporte;
import org.springframework.stereotype.Service;
import upc.efinance.reportes.domain.model.commands.CreateReporteCommand;
import upc.efinance.reportes.domain.model.commands.UpdateReporteCommand;
import upc.efinance.reportes.domain.services.ReporteCommandService;
import upc.efinance.reportes.infrastructure.persistence.jpa.ReporteRepository;

import java.util.Optional;

@Service
public class ReporteCommandServiceImpl implements ReporteCommandService {
    private final ReporteRepository reporteRepository;

    public ReporteCommandServiceImpl(ReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }

    @Override
    public Optional<Reporte> handle(CreateReporteCommand command){
        var reporte = new Reporte(command);
        var createdReporte = reporteRepository.save(reporte);
        return Optional.of(createdReporte);
    }

    @Override
    public Optional<Reporte> updateReporte(UpdateReporteCommand command) {
        Optional<Reporte> existingReporte = reporteRepository.findByIdReporte(command.idReporte());
        return existingReporte.map(reporte -> {
            reporte.update(command);
            return Optional.of(reporteRepository.save(reporte));
        }).orElse(Optional.empty());
    }

    @Override
    public void deleteById(Long idReporte) {
        reporteRepository.deleteById(idReporte);
    }

}
