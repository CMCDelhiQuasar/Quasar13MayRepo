<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertTemplate template="/layout.jsp">
	<tiles:putAttribute name="title" value="www.bismillah.com -Home Page"
		type="string" />
	<tiles:putAttribute name="header" value="/header.jsp" />
	<tiles:putAttribute name="sideMenu" value="/sidemenu.jsp" />
	<tiles:putAttribute name="body" value="/chequemode.jsp" />
	<tiles:putAttribute name="footer" value="/footer.jsp" />
</tiles:insertTemplate>