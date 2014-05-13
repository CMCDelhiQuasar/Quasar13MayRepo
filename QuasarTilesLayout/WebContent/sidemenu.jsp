<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sj:head jqueryui="true" />
</head>
<body>

	<sj:accordion id="student" collapsible="false" openOnMouseover="false"
		heightStyle="content" animate="true">
		<sj:accordionItem title="Student">
			<ul type="none">
				<li><div align="left">
						<a href="registration.jsp"> <img src="images/addstudent.png" /></a>
					</div></li>
				<li><a href="deletestudentwrapper.jsp"><img
						src="images/deletestudent.png"></a></li>
				<li><img src="images/starred.png"></li>
			</ul>
		</sj:accordionItem>

		<sj:accordionItem title="Payment">
			<ul type="none">
				<li><a href="registration.jsp"><img src="images/002.png"></img></a></li>

				<li><a href="pendingpayment"><img src="images/calendar.png" /></a></li>
			</ul>
		</sj:accordionItem>

		<sj:accordionItem title="History">
			<ul type="none">
				<li>A</li>
				<li>B</li>
			</ul>


			<sj:accordionItem title="Print">
				<ul type="none">
					<li>R</li>
					<li>R</li>
				</ul>
			</sj:accordionItem>
		</sj:accordionItem>

	</sj:accordion>





</body>
</html>