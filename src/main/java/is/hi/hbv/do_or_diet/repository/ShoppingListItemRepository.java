/**
 * ShoppingListItemRepository keeps a list of shopping list item
 * 
 * @author Viktor Alex Brynjarsson vab18@hi.is
 * @date October 2017
 */
package is.hi.hbv.do_or_diet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import is.hi.hbv.do_or_diet.model.ShoppingListItem;

public interface ShoppingListItemRepository extends JpaRepository<ShoppingListItem, Long>
{
	List<ShoppingListItem> findAll();

	ShoppingListItem findOne(Long id);

	// Suppressed as teacher had same warning and had not fixed it
	@SuppressWarnings("unchecked")
	ShoppingListItem save(ShoppingListItem m);

	List<ShoppingListItem> save(List<ShoppingListItem> items);
}
