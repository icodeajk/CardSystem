<%@ page import="dao.UserDaoImpl"%>
<%@ page import="dao.SpendDaoImpl"%>
<%@ page import="vo.xiqu"%>
<%@ page import="vo.money"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpendCheck</title>

<link href="CSS/table.css" rel="stylesheet" type="text/css">
</head>
<body>
	<table class="hovertable">
		<caption>消费查询</caption>
		<tr>
			<th>花费金钱</th>
			<th>消费时间</th>
		</tr>
		<%
			String un = request.getParameter("username");
		%>
		<%
			SpendDaoImpl dao = new SpendDaoImpl();
			List<money> list = dao.queryMoney(un);
			Iterator<money> it = list.iterator();
			while (it.hasNext()) {
				money money = it.next();
		%>
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<td><%=money.getUsemoney()%></td>
			<td><%=money.getDate()%></td>
		</tr>


		<%
			}
		%>
	</table>
</body>
</html>