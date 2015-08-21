/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: December 1, 2011													  *
*******************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.Border;

public class depositPanel extends JPanel
   implements ListSelectionListener, ActionListener
{
	private String Username;


   public depositPanel(String UName)


   {  Username = UName;
      depositButton = new JButton("Deposit");
      selectedSwingComponentTextField = new JTextField(14);
      selectedSwingComponentTextField3 = new JTextField(14);
      add(depositButton);
      JLabel textFieldLabel = new JLabel("To: ");
      JLabel textFieldLabel3 = new JLabel("Amount: ");
      JPanel p1 = new JPanel();
      JPanel p5 = new JPanel();
      depositButton.addActionListener(this);
      p1.add(textFieldLabel);
      p5.add(textFieldLabel3);
      p1.add(selectedSwingComponentTextField);
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
      add(p3, gbc, 1, 3, 4, 1);

	  gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 100;
      gbc.weighty = 100;
      add(p5, gbc, 1, 4, 5, 1);

      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 100;
      gbc.weighty = 100;
      add(depositButton, gbc, 1, 5, 6, 1);

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

         }

 public void actionPerformed(ActionEvent evt)  //event handling
   	         {
   	             Object source = evt.getSource(); //get who generates this event
   	             if (source == depositButton)
   	                         amount = selectedSwingComponentTextField3.getText(); //take actions
				             account =selectedSwingComponentTextField.getText();
				             type="Deposit";

                    if (amount.equals("") && account.equals(""))
                    	JOptionPane.showMessageDialog(null, "Please select an account and enter the deposit amount!", "Error", JOptionPane.INFORMATION_MESSAGE);
                    else if (amount.equals(""))
                    	JOptionPane.showMessageDialog(null, "Please enter the deposit amount!", "Error", JOptionPane.INFORMATION_MESSAGE);
                    else
                		   					   System.out.println("Username: " + Username);
   					      					   System.out.println("d_to: " +account);
   					      					   System.out.println("d_amount: " + amount);
   					      					   DepositControl DepositC = new DepositControl(Username, account, amount, type);
   					   }

      private JTextField selectedSwingComponentTextField;
      private JTextField selectedSwingComponentTextField3;
      private JList swingComponentList;
      private JButton depositButton;
      private String account, amount, type;
}

