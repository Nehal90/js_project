/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: December 1, 2011													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
public class TransferControl
{
	String Username, amount, account1, account2, type;

    public TransferControl(String UName, String AccFm, String AccTo, String amt, String typ) {
		Username=UName;
		account1=AccFm;
		account2=AccTo;
		amount=amt;
		type = typ;
		if (account1.equals("Checking"))
		{
		Checking_Account checkingaccountbalance = new Checking_Account(Username, account1, account2, amount, type);{
		            if (checkingaccountbalance.transferfrom())
		               { JOptionPane.showMessageDialog(null, "Your requested amount of $"+amount+" has been withdrawn from "+account1+" account!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
		                }
		            else
		                JOptionPane.showMessageDialog(null,"Invalid account or deposit amount.\n", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

        }

        Saving_Account savingaccountbalance = new Saving_Account(Username, account1, account2, amount, type);{
				            if (savingaccountbalance.transferto())
				               { JOptionPane.showMessageDialog(null, "Your requested amount of $"+amount+" has been deposited to "+account2+" account!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				               transaction newtransaction = new transaction(Username, amount, type);
				               newtransaction.s_saveTransaction();
				               }
				            else
				                JOptionPane.showMessageDialog(null,"Invalid account or deposit amount.\n", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }

	}
        else if (account1.equals("Savings"))
		{
				Saving_Account savingaccountbalance = new Saving_Account(Username, account1, account2, amount, type);
				            if (savingaccountbalance.transferfrom())
				               { JOptionPane.showMessageDialog(null, "Your requested amount of $"+amount+" has been withdrawn from "+account1+" account!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);}
				            else
				                JOptionPane.showMessageDialog(null,"Invalid account or deposit amount.\n", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }
        {
				Checking_Account checkingaccountbalance = new Checking_Account(Username, account1, account2, amount, type);
				            if (checkingaccountbalance.transferto())
				               { JOptionPane.showMessageDialog(null, "Your requested amount of $"+amount+" has been deposited to "+account2+" account!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				               transaction newtransaction = new transaction(Username, amount, type);
				               newtransaction.c_saveTransaction();}
				            else
				                JOptionPane.showMessageDialog(null,"Invalid account or deposit amount.\n", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }

	}


	}

