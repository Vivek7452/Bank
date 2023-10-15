package org.vivek.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionSupport;

public class CreateAccountAction extends ActionSupport{
	 private String name;
	 private String username;
	 private String password;
	 private int number;

	    public String execute(){

	    	String ret=ERROR;
	    	Connection con=null;
		    	
			try{
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/strutsDb","postgres","postgres");
				PreparedStatement st= con.prepareStatement("insert into Customer (name,username,password,Mobile_number) values(?,?,?,?);");
				st.setString(1,name);
				st.setString(2,username);
				st.setString(3,password);
				st.setInt(4, number);
				st.executeUpdate();
				ret=SUCCESS;
			}
			catch(Exception e)
			{
				e.printStackTrace();
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}
}
