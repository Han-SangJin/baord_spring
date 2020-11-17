package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/member")
@MultipartConfig
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberServiceI memberService;   
	
//	private String memId;		// 아이디		MEM_ID
//	private String memPass;		// 비밀번호	MEM_PASS
//	private Date memRegdt;		// 생성일		MEM_REGDT
    
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}
	
    public MemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 
		   userid 파라미터 받기 
		   service 객체 준비 - 호출
		   화면담당 jsp 로 위임
		 */
		String mem_id = request.getParameter("mem_id");
		MemberVO memberVo = memberService.getMember(mem_id);
		
		request.setAttribute("memberVo", memberVo);
		request.getRequestDispatcher("/member/member.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
