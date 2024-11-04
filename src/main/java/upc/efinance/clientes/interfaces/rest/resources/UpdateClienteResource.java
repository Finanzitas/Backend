package upc.efinance.clientes.interfaces.rest.resources;

public record UpdateClienteResource(
        String dni,
        String clave,
        String nombre,
        String direccion,
        String correo
) {
    public UpdateClienteResource {
        if (dni == null) {
            throw new IllegalArgumentException("El DNI no puede ser nulo.");
        }
    }
}
