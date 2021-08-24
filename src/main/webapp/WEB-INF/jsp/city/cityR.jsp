<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
CITY READ PAGE<br>

${city.cityId} / ${city.cityNm}

<br>
<a href="/city/list">목록으로</a>
	<br>
<a href="/city/update/${city.cityId}">수정</a>
	<br>
<a href="/city/delete/${city.cityId}">삭제</a> 

</body>
</html>