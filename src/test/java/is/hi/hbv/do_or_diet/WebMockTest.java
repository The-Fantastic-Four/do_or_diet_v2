/**
 * WebMockTest tests on the web layer and uses WebMvcTest
 * 
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 * @date október 2017 HBV501G Hugbúnaðarverkefni 1
 */
package is.hi.hbv.do_or_diet;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import is.hi.hbv.do_or_diet.controller.UserController;
import is.hi.hbv.do_or_diet.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class WebMockTest
{
	// Server is not initialized
	@Autowired
	private MockMvc mockMvc;

	// Mock user service
	@MockBean
	private UserService service;

	/**
	 * Tests that user registration returns success message on successful user
	 * registration.
	 * 
	 * @throws Exception
	 */
	@Test
	@WithMockUser(username = "test", password = "test", roles = "USER")
	public void registerMockUser() throws Exception
	{
		when(service.findUserByEmail("test@hi.is")).thenReturn(null);
		this.mockMvc
				.perform(post("/registration").param("username", "test").param("password", "1234").param("email",
						"test@hi.is"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(model().attribute("successMessage", "Skráning tókst"));
	}
}