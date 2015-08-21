/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: December 1, 2012													  *
*******************************************************************************/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.Date;
import java.util.Calendar;
import java.text.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.*;
import javax.swing.table.TableColumnModel;
import java.io.*;
import javax.servlet.*;  //package for GenericServlet
import javax.servlet.http.*;  //package for HttpServlet
import java.util.*;

public class TransactionHistoryServlet extends HttpServlet
{
   private PrintWriter output;
   private String Username;
   private String[] s_d;
   private Boolean Success;

   //a method called automatically to initialize the servlet
   public void init( ServletConfig config )
      throws ServletException
   {
      super.init( config );
      Username = "";
      s_d = new String[] {""};
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
      s_d = req.getParameterValues( "TransactionDateTextField" );

      String message = s_d[0] + ":" + Username;

	  transaction Tr = new transaction(Username, s_d[0]);
      Vector<Vector> VectorRecords = Tr.GetHistory();

      Vector<String> labels = (Vector<String>)VectorRecords.get(0);
	  Vector<Vector> rows = (Vector)VectorRecords.get(1);

	if(rows.size()==0)
		output.println("There are no transactions on the entered date");
	else
		//output.println("form a table");
		req.getSession().setAttribute("Table1", rows);
        //res.sendRedirect("/Java/TransactionHistory.jsp?Username="+Username+"");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Java/History.jsp?Username="+Username+"");
        dispatcher.forward( req, res);
   }

   //this "cleanup" method is called when a servlet is terminated by the server
   public void destroy() {
       output.close();
   }
}