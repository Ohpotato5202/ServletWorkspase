<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>html</h1>
	<input type='button' value="실행" id="btn">
	<div class="wrapper"></div>
<script>
	$("#btn").on("click", function(){
		$.ajax({
			url : "/ajax/html",//요청 받아야 할 서블릿 필요 
			success : function(data){
				console.log(data);
				$(".wrapper").html(data);//비동기 방식으로 가능. 주소 직접 치지 않아도 됨>>?
						
			},
			error : function(xhr){
				console.log(xhr);
			}
		})
	});
	
</script>








</body>
</html>