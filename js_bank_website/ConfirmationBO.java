/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: December 1, 2012													  *
*******************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ConfirmationPanel extends JPanel
{
	private String Username;

   public ConfirmationPanel(String UName)
   {  Username = UName;
      tabbedPane = new JTabbedPane(); //initialize a JTabbedPane object
      tabPanel_1 = new viewbalancePanel(Username);
      tabPanel_2 = new transferPanel(Username);
      tabPanel_3 = new depositPanel(Username);
      tabPanel_4 = new withdrawPanel(Username);
      tabPanel_5 = new historyPanel(Username);

      tabbedPane.addTab("View Balance", tabPanel_1); //add GUI components to Tabbed Pane
      tabbedPane.setSelectedIndex(0);
      tabbedPane.addTab("Transfer", tabPanel_2);
      tabbedPane.addTab("Deposit", tabPanel_3);
      tabbedPane.addTab("Withdraw", tabPanel_4);
      tabbedPane.addTab("Account History", tabPanel_5);
      add(tabbedPane);
   }

   private JTabbedPane tabbedPane;
   private JPanel tabPanel_1, tabPanel_2, tabPanel_3, tabPanel_4, tabPanel_5;

}


public class ConfirmationBO extends JFrame
   {
    private ConfirmationPanel C_Panel;

    public ConfirmationBO(String Username)

    	    {
	        setTitle("Account Logged in as "+Username);
	        setSize(500, 210);

	         //get screen size and set the location of the frame
	         Toolkit tk = Toolkit.getDefaultToolkit();
	         Dimension d = tk.getScreenSize();
	         int screenHeight = d.height;
	         int screenWidth = d.width;
	         setLocation( screenWidth / 3, screenHeight / 4);

	         addWindowListener (new WindowAdapter()  //handle window event
	            {
			       public void windowClosing (WindowEvent e)
				                  { System.exit(0);
	               }
	            });


	         Container contentPane = getContentPane(); //add a panel to a frame
	         C_Panel = new ConfirmationPanel(Username);
	         contentPane.add(C_Panel);
	         show();
    }


}