package org.vivek.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport{
	 private String password;
	public String execute(){
		String ret=ERROR;
    	Connection con=null;
	    	
		try{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/strutsDb","postgres","postgres");
			String query = "delete from Customer where password=?";
			PreparedStatement statement = null;
			statement = con.prepareStatement(query);
            statement.setString(1, password);
            statement.executeUpdate();
            ret=SUCCESS;
		}
		catch(Exception e)
		{
			ret=ERROR;
		}
		finally 
		{
			if(con!=null) 
			try{
				con.close();
			}catch(Exception e){
				
			}
		}
	  return ret;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
