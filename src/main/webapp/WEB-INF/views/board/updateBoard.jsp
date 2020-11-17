<%@page import="ch.qos.logback.core.recovery.ResilientSyslogOutputStream"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.ddit.attachfile.model.AttachVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="/js/summernote/summernote-lite.js"></script>
<script src="/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/css/summernote/summernote-lite.css">
<script src="/js/fileupdate.js"></script> 
<title>Insert title here</title>
<style>
	.dlabel{
		display : inline-block; 
		
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
	#board_cont{
		margin-left : 40px;
	}
	#board_title{
		width : 300px;
		height : 50px;
	}
	t {
		font-size: 23px;
		
	}
	#plus{ 
		border-radius : 50%;
		width : 35px;
		height : 35px;
		border-color : blue;
		background-color : rgba(255,255,255,0.5); 
	}
	#sub{
		margin-left : 90%; 
	}
	#filesub{
		margin-left : 15%; 
	}
	#filedel{
		margin-left : 15%; 
	
	}
</style>

<script>
$(document).ready(function() {


	 $("#attachList li").on("click", function(){
		var file_seq1 = $(this).data("fileseq1");
		 document.getElementById("i_result").innerHTML=file_seq1;
		 $('#i_result').val(file_seq1);
	})

	
	var delNumber = new Array(0,0,0,0,0);

		
	$('#del0').on('click',function(){
		alert('파일이 삭제되었습니다.')
		 $(this).parent().hide();

		var file_seq1 = $(this).parent().data("fileseq1");
		delNumber[0]= file_seq1
		 $('#divdel').val(delNumber);
	}) 
	
	$('#del1').on('click',function(){
		alert('파일이 삭제되었습니다.')
		 $(this).parent().hide();

		var file_seq1 = $(this).parent().data("fileseq1");
		delNumber[1]= file_seq1
		 $('#divdel').val(delNumber);
	})
	
	$('#del2').on('click',function(){
		alert('파일이 삭제되었습니다.')
		 $(this).parent().hide();

		var file_seq1 = $(this).parent().data("fileseq1");
		delNumber[2]= file_seq1
		 $('#divdel').val(delNumber);
	})
	
	$('#del3').on('click',function(){
		alert('파일이 삭제되었습니다.')
		 $(this).parent().hide();

		var file_seq1 = $(this).parent().data("fileseq1");
		delNumber[3]= file_seq1
		 $('#divdel').val(delNumber);
	})
	
	$('#del4').on('click',function(){
		alert('파일이 삭제되었습니다.')
		 $(this).parent().hide();

		var file_seq1 = $(this).parent().data("fileseq1");
		delNumber[4]= file_seq1
		 $('#divdel').val(delNumber);
	})
		 
	//	dell.parent('li').style.display = 'none'

	//		jQuery('.child').parent().css('color', 'red');
		
	
	
	
	/* alert("file_seq0 : " + $('input[name=index1]').val())
	
	var file_seq1 = document.getElementByName("file_seq1").value
	alert("file_seq1 : " + file_seq1) */

	
	//여기 아래 부분
	//$('#board_content').summernote('code', '${board_data.BOARD_CONTENT}');
	$('#board_cont').summernote('editor.insertText', "${board_data.BOARD_CONTENT}")
	
	$('#board_cont').summernote({
		  height: 400,                 // 에디터 높이
		  minHeight: 400,             // 최소 높이
		  maxHeight: 300,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: "최대 2048자까지 쓸 수 있습니다"	//placeholder 설정
	});


	

	
	var board_seq1 = 0;
	var arrNumber = new Array(0,0,0,0,0);
	var name= new Array();
	
	$("#files0").on("click", function(){
		
		var file_seq1 = $(this).parent().data("fileseq1");
		var file = $(this).data("fileseq1");

		
		arrNumber[0]= file_seq1
		name[0] = file
		
		 $('#di').val(arrNumber);
		 $('#nm').val(name);
		 
	})
	
	$("#files1").on("click", function(){
		
		var file_seq1 = $(this).parent().data("fileseq1");
		var file = $(this).data("fileseq1");
		arrNumber[1]= file_seq1
		name[1] = file
		 $('#di').val(arrNumber);
		 $('#nm').val(name);
	})
	  
	$("#files2").on("click", function(){
		
		var file_seq1 = $(this).parent().data("fileseq1");
		arrNumber[2]= file_seq1
		 $('#di').val(arrNumber);
	})
	  
	$("#files3").on("click", function(){
		
		var file_seq1 = $(this).parent().data("fileseq1");
		arrNumber[3]= file_seq1
		 $('#di').val(arrNumber);
	})
	
	$("#files4").on("click", function(){
		
		var file_seq1 = $(this).parent().data("fileseq1");
		arrNumber[4]= file_seq1
		 $('#di').val(arrNumber);
	})
	
	
	
	 
	
});
    // 파일 초기화
 	function fileReset(form){
 		document.getElementById("a").value = ""
 		document.getElementById("b").value = ""
 		document.getElementById("c").value = ""
 		document.getElementById("d").value = ""
 		document.getElementById("e").value = ""
	
    }

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
		<h1 class="blog-title">Category</h1>
		<p class="lead blog-description">Jsp / CategoryList.</p>
	</div> 
  
	<div class="col-sm-8 blog-main">
		<div class="blog-post">

		<form id="frm" class="form-horizontal" role="form" action="/board/boardupdate?board_seq1=${boardVo.board_seq1}" method="POST" enctype="multipart/form-data">
		
		<h2>${boardVo.board_seq1} 번 게시글 수정</h2>
		<c:set var="board_seq1" scope="request" value="${boardVo.board_seq1}"/>
		
		<input id="sub" type="submit" value="작성완료">
		<hr>
		<label for="board_title" class="dlabel" value=""><h3>제목 수정 : </h3></label>
		<input type="text" id="board_title" name="board_title" placeholder="" value="${boardVo.board_title}">
		<hr>
		
		
		<h3> 내 용 수 정</h3>
		<textarea id="board_cont" name="board_cont" placeholder="" value="">${boardVo.board_cont}</textarea>
		<hr>
		
		
		<t> 파일 수정 </t>	<br>
	 	<%
    		List<AttachVO> attachList = (List<AttachVO>) request.getAttribute("attachList");
    	%>   
		
			 	
		<input id="filedel" type="button" value="목록 초기화" onclick="fileReset(this.form);">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><br><br>
		
		
		<% 	 
			int attachsize = attachList.size();
		%>	
				<!-- file_seq 담기 -->				
				i_result : <input type="text" name="afile" id="i_result" value="0"/>
				nm : <input type="text" id="nm"/> 
				di : <input type="text" name="arr" id="di" value="0"/>
				li : <input type="text" name="li" id="li" value="0"/>
				del : <input type="text" name="delarr" id="divdel" value="0"/>

				<input type="text" name="attachsize" value="<%= attachsize %>" style="display:none">
				<ul id="attachList">
		<%		
			if(attachsize > 0){
				for(int i=0; i<attachsize; i++){
		%>		
				<li data-fileseq1="<%= attachList.get(i).getFile_seq1() %>" >
					<c:set var="fiseq" scope="request" value="<%= attachList.get(i).getFile_seq1() %>"/>
					<c:out value="${fiseq }"/>
					<fmt:formatNumber value="${fiseq }" type="number" var="numberType"/>
					<c:set var="file_seq1" scope="request" value="${fiseq }"/>
					
					<input type="text" name="file_seq1" data-fileseq1="<c:out value="${file_seq1 }"/>" value="<%= attachList.get(i).getFile_seq1() %>" style="display:none">
					<input type="file" id="files<%= i %>" name="file_real_name" value="<%= attachList.get(i).getFile_name() %>"><%= attachList.get(i).getFile_real_name() %>
					<input data-del="<%= attachList.get(i).getFile_seq1() %>" type="button" id="del<%= i %>" class="infile" name="file_real_name" value="삭제"><br><hr>
			 	</li>  
		<% }	%> 
				</ul>	
				
		<%		 
				
			}else{ // 회원정보가 존재하지 않을 경우...
		%>
						<a>등록된 파일이 존재하지 않습니다.</a>
			<%	
				}
			%>
		  
 		
		
		<div class="boarddiv" style="display:none">
			<input type="text" name="board_seq1" value="${boardVo.board_seq1}" data-boardseq1="${boardVo.board_seq1}">
			<input type="text" name="ctgr_seq1" value="<%= request.getParameter("ctgr_seq1") %>">
		</div>
	
	</form>

		</div>
	</div>            
	<!-- /.blog-main -->
</div>	
</div>
	</div>
		
</body>
</html>