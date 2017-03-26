package infrastructure.repository.user;

import domain.entity.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by ShchykalauM on 21.02.2017.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Modifying
    @Query("DELETE FROM Role r WHERE r.user.id = :id")
    void deleteRolesByUserId(@Param("id") Long id);

}
