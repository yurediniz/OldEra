package br.com.IgorAssis.OldEra.Repository;

import br.com.IgorAssis.OldEra.Entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
