package upc.efinance.carteras.domain.model.commands;

public record UpdateCarteraCommand(
Long idCartera,
        String dniCliente,
        String nombreCartera,
        java.time.LocalDate fechaInicial,
        java.time.LocalDate fechaFinal,
        int diasTranscurridos,
        float interesGenerado,
        int numeroDocumentos,
        int documentosPagados,
        int documentosPendientes,
        String banco
) {
    public UpdateCarteraCommand {

        if (dniCliente == null || dniCliente.isBlank()) {
            throw new IllegalArgumentException("DNI cliente no puede ser nulo");
        }
        if (fechaInicial == null) {
            throw new IllegalArgumentException("Fecha inicial no puede ser nula");
        }
        if (fechaFinal == null) {
            throw new IllegalArgumentException("Fecha final no puede ser nula");
        }
        if (diasTranscurridos < 0) {
            throw new IllegalArgumentException("Días transcurridos no puede ser negativo");
        }
        if (numeroDocumentos < 0) {
            throw new IllegalArgumentException("Número de documentos no puede ser negativo");
        }
        if (documentosPagados < 0) {
            throw new IllegalArgumentException("Documentos pagados no puede ser negativo");
        }
        if (documentosPendientes < 0) {
            throw new IllegalArgumentException("Documentos pendientes no puede ser negativo");
        }
        if (banco == null) {
            throw new IllegalArgumentException("Banco no puede ser nulo");
        }
    }
}
