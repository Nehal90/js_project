/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: December 1, 2011													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program
import javax.swing.*;
public class LoginControl
{

    public LoginControl(String Username, String Password) {
		Account checklogin = new Account(Username, Password);
		            if (checklogin.signIn())
		               { //JOptionPane.showMessageDialog(null, "Login Successful!\n", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
						   ConfirmationBO C_BO = new ConfirmationBO(Username);}
		            else
		                JOptionPane.showMessageDialog(null, "                                                            Login Failed!\n"
		                +"Invalid email address or unmatched passwords or the email address does not exists.\n", "Confirmation", JOptionPane.INFORMATION_MESSAGE);


	}
}