package upc.efinance.clientes.application.internal.queryservices;

import org.springframework.stereotype.Service;
import upc.efinance.clientes.domain.model.aggregates.Cliente;
import upc.efinance.clientes.domain.model.queries.GetClienteByDniQuery;
import upc.efinance.clientes.domain.services.ClienteQueryService;
import upc.efinance.clientes.infrastructure.persistence.jpa.ClienteRepository;

import java.util.Optional;

@Service  // Asegúrate de agregar esta anotación
public class ClienteQueryServiceImpl implements ClienteQueryService {
    private final ClienteRepository clienteRepository;

    public ClienteQueryServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Optional<Cliente> handle(GetClienteByDniQuery query){
        return clienteRepository.findById(query.dni());
    }
}
