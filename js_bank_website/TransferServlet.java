/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: December 1, 2011													  *
*******************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.Border;
import java.io.*;
import javax.servlet.*;  //package for GenericServlet
import javax.servlet.http.*;  //package for HttpServlet
import java.util.*;

public class TransferServlet extends HttpServlet

{
   private String[] account1;
   private String[] account2;
   private String type;
   private PrintWriter output;
   private String Username;
   private String amount;
   private Boolean Success, Success2;

//a method called automatically to initialize the servlet
   public void init( ServletConfig config )
      throws ServletException
   {
      super.init( config );
      Username = "";
      amount= "";
      account1 = new String[]{""};
      account2 = new String[]{""};
   }

   //a method included in class HttpServlet to respond to post requests from a client.
   public void doGet ( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException
   {
	   doPost(req, res);
   }

   //a method included in class HttpServlet to respond to post requests from a client.
   public void doPost ( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException
   {
      //obtains a character-based output stream that enables text data to be sent to the client
      output = res.getWriter();

      //specifies the MIME type of the response to the browser
      res.setContentType( "text/html" );

      //returns the value associated with a parameter sent to the servlet as part of a post request
      Username = req.getParameter( "Username" );
      amount = req.getParameter( "transferAmountTextField");
      account1 = req.getParameterValues("FAccountList");
      account2 = req.getParameterValues("TAccountList");
      type="Transfer";

	if(account1[0].equals("Savings"))
  	{
		Saving_Account savingaccountbalance = new Saving_Account(Username, account1[0], account2[0], amount, type);
		Success = savingaccountbalance.transferfrom();
				transaction newtransaction = new transaction(Username, amount, type);
		                 newtransaction.s_saveTransaction();
		Checking_Account checkingaccountbalance = new Checking_Account(Username, account1[0], account2[0], amount, type);
		Success2 = checkingaccountbalance.transferto();
				transaction newtransaction2 = new transaction(Username, amount, type);
		                 newtransaction2.c_saveTransaction();
  	}
 	else if(account1[0].equals("Checking"))
	{
		Checking_Account checkingaccountbalance = new Checking_Account(Username, account1[0], account2[0], amount, type);
		Success = checkingaccountbalance.transferfrom();
				transaction newtransaction = new transaction(Username, amount, type);
		                 newtransaction.c_saveTransaction();
		Saving_Account savingaccountbalance = new Saving_Account(Username, account1[0], account2[0], amount, type);
				Success2 = savingaccountbalance.transferto();
				transaction newtransaction2 = new transaction(Username, amount, type);
		                 newtransaction2.s_saveTransaction();
	}

	if(Success)
		output.println("Amount has been transferred successfully.");
	else
		output.println("Transaction failed");
   }

   //this "cleanup" method is called when a servlet is terminated by the server
   public void destroy() {
       output.close();
   }
}