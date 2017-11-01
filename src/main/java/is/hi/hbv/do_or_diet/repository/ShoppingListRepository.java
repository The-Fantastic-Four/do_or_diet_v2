package is.hi.hbv.do_or_diet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import is.hi.hbv.do_or_diet.model.ShoppingList;
import is.hi.hbv.do_or_diet.model.User;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long>
{
	List<ShoppingList> findAll();
	
	List<ShoppingList> findByOwner(User owner);

	ShoppingList findOne(Long id);

	// Suppressed as teacher had same warning and had not fixed it
	@SuppressWarnings("unchecked")
	ShoppingList save(ShoppingList m);
}
