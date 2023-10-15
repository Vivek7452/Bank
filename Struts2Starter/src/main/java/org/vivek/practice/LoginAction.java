package org.vivek.practice;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginAction extends ActionSupport{
    private String username;
    private String password;
    private int balance = 0;

	public String execute(){

    	String ret=ERROR;
    	Connection con=null;
	    	
		try{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/strutsDb","postgres","postgres");
			PreparedStatement st= con.prepareStatement("select * from Customer where username=? and password=?");
			st.setString(1,username);
			st.setString(2,password);
			ResultSet rs=st.executeQuery();
			rs.next();
			username=rs.getString(3);
			password=rs.getString(4);
		
			
			
			String query = "SELECT balance FROM Customer WHERE username = ?";
			PreparedStatement statement = null;
			statement = con.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                balance = resultSet.getInt("balance");
            }

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
    // Getters and setters

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
	
    public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}