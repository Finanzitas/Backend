package upc.efinance.clientes.domain.model.aggregates;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import upc.efinance.clientes.domain.model.commands.CreateClienteCommand;
import upc.efinance.clientes.domain.model.commands.UpdateClienteCommand;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Cliente extends AbstractAggregateRoot<Cliente> {

    @Id
    @Getter
    private String dni;

    @Column
    @Getter
    private String clave;

    @Column
    @Getter
    private String nombre;

    @Column
    @Getter
    private String direccion;

    @Column
    @Getter
    private String correo;

    protected Cliente() {
        this.dni = null;
        this.clave = null;
        this.nombre = null;
        this.direccion = null;
        this.correo = null;
    }

    public Cliente(CreateClienteCommand command){
        this.dni = command.dni();
        this.clave = command.clave();
        this.nombre = command.nombre();
        this.direccion = command.direccion();
        this.correo = command.corre();
    }

    public void updateData(UpdateClienteCommand command) {
        this.clave = command.clave();
        this.nombre = command.nombre();
        this.direccion = command.direccion();
        this.correo = command.correo();
    }
}


