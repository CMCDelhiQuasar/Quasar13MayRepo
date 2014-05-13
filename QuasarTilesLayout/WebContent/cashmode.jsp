<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<script type="text/javascript">
	function thousand(z) {
		var x = document.getElementById("1000");
		var diplay = document.getElementById(z).value;
		//alert(diplay);
		x.innerHTML = (1000 * diplay);
	}

	function fivehundered(z) {
		var x = document.getElementById("500");
		var diplay = document.getElementById(z).value;
		//alert(diplay);
		x.innerHTML = (500 * diplay);
	}

	function hundered(z) {
		var x = document.getElementById("100");
		var diplay = document.getElementById(z).value;
		//alert(diplay);
		x.innerHTML = (100 * diplay);

	}

	function countfifty(z) {

		var x = document.getElementById("50");

		var diplay = document.getElementById(z).value;
		//alert(diplay);
		x.innerHTML = (50 * diplay);
	}

	function counttwenty(z) {
		var x = document.getElementById("20");
		var diplay = document.getElementById(z).value;
		//alert(diplay);
		x.innerHTML = (20 * diplay);
	}

	function countten(z) {
		var x = document.getElementById("10");
		var diplay = document.getElementById(z).value;
		//alert(diplay);
		x.innerHTML = (10 * diplay);
	}

	function countfive(z) {
		var x = document.getElementById("5");
		var diplay = document.getElementById(z).value;
		//alert(diplay);
		x.innerHTML = (5 * diplay);
	}

	function counttwo(z) {
		var x = document.getElementById("2");
		var diplay = document.getElementById(z).value;
		//alert(diplay);
		x.innerHTML = (2 * diplay);
	}

	function countone(z) {
		var x = document.getElementById("1");
		var diplay = document.getElementById(z).value;
		//alert(diplay);
		x.innerHTML = (1 * diplay);
	}

	function countCourseFee() {

		var x = document.getElementById("total");
		//alert("come to courseFee section");
		var thousand = document.getElementById("1000");
		var thousandvalue = thousand.innerHTML;
		var fivehundered = document.getElementById("500");
		var fivehunderedvalue = fivehundered.innerHTML;
		var hundered = document.getElementById("100");
		var hunderedvalue = hundered.innerHTML;
		var fifty = document.getElementById("50");
		var fiftyvalue = fifty.innerHTML;
		var twenty = document.getElementById("20");
		var twentyvalue = twenty.innerHTML;
		var ten = document.getElementById("10");
		var tenvalue = ten.innerHTML;
		var five = document.getElementById("5");
		var fivevalue = five.innerHTML;
		var two = document.getElementById("2");
		var twovalue = two.innerHTML;
		var one = document.getElementById("1");
		var onevalue = one.innerHTML;
		var sum = parseInt("1", 10);
		sum = parseFloat(thousandvalue) + parseFloat(fivehunderedvalue)
				+ parseFloat(hunderedvalue) + parseFloat(fiftyvalue)
				+ parseFloat(twentyvalue) + parseFloat(tenvalue)
				+ parseFloat(fivevalue) + parseFloat(twovalue)
				+ parseFloat(onevalue);

		x.innerHTML = sum * 1;

		//	window.confirm(sum);
	}

	function checkoutamount() {
		var cashamount = document.forms["regcash"]["cashAmount"].value;
		var totalvar = document.getElementById("total");
		var total=totalvar.innerHTML;
		if (parseFloat(total) != parseFloat(cashamount)) {
			alert("Please enter "+cashamount+" Rs")
			return false;
		} else {
			return true;
		}

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
		<h1>Cash Mode Details</h1>
		<s:form name="regcash" action="cashmode"
			onsubmit="return checkoutamount()" theme="simple">
			<table border="0">
				<tr>
					<td><s:label name="simple" value="Payment Mode for"
							labelposition="left" labelSeparator=":" /></td>
				</tr>
				<tr>
					<td><s:label name="studentName" value="Student Name" /></td>
					<td></td>
				</tr>
				<tr>
					<td><s:label name="studentEmail" value="Student Email" /></td>
					<td></td>
				</tr>
				<tr>
					<td><s:label name="regAmt" value="for the payment of Rs. "
							labelSeparator="" labelposition="left" /></td>

					<td><s:label name="cashAmount" label="Cash Amount"
							labelSeparator="" labelposition="left" /></td>
					<td><s:hidden name="cashAmount"
							value="%{#session.shagird.feeDetails.courseFees}" /> <s:property
							value="#session.shagird.feeDetails.courseFees" /></td>

				</tr>

				<tr>
					<td><s:label value="Enter 1000 Notes" /></td>
					<td><s:select id="thousandnotes" name="thousandnotes"
							label="1000 x" labelSeparator="" labelposition="left"
							onclick="thousand(this.id)" onkeypress="thousand(this.id)"
							onfocus="countCourseFee()" onmouseout="countCourseFee()"
							list="{'0','1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20'}" /></td>
					<td><div id="1000">0</div></td>
				</tr>

				<tr>
					<td><s:label value="Enter 500 Notes" /></td>
					<td><s:select id="fivehundred" name="fivehundred"
							label="500 x" labelSeparator="" labelposition="left"
							onclick="fivehundered(this.id)" onfocus="countCourseFee()"
							onmouseout="countCourseFee()"
							list="{'0','1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20'}" /></td>
					<td><div id="500">0</div></td>
				</tr>


				<tr>
					<td><s:label value="Enter 100 Notes" /></td>
					<td><s:select id="hundred" name="hundred" label="100 x"
							labelSeparator="" labelposition="left"
							onclick="hundered(this.id)" onfocus="countCourseFee()"
							onmouseout="countCourseFee()"
							list="{'0','1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20'}" /></td>
					<td><div id="100">0</div></td>
				</tr>

				<tr>
					<td><s:label value="Enter 50 Notes" /></td>
					<td><s:select id="fifty" name="fifty" label="50 x"
							labelSeparator="" labelposition="left"
							onclick="countfifty(this.id)" onfocus="countCourseFee()"
							onmouseout="countCourseFee()"
							list="{'0','1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20'}" /></td>
					<td><div id="50">0</div></td>
				</tr>

				<tr>
					<td><s:label value="Enter 20 Notes" /></td>
					<td><s:select id="twenty" name="twenty" label="20 x"
							labelSeparator="" labelposition="left"
							onclick="counttwenty(this.id)" onfocus="countCourseFee()"
							onmouseout="countCourseFee()"
							list="{'0','1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20'}" /></td>
					<td><div id="20">0</div></td>
				</tr>

				<tr>
					<td><s:label value="Enter 10 Notes" /></td>
					<td><s:select id="ten" name="ten" label="10 x"
							labelSeparator="" labelposition="left"
							onclick="countten(this.id)" onfocus="countCourseFee()"
							onmouseout="countCourseFee()"
							list="{'0','1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20'}" /></td>
					<td><div id="10">0</div></td>
				</tr>

				<tr>
					<td><s:label value="Enter 5 Notes" /></td>
					<td><s:select id="five" name="five" label="5 x"
							labelSeparator="" labelposition="left"
							onclick="countfive(this.id)" onfocus="countCourseFee()"
							onmouseout="countCourseFee()"
							list="{'0','1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20'}" /></td>
					<td><div id="5">0</div></td>
				</tr>

				<tr>
					<td><s:label value="Enter 2 Notes" /></td>
					<td><s:select id="two" name="two" label="2 x"
							labelSeparator="" labelposition="left"
							onclick="counttwo(this.id)" onfocus="countCourseFee()"
							onmouseout="countCourseFee()"
							list="{'0','1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20'}" /></td>
					<td><div id="2">0</div></td>
				</tr>

				<tr>
					<td><s:label value="Enter 1 Notes" /></td>
					<td><s:select id="one" name="one" label="1 x"
							labelSeparator="" labelposition="left"
							onclick="countone(this.id)" onfocus="countCourseFee()"
							onmouseout="countCourseFee()"
							list="{'0','1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20'}" />
					</td>
					<td><div id="1">0</div></td>
				</tr>

				<tr>
					<td><s:label value="Total" /></td>
					<td></td>
					<td><div id="total"></div></td>
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
								onfocus="countCourseFee()" onmouseout="countCourseFee()"
								src="images/forward.png" /></td>
					</s:div>
				</tr>
			</table>
		</s:form>
	</s:else>

</body>
</html>