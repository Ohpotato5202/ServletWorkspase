<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>
	
<div class="ul-widget">
	<label for="name" >우리반 이름 : </label>
	<input type='text' id="name">
</div>
<h1 class='selected'></h1>

	<script>
	 $("#name").autocomplete({
		source : function(req, res){ 
	 		//console.log(req);
	 		//console.log(res(["1234","123213"]));
	 		$.ajax({
	 			url : "/ajax/auto",
	 			data : {
	 				search : req.term
	 			},
	 			success : function(data){
	 				console.log(data);
	 				var arr = data.split("\n");//개행처리 
	 				arr.splice(arr.length -1, 1);//마지막 위치에서 하나 지우겠다.
	 				
	 				$.map(arr, function(name){
	 					return {
	 						label : name, // 노출 테스트 
	 						value : name // 내부적 처리값
	 					}
	 				})
	 				// 작업 완료 후 콜백 함수 호출
	 				res(arr);//콜백함수에 내가 위에서 처리한 값 넣어주고, 화면에 출력
	 			},
	 			error : function(xhr, status, err){
	 				console.log(xhr, status, err);
	 			}
	 		})
	 		
	 	},	
	 	select : function(event, selected){// 요소 선택 시 실행
	 		console.log(event);
	 		console.log(selected.item.label);//선택된(selected) 항목의 아이텐(item)의 라벨텍스트(label)
	 		
	 		$("h1.selected").html(selected.item.label);//value값을 어딘가에 저장해놨다가 비동기방식으로 뿌려줌.
	 	},
	 	focus : function(event, focused){//포커스 시 실행
	 		//console.log(event);
	 		//console.log(focused);
	 		
	 		return false;
	 	}
	 	
	});
	</script>
	
	
	
	
	
	
	
</body>
</html>