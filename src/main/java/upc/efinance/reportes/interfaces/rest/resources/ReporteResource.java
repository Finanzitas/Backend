package upc.efinance.reportes.interfaces.rest.resources;

public record ReporteResource(
        Long idReporte,
        String dniClientes,  // El nombre debe coincidir con lo que esperas en el JSON
        java.time.LocalDate fechaReporte,
        float montoTotal,
        int documentosPagados,
        int documentosPendientes,
        int documentosVencidos,
        int numeroCarteras
) {
    // No necesitas cambios adicionales aquí, pero asegúrate de que estos campos se asignen correctamente.
}
