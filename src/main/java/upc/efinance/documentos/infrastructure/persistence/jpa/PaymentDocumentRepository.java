package upc.efinance.documentos.infrastructure.persistence.jpa;

import upc.efinance.documentos.domain.model.aggregates.PaymentDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentDocumentRepository extends JpaRepository<PaymentDocument, Long> {
    Optional<PaymentDocument> findById(Long idDocumento);
    List<PaymentDocument> findByDniCliente(String dniCliente);
}
