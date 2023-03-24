package br.com.IgorAssis.OldEra.OldEra.Repository;

import br.com.IgorAssis.OldEra.OldEra.Entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.nome LIKE %:nome%")
    List<Cliente> buscarClientesPorNome(@Param("nome") String nome);

    @Query(value = "SELECT COUNT(*) FROM cliente WHERE email = :email", nativeQuery = true)
    Integer contarClientesPorEmail(@Param("email") String email);
}
