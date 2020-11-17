<%@ page import="kr.or.ddit.category.model.CtgrVO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<body>
	<ul class="nav nav-sidebar">
		<li class="active"><a href="${pageContext.request.contextPath}/login/unt/main">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="${pageContext.request.contextPath}/memberList/process">사용자</a></li>
		<li class="active"><a href="${pageContext.request.contextPath}/category/view">게시판 생성</a></li>
	
		<c:set var="ctgrsize" value="${ctgrList.size()-1}"/>
		 
		<c:forEach var="i" begin="0" end="${ctgrsize}">
			<c:if test="${ctgrList.get(i).getCtgr_use() == 1}">
				<li class="active"><a href="${pageContext.request.contextPath}/board/boardselectall?ctgr_seq1=${ctgrList.get(i).getCtgr_seq1()}">
						${ctgrList.get(i).getCtgr_name()}</a></li>
			</c:if>
		</c:forEach>
 	
	</ul>
</body>