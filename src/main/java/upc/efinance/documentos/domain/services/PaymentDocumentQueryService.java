package upc.efinance.documentos.domain.services;

import upc.efinance.documentos.domain.model.aggregates.PaymentDocument;
import upc.efinance.documentos.domain.model.queries.GetPaymentDocumentByIdDocumentoQuery;
import upc.efinance.documentos.domain.model.queries.GetPaymentDocumentsByDniClienteQuery;

import java.util.List;
import java.util.Optional;

public interface PaymentDocumentQueryService {
    Optional<PaymentDocument> handle(GetPaymentDocumentByIdDocumentoQuery query);
    List<PaymentDocument> handle(GetPaymentDocumentsByDniClienteQuery query);
}
