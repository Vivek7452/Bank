package org.vivek.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class DepositAction  extends ActionSupport {

    private String password;
    private int balance;
    private int currentBal=-1;

	public String execute(){
		String ret=ERROR;
    	Connection con=null;
	    	
		try{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/strutsDb","postgres","postgres");
			String query = "SELECT balance FROM Customer WHERE password = ?";
			PreparedStatement statement = null;
			statement = con.prepareStatement(query);
            statement.setString(1, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                currentBal = resultSet.getInt("balance");
            }
            balance=currentBal+balance;
            
            String query2="update Customer set balance=? where password=?;";
            PreparedStatement stmt = null;
            stmt = con.prepareStatement(query2);
            stmt.setInt(1, balance);
            stmt.setString(2, password);
            stmt.executeUpdate();
            
            ret=SUCCESS;
            if(currentBal==-1)ret=ERROR;
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

    
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}