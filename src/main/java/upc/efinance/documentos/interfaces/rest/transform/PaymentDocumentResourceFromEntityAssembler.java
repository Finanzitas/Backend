package upc.efinance.documentos.interfaces.rest.transform;

import upc.efinance.documentos.domain.model.aggregates.PaymentDocument;
import upc.efinance.documentos.interfaces.rest.resources.PaymentDocumentResource;

public class PaymentDocumentResourceFromEntityAssembler {
    public static PaymentDocumentResource toPaymentDocumentResource(PaymentDocument entity) {
        return new PaymentDocumentResource(
                entity.getDniCliente(),
                entity.getIdCartera(),
                entity.getTipoDocumento(),
                entity.getCapital(),
                entity.getInteresGenerado(),
                entity.getDivisa(),
                entity.getMontoFinal(),
                entity.getTasaEfectiva(),
                entity.getFechaEmision(),
                entity.getFechaVencimiento(),
                entity.getTasaDescuento(),
                entity.getMontoDescuento(),
                entity.getDescripcion(),
                entity.getEstado(),
                entity.getTipoInteres()
        );
    }
}
