package upc.efinance.reportes.domain.model.aggregates;


import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import upc.efinance.reportes.domain.model.commands.CreateReporteCommand;
import upc.efinance.reportes.domain.model.commands.UpdateReporteCommand;

import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Reporte extends AbstractAggregateRoot<Reporte> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long idReporte;

    @Column
    @Getter
    private String dniCliente;

    @Column(nullable = false)
    @Getter
    private LocalDate fechaReporte;

    @Column(nullable = false)
    @Getter
    private float montoTotal;

    @Column(nullable = false)
    @Getter
    private int documentosPagados;

    @Column(nullable = false)
    @Getter
    private int documentosPendientes;

    @Column(nullable = false)
    @Getter
    private int documentosVencidos;

    @Column(nullable = false)
    @Getter
    private  int numeroCarteras;


    protected Reporte() {
        this.dniCliente = null;
        this.fechaReporte = LocalDate.now();
        this.montoTotal=0;
        this.documentosPagados = 0;
        this.documentosPendientes = 0;
        this.documentosVencidos = 0;
        this.numeroCarteras = 0;

    }

    public Reporte (CreateReporteCommand command){
        this.dniCliente=command.dniCliente();
        this.fechaReporte = command.fechaReporte();
        this.montoTotal = command.montoTotal();
        this.documentosPagados = command.documentosPagados();
        this.documentosPendientes= command.documentosPendientes();
        this.documentosVencidos = command.documentosVencidos();
        this.numeroCarteras=command.numeroCarteras();
    }

    public void update(UpdateReporteCommand command) {
        this.dniCliente = command.dniCliente();
        this.fechaReporte = command.fechaReporte();
        this.montoTotal = command.montoTotal();
        this.documentosPagados = command.documentosPagados();
        this.documentosPendientes = command.documentosPendientes();
        this.documentosVencidos = command.documentosVencidos();
        this.numeroCarteras = command.numeroCarteras();
    }

}
