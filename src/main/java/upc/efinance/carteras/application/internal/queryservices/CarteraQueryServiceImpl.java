package upc.efinance.carteras.application.internal.queryservices;

import org.springframework.stereotype.Service;
import upc.efinance.carteras.domain.model.aggregates.Cartera;
import upc.efinance.carteras.domain.model.queries.GetCarteraByDniClienteQuery;
import upc.efinance.carteras.domain.model.queries.GetCarteraByIdCarteraQuery;
import upc.efinance.carteras.domain.services.CarteraQueryService;
import upc.efinance.carteras.infrastructure.persistence.jpa.CarteraRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarteraQueryServiceImpl implements CarteraQueryService {
    private final CarteraRepository carteraRepository;

    public CarteraQueryServiceImpl(CarteraRepository carteraRepository) {
        this.carteraRepository = carteraRepository;
    }

    @Override
    public Optional<Cartera> handle(GetCarteraByIdCarteraQuery query){
        return carteraRepository.findById(query.idCartera());
    }

    @Override
    public List<Cartera> handle(GetCarteraByDniClienteQuery query) {
        return carteraRepository.findByDniCliente(query.dniCliente());
    }

}
