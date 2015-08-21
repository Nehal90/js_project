<!--
/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: 01 December, 2012							                  *
*******************************************************************************/
-->

<HTML><HEAD></HEAD>
<BODY>
    <FORM NAME="ViewBalanceForm" ACTION="/ViewBalanceServlet" METHOD ="POST">
        <INPUT TYPE='hidden' NAME='Username' VALUE='<%=request.getParameter("Username")%>'>
         
        <TABLE cellPadding=3 ALIGN='center'>
	    <TR bgcolor='#ECFAEB'>
                <TD>Select Account:</TD>
                <TD>
                    <select size="1" name="account">
		    	<option selected value="Savings">Savings</option>
		    	<option value="Checking">Checking</option>    
  	            </select>
                </TD>
            </TR>  
            <TR>
                <TD colspan="2" ALIGN='center'>
                	<INPUT TYPE="SUBMIT" NAME='submitViewBalanceBTN' VALUE='Check Balance' onClick="checkInputs()">
                </TD>
            </TR>
            <TR bgcolor='#F1F1FD'>
		<TD>Your account balance is: $</TD>
		<TD>
		       <INPUT TYPE='number' NAME='AmountTextField' Value='<%=session.getAttribute("Balance")%>' SIZE='15'>
		</TD>
            </TR>
          </TABLE><BR>

</FORM>

</BODY>
</HTML>
<SCRIPT LANGUAGE="JavaScript">
document.ViewBalanceForm.AmountTextField.focus();
   function checkInputs()
   {
       var Prompts = "";
       document.ViewBalanceForm.submit();
   }

</SCRIPT>