<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>게시물 검색</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>

<main role="main">
	<c:choose>
		<c:when test = "${empty pageList.content }">
			<div class="container marketing">
			    <div class="row">
			      <div class="col-lg-10">
			        <h2>검색 결과 없음</h2>
			        <p>"<b style = "color: red;">${srchTxt}</b>"에 대한 검색결과가 없습니다.</p>
			        <p>다른 검색어를 입혁해 주시기 바랍니다.</p>
			      </div><!-- /.col-lg-10 -->
			    </div><!-- /.row -->
		  	</div>
		</c:when>
		<c:otherwise>
			<div class="container marketing">
				<div class="row">
					<div class="col-lg-10">
					
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
							<li class="page-item"><a class="page-link" href="/bbs/totalSearch?srchTxt=${srchTxt}&pageNum=${stat.count}">${stat.count}</a></li>
					</c:forEach>		
				  </ul>
				</nav>		
			 </div><!-- /.container -->		
		</c:otherwise>
	</c:choose>
</main>
	



</body>
</html>