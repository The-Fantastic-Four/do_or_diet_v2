/**
 * RecipeRepository keeps a list of recipes
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 */
package is.hi.hbv.do_or_diet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import is.hi.hbv.do_or_diet.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAll();
    
    Recipe save(Recipe recipe);
	
	/*public static List<Recipe> getRecipes() 
	{
		EntityManager entityManager = SessionFactory.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Recipe> recipes = entityManager.createQuery("from Recipe", Recipe.class).getResultList();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return recipes;
	}*/

	/**
	 * Add a new recipe to the repository
	 * @param r the recipe to be added
	 */
	/*public static void addRecipes(Recipe r) 
	{
		
		//recipes.add(r);
	}*/
	
	/**
	 * Reset the recipe list and add a few default recipes
	 */
	/* TODO: DELETE
	public static void resetRecipes()
	{
		Recipe r1 = new Recipe(0, "Tikka masala", null, null, 2, null);
		Recipe r2 = new Recipe(1, "Pasta", null, null, 2, null);
		Recipe r3 = new Recipe(2, "Bananar", null, null, 2, null);
		Recipe r4 = new Recipe(3, "Bakaðar kartöflur", null, null, 2, null);
		
		recipes = new ArrayList<Recipe>(Arrays.asList(r1, r2, r3, r4));
	}*/
	
	/*public static void test()
	{
		EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("is.hi.hbv.do_or_diet.jpa");
		EntityManager entityManager = sessionFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<IngredientType> ingredientTypes = entityManager.createQuery("from IngredientType", IngredientType.class).getResultList();
		for (IngredientType type : ingredientTypes)
		{
			System.out.println("IngredientType: " + type);
		}
		entityManager.getTransaction().commit();
		entityManager.close();
	}*/
}
