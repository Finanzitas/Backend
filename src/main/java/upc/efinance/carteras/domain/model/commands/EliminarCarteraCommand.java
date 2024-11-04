package upc.efinance.carteras.domain.model.commands;

public record EliminarCarteraCommand(Long idCartera) {
    public EliminarCarteraCommand {
        if (idCartera == null || idCartera < 0) {
            throw new IllegalArgumentException("El ID de la cartera no puede ser nulo ni negativo");
        }
    }
}
