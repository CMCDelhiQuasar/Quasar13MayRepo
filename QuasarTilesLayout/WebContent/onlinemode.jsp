<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<script type="text/javascript">
	function validateform() {

		var strtransactionId = document.forms["onlineform"]["transactionId"].value;
		var transactionId = parseInt(strtransactionId, 10);

		var strreicptNumber = document.forms["onlineform"]["reicptNumber"].value;
		var reicptNumber = parseInt(strreicptNumber, 10);

		if (strtransactionId == "" || transactionId <= 0) {
			alert("Please check transaction ID!!!");
			return false;
		}

		if (strreicptNumber == "" || reicptNumber <= 0) {
			alert("Please check Reciept Number!!!");
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
				<td colspan="4"><h2>Welcome</h2></td>
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

		<h1>Online Transaction Details</h1>
		<s:form name="onlineform" theme="simple"
			onsubmit="return true" method="post" action="onlinemode">
			<table>
				<tr>
					<td><s:label value="Transaction Id" /></td>
					<td><s:textfield labelSeparator="" labelposition="left"
							name="transactionId" /></td>
					<td><s:fielderror fieldName="transactionId" /></td>
				</tr>
				<tr>
					<td><s:label value="Reicpt Number" /></td>
					<td><s:textfield value="0" labelSeparator=""
							labelposition="left" name="reicptNumber" /></td>
					<td><s:fielderror fieldName="transactionId" /></td>
				</tr>
			</table>
			<table border="0">
				<tr>
					<s:div>
						<td width="250"></td>
						<td><s:submit type="image" value="Back" src="images/back.png"
								align="left" /></td>
						<td width="30"></td>

						<td><s:submit type="image" value="Proceed"
								src="images/forward.png" /></td>

					</s:div>
				</tr>
			</table>
		</s:form>
	</s:else>


</body>
</html>