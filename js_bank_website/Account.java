/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: December 1, 2012													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import java.sql.*;

public class Account
{
	private String Username, Password, Password1;

	public Account(String UN, String PassW, String PassW1) {
		Username = UN;
		Password = PassW;
		Password1 = PassW1;
	}

	public Account(String UN, String PassW) {
		Username = UN;
		Password = PassW;
	}

    public boolean signUp() {
		boolean done = !Username.equals("") && !Password.equals("") && !Password1.equals("") && Password.equals(Password1);
		try {
		    if (done) {
		        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
		        Connection DBConn = ToDB.openConn();
		        Statement Stmt = DBConn.createStatement();
		        String SQL_Command = "SELECT Username FROM Customer WHERE Username ='"+Username+"'"; //SQL query command
		        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
		        done = done && !Rslt.next();
		        if (done) {
				    SQL_Command = "INSERT INTO Customer(Username, Password) VALUES ('"+Username+ "','"+Password+"')"; //Save the username and password
				    Stmt.executeUpdate(SQL_Command);
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
	    return done;
	}

    public boolean signIn() {
				boolean done = false;
				try {
					DBConnection ToDB = new DBConnection(); //Have a connection to the DB
					Connection DBConn = ToDB.openConn();
					Statement Stmt = DBConn.createStatement();
					String SQL_Command = "SELECT Username, Password FROM Customer WHERE Username ='"+Username+ "'AND Password ='"+Password+"'"; //SQL query command
					ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username and password exist/are correct.

						done = Rslt.next();
						Stmt.close();
						ToDB.closeConn();
			    }
				catch(java.sql.SQLException e)
		        {   done = false;
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
			    {     done = false;
					  System.out.println("Exception: " + e);
					  e.printStackTrace ();
				}

			    return done;

	}

	public boolean CheckLogIn(String Username,String Password)
	{
		boolean Success=false;

		try
		{
			DBConnection ToDB = new DBConnection(); //Have a connection to the DB
			Connection DBConn = ToDB.openConn();
			Statement Stmt = DBConn.createStatement();
			String SQL_Command = "SELECT Username, Password FROM Customer WHERE Username ='"+Username+ "'AND Password ='"+Password+"'";
			ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username and password exist/are correct.

									Success = Rslt.next();
									Stmt.close();
									ToDB.closeConn();
			    }
		catch(java.sql.SQLException e)
		{
			System.out.println("SQLException: " + e);
			while (e != null)
			 {
				 System.out.println("SQLState: " + e.getSQLState());
				 System.out.println("Message: " + e.getMessage());
				 System.out.println("Vendor: " + e.getErrorCode());
				 e = e.getNextException();
				 System.out.println("");
			 }
		}
		catch (java.lang.Exception e)
	    {
		   System.out.println("Exception: " + e);
		   e.printStackTrace ();
		}
		/*End of code added by Swetha on 23 Oct 2012*/
		return Success;
}
}