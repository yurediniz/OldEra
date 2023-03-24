package br.com.IgorAssis.OldEra.OldEra.Repository;

import br.com.IgorAssis.OldEra.OldEra.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
