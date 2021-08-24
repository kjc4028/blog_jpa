<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>카테고리 목록</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>

	<main role="main">
	  <div class="container marketing">
	    <div class="row">
	      <div class="col-lg-10">
			<p><a class="btn btn-secondary" href="/category/insert" role="button">카테고리 등록</a></p>
			
			<c:forEach items="${pageList}" var="list">
			${list.categorySeq} | ${list.categoryNm} | ${list.useYn} | ${list.regDate}<br>
			</c:forEach>			
					        
	      </div><!-- /.col-lg-10 -->
	    </div><!-- /.row -->
	  </div><!-- /.container -->
	</main>
	

</body>
</html>