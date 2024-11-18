package upc.efinance.reportes.interfaces.rest;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.efinance.reportes.domain.model.aggregates.Reporte;
import upc.efinance.reportes.domain.model.commands.UpdateReporteCommand;
import upc.efinance.reportes.domain.model.queries.GetReportesByIdReporteQuery;
import upc.efinance.reportes.domain.model.queries.GetReportesByDniClienteQuery;
import upc.efinance.reportes.domain.services.ReporteCommandService;
import upc.efinance.reportes.domain.services.ReporteQueryService;
import upc.efinance.reportes.interfaces.rest.resources.CreateReporteResource;
import upc.efinance.reportes.interfaces.rest.resources.ReporteResource;
import upc.efinance.reportes.interfaces.rest.transform.CreateReporteCommandFromResourceAssembler;
import upc.efinance.reportes.interfaces.rest.transform.ReporteResourceFromEntityAssembler;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/E-Finance/Reporte")
public class ReporteController {
    private final ReporteQueryService reporteQueryService;
    private final ReporteCommandService reporteCommandService;

    public ReporteController( ReporteCommandService reporteCommandService, ReporteQueryService reporteQueryService) {
        this.reporteQueryService = reporteQueryService;
        this.reporteCommandService = reporteCommandService;
    }

    @PostMapping
    public ResponseEntity<ReporteResource> createReporte(@RequestBody CreateReporteResource resource){
        Optional<Reporte> reporte = reporteCommandService
                .handle(CreateReporteCommandFromResourceAssembler.toCommandFromResource(resource));
        return reporte.map( source ->
                new ResponseEntity<>(ReporteResourceFromEntityAssembler.toResourceFromEntity(source),CREATED))
                .orElseGet( () -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{idReporte}")
    public ResponseEntity<?> getAllReporte(@PathVariable Long idReporte) {
        Optional<Reporte> reporte = reporteQueryService.handle(new GetReportesByIdReporteQuery(idReporte));
        return reporte.map(source ->
                ResponseEntity.ok(ReporteResourceFromEntityAssembler.toResourceFromEntity(source))
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }



    @PutMapping("{idReporte}")
    public ResponseEntity<ReporteResource> updateReporte(@PathVariable Long idReporte,
                                                         @RequestBody CreateReporteResource resource) {
        var updateCommand = new UpdateReporteCommand(
                idReporte,
                resource.dniClientes(),
                resource.fechaReporte(),
                resource.montoTotal(),
                resource.documentosPagados(),
                resource.documentosPendientes(),
                resource.documentosVencidos(),
                resource.numeroCarteras()
        );

        Optional<Reporte> updatedReporte = reporteCommandService.updateReporte(updateCommand);
        return updatedReporte.map(source ->
                        new ResponseEntity<>(ReporteResourceFromEntityAssembler.toResourceFromEntity(source), CREATED))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{dniCliente}")
    public ResponseEntity<List<ReporteResource>> getReportesByDniCliente(@PathVariable String dniCliente) {
        List<Reporte> reportes = reporteQueryService.handle(new GetReportesByDniClienteQuery(dniCliente));
        if (reportes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<ReporteResource> reporteResources = reportes.stream()
                .map(ReporteResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(reporteResources);
    }

    @DeleteMapping("{idReporte}")
    public ResponseEntity<Void> deleteReporte(@PathVariable Long idReporte) {
        reporteCommandService.deleteById(idReporte);
        return ResponseEntity.noContent().build();
    }
}
