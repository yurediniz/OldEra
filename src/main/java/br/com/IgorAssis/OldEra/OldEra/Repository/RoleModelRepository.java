package br.com.IgorAssis.OldEra.OldEra.Repository;

import br.com.IgorAssis.OldEra.OldEra.Entity.RoleModel;
import br.com.IgorAssis.OldEra.OldEra.Enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleModelRepository extends JpaRepository<RoleModel, Long> {
    public List<RoleModel> findByRoleNameIn(List<RoleName> roles);
}
