<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>哈尔滨理工大学学生管理系统</title>
<link href="./CSS/style_log.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script>
       $(function () {
           $("#btn").click(function () {
               $.ajax({
                   type:"post",
                   url:"user",
                   dataType:"text",
                   data:$("#login").serialize(),
                   statusCode:{
                       200:function (data) {
                             if(data.indexOf("no")!=-1){
                                 alert("登录失败，请检查账号密码是否错误！");

                             }else {
                                var url="indexlogin.jsp?username="+data;
                                 window.location.href=url;

                             }


                       },
                   }
               });
           });
           
       });



    </script>
</head>
<body class="login">
	<!-- <h1>
    用户登陆
  </h1>
  <form name="login" id="login">
  账号<input name="username" id="username" type="text"><br>
  密码<input name="password" id="password" type="password"><br>

  <button id="btn">提交</button>

  </form>-->
	<div class="login_m">
		<div class="login_logo">
			<img src="./image/logo.png" width="600" height="80">
		</div>
		<div class="login_boder">

			<div class="login_padding" id="login_model">
				<form name="login" id="login">
					<h2>USERNAME</h2>
					<label> <input type="text" id="username" name="username" class="txt_input txt_input2"
						onfocus="if (value ==&#39;username&#39;){value =&#39;&#39;}"
						onblur="if (value ==&#39;&#39;){value=&#39;username&#39;}" value="username">
					</label>
					<h2>PASSWORD</h2>
					<label> <input type="password" name="password" id="password" class="txt_input"
						onfocus="if (value ==&#39;******&#39;){value =&#39;&#39;}"
						onblur="if (value ==&#39;&#39;){value=&#39;******&#39;}" value="******">
					</label>



					<div class="rem_sub">
						<label> <input type="button" class="sub_button" name="button" id="btn" value="SIGN-IN"
							style="opacity: 0.7;"> <!--  <button id="btn" class="sub_button" name="button">提交</button>-->
						</label>
					</div>
				</form>
			</div>

			<!--login_padding  Sign up end-->
		</div>
		<!--login_boder end-->
	</div>
</body>
</html>
