package upc.efinance.clientes.interfaces.rest.transform;

import upc.efinance.clientes.domain.model.commands.CreateClienteCommand;
import upc.efinance.clientes.interfaces.rest.resources.CreateClienteResource;

public class ClienteResourceFromEntityAssembler {
    public static CreateClienteCommand toCommandFromResource(CreateClienteResource resource) {
        return new CreateClienteCommand(
                resource.dni(),
                resource.clave(),
                resource.nombre(),
                resource.direccion(),
                resource.correo()
        );
    }
}

