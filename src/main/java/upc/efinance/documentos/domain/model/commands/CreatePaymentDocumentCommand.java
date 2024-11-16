package upc.efinance.documentos.domain.model.commands;

import java.time.LocalDate;

public record CreatePaymentDocumentCommand(
        String dniCliente,
        Long idCartera,
        String tipoDocumento,
        float capital,
        float interesGenerado,
        String divisa,
        float montoFinal,
        float tasaEfectiva,
        java.time.LocalDate fechaEmision,
        java.time.LocalDate fechaVencimiento,
        float tasaDescuento,
        float montoDescuento,
        String descripcion,
        String estado,
        String tipoInteres) {

    public CreatePaymentDocumentCommand {
        if ((dniCliente == null) || (idCartera == null)) {
            throw new IllegalArgumentException("El dni cliente no puede ser nulo");
        }

        if ((divisa == null) || divisa.isEmpty()) {
            throw new IllegalArgumentException("divisa no puede tomar ese valor");
        }
        if (tipoDocumento == null || tipoDocumento.isEmpty()) {
            throw new IllegalArgumentException("tipoDocumento no puede tomar ese valor");
        }
        if (capital < 0) {
            throw new IllegalArgumentException("capital no puede ser negativo");
        }
        if (interesGenerado < 0) {
            throw new IllegalArgumentException("interesGenerado no puede ser negativo");
        }
        if (montoFinal < 0) {
            throw new IllegalArgumentException("montoFinal no puede ser negativo");
        }
        if (tasaEfectiva < 0) {
            throw new IllegalArgumentException("tasaEfectiva no puede ser negativo");
        }
        if (fechaVencimiento == null) {
            throw new IllegalArgumentException("fechaVencimiento no puede ser null");
        }
        if (tasaDescuento < 0) {
            throw new IllegalArgumentException("tasaDescuento no puede ser negativo");
        }
        if (montoDescuento < 0) {
            throw new IllegalArgumentException("montoDescuento no puede ser negativo");
        }
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("descripcion no puede ser negativo");
        }
        if (estado == null || estado.isEmpty()) {
            throw new IllegalArgumentException("estado no puede ser negativo");
        }
    }



}



