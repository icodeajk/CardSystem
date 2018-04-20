<%@ page import="dao.UserDaoImpl"%>
<%@ page import="vo.xiqu"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyMessage</title>

<link href="CSS/table.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		String un = request.getParameter("username");
	%>

	<%
		UserDaoImpl dao = new UserDaoImpl();
		List<xiqu> list = dao.queryAll();
		Iterator<xiqu> it = list.iterator();
		while (it.hasNext()) {
			xiqu xiqu = it.next();

			if (un.equals(xiqu.getUsername())) {
				String c = "不允许";

				if (xiqu.getDoor() == 1) {
					c = "允许";
				}
	%>
	<table class="hovertable">
		<caption>个人信息表</caption>
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<th>学号</th>
			<td><%=xiqu.getUsername()%></td>
		</tr>
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<th>姓名</th>
			<td><%=xiqu.getName()%></td>
		</tr>
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<th>职位</th>
			<td><%=xiqu.getWork()%></td>
		</tr>
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<th>钱余额</th>
			<td><%=xiqu.getMoney()%>元</td>
		</tr>
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<th>门禁</th>
			<td><%=c%></td>
		</tr>
	</table>
	<%
		}
	%>

	<%
		}
	%>
</body>
</html>