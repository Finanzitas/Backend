package upc.efinance.reportes.domain.model.queries;

public record GetReportesByDniClienteQuery(String dniCliente) {
    public GetReportesByDniClienteQuery {
        if (dniCliente == null || dniCliente.isBlank()) {
            throw new IllegalArgumentException("El DNI del cliente no puede ser nulo o vacío.");
        }
    }
}
