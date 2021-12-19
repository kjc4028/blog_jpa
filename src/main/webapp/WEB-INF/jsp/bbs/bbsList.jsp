<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>게시글 목록</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>

<main role="main">
	<div class="container marketing">
		<div class="row">
			<div class="col-lg-10">
				<p><a class="btn btn-secondary" href="/bbs/insert" role="button">게시물 등록</a></p>
			
				<table class="table table-bordered table-hover">
					<tr>
					  <th class="info">일련번호</th>
					  <th class="info">제목</th>
					  <th class="info">등록일자</th>
					  <th class="info">작성자</th>
					</tr>
					
					<c:forEach items="${pageList.content}" var="list">
						<tr>
						    <td class="info">${list.bbsSeq}</td>
							<td class="info"><a href="/bbs/${list.bbsSeq}">${list.title}</a></td>
							<td class="info">${list.regDate}</td>
							<td class="info">${list.usrEntity.usrId}</td>
						</tr>
					</c:forEach>			
				</table>
			</div><!-- /.col-lg-10 -->
		</div><!-- /.row -->
		<!-- 페이징 영역 -->	  
		
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <c:forEach begin="1" end="${pageList.totalPages}" varStatus="stat">
					<li class="page-item"><a class="page-link" href="/bbs/totallist?pageNum=${stat.count}">${stat.count}</a></li>
			</c:forEach>		
		  </ul>
		</nav>		
	 </div><!-- /.container -->
</main>
	



</body>
</html>