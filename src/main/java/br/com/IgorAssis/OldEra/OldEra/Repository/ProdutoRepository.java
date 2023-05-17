package br.com.IgorAssis.OldEra.OldEra.Repository;

import br.com.IgorAssis.OldEra.OldEra.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.preco >= :minPreco AND p.preco <= :maxPreco")
    List<Produto> buscarProdutosPorPreco(@Param("minPreco") Double minPreco, @Param("maxPreco") Double maxPreco);

    @Query(value = "SELECT * FROM produto WHERE UPPER(nome) LIKE UPPER(CONCAT('%',:nome,'%'))", nativeQuery = true)
    List<Produto> buscarProdutosPorNome(@Param("nome") String nome);


}
