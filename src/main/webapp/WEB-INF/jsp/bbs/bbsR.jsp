<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 상세보기</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>

	<main role="main">
	  <div class="container marketing">
	    <div class="row">
	      <div class="col-lg-10">
				<div class="form-group">
					<figure>
					  <blockquote class="blockquote">
					    <p>${bbsEntity.title}</p>
					  </blockquote>
					  <figcaption class="blockquote-footer">
						${bbsEntity.categoryEntity.categoryNm} | ${bbsEntity.regDate}
					  </figcaption>
					</figure>
				</div>
				
				<div class="form-group" style="height: auto;">
					${bbsEntity.contents}
				</div>
				
				<sec:authorize access="isAuthenticated()">
					<sec:authentication property="principal" var="user"/>
					<c:if test="${user.username eq bbsEntity.usrEntity.usrId}">
						<button class="btn btn-primary" onclick="updateView('${bbsEntity.bbsSeq}');">수정</button>
					</c:if>
				</sec:authorize>
	      </div><!-- /.col-lg-10 -->
	    </div><!-- /.row -->
	  </div><!-- /.container -->
	</main>

<script type="text/javascript">
	function updateView(bbsSeq){
		location.href = '/bbs/update/'+bbsSeq;
	}
	
	$("#bbsEntity").keydown(function(){
		if(event.keyCode === 13){
			//event.preventDefault();
		}
	})
</script>
</body>
</html>