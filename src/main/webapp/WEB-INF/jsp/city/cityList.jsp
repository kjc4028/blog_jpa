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
CITY LIST PAGE <br>
<a href="/city/insert">도시 등록하기</a> <br>
<c:forEach items="${list}" var="list">
${list.cityId}/  <a href="/city/read/${list.cityId}">${list.cityNm}</a> <br>
</c:forEach>
</body>
</html>