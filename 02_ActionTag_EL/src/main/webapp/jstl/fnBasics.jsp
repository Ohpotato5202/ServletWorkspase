<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>fn basics</h1>
	<c:set var="str1" value="Hello world, Hello JSTL" />
	<c:set var="str2" value="Hello EL" />
	
	<p>${fn:toUpperCase(str1) }</p>
	<p>${fn:toUpperCase(str2) }</p>
	
	<p>${fn:length(str1) } ${str1.length()}</p>
	<p>${fn:contains(str1, "world")} </p><!-- "world" 요소가 포함되어있는지 확인할 수 있다. -->
	
	<c:if test="${fn:contains(str1,'world')}">
		world 없다.
	</c:if>
	
	<c:if test="${not fn:contains(str1,'world')}">
		world 없다.
	</c:if>
	
	<p>${fn:indexOf(str1,'world') }</p><!-- 몇개의 인덱스 존재하는지 확인  -->
	<p>${fn:indexOf(str1,'www') }</p><!-- 찾는 문자가 없을 경우 -1반환 -->
	
	<c:if test="${fn:indexOf(str1,'world') > -1}">
		world 있다.
	</c:if>
	
	<p>${fn:replace(str1,'Hello', 'Goodbye')}</p>
	<c:set var="script">
		<script>
			document.body.style.color ="red";
		</script>
	</c:set>
	${fn:escapeXml(script) }<!-- 내부 함수는 문자열로 호출하라는 의미 -->











</body>
</html>