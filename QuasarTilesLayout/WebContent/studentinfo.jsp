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
	
	<s:set name="x" value="student"/>
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
//		List<Student> stuList = (List<Student>) request
	//			.getAttribute("student");

	//	out.println("get Attribute Size  : " + stuList.size());
	%>

	<hr>



</body>
</html>