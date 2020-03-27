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
	$("#memberAdd").click(function(){
		location.href="/crud3/member/memberAdd.do";
	});
});

function goView(memberNo){
	location.href="/crud3/member/memberView.do?member_no="+memberNo;
}
</script>
</head>
<body>
<%@ include file="../menu.jsp" %>
<section class="goodslist">
	<div class="content">
		<div class="top clearfix">
			<div class="title">
				<h1>사원 관리</h1>
			</div>				
			<button id="memberAdd" type="button" class="upload">사원등록</button>
		</div>			
		<div class="col-1">
			<div class="col-1-top clearfix">
				<p class="title">사원 목록</p>		
			</div>
			<table class="col-1-table">
				<colgroup>
					<col width="20%"/>
					<col width="40%"/>
					<col width="40%"/>
				</colgroup> 
				<tr class="title">
					<th>No.</th>
					<th>사원명</th>
					<th>부서명</th>
				</tr>

		        <c:choose>
		            <c:when test="${fn:length(list) > 0}">
		                <c:forEach items="${list }" var="row" varStatus="status">
			                    <tr class="data" onclick="javascript: goView(${row.memberNo})">
			                        <td>${status.count }</td>
			                        <td>${row.memberName}</td>
			                        <td>${row.departmentVO.deptName}</td>
			                    </tr>
		                </c:forEach>
		            </c:when>
		            <c:otherwise>
		                <tr>
		                    <td colspan="3">조회된 결과가 없습니다.</td>
		                </tr>
		            </c:otherwise>
		        </c:choose>
		        
			</table>
		</div>
		<div class="pagination">
			<div class="page-table">
				<div class="thead">
					<div>
						<!-- <a class="btn-left"><<</a> -->
						<c:if test="${pagination.curPage ne 1}">
							<a class="one btn-left" href="/crud3/member/memberList.do?curPage=${pagination.prevPage}"><</a>
						</c:if>
						<c:forEach var="pageNum" begin="${pagination.startPage }" end="${pagination.endPage }">
	                        <c:choose>
	                            <c:when test="${pageNum eq  pagination.curPage}">
	                            	<a><span class="active">${pageNum }</span></a>
	                            </c:when>
	                            <c:otherwise>
	                            	<a href="/crud3/member/memberList.do?curPage=${pageNum }"><span>${pageNum }</span></a> 
	                            </c:otherwise>
	                        </c:choose>
                    	</c:forEach>
						<c:if test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0}">
							<a href="/crud3/member/memberList.do?curPage=${pagination.nextPage}" class="one btn-rigth">></a>
						</c:if>
						<!-- <a class="btn-rigth">>></a> -->
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
</body>
</html>