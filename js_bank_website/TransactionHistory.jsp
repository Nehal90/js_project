<!--
/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: 03 December, 2012							  *
*******************************************************************************/
-->
<%@ page import="java.util.*" %>
<HTML><HEAD></HEAD>
<BODY>
    <FORM NAME="TransactionHistoryForm" ACTION="/TransactionHistoryServlet" METHOD ="POST">
        <INPUT TYPE='hidden' NAME='Username' VALUE='<%=request.getParameter("Username")%>'>
        

        <TABLE cellPadding=3 ALIGN='center'>
	    <TR bgcolor='#F1F1FD'>
	                    <TD>Enter the Transaction Date (mm/dd/yyyy):</TD>
	                    <TD>
	                       <INPUT TYPE='date' NAME='TransactionDateTextField' Value='' SIZE='15'>
	                    </TD>
            </TR>
                     
          </TABLE><BR>
          
<CENTER><INPUT TYPE="button" NAME='submitHistoryBTN' VALUE='Get History' onClick="checkInputs()"></CENTER><BR>

	      </TABLE>
</FORM>

</BODY>
</HTML>
<SCRIPT LANGUAGE="JavaScript">
document.TransactionHistoryForm.TransactionDateTextField.focus();
   function checkInputs()
   {
       var Prompts = "";
       var Amount = document.TransactionHistoryForm.TransactionDateTextField.value;
       if (Amount == "")
       {
          Prompts +="Please enter an amount! \n";
          window.alert(Prompts);
       }
       else if (Amount <= 0)
       {
       document.TransactionHistoryForm.Submit.disabled=true
             window.alert("Invalid Amount. Please enter a valid amount.");
             
       }
       else
       {
       	  
          document.TransactionHistoryForm.submit();
       }
   }

</SCRIPT>