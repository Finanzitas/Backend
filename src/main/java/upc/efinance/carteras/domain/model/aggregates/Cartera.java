package upc.efinance.carteras.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import upc.efinance.carteras.domain.model.commands.CreateCarteraCommand;

import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Cartera extends AbstractAggregateRoot<Cartera> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCartera;

    @Column(nullable = false, updatable = true)
    @Getter
    @Setter
    private String nombreCartera;

    @Column(nullable = false, updatable = true)
    @Getter
    @Setter
    private String dniCliente;

    @Column(nullable = false, updatable = true)
    @Getter
    @Setter
    private LocalDate fechaInicial;

    @Column(nullable = false, updatable = true)
    @Getter
    @Setter
    private LocalDate fechaFinal;

    @Column
    @Getter
    @Setter
    private int diasTranscurridos;

    @Column
    @Getter
    @Setter
    private float interesGenerado;

    @Column
    @Getter
    @Setter
    private int numeroDocumentos;

    @Column
    @Getter
    @Setter
    private int documentosPagados;

    @Column
    @Getter
    @Setter
    private int documentosPendientes;

    @Column
    @Getter
    @Setter
    private String banco;


    //Constructor vacío
    protected Cartera() {
        this.dniCliente = "";
        this.nombreCartera="";
        this.fechaInicial = LocalDate.now();
        this.fechaFinal = LocalDate.now();
        this.diasTranscurridos = 0;
        this.interesGenerado = 0;
        this.numeroDocumentos = 0;
        this.documentosPagados = 0;
        this.documentosPendientes = 0;
        this.banco = "";
    }

    // Constructor con comando
    public Cartera(CreateCarteraCommand command) {
        this.dniCliente= command.dniCliente();
        this.nombreCartera=command.nombreCartera();
        this.fechaInicial = command.fechaInicial();
        this.fechaFinal = command.fechaFinal();
        this.diasTranscurridos = command.diasTranscurridos();
        this.interesGenerado = command.interesGenerado();
        this.numeroDocumentos = command.numeroDocumentos();
        this.documentosPagados = command.documentosPagados();
        this.documentosPendientes = command.documentosPendientes();
        this.banco = command.banco();
    }

}
