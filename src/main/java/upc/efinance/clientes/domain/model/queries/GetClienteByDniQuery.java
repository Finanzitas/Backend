package upc.efinance.clientes.domain.model.queries;

public record GetClienteByDniQuery(String dni) {
    public GetClienteByDniQuery {
        if (dni == null || dni.trim().isEmpty()) {
            throw new IllegalArgumentException("dni cannot be null or empty");
        }
    }
}
