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


//Deposit will define the structure of the tab "Deposit" and the logic to deposit the amount is written here
public class historyPanel extends JPanel
		implements ActionListener
{
	private JTextField TransactionDateTextField;
	private Vector TokensVec,rows,columns;
	private StringTokenizer StrTokens;
	private String Username;
	//private JTable table;
	GridBagLayout gbl;
			GridBagConstraints gbc;
			private JTable table;

	public historyPanel(String Uname)
   	{
		Username=Uname;
		JLabel TransactionDateLabel = new JLabel("Enter the transaction date");
		TransactionDateTextField = new JTextField(8);
		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		TransactionDateTextField.setText(dateFormat.format(calendar.getTime()));

			     gbl = new GridBagLayout();
				 setLayout(gbl);
				 gbc = new GridBagConstraints();
		       	 gbc.fill = GridBagConstraints.NONE;
		         gbc.weightx = 100;
		         gbc.weighty = 100;
		         add(TransactionDateLabel, gbc, 0, 0, 1, 1);

		         gbc.fill = GridBagConstraints.NONE;
		         gbc.weightx = 100;
		         gbc.weighty = 100;
		         add(TransactionDateTextField, gbc, 2, 0, 1, 1);

		         Border raised = BorderFactory.createRaisedBevelBorder();
				 setBorder(raised);

				 TransactionDateTextField.addActionListener(this);
		   	}
		   	//overload method ADD with GridBagConstraints
	public void add(Component c, GridBagConstraints gbc, int x, int y, int w, int h)
	{
		       gbc.gridx = x;
			   gbc.gridy = y;
			   gbc.gridwidth = w;
			   gbc.gridheight = h;
			   add(c, gbc);
	}



   	//this method is being called whenever the button is clicked. Data validations are being done here
   	public void actionPerformed(ActionEvent evt)
   	{
		Date TrDate = null;
		Object source = evt.getSource();
		String TableData="";
		int p=0,n=0;
		if(source == TransactionDateTextField)
		{
			try {


					// Create a connection to the server socket on the server application
					InetAddress host = InetAddress.getLocalHost();
					Socket socket = new Socket(host.getHostName(), 2020);

					String s = TransactionDateTextField.getText() + ":" + Username;
					// Send a message to the client application
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(s);

					// Read and display the response message sent by server application
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					System.out.println("ready to receive Vector");
					Vector<Vector> VectorTableDataFromServer = (Vector)ois.readObject();

					Vector<String> labels = (Vector<String>)VectorTableDataFromServer.get(0);
					Vector<Vector> rows = (Vector)VectorTableDataFromServer.get(1);

					if(rows.size()==0)
						JOptionPane.showMessageDialog(null, "There are no transactions on the entered date","Confirmation",JOptionPane.INFORMATION_MESSAGE);
					else
					{DisplayTable(rows,labels);
					JOptionPane.showMessageDialog(null, "Please maximize the window!","Confirmation",JOptionPane.INFORMATION_MESSAGE);}

					ois.close();
					oos.close();
				}
				catch (UnknownHostException e)
				{
					e.printStackTrace();
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
   	public void DisplayTable(Vector rows,Vector labels)
    {

		JLabel TLabel = new JLabel("            ");
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(TLabel, gbc, 0, 1, 1, 1);

		table = new JTable(rows,labels);
		TableColumnModel colMdl = table.getColumnModel();
		colMdl.getColumn(0).setPreferredWidth(100);
		colMdl.getColumn(1).setPreferredWidth(150);
		colMdl.getColumn(2).setPreferredWidth(150);


		if(rows.size()==0)
		{
		   	table.setVisible(false);
		   	remove(table);
		   	//System.out.println("here");
		}
	   else
	   {
		   JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	     	gbc.fill = GridBagConstraints.NONE;
	  		gbc.weightx = 100;
			gbc.weighty = 100;
		    add((new JScrollPane(table)), gbc, 0, 15, 10, 10);
		}
	}

}