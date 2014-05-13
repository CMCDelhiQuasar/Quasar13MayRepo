<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="sjc" uri="/struts-jquery-chart-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head jqueryui="true" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="right">
		<h3>
			Number of Registration

			<s:if test="dateFromMapAllCourse.size() != 0 ">
 			- All Courses 
	</s:if>

			<s:if test="dateFromMapJava.size() != 0 ">
		-  Java SE 
	</s:if>


			<s:if test="dateFromMapJ2EE.size() != 0 ">
 			- Java EE 
	</s:if>

			<s:if test="dateFromMapAndroid.size() != 0 ">
 			- Android 
	</s:if>
			<s:if test="dateFromMapPhp.size() != 0 ">
 			- Php
	</s:if>

			<s:if test="dateFromMapDotNet.size() != 0 ">
 			- .Net
	</s:if>

		</h3>
	</div>
	<sjc:chart id="chartDate" xaxisMode="time" xaxisTimeformat="%d"
		xaxisMin="%{minTime}" xaxisMax="%{maxTime}" xaxisColor="#1568b4"
		yaxisColor="#1568b4" xaxisTickSize="[1, 'day']" xaxisTickColor="#EEE"
		yaxisTickColor="#EEF" yaxisTickSize="1"
		cssStyle="width: 97%; height: 400px;" xaxisLabel="Dates"
		yaxisLabel="No. of Regisatrations">

		<s:if test="dateFromMapAllCourse.size() != 0 ">
			<sjc:chartData id="chartDateAll" label="All Courses"
				list="dateFromMapAllCourse" color="#1568b4" lines="{ show: true }"
				curvedLines="true" curvedLinesFit="true" />
		</s:if>

		<s:if test="dateFromMapJava.size() != 0 ">
			<sjc:chartData id="chartDateJavaSE" label="Java SE"
				list="dateFromMapJava" color="#faa31b" lines="{ show: true }"
				curvedLines="true" curvedLinesFit="true" />
		</s:if>


		<s:if test="dateFromMapJ2EE.size() != 0 ">
			<sjc:chartData id="chartDateJavaEE" label="Java EE"
				list="dateFromMapJ2EE" color="#ef4444" lines="{ show: true }"
				curvedLines="true" curvedLinesFit="true" />
		</s:if>


		<s:if test="dateFromMapAndroid.size() != 0 ">
			<sjc:chartData id="chartDateAndroid" label="Android"
				list="dateFromMapAndroid" color="#82c341" lines="{ show: true }"
				curvedLines="true" curvedLinesFit="true" />
		</s:if>


		<s:if test="dateFromMapPhp.size() != 0 ">
			<sjc:chartData id="chartDatePhp" label="Php" list="dateFromMapPhp"
				color="#fff000" lines="{ show: true }" curvedLines="true"
				curvedLinesFit="true" />
		</s:if>


		<s:if test="dateFromMapDotNet.size() != 0 ">
			<sjc:chartData id="chartDateDotNet" label=".Net"
				list="dateFromMapDotNet" color="#d54799" lines="{ show: true }"
				curvedLines="true" curvedLinesFit="true" />
		</s:if>




	</sjc:chart>

	<br>
	<br>

	<table border="0">
		<s:form action="analytics" theme="simple">
			<tr>
				<td><s:label value="Start Date" /></td>
				<td><sj:datepicker name="startdate" displayFormat="dd/mm/yy" /></td>
				<td><s:label value="End Date" /></td>
				<td><sj:datepicker name="enddate" displayFormat="dd/mm/yy" /></td>
			</tr>
			<tr>
				<td><s:checkbox name="checkall" /></td>
				<td>All</td>

			</tr>
			<tr>
				<td><s:checkbox name="checkj2se" /></td>
				<td><s:label value="J2SE" /></td>

			</tr>

			<tr>
				<td><s:checkbox name="checkj2ee" /></td>
				<td><s:label value="J2EE" /></td>

			</tr>
			<tr>
				<td><s:checkbox name="checkandriod" /></td>
				<td><s:label value="Anriod" /></td>

			</tr>
			<tr>
				<td><s:checkbox name="checkdotnet" /></td>
				<td><s:label value=">Net" /></td>

			</tr>
			<tr>
				<td><s:checkbox name="checkphp" /></td>
				<td><s:label value="PHP" /></td>

			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><s:submit value="Analyse" /></td>
			</tr>

		</s:form>
	</table>


	<!--  <sjg:grid id="gridtable" caption="Customer Examples" dataType="json"
		href="grid-data-provider" pager="true" gridModel="gridModel"
		rowList="2,5,10" rowNum="5" rownumbers="true" navigator="true"
		navigatorEdit="false" navigatorView="true" navigatorDelete="false"
		navigatorViewOptions="{'width':'700'}" navigatorAdd="false"
		navigatorSearch="false" altRows="true">
		<sjg:gridColumn name="studentId" index="id" title="St.ID"
			formatter="integer" sortable="false" width="20" />
		<sjg:gridColumn name="name" index="name" title="Name" sortable="true"
			width="80" align="center" />
		<sjg:gridColumn name="contactNumber" title="Contact Number"
			sortable="false" width="80" />
		<sjg:gridColumn name="courseName" title="Course Name" sortable="false"
			width="80" />

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


	</sjg:grid>
-->
</body>
</html>