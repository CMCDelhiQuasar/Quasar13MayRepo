<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@taglib prefix="sjc" uri="/struts-jquery-chart-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
html {
	font-size: 15px;
}

body {
	color: #333;
	font-family: arial, helvetica, sans-serif;
	color: #333;
	font-size: 13px;
}

body {
	font-family: Arial, sans-serif;
	font-size: 13px;
}

html {
	color: #333;
}

html {
	font-size: 13px;
}

body {
	background-color: #1568b4;
}

hr {
	background-color: #EEE;
	border: 0;
	height: 1px;
}

#container {
	background-color: #1568b4;
	border: 1px solid #DDD;
	margin-top: 20px;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	border: 1px solid #E9E9E9;
	-webkit-border-radius: 4px;
	box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);
	-moz-box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);
	-webkit-box-shadow: 0 4px 6px -5px rgba(0, 0, 0, 0.8);
	border: 1px solid #DDD;
	box-shadow: 0 1px 4px rgba(0, 0, 0, 0.5);
}

#content {
	background-color: white;
	border: 1px solid #DDD;
	margin: 20px 0;
	padding: 20px;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);
	-moz-box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);
	-webkit-box-shadow: 0 4px 6px -5px rgba(0, 0, 0, 0.8);
}

#sidemenu {
	/* -webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.2); */
	/*box-shadow: 0 1px 4px rgba(0, 0, 0, 0.2);*/
	
}
</style>

</head>
<body>
	<table id="container" width="95%" cellspacing="0" align="center"
		bgcolor="white">
		<tr>
			<td><sjg:grid id="gridtable" caption="Customer Examples"
					dataType="json" href="grid-data-provider" pager="true"
					gridModel="gridModel" rowList="5,10,20" rowNum="15"
					rownumbers="true" navigator="true" navigatorEdit="false"
					navigatorView="true" navigatorDelete="false" navigatorAdd="false"
					navigatorSearch="false" altRows="true">

					<sjg:gridColumn name="studentId" index="id" title="St.ID"
						formatter="integer" sortable="false" width="20" />
					<sjg:gridColumn name="name" index="name" title="Name"
						sortable="true" align="center" />
					<sjg:gridColumn name="contactNumber" title="Contact Number"
						sortable="false" />
					<sjg:gridColumn name="courseName" title="Course Name"
						sortable="false" />

					<sjg:gridColumn name="feeDetails.totalFee" title="Total Fee"
						formatter="currency" sortable="false" width="100" />
					<sjg:gridColumn name="emailId" title="Email ID" sortable="false" />

					<sjg:gridColumn name="feeDetails.courseFees" title="Course Fee"
						formatter="currency" sortable="false" />
					<sjg:gridColumn name="feeDetails.discountAvailable"
						title="Discount Available" formatter="currency" sortable="false" />
					<sjg:gridColumn name="feeDetails.serviceTax" title="Service Tax"
						sortable="false" />
					<sjg:gridColumn name="feeDetails.fine" title="Fine"
						formatter="currency" sortable="false" />

				</sjg:grid></td>
		</tr>


	</table>

</body>
</html>