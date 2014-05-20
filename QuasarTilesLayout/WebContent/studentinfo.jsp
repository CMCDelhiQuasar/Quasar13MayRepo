<%@page import="com.cmcdelhi.quasar.paymentDetails.FullFeePayment"%>
<%@page import="com.cmcdelhi.quasar.payMode.OnlineMode"%>
<%@page import="com.cmcdelhi.quasar.payMode.CardMode"%>
<%@page import="javax.smartcardio.Card"%>
<%@page import="com.cmcdelhi.quasar.payMode.ChequeMode"%>
<%@page import="com.cmcdelhi.quasar.payMode.DDMode"%>
<%@page import="com.cmcdelhi.quasar.payMode.CashMode"%>
<%@page import="com.cmcdelhi.quasar.payMode.Note"%>
<%@page import="com.cmcdelhi.quasar.payMode.PaymentMode"%>
<%@page import="com.cmcdelhi.quasar.paymentDetails.RegistrationPayment"%>
<%@page
	import="com.cmcdelhi.quasar.paymentDetails.InstallmentPayment,
	com.cmcdelhi.quasar.student.Student,
	java.util.List,com.cmcdelhi.quasar.paymentDetails.Payment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#studentdetail; {
	background-color: white;
	font-family: sans-serif;
	padding: 0px;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);
	-moz-box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);
	-webkit-box-shadow: 0 4px 6px -5px rgba(0, 0, 0, 0.8);
	padding: 10px;
}
</style>
<sj:head jqueryui="true" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

	<h2>Welcome to student info page...</h2>

	<s:set name="x" value="student" />
	<table border="0" width="">
		<tr>
			<td colspan="2">
				<h2>Basic Details Of Student</h2>
			</td>
			<td width="550"></td>
			<td><a href="getPDF?emailid=<s:property value="#x.emailId" />"><img
					src="images/print.jpg" alt="print"></a></td>
		</tr>
		<tr>
			<td>Name:-</td>
			<td><s:property value="#x.name" /></td>
		</tr>

		<tr>
			<td>Email:-</td>
			<td><s:property value="#x.emailId" /></td>
			<s:set var="email" value="#x.emailId" />
		</tr>

		<tr>
			<td>Contact:-</td>
			<td><s:property value="#x.contactNumber" /></td>
		</tr>
	</table>

	<table>
		<tr>
			<td colspan="2">
				<h2>Fee Details Of Student</h2>
			</td>
		</tr>
		<tr>
			<td>Course Fee:-</td>
			<td><s:property value="#x.feeDetails.courseFees" /></td>
		</tr>

		<tr>
			<td>Service Tax:-</td>
			<td><s:property value="#x.feeDetails.serviceTax" /></td>
		</tr>

		<tr>
			<td>Fine:-</td>
			<td><s:property value="#x.feeDetails.fine" /></td>
		</tr>

		<tr>
			<td>Discount Available:-</td>
			<td><s:property value="#x.feeDetails.discountAvailable" /></td>
		</tr>

		<tr>
			<td>Total Fee:-</td>
			<td><s:property value="#x.feeDetails.totalFee" /></td>
		</tr>

	</table>


	<table>

		<tr>
			<td><s:submit value="Back" /></td>
		</tr>

	</table>

	<hr>

	<%
		Student stu = (Student) request.getAttribute("student");

		//out.println("get Attribute  Name   : " + stu.getName());

		for (Payment p : stu.getPaymentsList()) {

			if (p instanceof RegistrationPayment) {
				out.println(" <table border='0' id='studentdetail' ><tr><td> <h3> Payment   :  Registration</h3></td></tr>");

				RegistrationPayment rp = (RegistrationPayment) p;

				out.println("<tr><td> Payment ID   :  </td><td>"
						+ rp.getPaymentID() + "</td></tr>");
				out.println("<tr><td> Payment Status    :  </td><td>"
						+ rp.getPaymentStatus() + "</td></tr></table>");

			} else if (p instanceof FullFeePayment) {
				FullFeePayment ffp = (FullFeePayment) p;

				out.println("<table border='0' id='studentdetail'><tr><td> <h3>  Fullfee Payment </h3></td></tr> ");

				out.println("<tr><td> Payment ID    :  </td><td>"
						+ ffp.getPaymentID() + "</td></tr>");
				out.println("<tr><td> Payment Status    :  </td><td>"
						+ ffp.getPaymentStatus() + "</td><td>"
						+ " <a href='perpareDuePayment?paymentId="
						+ ffp.getPaymentID()
						+ "'>PAY NOW </a></td></tr></table>");

			} else if (p instanceof InstallmentPayment) {

				InstallmentPayment ip = (InstallmentPayment) p;

				out.println("<table border='0' id='studentdetail'><tr><td> <h3>"
						+ ip.getInstallmentType()
						+ " Intsallment </h3> </td></tr>");
				out.println("<tr><td><font '> Payment Status     : </td><td>"
						+ ip.getPaymentStatus()
						+ "</font> <a href='perpareDuePayment?paymentId="
						+ ip.getPaymentID() + "'>PAY NOW </a></td></tr>");

				out.println("<br><tr><td> Payment ID    :  </td><td>"
						+ ip.getPaymentID());
				out.println("</td></tr></table>");

			} else {

			}

			///General Payment Details
			out.println("<table border='0' id='studentdetail'><tr><td> Prposed Amount   :  </td><td>"
					+ p.getPaymentDetails().getProposedAmount()
					+ "</td></tr>");
			out.println("<tr><td> Deposited Amount   :  </td><td>"
					+ p.getPaymentDetails().getDepositedAmount()
					+ "</td></tr>");
			out.println(" <tr><td> Prposed Date   :  </td><td>"
					+ p.getPaymentDetails().getProposedDate()
					+ "</td></tr>");
			if (p.getPaymentDetails().getPaymentDate() != null) {
				out.println("<tr><td> Payment Date   :  </td><td>"
						+ p.getPaymentDetails().getPaymentDate()
						+ "</td></tr>");
			} else {
				out.println(" <tr><td> Payment Date   :  </td><td>N/A </td></tr>");
			}

			out.println(" </table>");

			//Checking for Mode of Payment
			PaymentMode pm = p.getPaymentMode();

			if (pm instanceof CashMode) {

				out.println("<table border='0' id='studentdetail'><tr><td><b> Payment Mode </b></td>: <td>Cash Mode</td></tr>");

				CashMode cm = (CashMode) pm;
				out.println("<tr><td><b> Cash Amount </b></td><td>"
						+ cm.getCashAmount() + "</td></tr>");
				out.println("<tr><td> <b>Cash Details</b> </td></tr>");

				for (Note n : cm.getCashDetail().keySet()) {
					out.println("<tr><td><b> " + n + " </b></td><td> : "
							+ cm.getCashDetail().get(n)
							+ "</td></tr></table>");
				}

			} else if (pm instanceof DDMode) {
				out.println("<table border='0' id='studentdetail'><tr><td><b> Payment Mode </b></td>:<td> DD Mode </td></tr>");

				DDMode ddm = (DDMode) pm;
				out.println("<tr><td><b> Bank Name </b></td><td>"
						+ ddm.getBankName() + "</td></tr>");
				out.println("<tr><td><b>  DD Number </b></td><td>"
						+ ddm.getDDNumber() + "</td></tr>");
				out.println("<tr><td><b> DD Expiry Date </b></td><td>"
						+ ddm.getDdExpiryDate() + "</td></tr>");
				out.println("<tr><td><b> DD Issue Date </b></td><td>"
						+ ddm.getIssueDate() + "</td></tr></table>");

			} else if (pm instanceof ChequeMode) {
				out.println("<table border='0' id='studentdetail'><tr><td><b> Payment Mode </b></td>:<td> Cheque Mode</td></tr>");

				ChequeMode chqm = (ChequeMode) pm;
				out.println("<tr><td><b> Bank Name </b></td><td>"
						+ chqm.getBankName() + "</td></tr>");
				out.println("<tr><td><b> Cheque Number </b></td><td>"
						+ chqm.getChequeNumber() + "</td></tr>");
				out.println("<tr><td><b> Cheque Status </b></td><td>"
						+ chqm.getChequeStatus() + "</td></tr>");
				out.println("<tr><td><b> Cheque Expiry Date </b></td><td>"
						+ chqm.getExpriyDate() + "</td></tr>");
				out.println("<tr><td><b>Cheque Issue Date </b></td><td>"
						+ chqm.getIssueDate() + "</td></tr></table>");

			} else if (pm instanceof CardMode) {
				out.println("<table border='0' id='studentdetail'><tr><td><b> Payment Mode </b></td>:<td> Card  Mode </td></tr>");

				CardMode crdm = (CardMode) pm;
				out.println("<tr><td><b> Card Number  </b></td><td>"
						+ crdm.getCardNumber() + "</td></tr>");
				out.println("<tr><td><b> Transaction ID </b></td><td>"
						+ crdm.getTransactionID() + "</td></tr>");
				out.println("<tr><td><b> Card Expiry Date  </b></td><td>"
						+ crdm.getCardExpiryDate() + "</td></tr></table>");

			} else if (pm instanceof OnlineMode) {
				out.println("<table border='0' id='studentdetail'><tr><td><b> Payment Mode </b></td>:<td> Online Mode </td></tr>");

				OnlineMode om = (OnlineMode) pm;
				out.println("<tr><td><b> Reiciept Number  </b></td><td>"
						+ om.getRecieptNumber() + "</td></tr>");
				out.println("<tr><td><b> Transaction ID </b></td><td>"
						+ om.getTrasactionID() + "</td></tr>");

			} else {

			}

			out.println("<hr>");

			out.println("<br>");

			out.println("<hr>");

		}
	%>

	<hr>



</body>
</html>