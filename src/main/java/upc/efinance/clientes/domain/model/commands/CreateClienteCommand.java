package upc.efinance.clientes.domain.model.commands;

public record CreateClienteCommand(
        String dni,
        String clave,
        String nombre,
        String direccion,
        String corre
) {
    public CreateClienteCommand {
        if (dni == null || dni.length() == 0 || direccion == null || direccion.length() == 0) {
            throw new IllegalArgumentException("No puede haber datos nulos");
        }
    }
}
