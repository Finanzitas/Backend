package upc.efinance.carteras.interfaces.rest.transform;

import upc.efinance.carteras.domain.model.commands.CreateCarteraCommand;
import upc.efinance.carteras.interfaces.rest.resources.CreateCarteraResource;
import upc.efinance.reportes.domain.model.commands.CreateReporteCommand;
import upc.efinance.reportes.interfaces.rest.resources.CreateReporteResource;

public class CreateCarteraCommandFromResourceAssembler {
    public static CreateCarteraCommand toCommandFromResource(CreateCarteraResource resource) {
        return new CreateCarteraCommand(
                resource.dniCliente(),
                resource.nombreCartera(),
                resource.fechaInicial(),
                resource.fechaFinal(),
                resource.diasTranscurridos(),
                resource.interesGenerado(),
                resource.numeroDocumentos(),
                resource.documentosPagados(),
                resource.docuemntosPendientes(),
                resource.banco()
                );
    }
}
