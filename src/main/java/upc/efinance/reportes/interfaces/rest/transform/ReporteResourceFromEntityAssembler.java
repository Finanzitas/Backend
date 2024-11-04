package upc.efinance.reportes.interfaces.rest.transform;

import upc.efinance.reportes.domain.model.aggregates.Reporte;
import upc.efinance.reportes.interfaces.rest.resources.ReporteResource;

public class ReporteResourceFromEntityAssembler {
    public static ReporteResource toResourceFromEntity(Reporte entity) {
        return new ReporteResource(
                entity.getDniCliente(),
                entity.getIdReporte(),
                entity.getFechaReporte(),
                entity.getMontoTotal(),
                entity.getDocumentosPagados(),
                entity.getDocumentosPendientes(),
                entity.getDocumentosVencidos(),
                entity.getNumeroCarteras());
    }
}
