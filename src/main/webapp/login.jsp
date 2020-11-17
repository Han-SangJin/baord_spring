<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<!-- <link rel="icon" href="../../favicon.ico"> -->
	
<title>Signin Template for Bootstrap</title>
	 
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet"/>
<link href="/css/signin.css" rel="stylesheet"/>
     
<style>
 #subbtn {
	width: 48%;
	}
</style>      

<script src="/js/categoryupdate.js"></script>
<script>    
	$(function(){                 
		// remember me cookie 확인
	 	if(Cookies.get("REMEMBERME")=="Y"){
			$("input[type=checkbox]").prop("checked",true);
			//$("input[type=checkbox]").attr("checked","checked");
			$("#inputEmail").val(Cookies.get("mem_id"))
			//console.log("체크");
		}                                                    
                                                                   
		// sign in b버튼이 클릭 되엇을때 이벤크 핸들러
		$("button").on('click',function(){
			console.log("button_click");
						    
		 	if($("input[type=checkbox]").prop("checked") == true){
				Cookies.set("REMEMBERME","Y");
				Cookies.set("mem_id", $("#inputEmail").val());
			}else{
				Cookies.remove("REMEMBERME");
				Cookies.remove("mem_id");
			}  
			// submit 
			$("form").submit();
		})	     
	})	                  
	                    
	function getCookieValues(cookieName){
		var cookieString = document.cookie.split("; ")
		for(var i=0; i< cookies.length; i++){
			var cookie = cookies[i];
			var cookieArr = cookie.splie("=");
				if(cookieName == cookieArr[0]){
				return cookieArr[1];
			}  
		}               
		// 원하는 쿠키가 없는 경우	function setCookie(cookieName, cookieValue, expires){
		//"USERNM=brown; path=/; expries=Wed, 07 Oct 2020 00:38:35 GMT;"
		var today = new Date();
     
		return "";  
	}	                 
                                   
	                                                         
	// 쿠키 날짜 설정 
		// 현재 날짜에서 미래로  + expires 만큼 한 날짜 구하기
		today.setDate( today.getDate() + expires );
        
		       
		document.cookie = cookieName + "=" + cookieValue + "; path=/; expires=" + today.toGMTString();
		console.log(document.cookie);
	}  
		// 해당 쿠키의 expires 속성을 과거 날짜로 변경
	function deleteCookie(cookieName){
		setCookie(cookieName, "", -1);	
	}               
</script>                              
</head>                                                 
                                                                                                                                            
                                                                                                      
<body>    
  <div class="container"> 
    <form action="${pageContext.request.contextPath}/login" method="post">
       <h2 class="form-signin-heading">Please sign in</h2>
       <label for="inputEmail" >Email address</label>
       <input type="text" name="mem_id" placeholder="Email address" required autofocus value="a001">
       <label for="inputPassword">Password</label>
       <input type="password" " name="mem_pass" placeholder="Password" required value="123">
       <div class="checkbox">
         <label>
           <input type="checkbox" value="" id="remember"> Remember me
         </label>
       </div>
       <button id="subbtn" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
     </form>
  </div> 
</body>
</html>