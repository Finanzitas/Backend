package upc.efinance.carteras.domain.model.queries;

public record GetCarteraByIdCarteraQuery(Long idCartera) {
    public GetCarteraByIdCarteraQuery {
        if (idCartera == null || idCartera < 0) {
            throw new IllegalArgumentException("Id cartera no puede ser nulo");
        }
    }
}
