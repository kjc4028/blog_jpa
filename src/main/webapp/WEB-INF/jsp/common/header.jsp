<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/bootstrap-4.4.1-dist/css/bootstrap.min.css">
<script type="text/javascript" src="/resources/js/jquery-3.5.1.min.js"></script>


<style>
 [role=main]{
 	padding-top: 10rem;
 }
</style>
</head>

<body>
    <header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">JC BLOG</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
        </li>

        <sec:authorize access="isAnonymous()">
	        <li class="nav-item">
	        	<a class="nav-link" href="/usr/join">회원가입</a>
	        </li>
	        <li class="nav-item">
	        	<a class="nav-link" href="/usr/login">로그인</a>
	        </li>
	        <li class="nav-item">
	        	<a class="nav-link" href="/bbs/totallist">전체 게시물</a>
	        </li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
				<sec:authentication property="principal" var="user"/>
				
			<a class="nav-link" href="/usr/logout">${user.username}(${user.authorities})님 로그아웃</a>
			<a class="nav-link" href="/category/list">카테고리 관리</a>
			<a class="nav-link" href="/bbs/list">게시물 관리</a>
	        <a class="nav-link" href="/bbs/totallist">전체 게시물</a>
		</sec:authorize>	
		<sec:authorize access="hasAuthority('ADMIN')">
	        <li class="nav-item">
	        	<a class="nav-link" href="/city/list">도시관리(관리자)</a>
	        </li>			
		</sec:authorize>
        <!-- <li class="nav-item">
          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
        </li> -->
      </ul>
      <form class="form-inline mt-2 mt-md-0" action="/bbs/totalSearch">
        <input class="form-control mr-sm-2" name="srchTxt" type="text" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>
</header>

</body>
 </html>