<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- CSS -->
<link rel="stylesheet" href="<c:url value='/css/reset.css'/>" />
<link rel="stylesheet" href="<c:url value='/css/menu.css'/>" />

<!-- JQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</head>
<body>
	<header>
		<div class="logo">
		</div>
		<nav>
			<ul>
				<li><a href="/crud3/member/memberList.do">사원목록</a></li>
				<li><a href="/crud3/dept/deptList.do">부서목록</a></li>
			</ul>
		</nav>
	</header>
</body>
</html>