package kr.or.ddit.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//사용자에게 500 에러 대신 404 응답 코드로 응답이 가게끔 설정
@ResponseStatus(HttpStatus.NOT_FOUND)	// NOT_FOUNT = 404 error
public class NoFileException extends Exception {
	
}
