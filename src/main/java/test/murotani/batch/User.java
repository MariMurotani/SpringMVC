package test.murotani.batch;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	// setter / getter / toString等省略
	
	public String getUserName(){
		return this.username;
	}
	public void setUserName(String userName){
		this.username = userName;
	}
	
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String passWord){
		this.password = passWord;
	}
	
	
}