/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: October 3, 2011													  *
*******************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.Border;

class viewbalancePanel extends JPanel
   implements ListSelectionListener
{
	private String Username;
   public viewbalancePanel(String Username)
   {
      selectedSwingComponentTextField = new JTextField(14);
      JLabel textFieldLabel = new JLabel("Account Balance: ");
      JPanel p1 = new JPanel();
      p1.add(textFieldLabel);
      p1.add(selectedSwingComponentTextField);
 //initializing a list
      swingComponentList = new JList( new String []
          {"Checking", "Savings"});

swingComponentList.setVisibleRowCount(2); //set the visible rows
      swingComponentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      JLabel listLabel = new JLabel("Account Type:");
      JPanel p2 = new JPanel();
      p2.add(listLabel);
      p2.add(swingComponentList);

      //declare and initialize a SCROLL PANE
      JScrollPane listScroll = new JScrollPane(swingComponentList);
      p2.add(listScroll);

         //declare and initialize a GridBagLayout object
         GridBagLayout gbl = new GridBagLayout();
         setLayout(gbl); //let the layout manager be GridBagLayout
         //declare and initialize a GridBagConstraints object
         GridBagConstraints gbc = new GridBagConstraints();

     //apply GridBagConstraints to a GUI component and add it to this panel
      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 100;
      gbc.weighty = 100;
      add(textFieldLabel, gbc, 0, 0, 1, 1);

      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 100;
      gbc.weighty = 100;
      add(selectedSwingComponentTextField, gbc, 1, 0, 1, 1);

      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 100;
      gbc.weighty = 100;
      add(listLabel, gbc, 0, 3, 1, 1);
     gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 100;
      gbc.weighty = 100;
      add(p2, gbc, 1, 1, 1, 4);
      Border raised = BorderFactory.createRaisedBevelBorder();
      setBorder(raised);
      swingComponentList.addListSelectionListener(this); //register an event listener
   }
   //overload method ADD with GridBagConstraints
   public void add(Component c, GridBagConstraints gbc,
                   int x, int y, int w, int h)
   {
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.gridwidth = w;
      gbc.gridheight = h;
      add(c, gbc);
   }



   //method for ListSelectionEvent handling
      public void valueChanged(ListSelectionEvent evt)
      {
         JList source = (JList)evt.getSource();
         String tempString = (String)source.getSelectedValue();

         ViewBalanceControl ViewBalanceC = new ViewBalanceControl(Username, tempString);

			 }

      private JTextField selectedSwingComponentTextField;
      private JList swingComponentList;
}

/*
class ListFrame extends JFrame
{
   public ListFrame()
   {
      setTitle("Account");
      setSize(360, 140);
      //get screen size and set the location of the frame
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension d = tk.getScreenSize();
      int screenHeight = d.height;
      int screenWidth = d.width;
      setLocation( screenWidth / 2 - 180, screenHeight / 4);

      addWindowListener (new WindowAdapter()  //handle window closing event
         {  public void windowClosing (WindowEvent e)
            { System.exit(0);
            }
         });
     JPanel testviewbalancePanel = new viewbalancePanel();
      Container contentPane = getContentPane(); //add a panel to a frame
      contentPane.add(testviewbalancePanel);
   }
  }

public class viewbalance  //main class of this program
{  public static void main(String [] args)
   { JFrame frame = new ListFrame(); //initialize a JFrame object
     frame.show(); //display the frame
   }
}
*/