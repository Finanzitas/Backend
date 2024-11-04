package upc.efinance.reportes.interfaces.rest.resources;

public record ReporteResource(String dniClientes,
                              Long idReporte,
                              java.time.LocalDate fechaReporte,
                              float montoTotal,
                              int documentosPagados,
                              int documentosPendientes,
                              int documentosVencidos,
                              int numeroCarteras) {
}
