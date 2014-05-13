<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<sj:head jqueryui="true" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<script type="text/javascript">
	function validatedraft() {

		alert("Come to validate method");
		var strDDNumber = document.forms["draftdetails"]["DDNumber"].value;
		var DDNumber = parseInt(strDDNumber, 10);
		// window.confirm(strDDNumber);
		var bankName = document.forms["draftdetails"]["bankName"].value;
		var issueDate = document.forms["draftdetails"]["issueDate"].value;
		if (DDNumber <= 0 || strDDNumber == "") {
			alert("Please enter valid draft number");
			return false;
		}
		if (bankName.length < 3) {
			alert("Please enter at least 3 character in bank name");
			return false;
		}

		if (issueDate == "") {
			alert("Please select date!!");
			return false;
		}
		return true;
	}
</script>
</head>
<body>


	<s:if test="#session.REGISTERING_STUDENT_EMAIL==null">
		You are not within the session .Please Login
		<jsp:forward page="registration.jsp" />
	</s:if>
	<s:else>
		<table border="0" id="studentdetail">
			<tr>
				<td colspan="4"><h2>Installment Configuration For</h2></td>
				<td width="130"></td>
				<td width="110"></td>
				<td colspan="3" width="40"><a href="cancelregistration"><img
						src="images/cancel.png" alt="" /></a></td>
			</tr>
			<tr>
				<td>Name:-</td>
				<td><s:property value="#session.shagird.name" /></td>
			</tr>

			<tr>
				<td>Email:-</td>
				<td><s:property value="#session.shagird.emailId" /></td>
			</tr>

			<tr>
				<td>Contact:-</td>
				<td><s:property value="#session.shagird.contactNumber" /></td>
			</tr>

			<tr>
				<td>Payment Objects:-</td>
				<td><s:property value="#session.shagird.paymentsList.size" /></td>
			</tr>
			<s:iterator var="p" value="#session.shagird.paymentsList">
				<tr>
					<td>Proposed Amount:-</td>
					<td><s:property value="#p.paymentDetails.proposedAmount" /></td>
				</tr>
				<tr>
					<td>Proposed Date:-</td>
					<td><s:property value="#p.paymentDetails.proposedDate" /></td>
				</tr>

				<tr>
					<td>Payment Comment:-</td>
					<td><s:property value="#p.paymentComment" /></td>
				</tr>
			</s:iterator>
		</table>

		<hr />
		<h1>Registration Object Details</h1>
			Registration Proposed Amount:- <s:property
			value="#session.shagird.paymentsList.get(0).paymentDetails.proposedAmount" />
		<br />Registration Deposited Amount:- <s:property
			value="#session.shagird.paymentsList.get(0).paymentDetails.depositedAmount" />
		<br /> Registration Proposed Date : <s:property
			value="#session.shagird.paymentsList.get(0).paymentDetails.proposedDate" />
		<br />Registration Payment Date:- <s:property
			value="#session.shagird.paymentsList.get(0).paymentDetails.paymentDate" />
		<br />Registration Payment Comment:- <s:property
			value="#session.shagird.paymentsList.get(0).paymentComment" />
		<br />
		<hr />

		<h1>Demand Draft Details</h1>
		<s:form name="draftdetails" theme="simple" action="ddmode"
			method="post" onsubmit="return true">
			<table>
				<tr>
					<td><s:label value="DD Number" /></td>
					<td><s:textfield label="DD Number" labelSeparator=""
							labelposition="left" name="DDNumber" /></td>
					<td><s:fielderror fieldName="DDNumber" /></td>
				</tr>

				<tr>
					<td><s:label value="Drawn on/Bank Name" /></td>
					<td><s:textfield label="Drawn on/Bank Name" labelSeparator=""
							labelposition="left" name="bankName" /></td>
					<td><s:fielderror fieldName="bankName" /></td>
				</tr>

				<tr>
					<td><s:label value="Issue Date" /></td>
					<td><sj:datepicker name="issueDate" changeYear="true"
							changeMonth="true" label="Issue Date" labelSeparator=""
							labelposition="left" /></td>
					<td><s:fielderror fieldName="issueDate" /></td>
				</tr>


			</table>
			<table>
				<tr>
					<td width="200"></td>
					<td><s:submit type="image" value="Back" src="images/back.png"
							align="left" /></td>
					<td width="60"></td>

					<td><s:submit type="image" value="Proceed"
							src="images/forward.png" align="right" /></td>
				</tr>
			</table>

		</s:form>
	</s:else>


</body>
</html>