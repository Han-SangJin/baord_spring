package kr.or.ddit.attachfile.controller;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/profileDownload")
public class AttachDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberServiceI memberService;
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		// 사용자 아이디 파라미터 확인하고
//		String userid = request.getParameter("userid");
//		
//		// db에서 사용자 filename 확인
//		MemberVO memberVo = memberService.getMember(userid);
//		
//		//response content-type  설정
//		response.setHeader("Content-Disposition", "attachment; filename=\"" + memberVo.getRealFilename() + "\"");
//		response.setContentType("application/octet-stream");	
//		// mozila 사이트 에서 Content-Type - media type - Media Types의 종류 - octet 검색 내용 참고
//		
//		
//		// 경로 확인 후 파일 입츌룍울 통해 응답생성
//		// 파일 읽기
//		// 응답 생성 
//		System.out.println("memberVo.getFilename()"+ memberVo.getFilename());
//		FileInputStream fis = new FileInputStream(memberVo.getFilename());
//		ServletOutputStream sos = response.getOutputStream();
//		
//		byte[] buffer = new byte[512];
//		
//		while(fis.read(buffer) != -1) {
//			sos.write(buffer);
//		}
//		
//		 
//		fis.close();
//		sos.flush();
//		sos.close();
	}

}
