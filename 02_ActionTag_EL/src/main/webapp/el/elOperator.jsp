<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kh.person.Person" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String str1 = "안녕";
   String str2 = new String("안녕");
   
   int big = 100;
   int small = 30;
   
   Person p1 = new Person("honngd", "혼길동", '남', 35, true);
   Person p2 = new Person("honngd", "혼길동", '남', 35, true);
   
   List<String> list = null;
   list = new ArrayList<>();
   list.add("hello world");

   pageContext.setAttribute("str1", str1);
   pageContext.setAttribute("str2", str2);
   pageContext.setAttribute("big", big);
   pageContext.setAttribute("small", small);
   pageContext.setAttribute("p1", p1);
   pageContext.setAttribute("p2", p2);
   pageContext.setAttribute("list", list);
   
   pageContext.setAttribute("emptyStr", "");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>el 연산자</h1>
	<h2>산술연산</h2>
	<p>${big + small}</p>
	<p>${big - small}</p>
	<p>${big - '20'}</p>
	<%-- <p>${big - 'ab'}</p><!-- 형변환 못하는 경우 오류남. : NumberFormatException--> --%>
	<p>${big / small } ${big div small }</p><!-- div : 나눗셈 할 때 / 보다 div 쓰는 것이 좋음. 특수기호는 오류 생김  -->
	<p>${big % small } ${big mod small }</p><!-- mod : 나눗셈 할 때 / 보다 mod 쓰는 것이 좋음. 특수기호는 오류 생김  -->
	
	<p>${str1 }${str2 }</p>
	<p>${str1.concat(str2)}</p>
	
	
	<h2>비교연산 - 예약어</h2>
	<p>${big > small } ${big gt small}</p><!-- greater then -->
	<p>${big < small } ${big lt small}</p> <!-- lower then -->
	<p>${big >= small } ${big ge small}</p>
	<p>${big <= small } ${big le small}</p> 
	<p>${big == small } ${big eq small}</p>
	<p>${big != small } ${big ne small}</p>
	
	<hr>
	<p><%= str1 == str2 %> ${str1 ==str2 } ${str1 eq str2 }</p>
	<!-- 서로 다른 주소값을 가지고있으므로 F / 값과 값간의 동등비교 (자료변환 되어서 출력되므로 t) -->
	<p><%= str1 != str2 %> ${str1 !=str2 } ${str1 ne str2 }</p>
	
	<p>${p1 ==p2 } ${ p1 eq p2}</p><!-- 오버라이딩 해놓은게 뭐지  -->
	
	<!-- 객체가 null이거나 배열에 요소가 없는지 검사 -->
	<p>${empty list } ${not empty list }</p><!-- ex) 검색어가 있을 떄 보여지는 화면과, 없을 떄 보여지는 화면 따로 작업 가능함. -->
	<p>${empty emptyStr }</p>
	
	<p>[${dklfjdslkjf }]</p><!-- [] 빈괄호. -->
	
	<script>
		var temp = "1234";//EL 표현식 "${temp}"
		var str = `:::\${temp}:::`;// 해석 순서상 후순위이므로, escape'/'문법 붙여주기
		console.log(str);
	</script>
	
	
</body>
</html>