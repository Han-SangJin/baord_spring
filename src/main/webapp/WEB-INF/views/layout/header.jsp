<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 상단 네비게이션바 --> 
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button> 
			접속을 안했을 때 : ==> [] 
			접속을 했을 때 : [borwn] ==> [brown]
			<a class="navbar-brand" href="#">JSP/SPRING
				 <c:choose>
					<c:when test="${S_MEMBER.mem_id != null}">[${S_MEMBER.mem_id}]</c:when>
					<c:otherwise>[]</c:otherwise>
				</c:choose>
			</a> 
			
		</div> 
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Help</a></li>
				<li><a href="${cp}/logout">logout</a></li>
				<li><a href="${cp}/login">Login</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav>