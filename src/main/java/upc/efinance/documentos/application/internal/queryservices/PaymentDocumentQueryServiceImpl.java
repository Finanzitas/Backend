package upc.efinance.documentos.application.internal.queryservices;


import upc.efinance.documentos.domain.model.aggregates.PaymentDocument;
import upc.efinance.documentos.domain.model.queries.GetPaymentDocumentByIdDocumentoQuery;
import upc.efinance.documentos.domain.model.queries.GetPaymentDocumentsByDniClienteQuery;
import upc.efinance.documentos.domain.services.PaymentDocumentQueryService;
import upc.efinance.documentos.infrastructure.persistence.jpa.PaymentDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentDocumentQueryServiceImpl implements PaymentDocumentQueryService {
    private final PaymentDocumentRepository paymentDocumentRepository;

    public PaymentDocumentQueryServiceImpl(PaymentDocumentRepository paymentDocumentRepository) {
        this.paymentDocumentRepository = paymentDocumentRepository;
    }

    @Override
    public Optional<PaymentDocument> handle(GetPaymentDocumentByIdDocumentoQuery query){
        return paymentDocumentRepository.findById(query.idDocument());
    }

    @Override
    public List<PaymentDocument> handle(GetPaymentDocumentsByDniClienteQuery query) {
        return paymentDocumentRepository.findByDniCliente(query.dniCliente());
    }
}
