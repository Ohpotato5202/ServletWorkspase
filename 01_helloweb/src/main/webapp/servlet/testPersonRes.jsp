<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%--
   		jsp 주석
   		jsp : java Servlet
   		html내에 자바 문법을 사용할 수 있음. <%..%>태그 안에서만 작성할 수 있다.
    --%>
    <%@ page import='java.util.Arrays' %>
    <%
	//scriptlet(자바 작성 공간)
	System.out.println(123);
    
    //사용자가 입력한 값도 가져올 수 있음
    //request, response선언 없이 사용 가능. 
    String name = request.getParameter("name");
    String color = request.getParameter("color");
    String animal = request.getParameter("animal");
    String[] foods = request.getParameterValues("food");
    String recommendation = (String) request.getAttribute("recommendation");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.recommendation {
   font-size: 2em;
   color: lime;
   text-decoration: underline;
}
</style>
</head>
<body>
 	<h1>개취 검사 결과 jsp</h1>
 	<p><% out.print(name); %>님의 개인취향 검사 결과는</p>
 	<p><%= color %>색을 좋아합니다.</p>
 	<p>좋아하는 동물은 <%= animal %>입니다.</p>
 	<p>
 	<%
 		if(foods != null){
 			out.print("좋아하는 음식은"+Arrays.toString(foods)+"입니다.");
 		}else{
 			out.print("좋아하는 음식이 없습니다.");
 		}
 	%>
 	</p>
 	<hr>
 	<p class="recommendation">오늘의 추천 음식은 ${recommendation} 입니다.</p>
 	<%--EL표현식${}이 우선권을 갖는다. --%>
</body>
</html>