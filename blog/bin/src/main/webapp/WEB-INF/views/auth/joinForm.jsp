<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��α�</title>
</head>
<body>
	<h1>ȸ������ ������</h1>
	<hr />
	<form action="/join" method="POST">
		<input type="text" placeholder="Username" name="username" /> <br/>
		<input type="password" placeholder="Password" name="Password" /><br/>
		<input type="email" placeholder="Email" name="Email" /><br/>
		
		<button>ȸ������</button>
	</form>
	�̹� ȸ�������� �ȵǼ̳���? <a href="/loginForm">�α���</a>
</body>
</html>