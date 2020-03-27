<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>crud3</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- CSS -->
<link rel="stylesheet" href="<c:url value='/css/add.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/menu.css'/>" />

<!-- JQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#BtnMod").click(function(){
		var insertData = $("#form").serialize();
 		$.ajax({
		url : "/crud3/dept/deptUpdate.do"
		, data : insertData
		, type : "POST"
		, dataType : "json"
		, error : function(){
	    	alert('수정실패');
	    }
		, success : function(response) {
			if(response == 1){
				alert("수정성공");
				location.href="/crud3/dept/deptList.do";
			}else{				
				alert("수정실패 : " + response);
			}
		},
		});
	});
	
	$("#BtnDel").click(function(){
		if(confirm("삭제하시겠습니까?") == true){
			var insertData = $("#form").serialize();
	 		$.ajax({
			url : "/crud3/dept/deptDelete.do"
			, data : insertData
			, type : "POST"
			, dataType : "json"
			, error : function(){
		    	alert('삭제실패');
		    }
			, success : function(response) {
				if(response == 1){
					alert("삭제성공");
					location.href="/crud3/dept/deptList.do";
				}else{				
					alert("삭제실패 : " + response);
				}
			},
			});
		}else{
			return;
		}
	});
});
</script>
</head>
<body>
<%@ include file="../menu.jsp" %>
<section class="goodswrite">
	<div class="content">
		<form name="form" id="form">
		<input type="hidden" id="deptNo" name="deptNo" value="${dto.deptNo }">
		
		<div class="top clearfix">
			<div class="title">
				<h1>부서 관리</h1>
			</div>
			<div class="btn-box clearfix">
				<button id="BtnMod" type="button" class="del">수정</button>
				<button id="BtnDel" type="button" class="del">삭제</button>
			</div>
		</div>			
		<div class="col-2">
			<div class="col-2-top clearfix">
				<ul class="clearfix">
					<li class="btn active" data-type="kor">부서 정보</li>
				</ul>					
			</div>
			<div class="write_form kor active">
				<label for="">부서명</label><input type="text" name="deptName" id="deptName" placeholder = "입력해주세요" value="${dto.deptName}"/><br />
			</div>
		</div>
		
		</form>
	</div>
</section>
</body>
</html>