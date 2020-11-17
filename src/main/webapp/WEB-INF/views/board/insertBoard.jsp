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
	//여기 아래 부분
	$('#board_cont').summernote({
		  height: 400,                 // 에디터 높이
		  minHeight: 400,             // 최소 높이
		  maxHeight: 300,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: "최대 2048자까지 쓸 수 있습니다"	//placeholder 설정
	});

	$('#plus').click(function(){
		$('#filediv').append("")
		
	});

	cnt = 0;
	$('.infile').click(function(){
		$('#filecnt').val(++cnt);	
	});
	
	
     
});

$('#board_cont').summernote({
	  toolbar: [
		    // [groupName, [list of button]]
		    ['fontname', ['fontname']],
		    ['fontsize', ['fontsize']],
		    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
		    ['color', ['forecolor','color']],
		    ['table', ['table']],
		    ['para', ['ul', 'ol', 'paragraph']],
		    ['height', ['height']],
		    ['insert',['picture','link','video']],
		    ['view', ['fullscreen', 'help']]
		  ],
		fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
		fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
});


$('#board_cont').keyup(function (e){
    var content = $(this).val();
    $('#counter').html("("+content.length+" / 최대 500자)");    //글자수 실시간 카운팅

    if (content.length > 200){
        alert("최대 500자까지 입력 가능합니다.");
        $(this).val(content.substring(0, 500));
        $('#counter').html("(500 / 최대 500자)");
    }
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
		
		<form id="frm" class="form-horizontal" role="form" action="/board/boardinsert" method="POST" enctype="multipart/form-data">
		<%-- 
			이미지 파일 보여주기
			다운로드 버튼
		<div class="form-group">
			<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
			<div class="col-sm-10">
				<img src="${cp}/profile/${memberVo.filename}"/>

				<img src="${cp}/profileImg?userid=${memberVo.userid}" /><br>
				<button id="profileDownBtn" type="button" class="btn btn-default">다운로드
					:${memberVo.realFilename}</button>
				</a>
			</div>
		</div> --%> 
		<h2>게시글 작성</h2>
		<div id="counter">count :</div>
		<input type="submit" value="작성완료" id="sub">
		<hr>
		<label for="board_title" class="dlabel" value=""><h3>제목 : </h3></label>
		<input type="text" id="board_title" name="board_title" placeholder="" value="">
		<hr>
		
		
		
		<h3> 내 용 </h3>
		<textarea id="board_cont" name="board_cont"></textarea>
		<hr>
		
		 
	 	
		
		<t> 파일 추가 </t>	<br>
		<input id="filedel" type="button" value="목록 초기화" onclick="fileReset(this.form);">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><br><br>
			
		<input type="file" id="a" class="infile" name="file_real_name" value=""><br>
		<input type="file" id="b" class="infile" name="file_real_name" value=""><br>
		<input type="file" id="c" class="infile" name="file_real_name" value=""><br>
		<input type="file" id="d" class="infile" name="file_real_name" value=""><br>
		<input type="file" id="e" class="infile" name="file_real_name" value=""><br>
		
		
	
		del : <input type="text" name="filecnt" id="filecnt" value="0"/>
	
		
		
		<div>
			parent_seq1 : <input type="text" name="parent_seq1" value="<%= request.getParameter("parent_seq1") %>">
			board_seq1 : <input type="text" name="board_seq1" value="<%= request.getParameter("board_seq1") %>">
			board_dep : <input type="text" name="board_dep" value="<%= request.getParameter("board_dep") %>">
		</div>
		<div class="boarddiv" style="display:none">
			<label for="board_seq1" class="dlabel" style="display:none">게시글 번호 : </label>
			
			<input type="text" id="mem_id" name="mem_id" placeholder="사용자 아이디" value="<%= session.getAttribute("mem_id") %>">
			
			
			<label for="board_del" class="dlabel">삭제여부 : </label>
			<label class="label">${boardVo.board_del}</label>
			
			<label for="ctgr_seq1" class="dlabel">카테고리 : </label>
			<label class="label">${boardVo.ctgr_seq1}</label>
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

