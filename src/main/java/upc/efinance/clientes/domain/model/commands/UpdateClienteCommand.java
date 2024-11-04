package upc.efinance.clientes.domain.model.commands;

public record UpdateClienteCommand(
        String dni,
        String clave,
        String nombre,
        String direccion,
        String correo
) {
    public UpdateClienteCommand {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede ser nulo o vacío.");
        }
    }
}
