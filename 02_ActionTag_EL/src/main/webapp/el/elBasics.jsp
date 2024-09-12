<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String life = "life is very short!";
	pageContext.setAttribute("life", life);
	pageContext.setAttribute("movie", "노인을 위한 나라는 없다.");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- <%
	String coffee = (String)request.getAttribute("coffee");
%> --%>
<body>

	<h1>EL Basics</h1>
	<%-- scope생략 시 (공유범위) :  pageScope(현재 js페이지에서 유지 / 공유범위가 제일 짧음), 
	request(요청받은 서블릿에서 유지/  공유범위가 좀 더 넓음), sessionScope, applicationScope --%>
	<p>${life}</p><!-- 순서에 맞춰 조회하고, 해당하는 값 꺼내줌 -->
	<p>${requestScope.coffee}</p>
	<p>${coffee}</p>
	<p>${serverTime}</p>
	<p>${honngd}</p>
	<p>${honngd.id}</p>
	<%-- <p>${honngd.nickname}</p> org.apache.jasper.JasperException: 행 [27]에서 [/el/elBasics.jsp]을(를) 처리하는 중 예외 발생 --%>
	 
	<%-- <p>${honngd.id}</p><!-- honngd : 객체명.속성명을 통해서 값을 가져올 수 있다. -->
		 <p>${honngd.["id"]"}</p><!-- honngd : 객체명.속성명을 통해서 값을 가져올 수 있다. --> --%>
		 
		 <!-- 출력될 때는 문자열 형태로 출력됨 -->
		 <p>${honngd.name}</p>
		 <p>${honngd.gender}</p>
		 <p>${honngd.age}</p>
		 <p>${honngd.married}</p>
		 <p>${book}</p>
		 <p>${movie}</p>
		 <p>${applicationScope.movie}</p>
		 <!-- 각 스코프에 접근할 수 있는 객체를 가지고 있다. -->
		 
		 <h2>list</h2>
		 <p>${list }</p>
		 <p>${list[0] }</p><!-- 0번인덱스 값 가져오기  -->
		 <p>${list[1] }</p><!-- 1번인덱스 값 가져오기  -->
		 <p>${list[2] }</p><!-- 2번인덱스 값 가져오기  -->
		 <p>[${list[3] }]</p><!-- 3번인덱스 값 가져오기  값이 없으면 빈 []값만 반환-->
		 
		 <h2>map</h2>
		 <p>${map }</p>
		 <p>${map.language }</p>
		 <p>${map["Mrs.Jeon"].name}</p><!-- 필드 함수 기준이 아니라 getter 함수 기준으로 가져오기 때문...  -->
		 <p>${map["Mrs.Jeon"]["name"]}</p>
		 
		 
		 <h1>param</h1>
		 <p>${param.pname }</p>
		 <p>${param.pcount }</p><!-- 하나만 뽑아올 때 -->
		 <p>${paramValues.option }</p><!-- paramValues : 배열 형태의 데이터  -->
		 <p>${paramValues.option[0] }</p>
		 <p>${paramValues.option[1] }</p>
		 
		 
		 <h1>cookie</h1>
		 <p>${cookie.JSESSIONID}</p>
		 <p>${cookie.JSESSIONID.value}</p><!-- value값 꺼내기  -->
		 
		 <h1>header</h1>
		 <p>${header.accept}</p><!-- 어떤 형태의 데이터만 담을 것인지 헤데에 지정해 두는 것(자동 기본값으로 들어가 있음) -->
		 <p>${header['user-agent']}</p>
		 
		 <h1>pageContext</h1>
		 <p>${pageContext.request.contextPath }</p><!-- 하드코딩 할 필요 없이 요청에 맞는 contextPath(/action, /standard) 값을 넣어줄 수 있음  -->
		 <p>${pageContext.request.method }</p><!-- EL표현식 : 빠르게 객체에 접근할 수 있는 표현식. -->
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
</body>
</html>