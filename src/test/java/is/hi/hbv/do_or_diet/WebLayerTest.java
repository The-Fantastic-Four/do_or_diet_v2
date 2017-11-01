/**
 * WebLayerTest tests on the weblayer and uses WebMvcTest
 * 
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 * @date október 2017 HBV501G Hugbúnaðarverkefni 1
 */
package is.hi.hbv.do_or_diet;

import is.hi.hbv.do_or_diet.controller.WelcomeController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.security.test.context.support.WithMockUser;

@RunWith(SpringRunner.class)
@WebMvcTest(WelcomeController.class)
public class WebLayerTest
{
	// Server is not initialized
	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * Method that checks if it works to send a HTTP request to the 
	 * WelcomeController and receive the index page.
	 */
	@Test
	@WithMockUser(username = "test", password = "test", roles = "USER")
	public void webLayerTest() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("welcome/index"));
	}
}
