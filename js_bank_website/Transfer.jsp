<!--
/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: 01 December, 2012		                 					  *
*******************************************************************************/
-->

<HTML><HEAD></HEAD>
<BODY>
    <FORM NAME="TransferForm" ACTION="/TransferServlet" METHOD ="POST">
        <INPUT TYPE='hidden' NAME='Username' VALUE='<%=request.getParameter("Username")%>'>
        

        <TABLE cellPadding=3 ALIGN='center'>
	    <TR bgcolor='#F1F1FD'>
	                    <TD>Enter the amount to be transferred: $</TD>
	                    <TD>
	                       <INPUT TYPE='number' NAME='transferAmountTextField' Value='' SIZE='15'>
	                    </TD>
            </TR>
            <TR bgcolor='#ECFAEB'>
                <TD>Account From:</TD>
                <TD>
                    <select size="1" name="FAccountList">
		    	<option selected value="Savings">Savings</option>
		    	<option value="Checking">Checking</option>    
  	            </select>
                </TD>
            </TR>
            
            <TR bgcolor='#ECFAEB'>
                <TD>Account To:</TD>
                <TD>
                    <select size="1" name="TAccountList">
		    	<option selected value="Savings">Savings</option>
		    	<option value="Checking">Checking</option>    
  	            </select>
                </TD>
            </TR>
                        
          </TABLE><BR>
          
<CENTER><INPUT TYPE="SUBMIT" NAME='submitTransferBTN' VALUE='Transfer' onClick="checkInputs()"></CENTER><BR>
</FORM>

</BODY>
</HTML>
<SCRIPT LANGUAGE="JavaScript">
document.TransferForm.transferAmountTextField.focus();
   function checkInputs()
   {
       var Prompts = "";
       var Amount = document.TransferForm.transferAmountTextField.value;
       if (Amount == "")
       {
          Prompts +="Please enter an amount! \n";
          window.alert(Prompts);
       }
       else if (Amount <= 0)
       {
       
             window.alert("Invalid Amount. Please enter valid amount.");
             
       }
       else
       {
       	  
          document.TransferForm.submit();
       }
   }

</SCRIPT>