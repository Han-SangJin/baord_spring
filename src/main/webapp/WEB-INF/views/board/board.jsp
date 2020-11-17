<%@page import="kr.or.ddit.category.model.CtgrVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
 <%
    	List<CtgrVO> ctgrList = (List<CtgrVO>) request.getAttribute("ctgrList");
    %>        
<c:set var="ctgrList" value="<%=ctgrList %>"/>    
     
<!DOCTYPE html>
<html lang="UTF-8">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/js.cookie-2.2.1.min.js"></script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
     
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
    label{
    	width : 100px;
    }
      
  </style>
</head>



<title>Jsp</title>
<!-- 레이아웃 추가 -->
<%@ include file="../layout/commonLib.jsp" %>
</head>
  
      
<body>   
<!-- 상단 네비게이션바 -->
<%@ include file="../layout/header.jsp" %>
		

<div class="container-fluid">
<div class="row"> 

<!-- 왼쪽 사이드바 -->
<div class="col-sm-3 col-md-2 sidebar">
<%@ include file="../layout/left.jsp" %>

</div>  

<div class="col-sm-8 col-md-8  main">
	<div class="blog-header">
		<h1 class="blog-title">Category</h1>
		<p class="lead blog-description">Jsp / CategoryList.</p>
	</div> 
  
	<div class="col-sm-8 blog-main">
		<div class="blog-post">
		
		  <div class="row content">
   
   
    <div class="col-sm-3 sidenav">
      <h4>블로그</h4>
      <%= session.getAttribute("S_MEMBER") %>
      
      
      <%-- <c:forEach var="i" begin="0" end="${fn:length(ctgrList)-1}">
			${ctgrList[i]}<br>
		</c:forEach>
		   --%>
      
       
      <hr>
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="#section1">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/ctgrinsertservlet">게시판 생성</a></li>
        <li><a href="#section3">자유 게시판</a></li>
        <li><a href="#section3">공지 게시판</a></li>
      </ul><br>
  	
    </div>
 	
    <div class="col-sm-9">
      <h4><small>게시판 목록</small></h4>
      <hr>
  
    
    </div>
  </div>
	</div>
</div>            
	<!-- /.blog-main -->
</div>	
</div>
	</div>
		
</body>
</html>

