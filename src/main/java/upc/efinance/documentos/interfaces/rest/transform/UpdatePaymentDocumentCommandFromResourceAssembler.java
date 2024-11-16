package upc.efinance.documentos.interfaces.rest.transform;

import upc.efinance.documentos.domain.model.commands.UpdatePaymentDocumentCommand;
import upc.efinance.documentos.interfaces.rest.resources.CreatePaymentDocumentResource;

public class UpdatePaymentDocumentCommandFromResourceAssembler {
    public static UpdatePaymentDocumentCommand toCommandFromResource(Long idDocumento, CreatePaymentDocumentResource resource) {
        return new UpdatePaymentDocumentCommand(
                idDocumento,
                resource.dniCliente(),
                resource.idCartera(),
                resource.tipoDocumento(),
                resource.capital(),
                resource.interesGenerado(),
                resource.divisa(),
                resource.montoFinal(),
                resource.tasaEfectiva(),
                resource.fechaEmision(),
                resource.fechaVencimiento(),
                resource.tasaDescuento(),
                resource.montoDescuento(),
                resource.descripcion(),
                resource.estado(),
                resource.tipoInteres() // Nuevo atributo
        );
    }
}
