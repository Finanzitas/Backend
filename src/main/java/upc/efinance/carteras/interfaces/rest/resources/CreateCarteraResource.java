package upc.efinance.carteras.interfaces.rest.resources;

import java.time.LocalDate;

public record CreateCarteraResource( String dniCliente,
                                     LocalDate fechaInicial,
                                     LocalDate fechaFinal,
                                     int diasTranscurridos,
                                     float interesGenerado,
                                     int numeroDocumentos,
                                     int documentosPagados,
                                     int docuemntosPendientes,
                                     String banco
) {
    public CreateCarteraResource {
        if (fechaInicial == null) {
            throw new IllegalArgumentException("fechaInicial");
        }
        if (fechaFinal == null) {
            throw new IllegalArgumentException("fechaFinal");
        }
        if (banco == null) {
            throw new IllegalArgumentException("banco");
        }
    }
}
