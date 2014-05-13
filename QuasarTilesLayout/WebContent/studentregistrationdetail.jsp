<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>
</style>
<script type="text/javascript">
	function validateclient() {
		//alert("come to javascript validation");
		var studentname = document.forms["regform"]["studentname"].value;
		var studentemail = document.forms["regform"]["studentemail"].value;
		var pattern = /^[a-zA-Z0-9\-_]+(\.[a-zA-Z0-9\-_]+)*@[a-z0-9]+(\-[a-z0-9]+)*(\.[a-z0-9]+(\-[a-z0-9]+)*)*\.[a-z]{2,4}$/;

		var course = document.forms["regform"]["coursename"].value;
		var strcont = document.forms["regform"]["contact"].value;
		var contact = parseInt(strcont, 10);

		var strcoursefee = document.forms["regform"]["coursefee"].value;
		var coursefee = parseInt(strcoursefee, 10);

		var strstax = document.forms["regform"]["servicetax"].value;
		var servicetax = parseFloat(strstax);

		var strdiscount = document.forms["regform"]["discount"].value;
		var discount = parseFloat(strdiscount);

		var strfine = document.forms["regform"]["fine"].value;
		var fine = parseInt(strfine, 10);

		var strregistrationamount = document.forms["regform"]["registrationamount"].value;
		var registrationamount = parseInt(strregistrationamount, 10);
		var val = coursefee + servicetax + discount - fine;
		//document.forms["regform"]["total"].value = val;
		//window.confirm(document.forms["regform"]["total"].value);

		//alert("come here");
		if (studentname.length < 3) {
			alert("Length should be greater then 3 char");
			return false;
		}
		if (!pattern.test(studentemail)) {
			alert("Bad email address.!!!");
			return false;
		}

		if (course == "Select") {
			alert("Please select valid course!!");
			return true;
		}

		if (contact<=0 || contact>9999999999 || strcont == "") {
			alert("Contact should be 10 digit long!!!");
			return false;
		}

		if (coursefee<0||coursefee>9999999 || strcoursefee == "") {
			alert("Course fee can not be less then 0");
			return false;
		}

		if (servicetax<0.0||servicetax>100 || strstax == "") {
			alert("Enter valid service tax!!");
			return false;
		}

		if (discount<0.0||discount>100 || strdiscount == "") {
			alert("Enter valid discount!!");
			return false;
		}

		if (fine < 0 || strfine == "") {
			alert("Fine can not less then 0!!");
			return false;
		}

		if (registrationamount < 0 || strregistrationamount == "") {
			alert("Enter valid registration amount!!");
			return false;
		}

		return true;

	}

	function calculatefee() {
		var coursefe = document.forms["regform"]["coursefee"].value;
		var serviceTax = document.forms["regform"]["servicetax"].value;
		var discount = document.forms["regform"]["discount"].value;
		var fine = document.forms["regform"]["fine"].value;
		document.forms["regform"]["total"].value = parseInt(coursefe, 10)
				+ ((parseInt(coursefe, 10)*parseFloat(serviceTax))/100) - parseFloat(discount)
				+ parseFloat(fine);
		//window.confirm(document.forms["regform"]["total"].value);
		return true;

	}
	function display() {

		var ch = document.getElementsByName("paymenttype");
		var check = -1;

		if (ch[0].checked == true) {
			//	alert("come to fullfee");
			document.getElementsByName("totalinstallments").style.display = 'none';

		}

		if (ch[1].checked == true) {
			//	alert("come to installment");
			document.getElementsByName("totalinstallments").style.display = 'none';
		}

	}

	//function verifyEmailId(fld) {

	//	var emailId = fld.value;

	//	var xmlhttp = new XMLHttpRequest();

	//	xmlhttp.onreadystatechange = function() {
	//		if (xmlhttp.readyState == 1) {
	//			document.getElementById("myDiv").innerHTML = "Checking Email Id Please Wait .. . .";
	//		}
	//		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
	//			document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
	//		}
	//	}

	//	xmlhttp.open("GET", "verifyEmailId?emailId=" + emailId, true);
	//	xmlhttp.send();

	//verifyEmailId
	//}
</script>



<sj:head jqueryui="true" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Student Registration Page...</title>

