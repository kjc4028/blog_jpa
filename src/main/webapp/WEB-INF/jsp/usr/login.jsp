<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<style>
	.form-group{
		padding-right: 1rem;		
	}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>

	<main role="main">
	  <div class="container marketing">
	    <div class="row">
	      <div class="col-lg-10">
			<form:form modelAttribute="usrEntity" method="post" action="/usr/login" class="form-inline">
				<div class="form-group">
					<form:input path="usrId"  class="form-control" placeholder="Enter ID"/>
				</div>
				<div class="form-group">
					<form:password path="usrPw" class="form-control" placeholder="Password"/>
				</div>
				<button  class="btn btn-primary">로그인</button>
			</form:form>	        
	      </div><!-- /.col-lg-10 -->
	    </div><!-- /.row -->
	  </div><!-- /.container -->
	</main>
	

</body>
</html>