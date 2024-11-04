package upc.efinance.carteras.infrastructure.persistence.jpa;

import upc.efinance.carteras.domain.model.aggregates.Cartera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarteraRepository extends JpaRepository<Cartera, Long> {
    Optional<Cartera> findById(Long idCartera);
    List<Cartera> findByDniCliente(String dniCliente);
}
