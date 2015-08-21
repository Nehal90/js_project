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

public class ViewBalanceServlet extends HttpServlet

{
   private String[] account;
   private String type;
   private PrintWriter output;
   private String Username;
   private String amount;
   private int acc_bal;

//a method called automatically to initialize the servlet
   public void init( ServletConfig config )
      throws ServletException
   {
      super.init( config );
      Username = "";
      account = new String[]{""};
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
      account = req.getParameterValues("AccountList");


	if(account[0].equals("Savings"))
  	{
		Saving_Account savingaccountbalance = new Saving_Account(Username, account[0]);
		acc_bal = savingaccountbalance.viewbalance();
	}
 	else
	{
		Checking_Account checkingaccountbalance = new Checking_Account(Username, account[0]);
		acc_bal = checkingaccountbalance.viewbalance();

	}

	req.getSession().setAttribute("Balance", acc_bal);
	            res.sendRedirect("/Java/ViewBalance.jsp?Username="+Username+"");

   }

   //this "cleanup" method is called when a servlet is terminated by the server
   public void destroy() {
       output.close();
   }
}