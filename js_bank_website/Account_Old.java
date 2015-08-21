/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: October 3, 2011													  *
*******************************************************************************/

import java.lang.*; //including Java packages used by this program

public class Account
{
	private String Username, Password, Password1;

	public Account(String UN, String PassW, String PassW1) {
		Username = UN;
		Password = PassW;
		Password1 = PassW1;
	}

	public Account(String UN, String PassW) {
		Username = UN;
		Password = PassW;
	}

    public boolean signUp() {
		if (!Username.equals("") && !Password.equals("") && !Password1.equals("") &&
		    Password.equals(Password1) && !Username.equals("someone@yahoo.com"))
		     return true;
		else return false;
	}
    public boolean signIn() {
		if (!Username.equals("") && !Password.equals("") &&
		    Password.equals("HelloFDU") && Username.equals("someone@yahoo.com"))
		     return true;
		else return false;
	}

}