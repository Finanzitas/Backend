package upc.efinance.carteras.domain.services;

import upc.efinance.carteras.domain.model.aggregates.Cartera;
import upc.efinance.carteras.domain.model.commands.CreateCarteraCommand;
import upc.efinance.carteras.domain.model.commands.UpdateCarteraCommand;

import java.util.Optional;

public interface CarteraCommandService {
    Optional<Cartera> handle(CreateCarteraCommand command);
    void eliminarCartera(Long idCartera);
    Optional<Cartera> updateCartera(UpdateCarteraCommand command);
}
