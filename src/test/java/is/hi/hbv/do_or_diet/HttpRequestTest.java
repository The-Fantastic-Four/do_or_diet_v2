/**
 * HttpRequestTest sends a url to a test web client
 * 
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 * @date október 2017 HBV501G Hugbúnaðarverkefni 1
 */
package is.hi.hbv.do_or_diet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest
{
	// For random port
	@LocalServerPort
	private int port;
	
	// Client class for use in integration test, uses HTTP API
	@Autowired
	private TestRestTemplate restTemplate;
	
	/**
	 * Method that checks if sending HttpRequest returns a correct page
	 * 
	 * @throws java.lang.Exception
	 */
	@Test
	public void httpRequestTest() throws Exception
	{
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("Um okkur");
	}
}
