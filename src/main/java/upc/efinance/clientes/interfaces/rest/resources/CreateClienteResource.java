package upc.efinance.clientes.interfaces.rest.resources;

import upc.efinance.clientes.domain.model.commands.CreateClienteCommand;

public record CreateClienteResource(String dni,
                                    String clave,
                                    String nombre,
                                    String direccion,
                                    String correo
) {
    public CreateClienteResource {
        if (dni == null) {
            throw new IllegalArgumentException("dni");
        }
        if (clave == null) {
            throw new IllegalArgumentException("clave");
        }
        if (nombre == null) {
            throw new IllegalArgumentException("nombre");
        }
        if (direccion == null) {
            throw new IllegalArgumentException("direccion");
        }
        if (correo == null) {
            throw new IllegalArgumentException("correo");
        }
    }
}
