package upc.efinance.carteras.interfaces.rest;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.efinance.carteras.domain.model.aggregates.Cartera;
import upc.efinance.carteras.domain.model.commands.UpdateCarteraCommand;
import upc.efinance.carteras.domain.model.queries.GetCarteraByDniClienteQuery;
import upc.efinance.carteras.domain.model.queries.GetCarteraByIdCarteraQuery;
import upc.efinance.carteras.domain.services.CarteraCommandService;
import upc.efinance.carteras.domain.services.CarteraQueryService;
import upc.efinance.carteras.interfaces.rest.resources.CarteraResource;
import upc.efinance.carteras.interfaces.rest.resources.CreateCarteraResource;
import upc.efinance.carteras.interfaces.rest.transform.CarteraResourceFromEntityAssembler;
import upc.efinance.carteras.interfaces.rest.transform.CreateCarteraCommandFromResourceAssembler;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/E-Finance/Cartera")
public class CarteraController {
    private final CarteraQueryService carteraQueryService;
    private final CarteraCommandService carteraCommandService;

    public CarteraController(CarteraCommandService carteraCommandService, CarteraQueryService carteraQueryService) {
        this.carteraCommandService = carteraCommandService;
        this.carteraQueryService = carteraQueryService;
    }

    @PostMapping
    public ResponseEntity<CarteraResource> createCartera(@RequestBody CreateCarteraResource resource) {
        Optional<Cartera> cartera = carteraCommandService
                .handle(CreateCarteraCommandFromResourceAssembler.toCommandFromResource(resource));
        return cartera.map(source ->
                new ResponseEntity<>(CarteraResourceFromEntityAssembler.toCarteraResource(source),CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{idCartera}")
    public ResponseEntity<CarteraResource> getCartera(@PathVariable long idCartera) {
        Optional<Cartera> cartera = carteraQueryService.handle(new GetCarteraByIdCarteraQuery(idCartera));
        return cartera.map(source -> ResponseEntity.ok(CarteraResourceFromEntityAssembler.toCarteraResource(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{idCartera}")
    public ResponseEntity<Void> eliminarCartera(@PathVariable long idCartera) {
        carteraCommandService.eliminarCartera(idCartera);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{idCartera}")
    public ResponseEntity<CarteraResource> updateCartera(@PathVariable Long idCartera, @RequestBody UpdateCarteraCommand command) {
        // Crear un nuevo comando incluyendo el idCartera
        command = new UpdateCarteraCommand(
                idCartera, // Incluir idCartera aquí
                command.dniCliente(),
                command.fechaInicial(),
                command.fechaFinal(),
                command.diasTranscurridos(),
                command.interesGenerado(),
                command.numeroDocumentos(),
                command.documentosPagados(),
                command.documentosPendientes(),
                command.banco()
        );

        Optional<Cartera> cartera = carteraCommandService.updateCartera(command);
        return cartera.map(source -> ResponseEntity.ok(CarteraResourceFromEntityAssembler.toCarteraResource(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/dni/{dniCliente}")
    public ResponseEntity<List<CarteraResource>> getCarterasByDniCliente(@PathVariable String dniCliente) {
        List<Cartera> carteras = carteraQueryService.handle(new GetCarteraByDniClienteQuery(dniCliente));
        if (carteras.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<CarteraResource> resources = carteras.stream()
                .map(CarteraResourceFromEntityAssembler::toCarteraResource)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resources);
    }

}
