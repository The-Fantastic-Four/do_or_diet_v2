/**
 * RoleRepository keeps a list of roles
 * 
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 */
package is.hi.hbv.do_or_diet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import is.hi.hbv.do_or_diet.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>
{
	Role findByRole(String role);
}
