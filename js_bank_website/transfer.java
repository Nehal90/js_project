/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: October 3, 2011													  *
*******************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.Border;

class transferPanel extends JPanel
   implements ListSelectionListener, ActionListener
{
	private String Username;
   public transferPanel(String Username)
   {
      transferButton = new JButton("Transfer");
      selectedSwingComponentTextField = new JTextField(14);
      selectedSwingComponentTextField2 = new JTextField(14);
      selectedSwingComponentTextField3 = new JTextField(14);
      add(transferButton);
      JLabel textFieldLabel = new JLabel("From: ");
      JLabel textFieldLabel2 = new JLabel("To: ");
      JLabel textFieldLabel3 = new JLabel("Amount: ");
      JPanel p1 = new JPanel();
      JPanel p2 = new JPanel();
      JPanel p5 = new JPanel();
      transferButton.addActionListener(this);
      p1.add(textFieldLabel);
      p2.add(textFieldLabel2);
      p5.add(textFieldLabel3);
      p1.add(selectedSwingComponentTextField);
      p2.add(selectedSwingComponentTextField2);
      p5.add(selectedSwingComponentTextField3);
      //initializing a list
      swingComponentList = new JList( new String []
          {"Checking", "Savings"});

swingComponentList.setVisibleRowCount(2); //set the visible rows
      swingComponentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      JLabel listLabel = new JLabel("Select Account:");
      JPanel p3 = new JPanel();
      p3.add(listLabel);
      p3.add(swingComponentList);


         //declare and initialize a GridBagLayout object
         GridBagLayout gbl = new GridBagLayout();
         setLayout(gbl); //let the layout manager be GridBagLayout
         //declare and initialize a GridBagConstraints object
         GridBagConstraints gbc = new GridBagConstraints();

     //apply GridBagConstraints to a GUI component and add it to this panel
      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 100;
      gbc.weighty = 100;
      add(p1, gbc, 1, 1, 1, 1);

      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 100;
      gbc.weighty = 100;
      add(p3, gbc, 1, 3, 5, 1);

      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 100;
      gbc.weighty = 100;
      add(p2, gbc, 4, 1, 0, 1);


  	  gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 100;
      gbc.weighty = 100;
      add(p5, gbc, 1, 5, 5, 1);

      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 100;
      gbc.weighty = 100;
      add(transferButton, gbc, 3, 6, 1, 5);

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
         JList source1 = (JList)evt.getSource();
         String tempString = (String)source1.getSelectedValue();
         selectedSwingComponentTextField.setText(tempString);
         if (tempString.equals("Savings"))
		 		     selectedSwingComponentTextField2.setText("Checking");
		   else if (tempString.equals("Checking"))
                     selectedSwingComponentTextField2.setText("Savings");
      }

  public void actionPerformed(ActionEvent evt)  //event handling
   	         {
   	             Object source = evt.getSource(); //get who generates this event
   	             if (source == transferButton)
   	                         t_amount = selectedSwingComponentTextField3.getText(); //take actions
				             t_frm =selectedSwingComponentTextField.getText();
				             t_to = selectedSwingComponentTextField2.getText();
                    if (t_amount.equals("") && t_frm.equals(""))
                    	JOptionPane.showMessageDialog(null, "Please select an account and enter the transfer amount!", "Error", JOptionPane.INFORMATION_MESSAGE);
                    else if (t_amount.equals(""))
                    	JOptionPane.showMessageDialog(null, "Please enter the transfer amount!", "Error", JOptionPane.INFORMATION_MESSAGE);
                    else if (t_frm.equals(""))
                    	JOptionPane.showMessageDialog(null, "Please select an account!", "Error", JOptionPane.INFORMATION_MESSAGE);
                    else
                		JOptionPane.showMessageDialog(null, "Your requested transfer amount of $"+t_amount+" from "+t_frm+" account to "+t_to+" account has been proceeded!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
   					   }


      private JTextField selectedSwingComponentTextField;
      private JTextField selectedSwingComponentTextField2;
      private JTextField selectedSwingComponentTextField3;
      private JList swingComponentList;
      private JButton transferButton;
      private String t_frm, t_to, t_amount;
}

/*
class ListFrame extends JFrame
{
   public ListFrame()
   {
      setTitle("Transfer");
      setSize(540, 330);
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
     JPanel testtransferPanel = new transferPanel();
      Container contentPane = getContentPane(); //add a panel to a frame
      contentPane.add(testtransferPanel);
   }
  }

public class transfer  //main class of this program
{  public static void main(String [] args)
   { JFrame frame = new ListFrame(); //initialize a JFrame object
     frame.show(); //display the frame
   }
}
*/