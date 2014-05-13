<%@ page language="java" contentType="text/html; charset=iso-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
html {
	font-size: 15px;
}

body {
	font-family: 'open-sans', 'Helvetica Neue', Helvetica, Arial, sans-serif;
	font-weight: 300;
	font-size: 12px;
	line-height: 1.4;
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
	/*background-image: url("images/dots.png"); */
	/*background-color:white;
background-image: radial-gradient(#1568b4 1%, transparent 20%),
radial-gradient(#1568b4 1%, transparent 20%);
background-size:10px 10px;
background-position: 0 0, 30px 30px;
	*/
	background-color: #FFFFF5; background-image : linear-gradient( 90deg,
	transparent 79px, #abced4 79px, #abced4 81px, transparent 81px),
	linear-gradient( #eee .1em, transparent .1em);
	background-size: 50% 1.2em;
	border: 1px solid #DDD;
	padding: 20px;
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
	border: 1px solid #DDD;
	background-image: linear-gradient(90deg, transparent 79px, #abced4 79px, #abced4 81px,
		transparent 81px), linear-gradient(#eee .1em, transparent .1em);
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
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Insert title here</title>
</head>
<body topmargin="0">

	<table id="container" width="85%" cellspacing="0" align="center"
		bgcolor="white">
		<tr>
			<td colspan="2" height="70"><tiles:insertAttribute name="header" /></td>
		</tr>

		<tr>
			<td width="10%" id="sidemenu" valign="top"><tiles:insertAttribute
					name="sideMenu" /></td>
			<td width="90%" id="content"><tiles:insertAttribute name="body" /></td>
		</tr>
		<tr>
			<td colspan="2" height="1"><tiles:insertAttribute name="footer" />
			</td>
		</tr>
	</table>

</body>
</html>