<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="../../../assets/css/main.css" />
	<link rel="stylesheet" href="../../../assets/css/detail.css" />
<link rel="stylesheet" href="../../../assets/css/header.css" />
<link rel="stylesheet" href="../../../assets/css/circleimage.css" />
<link rel="stylesheet"
	href="../../../assets/bootstrap-4.1.0/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" media="(max-width: 320px)" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" media="(max-width: 320px)" />
<style>
#clr {
	background-color: #E2F4E5;
	margin-bottom: 0.8rem;
	height: 300px;
}

#si {
	font-size: 1.2rem;
	padding-left: 0;
}

#le {
	padding-right: 20px;
}

p {
	padding-top: 20px;
}
</style>
<%@ include file="../header.jsp"%>
<div class="jumbotron btm jumbotron-fluid" id="clr">
	<div class="container">
		<h1>
			<b>${sessionScope.u_id}</b> 님 방문해주셔서 감사합니다.
		</h1>
		 <c:set var="point" value="${point}"/>
		<h4>
			<p>포인트: ${point.rPoint} p</p>
		</h4>
	</div>
</div>
<div class="container">
	<nav class="navbar navbar-expand-lg navbar-light" id="si">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active" id="le"><a class="nav-link"
					href="myPage.do">내 게시물</a></li>
				<li class="nav-item" id="le"><a class="nav-link"
					href="myBuy.do">구매리스트</a></li>
				<li class="nav-item" id="le"><a class="nav-link"
					href="myPoint.do">포인트</a></li>
				<li class="nav-item" id="le"><a class="nav-link"
					href="myMessage.do">쪽지</a></li>
				<li class="nav-item" id="le"><a class="nav-link"
					href="mySetting.do">설정</a></li>
			</ul>
			<span class="navbar-text"><a class="nav-link"
					href="writeForm.do">글쓰기</a></span>
		</div>
	</nav>
