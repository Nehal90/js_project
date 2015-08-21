<!--
/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: 01 December, 2012							  *
*******************************************************************************/
-->

<HTML><HEAD></HEAD>
<BODY>
    <FORM NAME="DepositForm" ACTION="/DepositServlet" METHOD ="POST">
        <INPUT TYPE='hidden' NAME='Username' VALUE='<%=request.getParameter("Username")%>'>
        

        <TABLE cellPadding=3 ALIGN='center'>
	    
            <TR bgcolor='#ECFAEB'>
                <TD>Deposit To:</TD>
                <TD>
                    <select size="1" name="account">
		    	<option selected value="Savings">Savings</option>
		    	<option value="Checking">Checking</option>    
  	            </select>
                </TD>
            </TR>
            
            <TR bgcolor='#F1F1FD'>
	                    <TD>Enter the deposit amount: $</TD>
	                    <TD>
	                       <INPUT TYPE='number' NAME='depositAmountTextField' Value='' SIZE='15'>
	                    </TD>
            </TR>
                        
          </TABLE><BR>
          
<CENTER><INPUT TYPE="button" NAME='submitDepositBTN' VALUE='Deposit' onClick="checkInputs()"></CENTER><BR>
</FORM>

</BODY>
</HTML>
<SCRIPT LANGUAGE="JavaScript">
document.DepositForm.depositAmountTextField.focus();
   function checkInputs()
   {
       var Prompts = "";
       var Amount = document.DepositForm.depositAmountTextField.value;
       if (Amount == "")
       {
          Prompts +="Please enter an amount! \n";
          window.alert(Prompts);
       }
       else if (Amount <= 0)
       {
       
             window.alert("Invalid Amount. Please enter valid amount.");
             exit(0);
             
       }
       else
       {
       	  
          document.DepositForm.submit();
       }
   }

</SCRIPT>