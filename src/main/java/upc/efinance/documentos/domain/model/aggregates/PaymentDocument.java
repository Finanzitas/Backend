package upc.efinance.documentos.domain.model.aggregates;

import lombok.Setter;
import upc.efinance.documentos.domain.model.commands.CreatePaymentDocumentCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class PaymentDocument extends AbstractAggregateRoot<PaymentDocument> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long idDocumento;

    @Column(nullable = false)
    @Getter
    @Setter // Agregar Setter
    private String dniCliente;

    @Column(nullable = false)
    @Getter
    @Setter // Agregar Setter
    private Long idCartera;

    @Column(nullable = false)
    @Getter
    @Setter // Agregar Setter
    private String tipoDocumento;

    @Column(nullable = false)
    @Getter
    @Setter // Agregar Setter
    private float capital;

    @Column(nullable = false)
    @Getter
    @Setter // Agregar Setter
    private float interesGenerado;

    @Column(nullable = false)
    @Getter
    @Setter // Agregar Setter
    private String divisa;

    @Column(nullable = false)
    @Getter
    @Setter // Agregar Setter
    private float montoFinal;

    @Column(nullable = false)
    @Getter
    @Setter // Agregar Setter
    private float tasaEfectiva;


    @Column(nullable = false)
    @Getter
    @Setter
    private LocalDate fechaEmision;

    @Column(nullable = false, updatable = true)
    @Getter
    @Setter
    private LocalDate fechaVencimiento;

    @Column(nullable = false)
    @Getter
    @Setter
    private float tasaDescuento;

    @Column(nullable = false)
    @Getter
    @Setter
    private float montoDescuento;

    @Column(nullable = false)
    @Getter
    @Setter
    private String descripcion;

    @Column(nullable = false)
    @Getter
    @Setter
    private String estado;

    @Column(nullable = false)
    @Getter
    @Setter
    private String tipoInteres;

    // Constructor vacío
    protected PaymentDocument() {
        this.dniCliente = Strings.EMPTY;
        this.idCartera = 0L;
        this.divisa = Strings.EMPTY;
        this.tipoDocumento = Strings.EMPTY;
        this.capital = 0.0f;
        this.interesGenerado = 0.0f;
        this.montoFinal = 0.0f;
        this.tasaEfectiva = 0.0f;
        this.fechaEmision = LocalDate.now();
        this.fechaVencimiento = LocalDate.now();
        this.tasaDescuento = 0.0f;
        this.montoDescuento = 0.0f;
        this.descripcion = Strings.EMPTY;
        this.estado = Strings.EMPTY;
        this.tipoInteres = Strings.EMPTY;
    }

    // Constructor con comando
    public PaymentDocument(CreatePaymentDocumentCommand command) {
        this.dniCliente = command.dniCliente();
        this.idCartera = command.idCartera();
        this.divisa = command.divisa();
        this.tipoDocumento = command.tipoDocumento();
        this.capital = command.capital();
        this.interesGenerado = command.interesGenerado();
        this.montoFinal = command.montoFinal();
        this.tasaEfectiva = command.tasaEfectiva();
        this.fechaEmision = command.fechaEmision();
        this.fechaVencimiento = command.fechaVencimiento();
        this.tasaDescuento = command.tasaDescuento();
        this.descripcion = command.descripcion();
        this.estado = command.estado();
        this.tipoInteres=command.tipoInteres();
    }


}
