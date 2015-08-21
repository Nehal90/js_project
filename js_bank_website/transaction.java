/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: December 1, 2012													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;


public class transaction
{
	private String Username, amount, account, account1, account2, Balance, tempString, type,d_t, s_date,DateIDAsClientMsg,DateAsClientMsg, s_d;
	private int d, y, m, h, min, s;
	private GregorianCalendar C;
	private String txtFromAccountNo,txtToAccountNo,txtAction;
		private float Amount,fltBalance;
		private int intAccount_No;



public transaction(String UN, String s_dates) {
		Username = UN;
		s_d = s_dates;
	}

public transaction(String UN, String amt, String typ) {
		Username = UN;
		amount = amt;
		type=typ;

	}
public transaction(String UN, String AccTo, String AccFm, String amt, String typ) {
		Username = UN;
		account1=AccFm;
		account2 = AccTo;
		amount=amt;
		type=typ;
	}

public boolean c_saveTransaction() {


	C= new GregorianCalendar();
				d=C.get(Calendar.DATE);
				m=C.get(Calendar.MONTH);
				y=C.get(Calendar.YEAR);
				min=C.get(Calendar.MINUTE);
				h=C.get(Calendar.HOUR);
				s=C.get(Calendar.SECOND);

			String date= new String (String.valueOf(d));
			String month= new String (String.valueOf(m+1));
			String year= new String (String.valueOf(y));
			String hr= new String (String.valueOf(h));
			String mins= new String (String.valueOf(min));
			String sec= new String (String.valueOf(s));

		d_t=(month + "/" + date + "/" + year + "  " + hr + ":" + mins + ":" + sec);


				boolean done = !Username.equals("") && !amount.equals("");
				try {
				    if (done) {
				        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				        Connection DBConn = ToDB.openConn();
				        Statement Stmt = DBConn.createStatement();
				        String SQL_Command = "SELECT Account_No FROM Checking_Account WHERE Username ='"+Username+"'";
				        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				        int acc_no=0;

				        while(Rslt.next())
           			{
						acc_no = Rslt.getInt(1);
				    }
           				float newbalance = Float.parseFloat(amount);
				        String SQL_Command2 = "INSERT INTO Transaction(Amount, Type, TimeandDate, Username, Account_No) VALUES("+amount+",'"+type+"','"+d_t+"','"+Username+"',"+acc_no+") "; //SQL query command
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
public boolean s_saveTransaction() {


	C= new GregorianCalendar();
				d=C.get(Calendar.DATE);
				m=C.get(Calendar.MONTH);
				y=C.get(Calendar.YEAR);
				min=C.get(Calendar.MINUTE);
				h=C.get(Calendar.HOUR);
				s=C.get(Calendar.SECOND);

			String date= new String (String.valueOf(d));
			String month= new String (String.valueOf(m));
			String year= new String (String.valueOf(y));
			String hr= new String (String.valueOf(h));
			String mins= new String (String.valueOf(min));
			String sec= new String (String.valueOf(s));


				boolean done = !Username.equals("") && !amount.equals("");
				try {
				    if (done) {
				        DBConnection ToDB = new DBConnection(); //Have a connection to the DB
				        Connection DBConn = ToDB.openConn();
				        Statement Stmt = DBConn.createStatement();
				        String SQL_Command = "SELECT Account_No FROM Saving_Account WHERE Username ='"+Username+"'";
				        ResultSet Rslt = Stmt.executeQuery(SQL_Command); //Inquire if the username exsits.
				        int acc_no=0;

				        while(Rslt.next())
           			{
						acc_no = Rslt.getInt(1);
				    }
           				float newbalance = Float.parseFloat(amount);
				        String SQL_Command2 = "INSERT INTO Transaction(Username,  Account_No, Amount, Type, TimeandDate) VALUES('"+Username+"',"+acc_no+","+amount+",'"+type+"','"+d_t+"') "; //SQL query command
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

public transaction(String ClientMsg)
	 {
		 DateIDAsClientMsg = ClientMsg;


		 String[] parts = DateIDAsClientMsg.split(":", 2);
		 DateAsClientMsg = parts[0];


  	 }

public Vector GetHistory()
	{
		 boolean done,Success=false;
		 String TableData="";



		 Vector<Vector> table = new Vector<Vector>();
		 try
		 {
				DBConnection ToDB = new DBConnection();
				Connection DBConn = ToDB.openConn();
				Statement Stmt = DBConn.createStatement();

					System.out.println(Username);
					System.out.println(s_d);
					String SQL_Command = "SELECT TransactionID as 'TID', Account_No as 'A/C No', Amount as 'Amount',Type as 'Type', TimeandDate as 'Date and Time' FROM Transaction  WHERE Username ='"+Username+"' AND TimeandDate LIKE '"+s_d+"%'";
					ResultSet Rslt = Stmt.executeQuery(SQL_Command);

					ResultSetMetaData rsmd = Rslt.getMetaData();
					Vector<String> labels = new Vector<String>();
					Vector<Object> rows = new Vector<Object>();
					Vector<Vector> rowsAll = new Vector<Vector>();
					int cols = rsmd.getColumnCount();

					for(int i=0;i<cols;i++)
											{
							labels.addElement(rsmd.getColumnLabel(i+1));
					}
					while(Rslt.next())
					{
						System.out.println("Going to add a row");
						rows.add(getNextRow(Rslt,rsmd));
					}

					table.addElement(labels);
					System.out.println("Size of the row is: " +rows.size());
					table.addElement(rows);

				Stmt.close();
				ToDB.closeConn();
			}
			catch(java.sql.SQLException e)
			{
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
			{
				 System.out.println("Exception: " + e);
				 e.printStackTrace ();
			}
		return table;
	}

	public Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException
		 {
		     Vector currentRow = new Vector();

		     for(int i=1;i<=rsmd.getColumnCount();i++)
		         switch(rsmd.getColumnType(i))
		         {
		              case Types.VARCHAR:
		              case Types.LONGVARCHAR:
		                   currentRow.addElement(rs.getString(i));
		                   break;
		              case Types.INTEGER:
		                   currentRow.addElement(new Long(rs.getLong(i)));
		                   break;
		              case Types.DOUBLE:
		              	   currentRow.addElement(new Double(rs.getDouble(i)));
		                   break;
		              case Types.FLOAT:
		              	   currentRow.addElement(new Float(rs.getFloat(i)));
		                   break;
		              case Types.DECIMAL:
					  	   currentRow.addElement(new Float(rs.getFloat(i)));
		                   break;
		              default:
		                   System.out.println("Type was: "+ rsmd.getColumnTypeName(i));
		          }

		          return currentRow;
    }

	public static void main(String [] args)
	{
		//JFrame frame = new ConfirmationBO();
		//frame.show();
	}
}
