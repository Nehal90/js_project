/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: December 1, 2011													  *
*******************************************************************************/

import java.awt.*;     //including Java packages used by this program
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.servlet.*;  //package for GenericServlet
import javax.servlet.http.*;  //package for HttpServlet
import java.util.*;

public class LoginServlet extends HttpServlet
{
   private String Username, Password;
   private Boolean Success;
   private PrintWriter output;


   //a method called automatically to initialize the servlet
   public void init( ServletConfig config )
      throws ServletException
   {
      super.init( config );
      Username = new String("");
      Password = new String("");
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
      Username = req.getParameter( "UserName" );
      Password = req.getParameter( "PassWord" );

	  //LoginControl LoginC = new LoginControl(Username, Password);
	  //LoginC.DisplaySuccess();

      Account Acct = new Account(Username,Password);
      Success = Acct.CheckLogIn(Username,Password);

      if (Success.equals("UsernameNotValid"))
           output.println("Invalid user name or password!");
      else
      {
		  showSuccess(Username);
  	  }
   }

   public void showSuccess(String Username)
   {
	    StringBuffer Buf = new StringBuffer();
		Buf.append("<HTML><HEAD></HEAD>\n");
		Buf.append("<BODY bgcolor='#F1F1FD'>\n");
		   Buf.append("<FORM NAME=\"LoginPage\" ACTION=\"/LoginSrvlet\" METHOD =\"POST\" ALIGN='center'>\n");

			   Buf.append("<A HREF='/JAVA/ViewBalance.jsp?Username="+Username+"' TARGET='display'>View Balance</A>\n");
			   Buf.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			   Buf.append("<A HREF='/JAVA/Transfer.jsp?Username="+Username+"' TARGET='display'>Transfer</A>\n");
			   Buf.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			   Buf.append("<A HREF='/JAVA/Deposit.jsp?Username="+Username+"' TARGET='display'>Deposit</A>\n");
			   Buf.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			   Buf.append("<A HREF='/JAVA/Withdraw.jsp?Username="+Username+"' TARGET='display'>Withdraw</A>\n");
			   Buf.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			   Buf.append("<A HREF='/JAVA/TransactionHistory.jsp?Username="+Username+"' TARGET='display'>History</A>");
		   Buf.append("</FORM>\n");
		Buf.append("</BODY>\n");
		Buf.append("</HTML>\n");
		output.println(Buf.toString());
   }

   //this "cleanup" method is called when a servlet is terminated by the server
   public void destroy() {
       output.close();
   }
}