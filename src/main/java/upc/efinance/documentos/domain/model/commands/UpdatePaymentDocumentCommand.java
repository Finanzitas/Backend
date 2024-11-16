package upc.efinance.documentos.domain.model.commands;

import java.time.LocalDate;

public record UpdatePaymentDocumentCommand(
        Long idDocumento,  // Necesitamos el ID para identificar qué documento actualizar
        String dniCliente,
        Long idCartera,
        String tipoDocumento,
        float capital,
        float interesGenerado,
        String divisa,
        float montoFinal,
        float tasaEfectiva,
        LocalDate fechaEmision,
        LocalDate fechaVencimiento,
        float tasaDescuento,
        float montoDescuento,
        String descripcion,
        String estado,
        String tipoInteres) {
    public UpdatePaymentDocumentCommand {
        if (idDocumento == null || idDocumento <= 0) {
            throw new IllegalArgumentException("El idDocumento no puede ser nulo o inválido");
        }
        if ((dniCliente == null || dniCliente.isEmpty()) ||
                (tipoDocumento == null || tipoDocumento.isEmpty()) ||
                (divisa == null || divisa.isEmpty()) ||
                (descripcion == null || descripcion.isEmpty()) ||
                (estado == null || estado.isEmpty()) ||
                (fechaVencimiento == null)) {
            throw new IllegalArgumentException("Algunos de los valores no pueden ser nulos o vacíos");
        }
        if (capital < 0 || interesGenerado < 0 || montoFinal < 0 || tasaEfectiva < 0 || tasaDescuento < 0 || montoDescuento < 0) {
            throw new IllegalArgumentException("Los valores no pueden ser negativos");
        }
    }


}
