package upc.efinance.reportes.domain.model.queries;

public record GetReportesByIdReporteQuery(Long idReporte ) {
    public GetReportesByIdReporteQuery {
        if (idReporte == null) {
            throw new IllegalArgumentException("Id reporte no puede ser nulo");
        }
    }
}
