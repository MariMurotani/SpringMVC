package test.murotani.myapp;

import java.text.DateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.murotani.batch.DataAccessSample;


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
		
		model.addAttribute("serverTime", getFormattedDate(locale) );
		model.addAttribute("test","murotani");
	
		// DAO 呼び出しテスト
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("mainContextConfig.xml");
		DataAccessSample das = applicationContext.getBean(DataAccessSample.class);
		das.execute();
		
		
		
		//	Bipass the formatted request to WEB-INF/views/test/murtani.jsp
		return className + "/" + functionName;
	}
	
	private String getFormattedDate(Locale locale){
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		return formattedDate;
	} 
}
