<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"/>

	<main role="main">
	  <div class="container marketing">
	    <div class="row">
	      <div class="col-lg-10">
				<div class="form-group">
					<button class="btn btn-primary" onclick="testUsrCreate(); return false;">간편 테스트 회원가입</button>
				</div>	      
			<form:form modelAttribute="usrEntity" method="post" class="form-horizontal">
				<div class="form-group">
					<label for="usrId" class="col-sm-2 control-label">ID</label>
					<form:input path="usrId" class="form-control" placeholder="Enter ID" value=""/>
				</div>
				<div class="form-group">
					<label for="usrPw" class="col-sm-2 control-label">Password</label>
					<form:password path="usrPw" class="form-control" placeholder="Password"/>
				</div>
				<div class="form-group">
					<label for="usrNm" class="col-sm-2 control-label">NAME</label>
					<form:input path="usrNm" class="form-control" placeholder="Enter NAME"/>
				</div>				
				<div class="form-group">
					<label for="rrn" class="col-sm-2 control-label">생년월일</label>
					<form:input path="rrn" class="form-control" placeholder="Enter RRN"/>
				</div>				
				<div class="form-group">
					<label for="gender" class="col-sm-2 control-label">성별</label>
					<label class="radio-inline">
						<form:radiobutton path="gender" label="남" value="M"/>
					</label>
					<label class="radio-inline">
						<form:radiobutton path="gender" label="여" value="F"/>				
					</label>
				</div>
				
				<div class="form-group">
					<label for="telNum1" class="col-sm-2 control-label">전화번호</label>
					<form:input path="telNum1" class="form-control" placeholder="010"/>
					<form:input path="telNum2" class="form-control" placeholder="0000"/>
					<form:input path="telNum3" class="form-control" placeholder="0000"/>
				</div>
				<button  class="btn btn-primary">회원가입</button>
			</form:form>
			
					        
	      </div><!-- /.col-lg-10 -->
	    </div><!-- /.row -->
	  </div><!-- /.container -->
	</main>
	
<script type="text/javascript">

 function testUsrCreate(){
	
	$("#usrId").attr('value', 'qwer');
	$("#usrPw").attr('value', 'qwer');
	$("#usrNm").attr('value', '테스트 사용자');
	$("#rrn").attr('value', '930101');
	$("#gender1").attr('checked','checked');
	$("#telNum1").attr('value', '010');
	$("#telNum2").attr('value', '0000');
	$("#telNum3").attr('value', '0000');
} 
</script>
</body>
</html>