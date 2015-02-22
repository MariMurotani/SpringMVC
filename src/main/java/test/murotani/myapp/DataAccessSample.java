package test.murotani.myapp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
 
@Component
public class DataAccessSample {
	private static final Logger logger = Logger.getLogger(DataAccessSample.class);
	private static final String SPRING_CONFIG_FILE = "classpath:applicationContext.xml";
	
	public static void main(String[] args) {
		//logs debug message
		if(logger.isDebugEnabled()){
			logger.debug("getWelcome is executed!");
		}
 
		//logs exception
		logger.error("This is Error message", new Exception("Testing"));
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(SPRING_CONFIG_FILE);
		
		try{
			DataAccessSample das = applicationContext.getBean(DataAccessSample.class);
			das.execute();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}catch(Error e){
			System.out.println(e.getMessage());
		}
		/*try (ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			DataAccessSample das = context.getBean(DataAccessSample.class);
			das.execute();
		}*/
	}
   
	@Autowired
	JdbcTemplate jdbcTemplate;
   
	@Transactional
	public void execute() {
		// do some work
		System.out.println("aaaaaaaaa");
	}
}