package is.hi.hbv.do_or_diet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import is.hi.hbv.do_or_diet.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>
{
	Role findByRole(String role);
}