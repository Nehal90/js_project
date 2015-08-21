/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: December 1, 2012													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import java.sql.*;

public class Checking_Account
{
	private String Username, amount, account, account1, account2, Balance, tempString, type;

public Checking_Account(String UN, String acct) {
		Username = UN;
		account= acct;
	}

public Checking_Account(String UN, String acct, String amt, String typ) {
		Username = UN;
		account = acct;
		amount = amt;
		type=typ;

	}
public Checking_Account(String UN, String AccTo, String AccFm, String amt, String typ) {
		Username = UN;
		account1=AccFm;
		account2 = AccTo;
		amount=amt;
		type=typ;
	}

    public int viewbalance() {
		int balance=0;
		boolean done = !Username.equals("") && !account.equals("");
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Balance FROM Checking_Account WHERE Username ='"+Username+"'";
								        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.

								        while(Rslt.next())
				           			{
										balance = Rslt.getInt(1);
				    }

			    Stmt.close();
			    ToDB.closeConn();
			}
		}
	    catch(java.sql.SQLException e)
	    {         done = false;
				 System.out.println("SQLException: " + e);
				 while (e != null)
				 {   System.out.println("SQLState: " + e.getSQLState());
					 System.out.println("Message: " + e.getMessage());
					 System.out.println("Vendor: " + e.getErrorCode());
					 e = e.getNextException();
					 System.out.println("");
				 }
	    }
	    catch (java.lang.Exception e)
	    {         done = false;
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
	    }
	    return balance;

	    }

	    public boolean deposit() {

				boolean done = !Username.equals("") && !account.equals("") && !amount.equals("");
				try {
				    if (done) {
				        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				        Connection DBConn = ToDB.openConn();
				        Statement Stmt = DBConn.createStatement();
				        String SQL_Command = "SELECT Balance FROM Checking_Account WHERE Username ='"+Username+"'";
				        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				        int balance=0;
				        while(Rslt.next())
           			{
						balance = Rslt.getInt(1);
				    }
           				float newbalance = Float.parseFloat(amount);
				        float currbalance=balance+(newbalance);
				        String SQL_Command2 = "UPDATE Checking_Account SET Balance ="+currbalance+" WHERE Username ='"+Username+ "'"; //SQL query command
				        Stmt.executeUpdate(SQL_Command2);


					    Stmt.close();
					    ToDB.closeConn();
					}
				}
			    catch(java.sql.SQLException e)
			    {         done = false;
						 System.out.println("SQLException: " + e);
						 while (e != null)
						 {   System.out.println("SQLState: " + e.getSQLState());
							 System.out.println("Message: " + e.getMessage());
							 System.out.println("Vendor: " + e.getErrorCode());
							 e = e.getNextException();
							 System.out.println("");
						 }
			    }
			    catch (java.lang.Exception e)
			    {         done = false;
						 System.out.println("Exception: " + e);
						 e.printStackTrace ();
			    }
	    return done;
}

        public boolean withdraw() {


						boolean done = !Username.equals("") && !account.equals("") && !amount.equals("");
										try {
										    if (done) {
										        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
										        Connection DBConn = ToDB.openConn();
										        Statement Stmt = DBConn.createStatement();
										        String SQL_Command = "SELECT Balance FROM Checking_Account WHERE Username ='"+Username+"'";
										        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
										        int balance=0;
										        while(Rslt.next())
						           			{
												balance = Rslt.getInt(1);
										    }
						           				float newbalance = Float.parseFloat(amount);
										        float currbalance=balance-(newbalance);
										        String SQL_Command2 = "UPDATE Checking_Account SET Balance ="+currbalance+" WHERE Username ='"+Username+ "'"; //SQL query command
										        Stmt.executeUpdate(SQL_Command2);


											    Stmt.close();
					    						ToDB.closeConn();
							}
						}
					    catch(java.sql.SQLException e)
					    {         done = false;
								 System.out.println("SQLException: " + e);
								 while (e != null)
								 {   System.out.println("SQLState: " + e.getSQLState());
									 System.out.println("Message: " + e.getMessage());
									 System.out.println("Vendor: " + e.getErrorCode());
									 e = e.getNextException();
									 System.out.println("");
								 }
					    }
					    catch (java.lang.Exception e)
					    {         done = false;
								 System.out.println("Exception: " + e);
								 e.printStackTrace ();
					    }
			    return done;
		}

public boolean transferto() {

				boolean done = !Username.equals("") && !account1.equals("") && !account2.equals("") && !amount.equals("");
				try {
				    if (done) {
				        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				        Connection DBConn = ToDB.openConn();
				        Statement Stmt = DBConn.createStatement();
				        String SQL_Command = "SELECT Balance FROM Checking_Account WHERE Username ='"+Username+"'";
				        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				        int balance=0;
				        while(Rslt.next())
           			{
						balance = Rslt.getInt(1);
				    }
           				float newbalance = Float.parseFloat(amount);
				        float currbalance=balance+(newbalance);
				        String SQL_Command2 = "UPDATE Checking_Account SET Balance ="+currbalance+" WHERE Username ='"+Username+ "'"; //SQL query command
				        Stmt.executeUpdate(SQL_Command2);


					    Stmt.close();
					    ToDB.closeConn();
					}
				}
			    catch(java.sql.SQLException e)
			    {         done = false;
						 System.out.println("SQLException: " + e);
						 while (e != null)
						 {   System.out.println("SQLState: " + e.getSQLState());
							 System.out.println("Message: " + e.getMessage());
							 System.out.println("Vendor: " + e.getErrorCode());
							 e = e.getNextException();
							 System.out.println("");
						 }
			    }
			    catch (java.lang.Exception e)
			    {         done = false;
						 System.out.println("Exception: " + e);
						 e.printStackTrace ();
			    }
	    return done;
}

public boolean transferfrom() {


						boolean done = !Username.equals("") && !account1.equals("") && !account2.equals("") && !amount.equals("");
										try {
										    if (done) {
										        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
										        Connection DBConn = ToDB.openConn();
										        Statement Stmt = DBConn.createStatement();
										        String SQL_Command = "SELECT Balance FROM Checking_Account WHERE Username ='"+Username+"'";
										        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
										        int balance=0;
										        while(Rslt.next())
						           			{
												balance = Rslt.getInt(1);
										    }
						           				float newbalance = Float.parseFloat(amount);
										        float currbalance=balance-(newbalance);
										        String SQL_Command2 = "UPDATE Checking_Account SET Balance ="+currbalance+" WHERE Username ='"+Username+ "'"; //SQL query command
										        Stmt.executeUpdate(SQL_Command2);


											    Stmt.close();
					    						ToDB.closeConn();
							}
						}
					    catch(java.sql.SQLException e)
					    {         done = false;
								 System.out.println("SQLException: " + e);
								 while (e != null)
								 {   System.out.println("SQLState: " + e.getSQLState());
									 System.out.println("Message: " + e.getMessage());
									 System.out.println("Vendor: " + e.getErrorCode());
									 e = e.getNextException();
									 System.out.println("");
								 }
					    }
					    catch (java.lang.Exception e)
					    {         done = false;
								 System.out.println("Exception: " + e);
								 e.printStackTrace ();
					    }
			    return done;
		}

}


