package br.com.camilaferreiranas.reserva;

import br.com.camilaferreiranas.cliente.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserva extends PanacheEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    public Cliente cliente;
}
