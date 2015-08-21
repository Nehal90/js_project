/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: December 1, 2011													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
public class ViewBalanceControl
{
	private int acct_bal;
	String Username, account;

    public ViewBalanceControl(String UName, String acct) {
		Username=UName;
		account=acct;

		if (account.equals("Checking"))
		{
		Checking_Account checkingaccountbalance = new Checking_Account(Username, account);
		            acct_bal=checkingaccountbalance.viewbalance();
		            JOptionPane.showMessageDialog(null, "Your Checking account balance is " +acct_bal, "Checking Balance", JOptionPane.INFORMATION_MESSAGE);

		            }
        else if (account.equals("Savings"))
		{
		Saving_Account savingaccountbalance = new Saving_Account(Username, account);
		            acct_bal=savingaccountbalance.viewbalance();
		            JOptionPane.showMessageDialog(null, "Your Saving account balance is " +acct_bal, "Checking Balance", JOptionPane.INFORMATION_MESSAGE);

		   }


	}
}