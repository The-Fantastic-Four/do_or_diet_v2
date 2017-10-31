package is.hi.hbv.do_or_diet.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ebba Þóra Hvannberg
 * @author Modified by: Eiður Örn Gunnarsson eog26@hi.is
 * @date 31. okt. 2017
 */
@Controller
public class InvalidURLController implements ErrorController
{
	private static final String PATH = "/error";
	
	@Autowired
	private ErrorAttributes errorAttributes;
	
	/**
	 * Responds to an invalid URL request
	 * 
	 * @param request the URL that is invalid
	 * @return response to the invalid URL
	 */
	@RequestMapping(value = PATH)
    public ModelAndView invalidURL(HttpServletRequest request) {
        return new ModelAndView("invalidURLPage", "attrs", getErrorAttributes(request, false));
    }
	
	/**
	 * Returns the PATH for the error
	 */
	@Override
    public String getErrorPath() {
        return PATH;
    } 
	
	/**
	 * Fetches the error attribute that came from the HTTP request
	 * 
	 * @param request the HTTP request
	 * @param includeStackTrace if true, returns stack trace. Otherwise it does not
	 * @return set containing the name and value of error attributes linked together.
	 */
	private Map<String, Object> getErrorAttributes(HttpServletRequest request,
			boolean includeStackTrace) {
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		return this.errorAttributes.getErrorAttributes(requestAttributes,
				includeStackTrace);
	}
}
