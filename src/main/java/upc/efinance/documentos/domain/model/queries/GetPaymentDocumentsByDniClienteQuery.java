package upc.efinance.documentos.domain.model.queries;

public record GetPaymentDocumentsByDniClienteQuery(String dniCliente) {
    public GetPaymentDocumentsByDniClienteQuery {
        if (dniCliente == null || dniCliente.isEmpty()) {
            throw new IllegalArgumentException("El dniCliente no puede ser nulo o vacío");
        }
    }
}
