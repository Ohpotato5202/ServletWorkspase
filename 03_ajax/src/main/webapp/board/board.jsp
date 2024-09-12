<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ajax/resources/css/board.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class='wrapper'>
      <header>
         <h3 style="fontWeight: bolder">KH C CLASS</h3>
      </header>
      <nav>
         <a id='list'>게시판</a> <a id='insert'>등록</a>
      </nav>
      <div class='outer'>
 <script>
 	function showList() {
 		$.ajax({
 			url : "/ajax/board/list",//요청보내기
 			success : function(data){
 				$(".outer").html(data);//html페이지로 정보 보내기
 			},
 			error : function(xhr){
 				console.log(xhr);
 			}
 		})
 	}
 	
 	$("#list").on('click', function(){
 		showList();
 	});
 	
 	showList();
 	
 	$("#insert").on('click', function(){
 		$.ajax({
 			url : '/ajax/board/insert',
 			method : 'GET',
 			success : function(data){
 				$(".outer").html(data);
 			},
 			error : function(xhr){
 				console.log(xhr);
 			}
 		})
 	})
</script>   
      </div>
   </div>

</body>
</html>