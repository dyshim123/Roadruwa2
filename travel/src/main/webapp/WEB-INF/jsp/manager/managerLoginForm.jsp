<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="../../../assets/bootstrap-4.1.0/css/bootstrap.min.css">
<link href="../../../assets/manager/css/login.css" rel="stylesheet" type="text/css">
<title>관리자 로그인</title>
</head>
<body>
	<div class="login">
		<h1>Login</h1>
		<form method="post" action="/managerlogin/login.do">
			<input type="text" id="id" name="uId" placeholder="Username"
				required="required" autofocus/> <input type="password" id="uPwd"
				name="uPwd" placeholder="Password" required="required" />
			<button type="submit" class="btn btn-primary btn-block btn-large">Login</button>
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="../../../assets/bootstrap-4.1.0/js/bootstrap.min.js"></script>
	<script
		src="../../../assets/manager/fontawesome-free-5.0.9/svg-with-js/js/fontawesome-all.js"></script>
	<script src="script.js"></script>
</body>
</html>