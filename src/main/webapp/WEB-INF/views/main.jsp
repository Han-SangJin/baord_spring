<%@page import="kr.or.ddit.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">



<title>Jsp</title>
<!-- 레이아웃 추가 -->
<%@ include file="layout/commonLib.jsp" %>
</head>
 
     
<body>   
<!-- 상단 네비게이션바 -->
<%@ include file="layout/header.jsp" %>
		

<div class="container-fluid">
<div class="row"> 

<!-- 왼쪽 사이드바 -->
<div class="col-sm-3 col-md-2 sidebar">
<%@ include file="layout/left.jsp" %>

</div>  

<div class="col-sm-8 col-md-8  main">
	<div class="blog-header">
		<h1 class="blog-title">Main</h1>
		<p class="lead blog-description">Jsp / Main.</p>
	</div> 
  
	<div class="col-sm-8 blog-main">
		<div class="blog-post">
				<div class="blog-post">
			<h2 class="blog-post-title">JSP</h2>
			<p class="blog-post-meta">
				2017.10.30, room 201
			</p>
 	  
			<p>jsp를 통한 웹 프로그래밍 학습</p>
			<hr>
			 
			<h3>상세내역</h3>
			<p>JSP과정에서는 다음과 같은 내용을 학습한다.</p>
			<ul>
				<li>servlet 동작원리</li>
				<li>jsp와 servlet의 관계</li>
				<li>jsp 스크립틀릿 요소</li>
				<li>jsp action tag (standard)</li>
				<li>jstl</li>
				<li>db pooling</li>
				<li>페이지 모듈화</li>
			</ul>
		</div>
		</div>
	</div>            
	<!-- /.blog-main -->
</div>	
</div>
	</div>
		
</body>
</html>

