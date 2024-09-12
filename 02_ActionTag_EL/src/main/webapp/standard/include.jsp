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
	 	<jsp:param value="INCLUDE" name="title"/>
	</jsp:include>
	<!--  file는 하나의 페이지로 관리하게 되는 것이나 -->
	<!-- page 각 페이지를 부품화, 모듈화할 수 있고, 별개의 페이지로 관리하여 조립해서 사용 가능 ( 컴파일 시점에서 포함 안되고, 실행시점에 포함. )  -->
	
	<section>
		<article>
			<h2>모든 국민은 근로의 권리를 가진다. 국가는 사회적·경제적 방법으로 근로자의 고용의 증진과 적정임금의 보장에 노력하여야 하며, 법률이 정하는 바에 의하여 최저임금제를 시행하여야 한다.
	
			탄핵결정은 공직으로부터 파면함에 그친다. 그러나, 이에 의하여 민사상이나 형사상의 책임이 면제되지는 아니한다. 군인·군무원·경찰공무원 기타 법률이 정하는 자가 전투·훈련등 직무집행과 관련하여 받은 손해에 대하여는 법률이 정하는 보상외에 국가 또는 공공단체에 공무원의 직무상 불법행위로 인한 배상은 청구할 수 없다.</h2>
			<a href="another.jsp">another</a>
			<!-- 상대경로 방식 : 문자(.도 문자열임)로 시작. -->
			<!-- ./ : 현재 경로 위치에서 마지막 슬래시 뒤에 이어붙여진다.(이 주소로 뒤에 더 타고 들어갈 수 있다.)-->
			<!-- ./another 도 가능 -->
		</article>
	</section>
	<jsp:include page="/standard/footer.jsp" />
</body>
</html>