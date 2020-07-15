<%@page import="java.util.List"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="spms.controls.ManagerUpdateController" %>
<%@ page import="spms.controls.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>확인 페이지</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script>
	$(document).ready(function(){
		 var test = document.getElementById('busNo').value;
         alert('예매가완료되었습니다');
         alert('탑승 버스 번호 :  ' + test);
         window.open('http://localhost:9999/_bus_project/search/searchFromLogOut.jsp', '_self');
    });
</script>
</head>
<body>
<div>
	<input type='text' id='busNo' value='${manager.busNo}'>
</div>
</body>
</html>