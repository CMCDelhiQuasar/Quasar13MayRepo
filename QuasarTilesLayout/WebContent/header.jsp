<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
input {
	outline: none;
}

input[type=search] {
	-webkit-appearance: textfield;
	-webkit-box-sizing: content-box;
	font-family: inherit;
	font-size: 100%;
}

input::-webkit-search-decoration,input::-webkit-search-cancel-button {
	display: none;
}

input[type=search] {
	background: #ededed url(images/search.png) no-repeat 9px center;
	border: solid 1px #ffffff;
	padding: 9px 10px 9px 32px;
	width: 30px;
	-webkit-border-radius: 10em;
	-moz-border-radius: 10em;
	border-radius: 10em;
	-webkit-transition: all .5s;
	-moz-transition: all .5s;
	transition: all .5s;
}

input[type=search]:focus {
	width: 150px;
	background-color: #fff;
	border-color: #ffffff;
	-webkit-box-shadow: 0 0 5px rgba(109, 207, 246, .5);
	-moz-box-shadow: 0 0 5px rgba(109, 207, 246, .5);
	box-shadow: 0 0 5px rgba(109, 207, 246, .5);
}
</style>

<table width="100%" height="100%">

	<tr>

		<td align="left" valign="top">
			<div valign="top">&nbsp;&nbsp;&nbsp;
				<a href=""><img src="images/logo.png" alt="CMC Ltd" /> <img
					alt="" align="bottom" src="images/homecolor.png" /></a>&nbsp;&nbsp;&nbsp;
				<a href=""><img alt="" align="bottom" src="images/setting.png" />
				</a>&nbsp;&nbsp;&nbsp;<a href="analyticswrapper.jsp"><img alt=""
					align="bottom" src="images/analytics.png" /> </a> <a
					href="console.jsp"><img alt="" align="bottom"
					src="images/console.png" /></a>
			</div>
		</td>

		<td align="center" valign="top">
			<div>
				<s:form action="globalsearch" theme="simple">
					<s:textfield label="" type="search" labelposition="left"
						name="queryString" />
				</s:form>

			</div>
		</td>
		<td align="right" valign="top">

			<div
				style="background-image: url('images/quasar_logo.png'); background-repeat: no-repeat; width: 110px">
				<span style="font-size: 170%">Quasar</span>
			</div>
		</td>

	</tr>
</table>
