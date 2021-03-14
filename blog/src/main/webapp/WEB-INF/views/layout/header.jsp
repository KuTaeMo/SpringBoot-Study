<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!-- property = 가져올 변수명 => 유저컨트롤러의 get.principal()과 같은 뜻 -->
<!-- var = 사용할 변수명 -->
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>BLOG</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

	<c:choose>
		<c:when test="${empty principal}">
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="/">BLOG</a></li>
					<li class="nav-item"><a class="nav-link" href="/loginForm">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="/joinForm">회원가입</a></li>
				</ul>
			</nav>
		</c:when>
		<c:otherwise>
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="/">BLOG</a></li>
					<li class="nav-item"><a class="nav-link" href="/post/saveForm">글쓰기</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/1">회원정보보기</a></li>
					<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
				</ul>
			</nav>
		</c:otherwise>
	</c:choose>
	<br />