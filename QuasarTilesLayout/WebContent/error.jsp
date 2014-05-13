<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	background-color: #1568b4;
	background-image: url("images/logo.png");
}

#buggyImageArea {
	background-color: rgb(255, 255, 255);
	background-image: url("animals/zebra.png");
	background-repeat: no-repeat;
	background-position: right;
	width: 500px;
	padding: 10px;
	padding-right: 130px;
	font-family: cursive;
	text-align: center;
	margin: auto;
	right: 50%;
	left: 50%;
	background-image: url("animals/zebra.png");
	border-color: silver;
	border-width: 1px;
	border-style: solid;
	border-bottom-width: 0px;
}



#container {
	background-image: url("images/dots.png");
	border: 1px solid #DDD;
	width: 500px;
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
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<div align="center" id="buggyImageArea">



			<h2>Seems a wild animal attacked has our server !</h2>
			<p>

				<font color="red">Exception ${exception.message}</font>
			</p>

		</div>

		<h1>Errors Details</h1>
		<p>We receive and store any information you enter on our website
			or provide to us in any other way. You can choose not to provide us
			with certain information, but then you may not be able to take
		<ul>
			<li>certain information, but then you may not be able to take</li>
			<li>Lets check all the fields information, but then you may not
				be able to take</li>
		</ul>
		</p>



		<h2>Back to the Home Page</h2>
		<br> <br> <br> <br>


	</div>


	<!-- Some Cool Stuffs Here  -->

	<script type="text/javascript">
		//generateRandomNumber();

		var rand = generateRandomNumber();

		var img = document.getElementById('buggyImageArea');

		switch (rand) {
		case 1:
			img.style.backgroundImage = "url('animals/lion.png')";
			break;
		case 2:
			img.style.backgroundImage = "url('animals/giraffe.png')";
			break;
		case 3:
			img.style.backgroundImage = "url('animals/elephant.png')";
			break;
		case 4:
			img.style.backgroundImage = "url('animals/rhino.png')";
			break;
		case 5:
			img.style.backgroundImage = "url('animals/zebra.png')";
			break;

		default:
			break;
		}

		function generateRandomNumber() {
			var x = Math.round(Math.random() * 10);
			if (x <= 5) {
				return x;
			} else {
				return generateRandomNumber();
			}

		}
	</script>
	</ bod y>
</html>