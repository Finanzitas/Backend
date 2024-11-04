package upc.efinance.clientes.interfaces.rest.transform;

import upc.efinance.clientes.domain.model.aggregates.Cliente;
import upc.efinance.clientes.interfaces.rest.resources.ClienteResource;

public class CreateClienteCommandFromResourceAssembler {
    public static ClienteResource toClienteResource(Cliente entity) {
        return new ClienteResource(
                entity.getDni(),
                entity.getClave(),
                entity.getNombre(),
                entity.getDireccion(),
                entity.getCorreo()
        );
    }
}
