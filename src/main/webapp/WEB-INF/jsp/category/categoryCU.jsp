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
			
			<form:form modelAttribute="categoryEntity" method="post" class="form-horizontal">
				<div class="form-group">
					<label for="categoryNm" class="col-sm-2 control-label">카테고리명</label>
					<form:input path="categoryNm" class="form-control" placeholder="카테고리 제목"/>
				</div>
				<%-- <div class="form-group">
					<label for="usrId" class="col-sm-2 control-label">작성자</label>
					<form:input path="usrId" class="form-control" placeholder="작성자 제목" readonly="true" value="${sessionScope.user.username}"/>
				</div> --%>
				<div class="form-group">
					<label for="useYn" class="col-sm-2 control-label">사용여부</label>
					<form:radiobutton path="useYn" value="Y" checked="checked"/> Y
					<form:radiobutton path="useYn" value="N"/> N
				</div>
				<button  class="btn btn-primary">카테고리 생성</button>				
			</form:form>		
					        
	      </div><!-- /.col-lg-10 -->
	    </div><!-- /.row -->
	  </div><!-- /.container -->
	</main>
	

</body>
</html>