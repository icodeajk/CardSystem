<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校园一卡通管理系统</title>
</head>
<%
	String un = request.getParameter("username");
	String url = "left.jsp?username=" + un;
%>
<frameset rows="100,*" cols="*" frameborder="0" border="0" framespacing="0">
	<frame src="top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame"
		title="topFrame" />
	<frameset rows="*" cols="12%,*" framespacing="0" frameborder="yes" border="0" bordercolor="#FFFF00">
		<frame src=<%=url%> name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame"
			title="leftFrame" />
		<frame src="mainframe.jsp" name="mainFrame" id="mainFrame" title="mainFrame" />
	</frameset>
	<noframes>
		<body>

		</body>
	</noframes>
</frameset>
</html>