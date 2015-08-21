<!--
/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: December 01, 2012													  *
*******************************************************************************/
-->

<HTML><HEAD></HEAD>
<BODY>
    <FORM NAME="WithdrawForm" ACTION="/WithdrawServlet" METHOD ="POST">
        <INPUT TYPE='hidden' NAME='Username' VALUE='<%=request.getParameter("Username")%>'>

        <TABLE cellPadding=3 ALIGN='center'>

            <TR bgcolor='#ECFAEB'>
                <TD>Withdraw From:</TD>
                <TD>
                    <select size="1" name="account">
		    	<option selected value="Checking">Checking</option>
		    	<option value="Savings">Savings</option>    
  	            </select>
                </TD>
            </TR>

            <TR bgcolor='#F1F1FD'>
                <TD>Enter the amount to be withdrawn: $</TD>
                <TD>
                   <INPUT TYPE='text' NAME='WithdrawAmountTextField' Value='' SIZE='15'>
                </TD>
            </TR>
          </TABLE><BR>
<CENTER><INPUT TYPE="SUBMIT" NAME='submitBNTN' VALUE='Make Withdrawal'></CENTER><BR>
</FORM>

</BODY>
</HTML>
<SCRIPT LANGUAGE="JavaScript">
document.WithdrawForm.WithdrawAmountTextField.focus();
   function checkInputs()
   {
       var Prompts = "";
       var Amount = document.WithdrawForm.WithdrawAmountTextField.value;
       if (Amount == "")
       {
          Prompts +="Please enter an amount! \n";
          window.alert(Prompts);
       }
       else if (Amount <= 0)
       {
       
             window.alert("Invalid. Please enter a valid amount.");
             exit(0);
             
       }
       else
       {
       	  
          document.WithdrawForm.submit();
       }
   }

</SCRIPT>