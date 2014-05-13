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

		out.println("get Attribute  Name   : " + stu.getName());

		for (Payment p : stu.getPaymentsList()) {

			if (p instanceof RegistrationPayment) {
				out.println("<br>  <h3> Payment   :  Registration</h3>");

				RegistrationPayment rp = (RegistrationPayment) p;

				out.println("<br> Payment ID   :  " + rp.getPaymentID());
				out.println("<br> <font color='red'> Payment Status    :  "
						+ rp.getPaymentStatus() + "</font>");

			} else if (p instanceof FullFeePayment) {
				FullFeePayment ffp = (FullFeePayment) p;

				out.println("<br> <h3>  Fullfee Payment </h3> ");

				out.println("<br> Payment ID    :  " + ffp.getPaymentID());
				out.println("<br> <font color='red'> Payment Status    :  "
						+ ffp.getPaymentStatus() + "</font>");

			} else if (p instanceof InstallmentPayment) {

				InstallmentPayment ip = (InstallmentPayment) p;

				out.println("<br>  <h3>" + ip.getInstallmentType()
						+ " Intsallment </h3> ");
				out.println("<font color='red'> Payment Status     :  "
						+ ip.getPaymentStatus() + "</font>");

				out.println("<br> Payment ID    :  " + ip.getPaymentID());

			} else {

			}

			///General Payment Details
			out.println("<br> Prposed Amount   :  "
					+ p.getPaymentDetails().getProposedAmount());
			out.println("<br> Deposited Amount   :  "
					+ p.getPaymentDetails().getDepositedAmount());
			out.println("<br> Prposed Date   :  "
					+ p.getPaymentDetails().getProposedDate());
			if (p.getPaymentDetails().getPaymentDate() != null) {
				out.println("<br> Payment Date   :  "
						+ p.getPaymentDetails().getPaymentDate());
			} else {
				out.println("<br> Payment Date   :  N/A ");
			}

			out.println("<br> ");

			//Checking for Mode of Payment
			PaymentMode pm = p.getPaymentMode();

			if (pm instanceof CashMode) {

				out.println("<b> Payment Mode : Cash Mode <b>");

				CashMode cm = (CashMode) pm;
				out.println("<br> Cash Amount " + cm.getCashAmount());
				out.println("<br> Cash Details ");

				for (Note n : cm.getCashDetail().keySet()) {
					out.println("<br> " + n + "  : "
							+ cm.getCashDetail().get(n));
				}

			} else if (pm instanceof DDMode) {
				out.println("<b> Payment Mode : DD Mode<b>");

				DDMode ddm = (DDMode) pm;
				out.println("<br> Bank Name " + ddm.getBankName());
				out.println("<br> DD Number " + ddm.getDDNumber());
				out.println("<br> DD Expiry Date " + ddm.getDdExpiryDate());
				out.println("<br> DD Issue Date " + ddm.getIssueDate());

			} else if (pm instanceof ChequeMode) {
				out.println("<b> Payment Mode : Cheque Mode<b>");

				ChequeMode chqm = (ChequeMode) pm;
				out.println("<br> Bank Name " + chqm.getBankName());
				out.println("<br> Cheque Number " + chqm.getChequeNumber());
				out.println("<br> Cheque Status " + chqm.getChequeStatus());
				out.println("<br> Cheque Expiry Date "
						+ chqm.getExpriyDate());
				out.println("<br>Cheque Issue Date " + chqm.getIssueDate());

			} else if (pm instanceof CardMode) {
				out.println("<b> Payment Mode : Card  Mode <b>");

				CardMode crdm = (CardMode) pm;
				out.println("<br> Card Number  " + crdm.getCardNumber());
				out.println("<br> Transaction ID "
						+ crdm.getTransactionID());
				out.println("<br> Card Expiry Date  "
						+ crdm.getCardExpiryDate());

			} else if (pm instanceof OnlineMode) {
				out.println("<b> Payment Mode : Online Mode <b>");

				OnlineMode om = (OnlineMode) pm;
				out.println("<br> Reiciept Number  "
						+ om.getRecieptNumber());
				out.println("<br> Transaction ID " + om.getTrasactionID());

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