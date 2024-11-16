package upc.efinance.documentos.interfaces.rest.resources;

import java.time.LocalDate;

public record PaymentDocumentResource(
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
        String tipoInteres // Nuevo atributo
) {}
