package upc.efinance.documentos.interfaces.rest.resources;

import java.time.LocalDate;

public record CreatePaymentDocumentResource(String dniCliente,
                                            Long idCartera,
                                            String tipoDocumento,
                                            float capital,
                                            float interesGenerado,
                                            String divisa,
                                            float montoFinal,
                                            float tasaEfectiva,
                                            LocalDate fechaVencimiento,
                                            float tasaDescuento,
                                            float montoDescuento,
                                            String descripcion,
                                            String estado
) {
    public CreatePaymentDocumentResource {
        if (tipoDocumento == null || tipoDocumento.isEmpty()) {
            throw new IllegalArgumentException("Tipo de documento nulo");
        }
        if (capital <= 0) {
            throw new IllegalArgumentException("Capital invalido");
        }
        if (interesGenerado <= 0) {
            throw new IllegalArgumentException("InteresGenerado invalido");
        }
        if (divisa == null || divisa.isEmpty()) {
            throw new IllegalArgumentException("Divisa invalido");
        }
        if (montoFinal <= 0) {
            throw new IllegalArgumentException("MontoFinal invalido");
        }
        if (tasaEfectiva <= 0) {
            throw new IllegalArgumentException("TasaEfectiva invalido");
        }
        if (fechaVencimiento == null) {
            throw new IllegalArgumentException("FechaVencimiento invalido");
        }
        if (tasaDescuento <= 0) {
            throw new IllegalArgumentException("TasaDescuento incompleta");
        }
        if (montoDescuento <= 0) {
            throw new IllegalArgumentException("MontoDescuento invalido");
        }
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("Descripcion invalido");
        }
        if (estado == null || estado.isEmpty()) {
            throw new IllegalArgumentException("Estado invalido");
        }
    }
}
