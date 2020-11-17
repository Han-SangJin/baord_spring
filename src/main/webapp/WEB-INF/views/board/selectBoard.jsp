<%@page import="kr.or.ddit.attachfile.model.AttachVO"%>
<%@page import="kr.or.ddit.review.model.ReviewVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.downBtn{
		witdh:120px;
		height:30px;
		font-size:10px;
	}
	.label{
		display : inline-block;
		margin-left : 50px;
	}
	#modiBtn{
		margin-left : 200px;
	}
	#delBtn{
		margin-left : 50px;
	} 
	#contdiv{
		height : 400px;
	}
	#revwBtn{
		margin-left : 480px;
	}
	#revw_cont{
		width : 550px;
		height : 150px;
	}
	table {
		width: 60%;
		border-top: 1px solid #444444;
    	border-collapse: collapse;
	}
	tr, td{
		font-size :22px;
		border-bottom: 1px solid #444444;
    	padding: 10px;
	}

</style>
<script>

</script>
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
		
		<p class="lead blog-description">Jsp / selectBoard.</p>
	</div> 
  
	<div class="col-sm-8 blog-main">
		<div class="blog-post">
	
			
	<form id="frm" class="form-horizontal" role="form" enctype="multipart/form-data">

		<h2>게시판 조회</h2>
		<hr>
		  
		<div class="boarddiv">
			<label for="board_seq1" class="dlabel">게시글 번호 : </label>
			<label class="dlabe">${boardVo.board_seq1}</label>
			<label for="mem_id" class="dlabel">아이디 : </label>
			<label class="dlabel">${boardVo.mem_id}</label>
			<label for="board_date" class="dlabel">작성일 : </label>
			<label class="dlabel">
				<fmt:formatDate value="${boardVo.board_date}" pattern="yyyy-MM-dd" />
			</label>
			<br>
		</div>
		<hr>
		
		<div class="boarddiv">
			<label for="board_title" class="dlabel">제목</label>:
			<label class="dlabe">${boardVo.board_title}</label>
			
				 
				<c:set var="mem_id" value="<%= session.getAttribute("mem_id") %>"/>
			<c:choose>	
				<c:when test="${mem_id eq boardVo.mem_id}">
					<a href="/board/insertview?board_seq1=${boardVo.board_seq1}&ctgr_seq1=${boardVo.ctgr_seq1}&board_dep=${boardVo.board_dep}&parent_seq1=${boardVo.board_seq1}">
						<button id="delBtn" type="button">답글달기</button>
					</a>
					<a href="/board/selectupdate?board_seq1=${boardVo.board_seq1}">
						<button id="modiBtn" type="button">수정</button>
					</a>
					<a href="/board/boarddelete?board_seq1=${boardVo.board_seq1}&ctgr_seq1=${boardVo.ctgr_seq1}">
						<button id="delBtn" type="button">삭제</button>
					</a>
				</c:when>
				
				<c:otherwise>
					<a href="/board/boardinsert?board_seq1=${boardVo.board_seq1}&ctgr_seq1=${boardVo.ctgr_seq1}&board_dep=${boardVo.board_dep}&parent_seq1=${boardVo.board_seq1}">
						<button id="delBtn" type="button">답글달기</button>
					</a>
					
				</c:otherwise>
			</c:choose>	 
			
		</div>
		<hr>
		
		<div id="contdiv" class="boarddiv">
			<label for="board_cont" class="dlabel">내용</label><br>
			<label class="dlabe">${boardVo.getBoard_cont()}</label>
		</div>
		<hr>

		
		
		
		<div class="boarddiv" style="display:none">
			<label for="parent_seq1" class="dlabel">부모의 시퀸스 값 : </label>
			<label class="dlabe">${boardVo.parent_seq1}</label>
			
			<label for="board_dep" class="dlabel">깊이 : </label>
			<label class="dlabe">${boardVo.board_dep}</label>
			
			<label for="board_del" class="dlabel">삭제여부 : </label>
			<label class="dlabe">${boardVo.board_del}</label>
			
			<label for="ctgr_seq1" class="dlabel">카테고리 : </label>
			<label class="dlabe">${boardVo.ctgr_seq1}</label>
		</div>
	</form>











				<!--		 파 	  		일	   		목	  		록		 	-->


