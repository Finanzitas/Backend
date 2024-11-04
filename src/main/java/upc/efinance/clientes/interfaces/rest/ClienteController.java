package upc.efinance.clientes.interfaces.rest;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.efinance.clientes.domain.model.aggregates.Cliente;
import upc.efinance.clientes.domain.model.queries.GetClienteByDniQuery;
import upc.efinance.clientes.domain.services.ClienteCommanService;
import upc.efinance.clientes.domain.services.ClienteQueryService;
import upc.efinance.clientes.interfaces.rest.resources.ClienteResource;
import upc.efinance.clientes.interfaces.rest.resources.CreateClienteResource;
import upc.efinance.clientes.interfaces.rest.resources.UpdateClienteResource;
import upc.efinance.clientes.interfaces.rest.transform.ClienteResourceFromEntityAssembler;
import upc.efinance.clientes.interfaces.rest.transform.CreateClienteCommandFromResourceAssembler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upc.efinance.clientes.interfaces.rest.transform.UpdateClienteCommandFromResourceAssembler;

import java.util.Optional;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/E-Finance/Cliente")
public class ClienteController {
    private final ClienteQueryService clienteQueryService;
    private final ClienteCommanService clienteCommanService;

    public ClienteController(ClienteCommanService clienteCommanService ,ClienteQueryService clienteQueryService) {
        this.clienteCommanService = clienteCommanService;
        this.clienteQueryService = clienteQueryService;
    }

    @PostMapping
    public ResponseEntity<ClienteResource> createCliente(@RequestBody CreateClienteResource resource) {
        Optional<Cliente> cliente = clienteCommanService
                .handle(ClienteResourceFromEntityAssembler.toCommandFromResource(resource));
        return cliente.map(source ->
                        new ResponseEntity<>(CreateClienteCommandFromResourceAssembler.toClienteResource(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @GetMapping("{dni}")
    public ResponseEntity<ClienteResource> getCliente(@PathVariable String dni) {
        Optional<Cliente> cliente = clienteQueryService.handle(new GetClienteByDniQuery(dni));
        return cliente.map(source -> ResponseEntity.ok(CreateClienteCommandFromResourceAssembler.toClienteResource(source)))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("{dni}")
    public ResponseEntity<ClienteResource> updateCliente(@PathVariable String dni, @RequestBody UpdateClienteResource resource) {
        if (!dni.equals(resource.dni())) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Cliente> cliente = clienteCommanService.update(UpdateClienteCommandFromResourceAssembler.toCommand(resource));
        return cliente.map(source -> ResponseEntity.ok(CreateClienteCommandFromResourceAssembler.toClienteResource(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
