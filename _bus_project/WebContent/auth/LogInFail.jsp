<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Refresh" content="1;url=login.do">
</head>
<body>
	<%
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('아이디 또는 비밀번호가 틀렸습니다.')");
	script.println("</script>");
	%>
</body>
</html>