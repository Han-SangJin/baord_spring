<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	fileupload.jsp

		<!-- 
		 jsp 에서는 파일을 선택할 수 있는 input 태그 1개
		 userid 파라미터를 보낼 수 있는 input 태그 1개
		 전송을 담당하는 submit input 태그 1개를 작성 
		 /WEB-INF/views/fileupload/fileupload.jsp
		 -->
		  
	<!-- client form method : post 
				 enctype="multipart/form-data"
		server - servlet @MultipartConfig
			   - spring Framework multipartResolver		
	-->	  
	
	<form action="${cp }/fileupload/upload" method="POST" enctype="multipart/form-data">
		userid : <input type="text" name="userid" value="brown">
		file : <input type="file" name=file>
		
		<input type="submit" value="전송">
	</form>
	
</body>
</html>