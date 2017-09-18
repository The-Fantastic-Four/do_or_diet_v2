package is.hi.hbv.do_or_diet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class DoOrDietApplication extends SpringBootServletInitializer {
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(DoOrDietApplication.class);
    }
    
	public static void main(String[] args) {
		SpringApplication.run(DoOrDietApplication.class, args);
	}
}
