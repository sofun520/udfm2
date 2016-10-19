<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="http://g.alicdn.com/sj/dpl/1.5.1/css/sui.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
<script type="text/javascript"
	src="http://g.alicdn.com/sj/dpl/1.5.1/js/sui.min.js"></script>
</head>
<body>
	<div
		style="width: 400px; margin: 60px auto; border: 1px solid #efefef; padding-top: 120px">
		<div class="sui-container">
			<form class="sui-form form-horizontal sui-validate" action=""
				method="post" id="servingForm">
				<div class="control-group">
					<label class="control-label">用户名：</label>
					<div class="controls">
						<input class="input-large" type='text' id="username"
							data-rules="required|minlength=2|maxlength=30" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">密码：</label>
					<div class="controls">
						<input class="input-large" type='password' id="password"
							data-rules="required|minlength=2|maxlength=30" />
					</div>
				</div>
				<div style="text-align: center; width: 400px;">
					<button class="sui-btn btn-primary btn-large" onclick="login()">登录</button>
					<button class="sui-btn btn-large" type="reset">重置</button>
				</div>
			</form>
		</div>
	</div>

	<script type="text/javascript">
		function login() {
			var username = $("#username").val();
			var password = $("#password").val();
			if (username != null && password != null && username != ''
					&& password != '') {
				doLogin(username,password);
			}
		}

		function doLogin(username, password) {
			$.post("checkLogin.do", {
				username : username,
				password : password
			}, function(data) {
				//alert(JSON.stringify(data));
				if(data.success==0){
					window.location.href='main.do';
				}
			});
		}
	</script>
</body>
</html>