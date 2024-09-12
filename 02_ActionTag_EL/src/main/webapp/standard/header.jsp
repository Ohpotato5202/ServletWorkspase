<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><!-- 공용스타일 부여 -->
<style>
header, section, footer {
    border: 1px solid #000;
    margin: 10px 0;
}
section {
    height: 500px;
}
</style>
</head>
<body>
	<header>
		<h1>${param.title}</h1><!-- el 표현식 : 원하는 파라미터 값 가져올 수 있음. -->
	</header>
	
</body>
</html>