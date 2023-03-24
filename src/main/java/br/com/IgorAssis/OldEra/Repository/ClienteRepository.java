package br.com.IgorAssis.OldEra.Repository;

import br.com.IgorAssis.OldEra.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
