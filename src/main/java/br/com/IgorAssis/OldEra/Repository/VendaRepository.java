package br.com.IgorAssis.OldEra.Repository;

import br.com.IgorAssis.OldEra.Entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
