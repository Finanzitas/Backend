package upc.efinance.carteras.interfaces.rest.resources;

import java.time.LocalDate;

public record CarteraResource(
        String dniCliente,
        LocalDate fechaInicial,
        LocalDate fechaFinal,
        int diasTranscurridos,
        float interesGenerado,
        int numeroDocumentos,
        int documentosPagados,
        int docuemntosPendientes,
        String banco
) {
}
