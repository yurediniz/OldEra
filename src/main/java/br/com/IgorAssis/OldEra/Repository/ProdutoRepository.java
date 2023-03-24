package br.com.IgorAssis.OldEra.Repository;

import br.com.IgorAssis.OldEra.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
