<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style type="text/css">
#pendingpaymentcontactbox {
	/*	background-color: #F7F7F9;  */
	background-color: #fff;
	background-image: linear-gradient(90deg, transparent 79px, #abced4 79px, #abced4 81px,
		transparent 81px), linear-gradient(#eee .1em, transparent .1em);
	background-size: 85% 1.2em;
	
	
	
	padding: 20px;
	margin: 20px 0px;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	width: 300px;
	padding: 4px;
	margin: 4px;
	overflow: hidden;
	margin: 4px;
	border: 1.5px solid #ccc;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Pending Payment Page
	<s:iterator var="p" value="obtainePendingPayments()">
		<div id="pendingpaymentcontactbox">
			<input type="checkbox" name="nothing" /> <span
				style="color: #76797c; font-size: 95%; float: right;"> <s:property
					value="#p.paymentStatus" />
			</span> <br> <img src="images/student.png" alt="Student" title="{Name}"
				alt="{Name}" style="float: left;"> <span
				style="color: #76797c; font-size: 95%; float: right;">
				Payment ID : <s:property value="#p.paymentID" />
			</span><br> <br> <br>
			<div style="font-weight: bold; font-size: 150%; padding-top: 8px">
				<a style="color: #000000; text-decoration: none;" target="_blank"
					href="{Website}"><s:property value="#p.student.name" /></a>
			</div>
			<div>
				<s:property value="#p.student.emailId" />
			</div>
			<div style="padding-bottom: 12px">
				<span style="color: #76797c; font-size: 95%;">Due :</span> Rs.
				<s:property value="#p.paymentDetails.proposedAmount" />
				for Payment Type <br> <span
					style="color: #76797c; font-size: 95%;">Proposed Date :</span>
				<s:property value="#p.paymentDetails.proposedDate" />
				<br> <span style="color: #76797c; font-size: 95%;">Course
					:</span>
				<s:property value="#p.student.courseName" />
			</div>
			<div>

				<span style="color: #76797c; font-size: 150%; float: right;">
					<s:property value="#p.student.contactNumber" />
				</span> <span style="color: #76797c; float: left;"><a href="ap">
						<img src="images/mail.png" style="bottom: 1px;" height="30"
						width="30" alt="Send Mail Remainder">
				</a> </span>


			</div>
		</div>

		<br>
	</s:iterator>

</body>
</html>