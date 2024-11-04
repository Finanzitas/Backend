package upc.efinance.documentos.domain.model.queries;

public record GetPaymentDocumentByIdDocumentoQuery(Long idDocument) {
    public GetPaymentDocumentByIdDocumentoQuery {
        if (idDocument == null || idDocument < 0)
            throw new IllegalArgumentException("idDocument cannot be null");
    }
}
