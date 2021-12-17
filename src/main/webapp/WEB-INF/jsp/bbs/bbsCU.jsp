<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글등록</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>

	<main role="main">
	  <div class="container marketing">
	    <div class="row">
	      <div class="col-lg-10">
			<form:form modelAttribute="bbsEntity" method="post" class="form-horizontal">
				<div class="form-group">
					<label for="title" class="col-sm-2 control-label">title</label>
					<form:input path="title" class="form-control" placeholder="Enter title" value=""/>
				</div>
				<div class="form-group">
					<label for="categoryEntity.categorySeq" class="col-sm-2 control-label">category</label>
					<form:select path="categoryEntity.categorySeq" class="custom-select d-block w-50">
						<c:forEach items="${categoryList}" var="ctgList">
							<form:option value="${ctgList.getCategorySeq()}">${ctgList.getCategoryNm()}</form:option>
						</c:forEach>					
					</form:select>
				</div>
				<div class="form-group">
					<label for="contents" class="col-sm-2 control-label">contents</label>
					<form:textarea path="contents" class="form-control" placeholder="Enter contents" value="" style="height: 200px;"/>
				</div>
				<div class="form-group">
					<label for="useYn" class="col-sm-2 control-label">공개여부</label>
					<label class="radio-inline">
						<form:radiobutton path="useYn" label="Y" value="Y" checked="checked" />
					</label>
					<label class="radio-inline">
						<form:radiobutton path="useYn" label="N" value="N"/>				
					</label>
				</div>
				<button  class="btn btn-primary">등록</button>
			</form:form>
			
	      </div><!-- /.col-lg-10 -->
	    </div><!-- /.row -->
	  </div><!-- /.container -->
	</main>
	
<script type="text/javascript">
	$("#bbsEntity").keydown(function(){
		if(event.keyCode === 13){
			//event.preventDefault();
		}
	})
</script>
</body>
</html>