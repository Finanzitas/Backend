package upc.efinance.carteras.domain.services;

import upc.efinance.carteras.domain.model.aggregates.Cartera;
import upc.efinance.carteras.domain.model.queries.GetCarteraByDniClienteQuery;
import upc.efinance.carteras.domain.model.queries.GetCarteraByIdCarteraQuery;

import java.util.List;
import java.util.Optional;

public interface CarteraQueryService {
    Optional<Cartera> handle(GetCarteraByIdCarteraQuery query);
    List<Cartera> handle(GetCarteraByDniClienteQuery query);
}
