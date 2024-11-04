package upc.efinance.reportes.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.efinance.reportes.domain.model.aggregates.Reporte;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Long> {
    Optional<Reporte> findByIdReporte(Long idReporte);
    List<Reporte> findAllByDniCliente(String dniCliente);
}

