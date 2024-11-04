package upc.efinance.documentos.interfaces.rest.transform;

import upc.efinance.documentos.domain.model.commands.CreatePaymentDocumentCommand;
import upc.efinance.documentos.interfaces.rest.resources.CreatePaymentDocumentResource;

public class CreatePaymentDocumentCommandFromResourceAssembler {
    public static CreatePaymentDocumentCommand toCommandFromResource(CreatePaymentDocumentResource resource) {
        return new CreatePaymentDocumentCommand(
                resource.dniCliente(),
                resource.idCartera(),
                resource.tipoDocumento(),
                resource.capital(),
                resource.interesGenerado(),
                resource.divisa(),
                resource.montoFinal(),
                resource.tasaEfectiva(),
                resource.fechaVencimiento(),
                resource.tasaDescuento(),
                resource.montoDescuento(),
                resource.descripcion(),
                resource.estado()
        );
    }
}
