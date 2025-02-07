<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/header.jsp" %>
	<section>
	<h1>Content</h1>
	<p><%= name %>님 반갑습니다.</p><!-- header에서 선언한 것 아래쪽에서 호출 가능하다.  -->
	<!-- 정적 포함 방식 : jsp파일 불러오는 속도가 빠르다.(장점) / 변경이 되면 전체가 다 변경됨..(단점)-->
	<a href="/hello/jsp/basic.jsp">another.jsp</a>
	<p>선거에 있어서 최고득표자가 2인 이상인 때에는 국회의 재적의원 과반수가 출석한 공개회의에서 다수표를 얻은 자를 당선자로 한다. 국회의 정기회는 법률이 정하는 바에 의하여 매년 1회 집회되며, 국회의 임시회는 대통령 또는 국회재적의원 4분의 1 이상의 요구에 의하여 집회된다.

모든 국민은 인간다운 생활을 할 권리를 가진다. 국회의 회의는 공개한다. 다만, 출석의원 과반수의 찬성이 있거나 의장이 국가의 안전보장을 위하여 필요하다고 인정할 때에는 공개하지 아니할 수 있다.

국가는 균형있는 국민경제의 성장 및 안정과 적정한 소득의 분배를 유지하고, 시장의 지배와 경제력의 남용을 방지하며, 경제주체간의 조화를 통한 경제의 민주화를 위하여 경제에 관한 규제와 조정을 할 수 있다.</p>
	</section>
<%@ include file="/jsp/footer.jsp" %>