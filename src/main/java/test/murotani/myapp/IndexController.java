package test.murotani.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 * http://localhost:8080/SpringMVC/
 */
@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private HttpServletRequest context;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","/{className}/{functionName}"}, method = RequestMethod.GET)
	public String home(@PathVariable String className, @PathVariable String functionName,Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		System.out.println(this.context.getRequestURI());
		System.out.println("className: " + className + "," + "functionName: "+ functionName);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//	Bipass the formatted request to WEB-INF/views/test/murtani.jsp
		return className + "/" + functionName;
	}
	
}
