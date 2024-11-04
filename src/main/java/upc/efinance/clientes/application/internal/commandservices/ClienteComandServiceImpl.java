package upc.efinance.clientes.application.internal.commandservices;

import org.springframework.stereotype.Service;
import upc.efinance.clientes.domain.model.aggregates.Cliente;
import upc.efinance.clientes.domain.model.commands.CreateClienteCommand;
import upc.efinance.clientes.domain.model.commands.UpdateClienteCommand;
import upc.efinance.clientes.domain.services.ClienteCommanService;
import upc.efinance.clientes.infrastructure.persistence.jpa.ClienteRepository;

import java.util.Optional;


@Service
public class ClienteComandServiceImpl implements ClienteCommanService {
    private final ClienteRepository clienteRepository;

    public ClienteComandServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Optional<Cliente> handle(CreateClienteCommand command) {
        var cliente = new Cliente(command);
        var createdCliente = clienteRepository.save(cliente);
        return Optional.of(createdCliente);
    }

    @Override
    public Optional<Cliente> update(UpdateClienteCommand command) {
        return clienteRepository.findById(command.dni()).map(cliente -> {
            cliente.updateData(command);
            clienteRepository.save(cliente);
            return cliente;
        });
    }
}
