package upc.efinance.reportes.domain.model.commands;

import java.time.LocalDate;

public record UpdateReporteCommand(
        Long idReporte,
        String dniCliente,
        LocalDate fechaReporte,
        float montoTotal,
        int documentosPagados,
        int documentosPendientes,
        int documentosVencidos,
        int numeroCarteras) {

    public UpdateReporteCommand {
        if (numeroCarteras < 0){
            throw new IllegalArgumentException("Numero de carteras no puede ser menor que 0");
        }
    }
}
