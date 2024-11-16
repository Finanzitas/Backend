package upc.efinance.documentos.domain.services;

import upc.efinance.documentos.domain.model.aggregates.PaymentDocument;
import upc.efinance.documentos.domain.model.commands.CreatePaymentDocumentCommand;
import upc.efinance.documentos.domain.model.commands.UpdatePaymentDocumentCommand;

import java.util.Optional;

public interface PaymentDocumentCommanService {
    Optional<PaymentDocument> handle(CreatePaymentDocumentCommand command);
    Optional<PaymentDocument> update(UpdatePaymentDocumentCommand command);
    void deleteById(Long idDocumento);
}
