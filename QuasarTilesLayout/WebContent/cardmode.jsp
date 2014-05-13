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
	function validatecard() {
		alert("come to validate method");
		var cardtype = document.getElementsByName("cardType");

		var strcardNumber = document.forms["regmode"]["cardNumber"].value;
		var cardNumber = parseInt(strcardNumber, 10);

		var strtransactionId = document.forms["regmode"]["transactionId"].value;
		var transactionId = parseInt(strtransactionId, 10);

		var cardExpiryDate = document.forms["regmode"]["cardExpiryDate"].value;

		if (cardNumber < 0 || strcardNumber == "") {
			alert("Please enter valid card number!!");
			return false;
		}

		if (transactionId < 0 || strtransactionId == "") {
			alert("Please enter valid transaction id!!");
			return false;
		}

		if (cardExpiryDate == "") {
			alert("Please select Card Expiry Date");
			return false;
		}

		var check = -1;
		for (var i = 0; i < cardtype.length; i++) {
			// 	 alert("Come for radio list");
			if (cardtype[i].checked) {
				// alert("Value is incremented!!");
				check += 1;
			}
		}
		if (check == -1) {
			alert("Please select at least one radio button");
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
		<s:form name="regmode" theme="simple" action="cardmode" method="post"
			onsubmit="return true">
			<table>
				<tr>
					<td><s:label value="Card Type" /></td>
					<td><s:radio label="Card Type" labelSeparator=""
							labelposition="left" name="cardType"
							list="{'Debit Card','Credit Card'}" /></td>
					<td><s:fielderror fieldName="cardType" /></td>
				</tr>

				<tr>
					<td><s:label value="Card Number" /></td>
					<td><s:textfield label="Card Number" labelSeparator=""
							labelposition="left" name="cardNumber" /></td>
					<td><s:fielderror fieldName="cardNumber" /></td>
				</tr>

				<tr>
					<td><s:label value="Transaction ID" /></td>
					<td><s:textfield label="Transaction ID" labelSeparator=""
							labelposition="left" name="transactionId" /></td>
					<td><s:fielderror fieldName="transactionId" /></td>
				</tr>

				<tr>
					<td><s:label value="Expiry Date" /></td>
					<td><sj:datepicker label="Expiry Date" changeMonth="true"
							changeYear="true" labelSeparator="" labelposition="left"
							name="cardExpiryDate" displayFormat="dd/mm/yy" /></td>
					<td><s:fielderror fieldName="cardExpiryDate" /></td>
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