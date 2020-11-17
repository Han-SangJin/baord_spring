<%@page import="kr.or.ddit.review.model.ReviewVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<%
    List<ReviewVO> reviewList = (List<ReviewVO>) session.getAttribute("reviewList");
	int board_seq1 = Integer.parseInt(request.getParameter("board_seq1"));
%>   


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="mem_id" scope="session" value="<%= session.getAttribute("mem_id") %>"/>  
	<c:out value="${mem_id}"/> 
	
	<c:set var="boardsize" value="<%= reviewList.size() %>"/>
	<fmt:formatNumber value="${boardsize}" type="number" var="numberType" />
	
	<table border="1">
		<tr id=title>
			<!-- <td>댓글 시퀀스</td> -->
			<td>댓글 번호</td>
			<td>댓글 내용</td>
			<td>작성 날짜</td>
			<!-- <td>삭제 여부</td> -->
			<td>작성자</td>
			<!-- <td>게시판 번호</td> -->
			<td>삭제</td>
		</tr>
		
		<c:choose>
			
			<c:when test="${boardsize > 0}">
				<c:forEach var="i" begin="0" end="${boardsize-1}">
					<tr id="cont">
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
								<%-- <td>${reviewList.get(i).getRevw_seq1()}</td> --%>
								<td>${reviewList.get(i).getRevw_cont()}</td>
								<td>${reviewList.get(i).getRevw_dt()}</td>
								<%-- <td>${reviewList.get(i).getRevw_del()}</td> --%>
								<td>${reviewList.get(i).getMem_id()}</td>
								<%-- <td>${reviewList.get(i).getBoard_seq1()}</td> --%>
								<c:if test="${mem_id eq reviewList.get(i).getMem_id() }">
									<td><a href="/reviewdeleteservlet?revw_seq1=${reviewList.get(i).getRevw_seq1()}&board_seq1=${reviewList.get(i).getBoard_seq1()}"><input type="button" value="삭제"></a></td>
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
</body>
</html>