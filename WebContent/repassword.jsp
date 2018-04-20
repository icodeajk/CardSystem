<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RePassword</title>

<link href="CSS/table.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script>
	$(function() {
		$("#bu1").click(function() {

			$.ajax({
				type : "post",
				url : "password",
				dataType : "text",
				data : $("#repassword").serialize(),
				statusCode : {
					200 : function(data) {
						if (data.indexOf("no") != -1) {
							alert("修改密码失败！");

						} else {

							window.top.location.href = "index.jsp";
						}

					},
				}
			});
		});

	});
</script>
<body>
	<%
		String un = request.getParameter("username");
	%>
	<form id="repassword" name="repassword">

		<table class="hovertable">
			<caption>修改密码</caption>
			<tr>
				<td>原密码</td>
				<td><input type="text" name="old" id="old"
					onmouseover="this.style.backgroundColor='#ffff66';"
					onmouseout="this.style.backgroundColor='#d4e3e5';"></td>
			</tr>
			<tr>
				<td>新密码</td>
				<td><input type="password" name="new1" id="new1"
					onmouseover="this.style.backgroundColor='#ffff66';"
					onmouseout="this.style.backgroundColor='#d4e3e5';"></td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="password" name="new2" id="new2"
					onmouseover="this.style.backgroundColor='#ffff66';"
					onmouseout="this.style.backgroundColor='#d4e3e5';"></td>
			</tr>
			<tr>
				<td>按钮</td>
				<td><input type="button" id="bu1" value="提交"
					onmouseover="this.style.backgroundColor='#ffff66';"
					onmouseout="this.style.backgroundColor='#d4e3e5';"></td>
			</tr>
		</table>

		<input type="hidden" name="username" id="username" value="<%=un%>">
	</form>

</body>
</html>