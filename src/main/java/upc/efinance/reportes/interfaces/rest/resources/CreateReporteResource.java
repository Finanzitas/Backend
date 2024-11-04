package upc.efinance.reportes.interfaces.rest.resources;

import java.time.LocalDate;

public record CreateReporteResource(
                                    String dniClientes,
                                    LocalDate fechaReporte,
                                    float montoTotal,
                                    int documentosPagados,
                                    int documentosPendientes,
                                    int documentosVencidos,
                                    int numeroCarteras) {
public CreateReporteResource {

}
}
