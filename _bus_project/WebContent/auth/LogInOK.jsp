<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Refresh" content="2;url=login.do">
</head>
<body>
	<%
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('로그인에 성공하셨습니다')");
	script.println("window.open('http://localhost:9999/_bus_project/search/searchFromLogOut.jsp', '_self');");
	script.println("</script>");
	%>
</body>
</html>