</head>
<body>

	<div>
		<h3 align="center">
			<img src="images/student.png" alt="Student" /> Student Registration
			Details
		</h3>
	</div>
	<h2>Basic Details</h2>
	<s:form name="regform" theme="simple" action="registration"
		onsubmit="return validateclient()" method="post">
		<table border="0">
			<s:div id="basicDetails">
				<tr>
					<td><s:label value="Name of the Student" labelSeparator=""
							labelposition="left" /></td>
					<td><s:textfield label="Name of the Student" labelSeparator=""
							labelposition="left" name="studentname" /></td>
					<td><s:fielderror fieldName="studentname" /></td>
				</tr>
				<tr>
					<td><s:label value="Email Id" labelSeparator=""
							labelposition="left" /></td>
					<td><s:textfield label="Email Id" labelSeparator=""
							labelposition="left" name="studentemail" /></td>
					<td><s:fielderror fieldName="studentemail" /></td>
					<td><div id="myDiv"></div></td>
				</tr>
				<tr>
					<td><s:label value="Course" labelSeparator=""
							labelposition="left" /></td>
					<td><s:select name="coursename" list="%{#{'Select':'Select'}}"
							label="Course" labelSeparator="">
							<s:optgroup label="6 Weeks"
								list="#{'Java SE':'Java SE','Java EE':'Java EE','Android':'Android','.Net':'.Net','Php':'Php','C/C++':'C/C++','Cloud Computing':'Cloud Computing','Java EE':'Java EE','Java SE':'Java SE','Java EE':'Java EE'}" />
							<s:optgroup label="6 Months"
								list="#{'Java SE':'Java SE','Java EE':'Java EE','Android':'Android','.Net':'.Net','Php':'Php','C/C++':'C/C++','Cloud Computing':'Cloud Computing','Java EE':'Java EE','Java SE':'Java SE','Java EE':'Java EE'}" />
							<s:optgroup label="6 Months Weekend"
								list="#{'Java SE':'Java SE','Java EE':'Java EE','Android':'Android','.Net':'.Net','Php':'Php','C/C++':'C/C++','Cloud Computing':'Cloud Computing','Java EE':'Java EE','Java SE':'Java SE','Java EE':'Java EE'}" />
							<s:optgroup label="6 Weeks Weekend"
								list="#{'Java SE':'Java SE','Java EE':'Java EE','Android':'Android','.Net':'.Net','Php':'Php','C/C++':'C/C++','Cloud Computing':'Cloud Computing','Java EE':'Java EE','Java SE':'Java SE','Java EE':'Java EE'}" />
							<s:optgroup label="Edge"
								list="#{'.Net':'.Net','Core Java':'Core Java'}" />
							<s:optgroup label="Other" list="#{'Other':'Other'}" />
						</s:select></td>
					<td><s:fielderror fieldName="coursename" /></td>
				</tr>
				<tr>
					<td><s:label value="Contact Number" labelSeparator=""
							labelposition="left" /></td>
					<td><s:textfield label="Contact Number" labelSeparator=""
							labelposition="left" name="contact" /></td>
					<td><s:fielderror fieldName="contact" /></td>
				</tr>
			</s:div>
		</table>
		<hr />
		<hr />

		<h2>Fee Details</h2>
		<table border="0">
			<s:div id="paymentDetails">
				<tr>
					<td><s:label value="Course Fees" labelSeparator=""
							labelposition="left" /></td>
					<td><sj:textfield label="Course Fees" labelSeparator=""
							labelposition="left" name="coursefee" value="10000"
							onkeypress="return calculatefee()"
							onkeyup="return calculatefee()" onfocus="return calculatefee()"
							onmouseout="return calculatefee()" /></td>
					<td><s:fielderror fieldName="coursefee" /></td>
				</tr>

				<tr>
					<td><s:label value="Service Tax(%)" labelSeparator=""
							labelposition="left" /></td>
					<td><sj:textfield label="Service Tax(%)" labelSeparator=""
							value="10.45" labelposition="left"
							onkeypress="return calculatefee()"
							onkeyup="return calculatefee()"
							onmouseout="return calculatefee()"
							onfocus="return calculatefee()" name="servicetax" /></td>
					<td><s:fielderror fieldName="servicetax" /></td>
				</tr>

				<tr>
					<td><s:label value="Discount(Rs.)" labelSeparator=""
							labelposition="left" /></td>
					<td><sj:textfield label="Discount(%)" labelSeparator=""
							value="10" labelposition="left"
							onkeypress="return calculatefee()"
							onkeyup="return calculatefee()"
							onmouseout="return calculatefee()"
							onfocus="return calculatefee()" name="discount" /></td>
					<td><s:fielderror fieldName="discount" /></td>
				</tr>

				<tr>
					<td><s:label value="Fine(if any in Rs.)" labelSeparator=""
							labelposition="left" /></td>
					<td><sj:textfield label="Fine(if any)" labelSeparator=""
							value="10" labelposition="left"
							onkeypress="return calculatefee()"
							onkeyup="return calculatefee()"
							onmouseout="return calculatefee()"
							onfocus="return calculatefee()" name="fine" /></td>
					<td><s:fielderror fieldName="fine" /></td>
				</tr>

				<tr>
					<td><s:label value="Total" labelSeparator=""
							labelposition="left" /></td>
					<td><s:textfield label="Total" labelSeparator=""
							labelposition="left" name="total" disabled="true" value="0.0" /></td>
				</tr>
			</s:div>
		</table>
		<hr />
		<hr />
		<h2>Payment Details</h2>
		<table>
			<s:div id="radio">
				<tr>
					<td><s:label value="Payment Type" labelSeparator=""
							labelposition="left" /></td>
					<td><s:radio list="{'Full Fees','Installment'}"
							onclick="display()" name="paymenttype" label="Payment Type"
							value="%{'Full Fees'}" labelSeparator="" labelposition="left" /></td>
					<td><s:fielderror fieldName="paymenttype" /></td>
				</tr>
			</s:div>
			<s:div>
				<tr>
					<td><s:label value="Number of Installments" labelSeparator=""
							labelposition="left" /></td>
					<td><s:select name="totalinstallments" cssStyle=""
							headerKey="-1" headerValue="Select"
							list="#{'2':'2','3':'3','4':'4','5':'5','6':'6','7':'7','8':'8','9':'9','10':'10'}"
							label="Number of Installments" labelSeparator="" /></td>
					<td><s:fielderror fieldName="totalinstallments" /></td>
				</tr>

				<tr>
					<td><s:label value="Registration Amount" labelSeparator=""
							labelposition="left" /></td>
					<td><s:textfield name="registrationamount"
							label="Registration Amount" labelSeparator=""
							labelposition="left" /></td>
					<td><s:fielderror fieldName="registrationamount" /></td>
				</tr>
			</s:div>
		</table>
		<hr />
		<hr />
		<table border="0">
			<tr>
				<s:div>
					<td width="250"></td>
					<td><s:reset value="Reset" src="images/back.png" align="left" /></td>
					<td width="30"></td>

					<td><s:submit onfocus="return calculatefee()" type="image"
							value="Proceed" src="images/forward.png" /></td>

				</s:div>
			</tr>
		</table>
	</s:form>
</body>
</html>