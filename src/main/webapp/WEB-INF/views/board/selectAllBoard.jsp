<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="ch.qos.logback.core.recovery.ResilientSyslogOutputStream"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<%
    	List<BoardVo> selectAllBoard = (List<BoardVo>) session.getAttribute("selectAllBoard");
%>    
 
	<c:set var="selectAllBoard" value="<%= selectAllBoard %>"/>
	<c:set var="boardsize" value="<%= selectAllBoard.size() %>"/>
	<fmt:formatNumber value="${boardsize}" type="number" var="numberType" /> 
	
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<style>
	#title td {
		font-size:24px;
	}
	#cont td{
		font-size:20px;
	} 
	.title {
		width : 600px;
	}
	.date {
		width : 200px;
	}
	.id {
		width : 150px;
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
		<h1 class="blog-title">Board</h1>
		<p class="lead blog-description">Jsp / BoardList.</p>
	</div> 
  
	<div class="col-sm-8 blog-main">
		<div class="blog-post">
				
				
	<a href="/board/insertview?ctgr_seq1=${ctgr_seq1}&parent_seq1=0"><input type="button" value="새로운 글 등록"></a>
	 
	int boardsize : ${ boardsize }
 	page : ${ page }
 	pages : ${ pages }
 	pageSize : ${ pageSize }
 	ctgr_seq1 : ${ctgr_seq1}
 	
 	<c:set var="ctgr_seq1" value="${ctgr_seq1}" scope="session"/>
 	
	<br><br>

	<table border="1">
			<tr id=title>
				<td width="100px">번호</td>
				<td class="title">제목</td>
				<td>작성일</td>
				<td>아이디</td>
			</tr>
		
		<c:choose>
			<c:when test="${selectAllBoard.size() > 0}">
				<c:forEach var="i" begin="0" end="${selectAllBoard.size()-1}">
					<tr id="cont">
						<c:choose>
							<c:when test="${ selectAllBoard.get(i).getBoard_del() == 2 }">
								<td>${ selectAllBoard.get(i).getBoard_seq1() }</td> 
								<td class="title"> 삭제된 게시물 입니다.</td>
								<td class="date"> </td>
								<td class="id"> </td>
							</c:when>
							<c:otherwise>
								<td>${ selectAllBoard.get(i).getBoard_seq1() }</td>
								<td class="title"><a href="/board/selectBoard?board_seq1=${selectAllBoard.get(i).getBoard_seq1()}">${selectAllBoard.get(i).getBoard_title()}</a></td>
								<td class="date">${ selectAllBoard.get(i).getBoard_date() }</td>
								<td class="id">${ selectAllBoard.get(i).getMem_id() }</td>
							</c:otherwise>	
						</c:choose>
					</tr>
				</c:forEach> 
			</c:when>
			<c:otherwise>
				글 목록이 존재하지 않습니다.
			</c:otherwise>
		</c:choose>
	</table>
	
	<div class="text-center">
		<ul class="pagination">
			<c:choose>
				<c:when test="${1 < page}">
					<li><a href="/board/boardselectall?page=1&ctgr_seq1=${ctgr_seq1}&pageSize=${pageSize}">◀◀</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/board/boardselectall?page=${page}&ctgr_seq1=${ctgr_seq1}&pageSize=${pageSize}">◀◀</a></li>
				</c:otherwise>
			</c:choose>	
		
			<c:choose>
				<c:when test="${1 < page}">
					<li><a href="/board/boardselectall?page=${page-1}&ctgr_seq1=${ctgr_seq1}&pageSize=${pageSize}">◀</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/board/boardselectall?page=${page}&ctgr_seq1=${ctgr_seq1}&pageSize=${pageSize}">◀</a></li>
				</c:otherwise>
			</c:choose>	
			
				<c:forEach var="i" begin="1" end="${pages }">
					<c:choose>
						<c:when test="${i == page}">
							<li class="active"><span>${i}</span></li>
						</c:when>
						<c:otherwise>
							<li><a href="/board/boardselectall?page=${i}&ctgr_seq1=${ctgr_seq1}&pageSize=${pageSize}">${i}</a></li>
						</c:otherwise>
							  
					</c:choose>				
				</c:forEach>
				
			<c:choose>
				<c:when test="${page < pages}">
					<li><a href="/board/boardselectall?page=${page+1}&ctgr_seq1=${ctgr_seq1}&pageSize=${pageSize}">▶</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/board/boardselectall?page=${page}&ctgr_seq1=${ctgr_seq1}&pageSize=${pageSize}">▶</a></li>
				</c:otherwise>
			</c:choose>	
			
			<c:choose>
				<c:when test="${page < pages}">
					<li><a href="/board/boardselectall?page=${pages}&ctgr_seq1=${ctgr_seq1}&pageSize=${pageSize}">▶▶</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/board/boardselectall?page=${page}&ctgr_seq1=${ctgr_seq1}&pageSize=${pageSize}">▶▶</a></li>
				</c:otherwise>
			</c:choose>	
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