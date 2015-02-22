

import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
 
@Component
public class DataAccessSample {
   
	public static void main(String[] args) {
	
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
	}
}