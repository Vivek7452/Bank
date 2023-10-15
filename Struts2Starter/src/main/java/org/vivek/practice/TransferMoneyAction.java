package org.vivek.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class TransferMoneyAction extends ActionSupport {

	private int Account_number;
    private String password;
    private int balance;
    private int PayeeBalance=-1;
    private int PayorBalance=-1;
    private boolean Accountfound=true; 
    


	public String execute(){
		String ret=ERROR;
    	Connection con=null;
	    	
		try{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/strutsDb","postgres","postgres");
			String query = "SELECT balance FROM Customer WHERE account_number = ?";
			PreparedStatement statement = null;
			statement = con.prepareStatement(query);
            statement.setInt(1, Account_number);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                PayeeBalance = resultSet.getInt("balance");
            }else {
            	Accountfound=false;
            }
      
            String query2="SELECT balance FROM Customer WHERE password = ?";
            PreparedStatement stmt = null;
            stmt = con.prepareStatement(query2);
            stmt.setString(1, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                PayorBalance = rs.getInt("balance");
            }
            
            if(balance>PayorBalance) {
            	return "overlimit";
            }else if(Accountfound==false){
            	return "accountnotfound";
            }else {
            	PayeeBalance=PayeeBalance+balance;
            	PayorBalance=PayorBalance-balance;
                balance=PayorBalance;
            }
            
            String query3="update Customer set balance=? where password=?;";
            PreparedStatement stamt = null;
            stamt = con.prepareStatement(query3);
            stamt.setInt(1, balance);
            stamt.setString(2, password);
            stamt.executeUpdate();
            
            
            String query4="update Customer set balance=? where account_number=?;";
            PreparedStatement stemt = null;
            stemt = con.prepareStatement(query4);
            stemt.setInt(1, PayeeBalance);
            stemt.setInt(2, Account_number);
            stemt.executeUpdate();
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



	public int getAccount_number() {
		return Account_number;
	}



	public void setAccount_number(int account_number) {
		Account_number = account_number;
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