package upc.efinance.reportes.interfaces.rest.transform;

import upc.efinance.reportes.domain.model.commands.CreateReporteCommand;
import upc.efinance.reportes.interfaces.rest.resources.CreateReporteResource;

public class CreateReporteCommandFromResourceAssembler {
    public static CreateReporteCommand toCommandFromResource(CreateReporteResource resource) {
        return new CreateReporteCommand(
                resource.dniClientes(),
                resource.fechaReporte(),
                resource.montoTotal(),
                resource.documentosPagados(),
                resource.documentosPendientes(),
                resource.documentosVencidos(),
                resource.numeroCarteras()
        );
    }
}
