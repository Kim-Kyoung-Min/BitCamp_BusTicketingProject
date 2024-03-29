<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!doctype html>	
<html lang="ko">
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">

<title>고속버스통합예매</title>
<style>
    #contentwrap{width:100%;}
    .header_h2{font-size: 34px;font-weight: bold;color:#fff; }
    header{background-image: url('header_bg.gif');background-size: cover;height: 180px;position: relative;padding-top:75px;}
    .util{position: absolute;top:10px;right:30px;}
    .util .menu{float:left;display: block;list-style: none;font-size:12px;}
    .util .menu #login2 a{text-decoration: none;position: relative;color: #fff; }
    .util .menu .login a{text-decoration: none;position: relative;color: #fff;}
    .util .menu li{float:left;}
    .header_h2{text-align: center;line-height: 1.5;}
    .login{padding: 4px 10px;margin-right:10px;font-weight: bold;color: #fff;background-color: #cfa346;border: 1px solid #fff;}
    #login2{padding: 4px 0px;}
    #login2 a{border-left: 1px solid #fff;padding-left:10px;padding-right:10px;}
    .content{width: 1070px;height:750px;padding-top:30px;margin: 0 auto;}
    .content h3{font-size: 28px;text-align: center;}
    .search{width: 90%;margin-bottom: 10px;}    
    .table {margin: 0 auto;border-collapse: collapse;border-top: 3px solid #168;width: 1070px;}  
    .table th {color: #168;background: #f0f6f9;text-align: center;}
    .table th, .table td {padding: 10px;border: 1px solid #ddd;}
    .table th:first-child, .table td:first-child {border-left: 0;}
    .table th:last-child, .table td:last-child {border-right: 0;}
    .table tr td:first-child{text-align: center;}
    .table caption{caption-side: bottom; display: none;}
    .footer{width: calc(100% - 58px);margin: 0 29px;padding: 20px 0 25px;border-top: 1px solid #e5e5e5;}
    .copyright{color:#666;text-align: center;}
    .arrive{text-align: center;}
    .headerRight{margin-left:10px;}
    #ticketingBox {height: 28px;width: 50px;background: #317d97;border: 1px solid;border-color: white #f7f7f7 #f5f5f5;border-radius: 3px;
	 background-image: -webkit-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06)); background-image: -moz-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06));
   	background-image: -o-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06)); background-image: linear-gradient(to bottom, transparent, rgba(0, 0, 0, 0.06));
 	 -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.08); box-shadow: 0 1px 1px rgba(0, 0, 0, 0.08); color:white;}
    .dropbutton {height: 28px;width: 50px;background: #317d97;border: 1px solid; border-color: white #f7f7f7 #f5f5f5; border-radius: 3px;
	  background-image: -webkit-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06));  background-image: -moz-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06));
	  background-image: -o-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06));  background-image: linear-gradient(to bottom, transparent, rgba(0, 0, 0, 0.06));
	  -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.08);  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.08);color:white;}
	.dropdown { display: inline-block; position: relative; overflow: hidden; height: 28px; width: 150px; background: #f2f2f2; border: 1px solid;
	  border-color: white #f7f7f7 #f5f5f5; border-radius: 3px; background-image: -webkit-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06));
	  background-image: -moz-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06));  background-image: -o-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06));
	  background-image: linear-gradient(to bottom, transparent, rgba(0, 0, 0, 0.06));  -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.08);  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.08);}
	.dropdown2 { display: inline-block; position: relative; overflow: hidden;}
	.dropbutton {height: 28px; width: 50px; background: #317d97; border: 1px solid; border-color: white #f7f7f7 #f5f5f5; border-radius: 3px;
	  background-image: -webkit-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06));  background-image: -moz-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06));
	  background-image: -o-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06));  background-image: linear-gradient(to bottom, transparent, rgba(0, 0, 0, 0.06));
	  -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.08);  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.08);  color:white;}
	.dropdown-input {  display: inline-block;  position: relative;  overflow: hidden;  height: 28px;  width: 150px;  background: #f2f2f2;  border: 1px solid;
 	 border-color: white #f7f7f7 #f5f5f5;  border-radius: 3px;  background-image: -webkit-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06));
  	background-image: -moz-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06));  background-image: -o-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06));
 	 background-image: linear-gradient(to bottom, transparent, rgba(0, 0, 0, 0.06));  -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.08);
  	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.08);}
	.dropdown:before, .dropdown:after { content: ''; position: absolute; z-index: 2; top: 9px; right: 10px; width: 0; height: 0; border: 4px dashed;
 	 border-color: #888 transparent; pointer-events: none;}
	.dropdown:before { border-bottom-st	yle: solid; border-top: none;}
	.dropdown:after {  margin-top: 7px; border-top-style: solid; border-bottom: none;}
	.dropdown-select { position: relative; width: 130%; margin: 0; padding: 6px 8px 6px 10px; height: 28px; line-height: 14px;  font-size: 12px;
	  color: #62717a; text-shadow: 0 1px white; background: #f2f2f2; background: rgba(0, 0, 0, 0) !important; border: 0; border-radius: 0;
	  -webkit-appearance: none;}
	.dropdown-input-select { position: relative;margin: 0; */padding: 6px 8px 6px 10px;height: 20px;line-height: 14px;font-size: 12px;
	  color: #62717a; text-shadow: 0 1px white; background: #f2f2f2; background: rgba(0, 0, 0, 0) !important; border: 0; border-radius: 0; -webkit-appearance: none;}
	.dropdown-select:focus { z-index: 3; width: 100%; color: #394349; outline: none; outline-offset: -2px;}
	.dropdown-input-select:focus {color: #394349; outline: none; outline-offset: -2px;}
	.dropdown-select > option { margin: 3px; padding: 6px 8px; text-shadow: none; background: #f2f2f2; border-radius: 3px; cursor: pointer;}
	.lt-ie9 .dropdown { z-index: 1;}
	.lt-ie9 .dropdown-select { z-index: -1;}
	.lt-ie9 .dropdown-select:focus { z-index: 3;}
	@-moz-document url-prefix() {.dropdown-select { padding-left: 6px; }}
	#bottomSection{ text-align: center;}
	.dropdown-input{
    display: inline-block;  position: relative;  overflow: hidden;  height: 28px;  width: 150px;  background: #f2f2f2;  border: 1px solid;
     border-color: white #f7f7f7 #f5f5f5;  border-radius: 3px;  background-image: -webkit-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06));
     background-image: -moz-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06));  background-image: -o-linear-gradient(top, transparent, rgba(0, 0, 0, 0.06));
     background-image: linear-gradient(to bottom, transparent, rgba(0, 0, 0, 0.06));  -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.08);
     box-shadow: 0 1px 1px rgba(0, 0, 0, 0.08);
    margin-right: 6px;
   }
   .reserve{
       position: relative;
       top:3px;
   }
   .dropbutton_reserve{
    width:80px;
   }
   .inline{
       display: inline-block;
   }
</style>
<body>
    <div id="contentwrap">
        <header>
            <div class="util">
                <ul class="menu">
                    <li class="name"><a style="color:white;">${bus.bname} 님 안녕하세요   </a></li>
                    <li class="name headerRight"><a style="color:white;" href='../auth/myPage.jsp' onclick="window.open(this.href, '_blank', 'width=100px, toolbars=no, scrollbars=no'); return false;">마이페이지<br></a></li>
                    <li class="headerRight"><a id="logoutTag" style="color:white;" href="../auth/logout.do">로그아웃</a></li>
                 </ul>
            </div>	
            <h2 class="header_h2">고속버스 예매</h2>
        </header>
        <div class="content">
            <h3>노선조회</h3>
<div class="search">
      <form id="form1 " action="search.do" method="post" class="inline">
               <div class="dropdown-input">
                  <input type='date' id='depDate' name='departureDate'
                     class="dropdown-input-select" />
               </div>
               <div class="dropdown">
                  <select name="departure" id="startCity" class="dropdown-select">
                     <option value="">출발지</option>
                     <option value="서울">서울</option>
                     <option value="대전">대전</option>
                     <option value="대구">대구</option>
                     <option value="부산">부산</option>
                     <option value="세종">세종</option>
                  </select>
               </div>
               <div class="dropdown">
                  <select name="arrive" id="endCity" class="dropdown-select">
                     <option value="">도착지</option>
                     <option value="서울">서울</option>
                     <option value="대전">대전</option>
                     <option value="대구">대구</option>
                     <option value="부산">부산</option>
                     <option value="세종">세종</option>
                  </select>
               </div>
               <div class="dropdown2">
                  <button id="searchBtn" type="submit" class="dropbutton">조회</button>
                
               </div>
   </form>
            <form action="allSearch.do" method="post" class="inline">
                <div class="dropdown2">
                    <button id="searchBtn" type="submit" class="dropbutton dropbutton_reserve">전체 조회</button>
                </div>
           </form>
   </div>
           <h1>운행 리스트</h1>
	<form id="form2" action="update.do" method="post">
				<table class="table">
					<tr>
						<th>출발일</th>
						<th>출발지-도착지</th>
						<th>출발시간</th>
						<th>도착시간</th>
						<th>버스번호</th>
						<th>회사이름</th>
						<th>잔여좌석수</th>
						<th class="ticket">예매하기</th>
					</tr>
					<c:forEach var="list" items="${test}">
						<tr>
							<td class="arrive">${list.departureDate}</td>
							<td class="arrive">${list.departure}▶ ${list.arrive}</td>
							<td class="arrive">${list.departureTime}</td>
							<td class="arrive">${list.arriveTime}</td>
							<td class="arrive">${list.busNo}</td>
							<td class="arrive">${list.busCom}</td>
							<td class="arrive">${list.spareSeat}</td>
							<td class="arrive"><input type="checkbox" name="busNo" value="${list.busNo}"></td>
						</tr>
						<input type="hidden" name="departureDate" value="${list.departureDate}">
						<input type="hidden" name="departure" value="${list.departure}">
						<input type="hidden" name="arrive" value="${list.arrive}">
					</c:forEach>
				</table>
				<br>
				예매매수 :  <input id='bottomSection' type="text" name="ticket" class="dropdown-input"/><button id='ticketingBox' id="searchBtn2" type="submit" class="reserve"> 예매</button>
	</form>
        </div>
       <footer class="footer">
            <p class="copyright">COPYRIGHT© 2020. WWW.BITCAMP.CO.KR. ALL RIGHT RESERVED</p>
       </footer>
    </div>
</body>
</html>