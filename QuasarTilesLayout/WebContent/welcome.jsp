<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@taglib prefix="sjc" uri="/struts-jquery-chart-tags"%>


<head>
<script>
	function doWork() {
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
			}
		}

		xmlhttp.open("GET", "xxx", true);
		xmlhttp.send();
	}
</script>
</head>

<table width="400" align="center" cellpadding="10">
	<tr>
		<td>
			<p>
				Quasar is you for creating this tutorial. It's very clearly written.
				I'm having a problem adding a page to "Part 4: Struts 2 Tiles Plugin
				Tutorial with Example". I added the necessary code to struts.xml,
				tiles.xml, menu.jsp and linkAction.java but it's not working, the
				feedback in the Console section of Eclipse rolls on and on and the
				page does not render. Could you tell me what I missed or what files
				have to be changed to add a page. Thank you

				<s:iterator begin="1" end="10" step="1" status="i">
					Value <s:property value="#i.index" />
					<br>
				</s:iterator>


			</p>

			<div id="myDiv">This is basic text</div> <br>
			<button onclick="doWork()">Click Here</button>
		</td>
</table>