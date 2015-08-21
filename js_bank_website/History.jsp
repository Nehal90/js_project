<!--
/******************************************************************************
*	Program Author: Ahmed Nehal for CSCI 6810 Java and the Internet	  *
*	Date: 01 December, 2012							  *
*******************************************************************************/
-->
<%@ page import="java.util.*" %>
<HTML><HEAD></HEAD>
<BODY>
    <FORM NAME="HistoryForm" ACTION="/TransactionHistoryServlet" METHOD ="POST">
    <INPUT TYPE='hidden' NAME='Username' VALUE='<%=request.getParameter("Username")%>'>
        <TABLE cellPadding=3 ALIGN='center'  border="1">
	    <TR bgcolor='#F1F1FD'>
	                    <TD ALIGN='center'>TransactionID</TD>
	                    <TD ALIGN='center'>Account No</TD>
	                    <TD ALIGN='center'>Amount</TD>
	                    <TD ALIGN='center'>Type</TD>
	                    <TD ALIGN='center'>DateandTime</TD>
            </TR>
                        
	    <%Vector TableVec = (Vector)session.getAttribute("Table1");  
	    for(int k=0; k<TableVec.size();k++)
	    {
	    	Vector rowVec;
		rowVec = (Vector)TableVec.get(k);
	    %>
	    <TR bgcolor='#F1F1FD'>	
	    <%
		out.println("<TD >" + rowVec.get(0) + "</TD>");
		out.println("<TD >" + rowVec.get(1) + "</TD>");
		out.println("<TD >" + rowVec.get(2) + "</TD>");
		out.println("<TD >" + rowVec.get(3) + "</TD>");
		out.println("<TD >" + rowVec.get(4) + "</TD>");
    	     }
    	     %>
	   </TR>
      </TABLE>
</FORM>
</BODY>
</HTML>
<SCRIPT LANGUAGE="JavaScript">
document.TransactionHistoryForm.TransactionDateTextField.focus();
</SCRIPT>