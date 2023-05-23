package br.com.IgorAssis.OldEra.OldEra.Repository;

import br.com.IgorAssis.OldEra.OldEra.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}