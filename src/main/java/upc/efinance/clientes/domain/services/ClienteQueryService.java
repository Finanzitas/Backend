package upc.efinance.clientes.domain.services;

import upc.efinance.clientes.domain.model.aggregates.Cliente;
import upc.efinance.clientes.domain.model.queries.GetClienteByDniQuery;

import java.util.Optional;

public interface ClienteQueryService {
    Optional<Cliente> handle(GetClienteByDniQuery query);
}
