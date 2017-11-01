package is.hi.hbv.do_or_diet;

import is.hi.hbv.do_or_diet.configuration.SecurityConfiguration;
import is.hi.hbv.do_or_diet.configuration.WebMvcConfig;
import is.hi.hbv.do_or_diet.controller.WelcomeController;

import static javax.management.Query.value;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.containsString;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
