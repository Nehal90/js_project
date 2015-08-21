/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: December 1, 2011													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
public class DepositControl
{
	String Username, account, amount, type;

    public DepositControl(String UName, String Acct, String amt, String typ) {
		Username=UName;
		account=Acct;
		amount=amt;
		type=typ;

		if (account.equals("Checking"))
		{
		Checking_Account checkingaccountbalance = new Checking_Account(Username, account, amount, type);
		            if (checkingaccountbalance.deposit())
		               { JOptionPane.showMessageDialog(null, "Your requested amount of $"+amount+" has been deposited to "+account+" account!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		                 transaction newtransaction = new transaction(Username, amount, type);
		                 newtransaction.c_saveTransaction();
		                 }
		            else
		                JOptionPane.showMessageDialog(null,"Invalid account or deposit amount.\n", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (account.equals("Savings"))
		{
		Saving_Account savingaccountbalance = new Saving_Account(Username, account, amount, type);
		            if (savingaccountbalance.deposit())
		               { JOptionPane.showMessageDialog(null, "Your requested amount of $"+amount+" has been deposited to "+account+" account!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		               transaction newtransaction = new transaction(Username, amount, type);
		               newtransaction.s_saveTransaction();
		               }
		            else
		                JOptionPane.showMessageDialog(null,"Invalid account or deposit amount.\n", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }


	}
}