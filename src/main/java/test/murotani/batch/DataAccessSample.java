package test.murotani.batch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
 
@Component
public class DataAccessSample {
	private static final Logger logger = Logger.getLogger(DataAccessSample.class);
	private static final String SPRING_CONFIG_FILE = "mainContextConfig.xml";
	
	public static void main(String[] args) {
		//logs debug message
		if(logger.isDebugEnabled()){
			logger.debug("getWelcome is executed!");
		}
 
		//logs exception
		logger.error("This is Error message", new Exception("Testing"));
		
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(SPRING_CONFIG_FILE);
		
		DataAccessSample das = applicationContext.getBean(DataAccessSample.class);
		das.execute();
		
	}
    
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Transactional
	public void execute() {
		// do some work
		System.out.println("aaaaaaaaa");
		
		//	users count
		Object rc = this.jdbcTemplate.queryForObject("select count(*) from partyalbum.users", Integer.class);
		System.out.println("users count: " + rc.toString());
		
		// settings passwords
		//Object password = this.jdbcTemplate.queryForObject("SELECT password FROM users WHERE username = ?",new Object[]{"miyamoto"},String.class);
		//System.out.println("password = " + password);
		
		
		// using mapper
		String sql = "SELECT * FROM users where username = 'miyamoto'";
		User user = this.jdbcTemplate.queryForObject(sql, new RowMapper<User>() {	 // mapperくらす
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
			    user.setUserName(rs.getString("username"));
			    user.setPassword(rs.getString("password"));
			    return user;
			}
		});
		System.out.println("user = " + user.getUserName() + " , pass = " + user.getPassword());
		
		 }
	
}