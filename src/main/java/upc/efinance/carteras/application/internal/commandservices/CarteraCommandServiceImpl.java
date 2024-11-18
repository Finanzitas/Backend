package upc.efinance.carteras.application.internal.commandservices;

import upc.efinance.carteras.domain.model.aggregates.Cartera;
import upc.efinance.carteras.domain.model.commands.CreateCarteraCommand;
import upc.efinance.carteras.domain.model.commands.UpdateCarteraCommand;
import upc.efinance.carteras.domain.services.CarteraCommandService;
import upc.efinance.carteras.infrastructure.persistence.jpa.CarteraRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarteraCommandServiceImpl implements CarteraCommandService {
    private final CarteraRepository carteraRepository;

    public CarteraCommandServiceImpl(CarteraRepository carteraRepository) {
        this.carteraRepository = carteraRepository;
    }

    @Override
    public Optional<Cartera> handle(CreateCarteraCommand command) {
        var cartera = new Cartera(command);
        var createdCartera = carteraRepository.save(cartera);
        return Optional.of(createdCartera);
    }

    @Override
    public void eliminarCartera(Long idCartera) {
        carteraRepository.deleteById(idCartera);
    }

    @Override
    public Optional<Cartera> updateCartera(UpdateCarteraCommand command) {
        return carteraRepository.findById(command.idCartera()).map(cartera -> {
            cartera.setDniCliente(command.dniCliente());
            cartera.setNombreCartera(command.nombreCartera());
            cartera.setFechaInicial(command.fechaInicial());
            cartera.setFechaFinal(command.fechaFinal());
            cartera.setDiasTranscurridos(command.diasTranscurridos());
            cartera.setInteresGenerado(command.interesGenerado());
            cartera.setNumeroDocumentos(command.numeroDocumentos());
            cartera.setDocumentosPagados(command.documentosPagados());
            cartera.setDocumentosPendientes(command.documentosPendientes());
            cartera.setBanco(command.banco());
            return carteraRepository.save(cartera);
        });
    }

}
