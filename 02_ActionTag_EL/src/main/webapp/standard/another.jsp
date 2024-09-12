<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/standard/header.jsp">
		<jsp:param value="ANOTHER" name="title"/>
	</jsp:include>
	<section>
		<article>
			<h2>another.jsp</h2>
			<a href="/action">메인으로</a>
			<!-- /로 시작해야 절대경로 : 시작점부터 시작하려면 -->
			<!--  현재 페이지부터 시작하려면 문자로 시작. -->
		</article>
	</section>
	<jsp:include page="/standard/footer.jsp"></jsp:include>
</body>
</html>