<h3> 파 일 목 록 </h3>
<div>
	<table>
		<tr>
			<!-- <td>파일 시퀀스</td> -->
			<!-- <td>시퀸스 이름</td> -->
			<td>파일 이름</td>
		<!-- <td>게시판 번호</td>
			<td>다운로드</td> -->
		</tr>
		
		<c:choose>
			<c:when test="${attachList.size() > 0}">
				<c:forEach var="i" begin="0" end="${attachList.size()-1}">
					<tr>

						<%-- <td>${attachList.get(i).getFile_seq1()}</td> --%>
						<%-- <td>${attachList.get(i).getFile_name()}</td> --%>
						<td><a href="/file/profileDownload?file_seq1=${attachList.get(i).getFile_seq1()}">${attachList.get(i).getFile_real_name()}</a></td>
						<%-- <td>${attachList.get(i).getBoard_seq1()}</td>
						<td><button id="profileDownBtn" type="button" class="downBtn">다운로드 :${attachList.get(i).getFile_seq1()}</button></td>
						 --%>
					</tr>	
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td>
						파일 목록이 존재하지 않습니다.
					<td>
				</tr>
			</c:otherwise>
		
		</c:choose>
	</table>
</div>
<br><br><br><br><br><br>
<hr>











					<!-- 		댓 	 	 글   		목   		록   -->


	<div>
		<h3> 댓 글 작 성</h3>
						<!-- 댓  글  작  성 -->
						
		<form action="/review/reviewinsert" method="get">
		
			<!-- <input type="text" name="revw_cont" id="revw_cont" value=""/>	 -->
			<textarea id="revw_cont" name="revw_cont"></textarea>
			<input type="text" name="mem_id" value="<%= session.getAttribute("mem_id") %>" style="display:none">
			<input type="text" name="board_seq1" value="<%= request.getParameter("board_seq1") %>" style="display:none">
			
			<br><br>					
			<input id="revwBtn" type="submit" value="작성완료">							
			<br><br><br><br><br><br>
			 
		</form>
		
		
		
		
		
		
						<!-- 댓  글  목  록 -->
	<table>
		<tr>
			<td>번호</td>
			<!-- <td>댓글 시퀀스</td> -->
			<td>댓글 내용</td>
			<td>작성 날짜</td>
			<!-- <td>삭제 여부</td> -->
			<td>작성자</td>
			<!-- <td>게시판 번호</td> -->
			<td>삭제</td>
		</tr>
		<h3> 댓 글 목 록</h3>
		<c:choose>
			
			<c:when test="${reviewList.size() > 0}">
				<c:forEach var="i" begin="0" end="${reviewList.size()-1}">
					<tr>
						<c:choose>
							
							<c:when test="${reviewList.get(i).getRevw_del() == 2}">
								<td>${i +1}</td>
								<%-- <td>${reviewList.get(i).getRevw_seq1()}</td> --%>
								<td> -- 삭제된 댓글 입니다. -- </td>
								<td>${reviewList.get(i).getRevw_dt()}</td>
								<%-- <td>${reviewList.get(i).getRevw_del()}</td> --%>
								<td>${reviewList.get(i).getMem_id()}</td>
								<%-- <td>${reviewList.get(i).getBoard_seq1()}</td> --%>
								<td></td>
								 
							</c:when>
							<c:otherwise>
								<td>${i +1}</td>
							<%-- 	<td>${reviewList.get(i).getRevw_seq1()}</td> --%>
								<td>${reviewList.get(i).getRevw_cont()}</td>
								<td>${reviewList.get(i).getRevw_dt()}</td>
								<%-- <td>${reviewList.get(i).getRevw_del()}</td> --%>
								<td>${reviewList.get(i).getMem_id()}</td>
								<%-- <td>${reviewList.get(i).getBoard_seq1()}</td> --%>
								<c:if test="${mem_id eq reviewList.get(i).getMem_id() }">
									<td><a href="/review/reviewdelete?revw_seq1=${reviewList.get(i).getRevw_seq1()}&board_seq1=${reviewList.get(i).getBoard_seq1()}"><input type="button" value="삭제"></a></td>
								</c:if>
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
	</div>
		<div>
			<label for="parent_seq1" class="dlabel">레벨 : </label>
			<label class="dlabe">${boardVo.parent_seq1}</label>
				
			<label for="board_dep" class="dlabel">원글 번호 : </label>
			<label class="dlabe">${boardVo.board_dep}</label>
		</div>
<br><br><br><br><br><br>
<hr>
	
	
		</div>
	</div>            
	<!-- /.blog-main -->
</div>	
</div>
	</div>
		
</body>
</html>
