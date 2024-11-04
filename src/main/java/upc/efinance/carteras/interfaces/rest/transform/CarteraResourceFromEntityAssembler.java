package upc.efinance.carteras.interfaces.rest.transform;

import upc.efinance.carteras.domain.model.aggregates.Cartera;
import upc.efinance.carteras.interfaces.rest.resources.CarteraResource;

import java.time.LocalDate;
public class CarteraResourceFromEntityAssembler {
    public static CarteraResource toCarteraResource(Cartera entity) {
        return new CarteraResource(
                entity.getDniCliente(),
                entity.getFechaInicial(),
                entity.getFechaFinal(),
                entity.getDiasTranscurridos(),
                entity.getInteresGenerado(),
                entity.getNumeroDocumentos(),
                entity.getDocumentosPagados(),
                entity.getDocumentosPendientes(),
                entity.getBanco()
        );
    }
}
