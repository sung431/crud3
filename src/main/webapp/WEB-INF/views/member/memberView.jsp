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
		url : "/crud3/member/memberUpdate.do"
		, data : insertData
		, type : "POST"
		, dataType : "json"
		, error : function(){
	    	alert('수정실패');
	    }
		, success : function(response) {
			if(response == 1){
				alert("수정완료");
				location.href="/crud3/member/memberList.do";
			}else{				
				alert("수정실패 : " + reponse);
			}
		},
		});
	});
	
	$("#BtnDel").click(function(){
		if(confirm("삭제하시겠습니까?") == true){
			var insertData = $("#form").serialize();
	 		$.ajax({
			url : "/crud3/member/memberDelete.do"
			, data : insertData
			, type : "POST"
			, dataType : "json"
			, error : function(){
		    	alert('삭제실패');
		    }
			, success : function(response) {
				if(response == 1){
					alert("삭제완료");
					location.href="/crud3/member/memberList.do";
				}else{				
					alert("삭제실패 : " + reponse);
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
		<input type="hidden" id="memberNo" name="memberNo" value="${dto.memberNo }">
		<div class="top clearfix">
			<div class="title">
				<h1>사원 관리</h1>
			</div>
			<div class="btn-box clearfix">
				<button id="BtnMod" type="button" class="del">수정</button>
				<button id="BtnDel" type="button" class="del">삭제</button>
			</div>
		</div>			
		<div class="col-2">
			<div class="col-2-top clearfix">
				<ul class="clearfix">
					<li class="btn active" data-type="kor">사원 정보</li>
				</ul>					
			</div>
			<div class="write_form kor active">
				<label for="">부서</label><select id="departmentVO.deptNo" name="departmentVO.deptNo">
					<c:choose>
						<c:when test="${fn:length(list) > 0}">
			                <c:forEach items="${list }" var="row">
			                		<c:if test="${row.deptNo == dto.departmentVO.deptNo }">
			                			<option value="${row.deptNo}" selected>${row.deptName }</option>
			                		</c:if>
			                		<c:if test="${row.deptNo != dto.departmentVO.deptNo }">
				                        <option value="${row.deptNo}">${row.deptName }</option>
			                		</c:if>
			                </c:forEach>
			            </c:when>
		            </c:choose>
				</select>
				<label for="">사원명</label><input type="text" name="memberName" id="memberName" placeholder = "입력해주세요" value="${dto.memberName}"/><br />
			</div>
		</div>
		
		</form>
	</div>
</section>
</body>
</html>