package upc.efinance.documentos.interfaces.rest;

import upc.efinance.documentos.domain.model.aggregates.PaymentDocument;
import upc.efinance.documentos.domain.model.queries.GetPaymentDocumentByIdDocumentoQuery;
import upc.efinance.documentos.domain.model.queries.GetPaymentDocumentsByDniClienteQuery;
import upc.efinance.documentos.domain.services.PaymentDocumentCommanService;
import upc.efinance.documentos.domain.services.PaymentDocumentQueryService;
import upc.efinance.documentos.interfaces.rest.resources.CreatePaymentDocumentResource;
import upc.efinance.documentos.interfaces.rest.resources.PaymentDocumentResource;
import upc.efinance.documentos.interfaces.rest.transform.CreatePaymentDocumentCommandFromResourceAssembler;
import upc.efinance.documentos.interfaces.rest.transform.PaymentDocumentResourceFromEntityAssembler;
import upc.efinance.documentos.interfaces.rest.transform.UpdatePaymentDocumentCommandFromResourceAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/E-Finance/PaymentDocument")
public class PaymentDocumentController {
    private final PaymentDocumentQueryService paymentDocumentQueryService;
    private final PaymentDocumentCommanService paymentDocumentCommanService;

    public PaymentDocumentController(PaymentDocumentCommanService paymentDocumentCommanService, PaymentDocumentQueryService paymentDocumentQueryService) {
        this.paymentDocumentCommanService = paymentDocumentCommanService;
        this.paymentDocumentQueryService = paymentDocumentQueryService;
    }

    @PostMapping
    public ResponseEntity<PaymentDocumentResource> createPaymentDocument(@RequestBody CreatePaymentDocumentResource resource) {
        Optional<PaymentDocument> paymentDocument = paymentDocumentCommanService
                .handle(CreatePaymentDocumentCommandFromResourceAssembler.toCommandFromResource(resource));
        return paymentDocument.map(source ->
                        new ResponseEntity<>(PaymentDocumentResourceFromEntityAssembler.toPaymentDocumentResource(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{idDocument}")
    public ResponseEntity<PaymentDocumentResource> getPaymentDocument(@PathVariable Long idDocument) {
        Optional<PaymentDocument> paymentDocument = paymentDocumentQueryService.handle(new GetPaymentDocumentByIdDocumentoQuery(idDocument));
        return paymentDocument.map(source ->
                        ResponseEntity.ok(PaymentDocumentResourceFromEntityAssembler.toPaymentDocumentResource(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/dni/{dniCliente}")
    public ResponseEntity<List<PaymentDocumentResource>> getPaymentDocumentsByDniCliente(@PathVariable String dniCliente) {
        List<PaymentDocument> paymentDocuments = paymentDocumentQueryService.handle(new GetPaymentDocumentsByDniClienteQuery(dniCliente));
        if (paymentDocuments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<PaymentDocumentResource> resources = paymentDocuments.stream()
                .map(PaymentDocumentResourceFromEntityAssembler::toPaymentDocumentResource)
                .toList();
        return ResponseEntity.ok(resources);
    }

    @PutMapping("{idDocument}")
    public ResponseEntity<PaymentDocumentResource> updatePaymentDocument(
            @PathVariable Long idDocument,
            @RequestBody CreatePaymentDocumentResource resource) {
        var command = UpdatePaymentDocumentCommandFromResourceAssembler.toCommandFromResource(idDocument, resource);
        Optional<PaymentDocument> updatedDocument = paymentDocumentCommanService.update(command);
        return updatedDocument.map(source ->
                        ResponseEntity.ok(PaymentDocumentResourceFromEntityAssembler.toPaymentDocumentResource(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{idDocument}")
    public ResponseEntity<Void> deletePaymentDocument(@PathVariable Long idDocument) {
        paymentDocumentCommanService.deleteById(idDocument);
        return ResponseEntity.noContent().build();
    }
}
