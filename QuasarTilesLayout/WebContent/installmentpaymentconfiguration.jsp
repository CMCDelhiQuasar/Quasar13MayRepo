<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
#studentdetail {
	background-color: white;
	font-family: sans-serif;
	padding: 10px;
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<script type="text/javascript">
	function validateinstallment() {

		alert("come to javascript");
		var strpamount1 = document.forms["installmentform"]["proposedAmount1"].value;
		var pamount1 = parseInt(strpamount1, 10);

		//alert("come to javascript");
		var strpamount2 = document.forms["installmentform"]["proposedAmount2"].value;
		var pamount2 = parseInt(strpamount2, 10);

		//alert("come to javascript");
		var proposeddate1 = document.forms["installmentform"]["proposedDate1"].value;
		var proposeddate2 = document.forms["installmentform"]["proposedDate2"].value;

		if (strpamount1 == "" || pamount1 <= 0) {
			alert("Please check first proposed amount");
			return false;
		}

		if (strpamount2 == "" || pamount2 <= 0) {
			alert("Please check second proposed amount");
			return false;
		}

		if (proposeddate1 == "") {
			alert("Please check first proposed date");
			return false;
		}

		if (proposeddate2 == "") {
			alert("Please check second proposed date");
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

		</table>


		<!-- Fetch the number of Installment Student has opted  -->

		<s:set var="ins" value="#session.NUMBER_OF_INSTALLMENTS" />

		<br />Number of Installments : <s:property value="#ins" />
		<br />
		<s:form name="installmentform" action="installmentconfiguration"
			onsubmit="return true" method="post" theme="simple">
			<s:iterator var="n" begin="1" end="#ins" step="1">


				<h1>Installment ${n}</h1>
				<table>
					<tr>
						<td><s:label value="Proposed Amount" labelposition="left" /></td>
						<td><s:textfield value="0" labelSeparator=""
								labelposition="left" name="proposedAmount%{#n}" /></td>
					</tr>
					<tr>
						<td><s:label value="Proposed Date" labelposition="left" /></td>
						<td><sj:datepicker name="proposedDate%{#n}" minDate="1d"
								changeMonth="true" changeYear="true" labelSeparator=""
								labelposition="left" displayFormat="dd/mm/yy" /></td>
					</tr>
					<tr>
						<td><s:label value="Comments" labelposition="left" /></td>
						<td><s:textarea label="Comments" labelSeparator=""
								labelposition="left" name="comment%{#n}" /></td>
					</tr>
				</table>
				<hr />
			</s:iterator>

			<s:div id="submit">
				<table>
					<tr>
						<td width="250"></td>
						<td><s:submit type="image" value="Back" src="images/back.png"
								align="left" /></td>
						<td width="30"></td>

						<td><s:submit type="image" value="Proceed"
								src="images/forward.png" align="right" /></td>
					</tr>
				</table>
			</s:div>
		</s:form>
	</s:else>

</body>
</html>