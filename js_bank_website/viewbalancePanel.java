/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: December 1, 2011													  *
*******************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.Border;

class viewbalancePanel extends JPanel
   implements ListSelectionListener, ActionListener
{
	private String Username;


	   public viewbalancePanel(String UName)

	{
	  Username = UName;
      viewbalanceButton = new JButton("View Balance");
      selectedSwingComponentTextField = new JTextField(14);
      add(viewbalanceButton);
      JLabel textFieldLabel = new JLabel("Selected Account: ");
      JPanel p1 = new JPanel();

      viewbalanceButton.addActionListener(this);
      p1.add(textFieldLabel);
      p1.add(selectedSwingComponentTextField);
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
      add(viewbalanceButton, gbc, 1, 5, 6, 1);

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
   	             if (source == viewbalanceButton)
   	                        account =selectedSwingComponentTextField.getText();

			       if (account.equals(""))
			              	JOptionPane.showMessageDialog(null, "Please select an account and enter the deposit amount!", "Error", JOptionPane.INFORMATION_MESSAGE);
					else
							                		   					   System.out.println("Username: " + Username);
							   					      					   System.out.println("d_to: " +account);
							   					      					   ViewBalanceControl ViewBalanceC = new ViewBalanceControl(Username, account);
							   					   }

      private JTextField selectedSwingComponentTextField;
      private JList swingComponentList;
      private JButton viewbalanceButton;
      private String account;
}
