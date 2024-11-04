package upc.efinance.clientes.interfaces.rest.resources;

public record ClienteResource(
        String dni,
        String clave,
        String nombre,
        String direccion,
        String correo
) {
}
