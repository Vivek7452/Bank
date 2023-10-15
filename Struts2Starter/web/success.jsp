<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="/struts-tags" prefix="s"  %>
<html>
<head>
 <link rel="stylesheet" href="css/successfile.css">
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
    <header class="header">
        <div class="logo">
            <img src="./OT.jpg" alt="Bank Logo"> 
            <h1>OpenText Bank</h1>
        </div>
        <nav class="nav-links">
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">Accounts</a></li>
                <li><a href="#">Transactions</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
        </nav>
        <div class="user-info">
            <span>Welcome, <s:property value="username"/></span>
            <a class="button" id="btn" href="index.jsp">Logout</a>
        </div>
    </header>
    <div class="content">
      <h1>Account Balance: <s:property value="balance"/></h1>
      
        <button style="width:300px;display:inline"  id="showInputBtn">Deposit Money</button>
        <form action="deposit" method="post">
	    <div id="inputContainer" class="hidden">
	        <input style="width:270px; display:inline" type="text" id="inputBox" name="balance" placeholder="Enter Amount">
	        <input style="width:270px; display:inline" type="password" id="inputBox" name="password" placeholder="PIN">
	 		<input style="width:300px; background-color:green" id="btn" type="submit" value="Deposit Money">
	    </div>
	   </form>
	   
	    <button style="width:300px;display:inline"  id="showInputBtn2">Debit Money</button>
	    <form action="debit" method="post">
	    <div id="inputContainer2" class="hidden">
	        <input style="width:270px; display:inline" type="text" id="inputBox" name="balance" placeholder="Enter Amount">
	        <input style="width:270px; display:inline" type="password" id="inputBox" name="password" placeholder="PIN">
	 		<input style="width:300px; background-color:green" id="btn" type="submit" value="Debit Money">
	    </div>
	   </form>
	    
	    <button style="width:300px;display:inline"  id="showInputBtn3">Delete Account</button>
	    <form action="delete" method="post">
	     <div id="inputContainer3" class="hidden">
	        <input style="width:270px; display:inline" type="password" id="inputBox" name="password" placeholder="PIN">
	 		<input style="width:300px; background-color:green" id="btn" type="submit" value="Delete">
	    </div>
	    </form>
	    
	    <button style="width:300px;display:inline"  id="showInputBtn4">Transfer Money</button>
	    <form action="transfer" method="post">
	     <div id="inputContainer4" class="hidden">
	     	<input style="width:270px; display:inline" type="text" id="inputBox" name="Account_number" placeholder="Account Number">
	        <input style="width:270px; display:inline" type="text" id="inputBox" name="balance" placeholder="Amount">
	        <input style="width:270px; display:inline" type="password" id="inputBox" name="password" placeholder="Your PIN">
	 		<input style="width:300px; background-color:green" id="btn" type="submit" value="Send Money">
	    </div>
	    </form>
    </div>
  
    <footer class="footer">
       <div class="footer-content">
           <div class="footer-logo">
               <img src="./OT.jpg" alt="Bank Logo">
               <h2>OpenText</h2>
           </div>
           <div class="footer-links">
               <ul>
                   <li><a href="#">Privacy Policy</a></li>
                   <li><a href="#">Terms of Use</a></li>
                   <li><a href="#">Contact Us</a></li>
               </ul>
           </div>
       </div>
       <div class="footer-bottom">
           <p>&copy; 2023 BankingApp. All rights reserved.</p>
       </div>
   </footer>
  <script src="js/script.js"></script>
</body>
</html>