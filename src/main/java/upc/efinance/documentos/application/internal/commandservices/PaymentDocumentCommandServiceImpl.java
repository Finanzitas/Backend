package upc.efinance.documentos.application.internal.commandservices;

import upc.efinance.documentos.domain.model.aggregates.PaymentDocument;
import upc.efinance.documentos.domain.model.commands.CreatePaymentDocumentCommand;
import upc.efinance.documentos.domain.model.commands.UpdatePaymentDocumentCommand;
import upc.efinance.documentos.domain.services.PaymentDocumentCommanService;
import org.springframework.stereotype.Service;
import upc.efinance.documentos.infrastructure.persistence.jpa.PaymentDocumentRepository;

import java.util.Optional;

@Service
public class PaymentDocumentCommandServiceImpl implements PaymentDocumentCommanService {
    private final PaymentDocumentRepository paymentDocumentRepository;

    public PaymentDocumentCommandServiceImpl(PaymentDocumentRepository paymentDocumentRepository) {
        this.paymentDocumentRepository = paymentDocumentRepository;
    }

    @Override
    public Optional<PaymentDocument> handle(CreatePaymentDocumentCommand command) {
        var paymentDocument = new PaymentDocument(command);
        var createdPaymentDocument = paymentDocumentRepository.save(paymentDocument);
        return Optional.of(createdPaymentDocument);
    }

    @Override
    public Optional<PaymentDocument> update(UpdatePaymentDocumentCommand command) {

        return paymentDocumentRepository.findById(command.idDocumento()).map(existingDocument -> {
            // Actualizar los campos excepto el idDocumento
            existingDocument.setDniCliente(command.dniCliente());
            existingDocument.setIdCartera(command.idCartera());
            existingDocument.setTipoDocumento(command.tipoDocumento());
            existingDocument.setCapital(command.capital());
            existingDocument.setInteresGenerado(command.interesGenerado());
            existingDocument.setDivisa(command.divisa());
            existingDocument.setMontoFinal(command.montoFinal());
            existingDocument.setTasaEfectiva(command.tasaEfectiva());
            existingDocument.setFechaVencimiento(command.fechaVencimiento());
            existingDocument.setTasaDescuento(command.tasaDescuento());
            existingDocument.setMontoDescuento(command.montoDescuento());
            existingDocument.setDescripcion(command.descripcion());
            existingDocument.setEstado(command.estado());

            paymentDocumentRepository.save(existingDocument);
            return existingDocument;
        });
    }

    @Override
    public void deleteById(Long idDocumento) {  // Implementación del nuevo método
        paymentDocumentRepository.deleteById(idDocumento);
    }


}
