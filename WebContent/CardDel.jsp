<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CardDel</title>

<link href="CSS/table.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script>
	$(function() {
		$("#bto1").click(function() {
			$.ajax({
				type : "post",
				url : "carddel",
				dataType : "text",
				data : $("#carddel").serialize(),
				statusCode : {
					200 : function(data) {
						alert(data);

					},
				}
			});
			$("#username").val("");

		});

	});
</script>
</head>
<body>
	<form name="carddel" id="carddel">
		<table class="hovertable">
		<caption>注销一卡通</caption>
			<tr>
				<td>学号</td>
				<td><input name="username" id="username" type="text"
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