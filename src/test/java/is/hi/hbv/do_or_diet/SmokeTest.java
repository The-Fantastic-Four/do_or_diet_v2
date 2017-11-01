/**
 * SmokeTest tests if the welcome controller is initialized
 * 
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 * @date október 2017 HBV501G Hugbúnaðarverkefni 1
 */
package is.hi.hbv.do_or_diet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import is.hi.hbv.do_or_diet.controller.WelcomeController;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest
{
	@Autowired
	WelcomeController welcomeController;
	
	/**
	 * Method to check if WelcomeController has been created
	 */
	@Test
	public void contextLoads()
	{
		assertThat(welcomeController).isNotNull();
	}
}
