<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��α�</title>
</head>
<body>
	<h1>�α��� ������</h1>
	<hr />
	<form action="/login" method="POST">
		<input type="text" placeholder="Username" name="username" /> <input
			type="password" placeholder="Password" name="password" />
		<button>�α���</button>
	</form>
	���� ȸ�������� �ȵǼ̳���?
	<a href="/joinForm">ȸ������</a>
	<a href="/oauth2/authorization/google">���� �α���</a>
	<a href="/oauth2/authorization/facebook">���̽��� �α���</a>
</body>
</html>