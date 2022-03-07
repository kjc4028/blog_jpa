<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인페이지</title>
</head>
<body>

	<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>
	
<main role="main">
	<div class="container marketing">
		<div class="row">
			<div class="col-lg-10">
			
				<table class="table table-bordered table-hover">
					<tr>
					  <th class="info">최근 게시글</th>
					</tr>
					<c:forEach items="${pageList.content}" var="list">
						<tr>
							<td class="info"><a href="/bbs/${list.bbsSeq}">${list.title}</a></td>
						</tr>
					</c:forEach>			
				</table>
			</div><!-- /.col-lg-10 -->
		</div><!-- /.row -->
	 </div><!-- /.container -->
</main>

</body>
</html>