<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Carder</title>

<link href="CSS/table.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script>
	$(function() {
		$("#bto1").click(function() {
			$.ajax({
				type : "post",
				url : "card",
				dataType : "text",
				data : $("#card1").serialize(),
				statusCode : {
					200 : function(data) {
						alert(data);

					},
				}
			});
			$("#username").val("");
			$("#password").val("");
			$("#name").val("");
			$("#money").val("");

		});

	});
</script>
</head>
<body>
	<form name="card1" id="card1">
		<table class="hovertable">
			<caption>注册一卡通</caption>
			<tr>
				<td>学号</td>
				<td><input name="username" id="username" type="text"
					onmouseover="this.style.backgroundColor='#ffff66';"
					onmouseout="this.style.backgroundColor='#d4e3e5';"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input name="password" id="password" type="text"
					onmouseover="this.style.backgroundColor='#ffff66';"
					onmouseout="this.style.backgroundColor='#d4e3e5';"></td>
			</tr>
			<tr>
				<td>门禁</td>
				<!-- 				<td><input type="" value="提交" id="bto1" -->
				<!-- 					onmouseover="this.style.backgroundColor='#ffff66';" -->
				<!-- 					onmouseout="this.style.backgroundColor='#d4e3e5';"></td> -->
				<td><select id="door" name="door" onmouseover="this.style.backgroundColor='#ffff66';"
					onmouseout="this.style.backgroundColor='#d4e3e5';">
						<option value="1" selected>允许</option>
						<option value="0">不允许</option>
				</select></td>
			</tr>
			<tr>
				<td>名字</td>
				<td><input type="text" id="name" name="name"
					onmouseover="this.style.backgroundColor='#ffff66';"
					onmouseout="this.style.backgroundColor='#d4e3e5';"></td>
			</tr>
			<tr>
				<td>职位</td>
				<!-- 				<td><input type="button" value="提交" id="bto1" -->
				<!-- 					onmouseover="this.style.backgroundColor='#ffff66';" -->
				<!-- 					onmouseout="this.style.backgroundColor='#d4e3e5';"></td> -->
				<td><select id="work" name="work" onmouseover="this.style.backgroundColor='#ffff66';"
					onmouseout="this.style.backgroundColor='#d4e3e5';">
						<option value="stu" selected>student</option>
						<option value="card">card</option>
						<option value="shop">shop</option>
						<option value="library">library</option>
				</select></td>
			</tr>
			<tr>
				<td>钱余额</td>
				<td><input type="text" id="money" name="money"
					onmouseover="this.style.backgroundColor='#ffff66';"
					onmouseout="this.style.backgroundColor='#d4e3e5';"></td>
			</tr>
			<tr>
				<td>按钮</td>
				<td><input type="button" value="提交" id="bto1"
					onmouseover="this.style.backgroundColor='#ffff66';"
					onmouseout="this.style.backgroundColor='#d4e3e5';"></td>
			</tr>
		</table>

	</form>
</body>
</html>