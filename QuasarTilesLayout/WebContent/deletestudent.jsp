<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<s:form action="studentdeletion" theme="simple">
			<tr>
				<td><s:label value="Enter Student EmailId" /></td>
				<td><s:textfield name="emailId" /></td>
			</tr>
			<tr>
				<td></td>
				<td><s:submit value="Proceed" /></td>
			</tr>
		</s:form>
	</table>
	<hr />
	<hr />
	<h3>Student detail before deletion</h3>

	<s:iterator var="x" value="deletestudent">

		<table border="0" width="">
			<tr>
				<td colspan="2">
					<h2>Basic Details Of Student</h2>
				</td>
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
				<td colspan="2">
					<h2>Registration Details Of Student</h2>
				</td>
			</tr>
			<tr>
				<td>Registration Proposed Amount:-</td>
				<td><s:property
						value="#x.paymentsList.get(0).paymentDetails.proposedAmount" /></td>
			</tr>

			<tr>
				<td>Registration Deposited Amount:-</td>
				<td><s:property
						value="#x.paymentsList.get(0).paymentDetails.depositedAmount" /></td>
			</tr>

			<tr>
				<td>Registration Proposed Date :</td>
				<td><s:property
						value="#x.paymentsList.get(0).paymentDetails.proposedDate" /></td>
			</tr>

			<tr>
				<td>Registration Payment Date :</td>
				<td><s:property
						value="#x.paymentsList.get(0).paymentDetails.paymentDate" /></td>
			</tr>
			<tr>
				<td>Registration Payment Comment :</td>
				<td><s:property value="#x.paymentsList.get(0).paymentComment" /></td>
			</tr>

		</table>
		<table>
			<s:form action="studentdeletion">
				<s:hidden name="demail" value="%{email}" />
				<s:submit value="Delete Student" />

			</s:form>
		</table>

	</s:iterator>


</body>
</html>