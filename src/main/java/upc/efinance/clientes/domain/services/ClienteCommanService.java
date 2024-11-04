package upc.efinance.clientes.domain.services;

import upc.efinance.clientes.domain.model.aggregates.Cliente;
import upc.efinance.clientes.domain.model.commands.CreateClienteCommand;
import upc.efinance.clientes.domain.model.commands.UpdateClienteCommand;

import java.util.Optional;

public interface ClienteCommanService {
    Optional<Cliente> handle(CreateClienteCommand command);

    Optional<Cliente> update(UpdateClienteCommand command);
}
