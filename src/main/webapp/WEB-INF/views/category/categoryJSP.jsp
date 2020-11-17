<%@page import="kr.or.ddit.category.model.CtgrVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<%
    	List<CtgrVO> ctgrList = (List<CtgrVO>) session.getAttribute("ctgrList");
%>        

		<c:set var="ctgrList" value="<%= session.getAttribute("ctgrList") %>"/>
		
<!DOCTYPE html>
<html lang="UTF-8">
<head>
<meta charset="utf-8">
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
		
		
		
        	<fieldset>
				<legend> * 게시판 생성</legend>
				<form action="${pageContext.request.contextPath }/category/ctgrInsert" method="post">
					<label for="ctgr_name">게시판 이름 : </label>
					<input type="text" id="ctgr_name" name="ctgr_name" value="${param.ctgr_name }" placeholder="게시판 이름">
					<input type="submit" value="생성"/>
				</form>
			</fieldset>
			<br><br>
			
			
			<fieldset>
				<legend> * 게시판 목록</legend>
				<c:forEach var="i" items="${ctgrList }">
					<form action="${pageContext.request.contextPath }/category/ctgrUpdate">
						
						<label>게시판 이름 : </label>
						<input type="hidden" name="ctgr_seq1" value="${i.ctgr_seq1 }">
						<input style="border:none" type="text" name="ctgr_name" value="${i.ctgr_name }" readonly>
						
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<select name="ctgr_use">
								<c:choose>
									<c:when test="${i.ctgr_use == 1 }">
										<option value="1" selected>사용</option>
										<option value="2">미사용</option>
									</c:when>
									<c:otherwise> 
										<option value="1">사용</option>
										<option value="2" selected>미사용</option>
									</c:otherwise>
								</c:choose>
							</select>
							
						&nbsp;&nbsp;&nbsp;
						<input type="submit" value="수정"/>
					</form>
					<br>
				</c:forEach>
			</fieldset>
    		
    		
		</div>
	</div>            
	<!-- /.blog-main -->
</div>	
</div>
	</div>
		
</body>
</html>
