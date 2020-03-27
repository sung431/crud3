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
<link rel="stylesheet" href="<c:url value='/css/list.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/menu.css'/>" />

<!-- JQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#deptAdd").click(function(){
		location.href="/crud3/dept/deptAdd.do";
	});
});

function goView(deptNo){
	location.href="/crud3/dept/deptView.do?dept_no="+deptNo;
}
</script>
</head>
<body>
<%@ include file="../menu.jsp" %>
<section class="goodslist">
	<div class="content">
		<div class="top clearfix">
			<div class="title">
				<h1>부서 관리</h1>					
			</div>				
			<button id="deptAdd" type="button" class="upload">부서추가</button>
		</div>			
		<div class="col-1">
			<div class="col-1-top clearfix">
				<p class="title">부서 목록</p>		
			</div>
			<table class="col-1-table">
				<colgroup>
					<col width="40%"/>
					<col width="60%"/>
				</colgroup> 
				<tr class="title">
					<th>No.</th>
					<th>부서명</th>
				</tr>

		        <c:choose>
		            <c:when test="${fn:length(list) > 0}">
		                <c:forEach items="${list }" var="row" varStatus="status">
		                    <tr class="data" onclick="javascript: goView(${row.deptNo})">
		                        <td>${status.count }</td>
		                        <td>${row.deptName }</td>
		                    </tr>
		                </c:forEach>
		            </c:when>
		            <c:otherwise>
		                <tr>
		                    <td colspan="2">조회된 결과가 없습니다.</td>
		                </tr>
		            </c:otherwise>
		        </c:choose>
		        
			</table>
		</div>
	</div>
</section>
</body>
</html>