/**
 * Class which contains the main function
 * 
 * @author Eiður Örn Gunnarsson eog26@hi.is
 *
 */
package is.hi.hbv.do_or_diet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class DoOrDietApplication extends SpringBootServletInitializer
{

	// This function was added for spring-boot-devtools to enable automatic rebuild
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder)
	{
		return applicationBuilder.sources(DoOrDietApplication.class);
	}

	// Main function, creates default recipes and meal plans
	public static void main(String[] args)
	{
		SpringApplication.run(DoOrDietApplication.class, args);
	}
}
