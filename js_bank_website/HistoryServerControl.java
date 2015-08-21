/******************************************************************************
*	Program Author: Ahmed Neahal for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012													  *
*******************************************************************************/

import java.lang.*;  //including java packages used by this program
import java.awt.*;
import java.awt.event.*;  //for JOptionPane
import javax.swing.*;
import java.sql.*;
import java.util.Calendar;
import java.text.*;
import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.*;
import java.util.Vector;

public class HistoryServerControl
{
	private static ServerSocket server;
	private int port = 2020;
	private String Username;

public HistoryServerControl()
	{
		 try
		 {
		 	server = new ServerSocket(port);
		 }
		 catch (IOException e)
		 {
		            e.printStackTrace();
         }
	}

	public static void main(String [] args) throws IOException
	{
		HistoryServerControl ServerControl = new HistoryServerControl();

			// The server do a loop here to accept all connection initiated by the client application.
	        while (true)
	        {
	            try
	            {
	                Socket socket = server.accept();
	                new ConnectionHandler(socket);
	            }
	            catch (IOException e)
	            {
	                e.printStackTrace();
	            }
	        }
    }
}
class ConnectionHandler implements Runnable
{
    private Socket socket;

    public ConnectionHandler(Socket socket)
    {
        this.socket = socket;

        Thread t = new Thread(this);
        t.start();
    }

    public void run()
    {
		try
        {
            // Read a message sent by client application
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);
            String s_d=message.substring(0,10);
            String Username=message.substring(11);
            System.out.println("Searched date is: " + s_d);
            System.out.println("Username is: " + Username);

            transaction tr = new transaction(Username, s_d);
            Vector<Vector> VectorRecords = tr.GetHistory();
			// Send a response information to the client application
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(VectorRecords);

            ois.close();
            oos.close();
            socket.close();

            System.out.println("Waiting for client message...");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}