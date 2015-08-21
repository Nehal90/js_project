/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: December 1, 2011													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
public class transactionControl
{
	String Username, s_date;

	public transactionControl(String UName, String s_d) {
			Username=UName;
			s_date=s_d;


	{
			transaction transactionsearch = new transaction(Username, s_date);
			            if (transaction.searchtransaction())
			               { JOptionPane.showMessageDialog(null, "Your requested amount of $"+amount+" has been deposited to "+account+" account!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

			                 }
			            else
			                JOptionPane.showMessageDialog(null,"Invalid account or deposit amount.\n", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }

   }