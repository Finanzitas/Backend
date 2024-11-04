package upc.efinance.clientes.interfaces.rest.transform;

import upc.efinance.clientes.domain.model.commands.UpdateClienteCommand;
import upc.efinance.clientes.interfaces.rest.resources.UpdateClienteResource;

public class UpdateClienteCommandFromResourceAssembler {
    public static UpdateClienteCommand toCommand(UpdateClienteResource resource) {
        return new UpdateClienteCommand(
                resource.dni(),
                resource.clave(),
                resource.nombre(),
                resource.direccion(),
                resource.correo()
        );
    }
}
