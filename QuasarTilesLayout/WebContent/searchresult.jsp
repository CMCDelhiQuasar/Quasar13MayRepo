<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="sjg"
	uri="/struts-jquery-grid-tags"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head jqueryui="true" />


<style type="text/css">
#box {
	/*background-color: #F7F7F9; */
	background-color: #FFFFE0;
	background-image: linear-gradient(#eee .1em, transparent .1em);
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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<s:if test="queryResultStudentList.size()!=0">

		<div align="right">
			Search Result :
			<s:property value="queryResultStudentList.size()" />
			records found
		</div>
		<hr>
		<s:iterator var="s" value="queryResultStudentList">
			<div id="box">
				<div style="font-weight: bold; font-size: 150%; padding-top: 8px">
					<img src="images/student.png" /><a
						style="color: #000000; text-decoration: none;"><s:property
							value="#s.name" /></a>
				</div>
				<s:property value="#s.emailId" />
				<a
					href="searchstudent?emailId=<s:property
							value="#s.emailId" />"><img
					src="images/forward.png" align="right" /></a> <br>
			</div>
		</s:iterator>
	</s:if>



	<s:if test="queryResultPaymentList.size()!=0">

		<div align="right">
			Search Result :
			<s:property value="queryResultPaymentList.size()" />
			records found
		</div>
		<hr>

		<hr>

		<s:iterator var="p" value="queryResultPaymentList">
			<div id="box">
				<img src="images/payment.png" /> Payment of Rs
				<s:property value="#p.paymentDetails.proposedAmount" />
				<br> Desposited Rs .
				<s:property value="#p.paymentDetails.depositedAmount" />
				<br> for <a style="color: #000000; text-decoration: none;"><s:property
						value="#p.student.name" /></a> <a
					href="searchstudent?emailId=<s:property
							value="#p.student.emailId" />"><img
					src="images/forward.png" align="right" /></a> <br>
			</div>
		</s:iterator>
	</s:if>

	<s:if
		test=" queryResultPaymentList.size()==0 && queryResultStudentList.size()==0 ">
		<h1>No Records Found !</h1>
	</s:if>

</body>
</html>