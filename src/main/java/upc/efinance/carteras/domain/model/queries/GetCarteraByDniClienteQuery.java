package upc.efinance.carteras.domain.model.queries;

public record GetCarteraByDniClienteQuery(String dniCliente) {
    public GetCarteraByDniClienteQuery {
        if (dniCliente == null || dniCliente.isBlank()) {
            throw new IllegalArgumentException("DNI cliente no puede ser nulo o vacío");
        }
    }
}
