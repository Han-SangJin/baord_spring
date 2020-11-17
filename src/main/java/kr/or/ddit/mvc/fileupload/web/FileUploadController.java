package kr.or.ddit.mvc.fileupload.web;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/fileupload")
@Controller
public class FileUploadController {
	
	// localhost/fileupload/view 요청시 화면 요청 처리 메소드 
	// jsp로 응답생성
	// jsp 에서는 파일을 선택할 수 있는 input 태그 1개
	// userid 파라미터를 보낼 수 있는 input 태그 1개
	// 전송을 담당하는 submit input 태그 1개를 작성
	// jsp : /WEB-INF/views/fileupload/fileupload.jsp
	// 테스트 코드 까지 작성
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	
	@RequestMapping("/view")	
	public String getView() {
		return "fileupload/fileupload";	// application-context.xml 에서 설정한 경로를 더해서 url로 보내줌
	}										// <property name="prefix" value="/WEB-INF/views/"/>
											//     +  "fileupload/fileupload"  +
											// <property name="suffix" value=".jsp"/>
	
	
	@RequestMapping("/upload")
	public String upload(String userid, @RequestPart("file") MultipartFile file) {
		logger.debug("userid : {}", userid);
		logger.debug("name : {} / filename : {} / size : {}", 
		file.getName(), file.getOriginalFilename(), file.getSize());
		
		File uploadFile = new File("d:\\upload\\" + file.getOriginalFilename());
		
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return "fileupload/fileupload";
	}
	
	
}
