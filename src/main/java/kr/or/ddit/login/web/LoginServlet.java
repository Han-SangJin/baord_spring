package kr.or.ddit.login.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.category.model.CtgrVO;
import kr.or.ddit.category.service.CtgrService;
import kr.or.ddit.category.service.CtgrServiceI;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	private MemberServiceI memberService;
	private CtgrServiceI ctgrService;
	
	@Override
	public void init() throws ServletException {
		// service 객체 생성
		memberService = new MemberService();
		ctgrService = new CtgrService();
	}
	
	
	// login 화면을 클라이언트에게 응답으로 생성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("LoginServlet doget");
		logger.debug("UNT_CD parameter : {}", request.getParameter("UNT_CD"));
		System.out.println(("UNT_CD parameter : {}"+ request.getParameter("UNT_CD")));
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
	
	 
	// login 화면에서 사용자가 보낸 아이디 비밀번호를 사용하여 로그인 처리 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("LoginServlet dopost");
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		
		logger.debug("memId : {}, memPass : {} ", mem_id, mem_pass);

		// 파라미터로 온 userId가 디비상에 존재하는지 확인하고, 비밀번호가 데이터베이스에 저장된 비밀번호와 일치하는지 확인
		// SELECT * 
		// FROM 회원
		// WHERE 회원아아디 = 파라미터로 넘어온 userId;
		// 일치할 경우
				// main 페이지 이동
		// 일치하지 않을 경우
				// login 페이지 이동
		
		MemberVO memberVo = memberService.getMember(mem_id);
		 
		// 디비에 등록된 회원이 없거나 비밀번호가 틀린경우 (로그인 페이지)
		if(memberVo == null || !memberVo.getMem_pass().equals(mem_pass)) {
			System.out.println("접속실패");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}	
		// 비밀번호가 일치하는 경우 (메인페이지 이동)
		else if(memberVo.getMem_pass().equals(mem_pass)) {
			 
			System.out.println("접속성공!!!");
			request.getSession().setAttribute("mem_id", mem_id);
			request.getSession().setAttribute("S_MEMBER", memberVo);
			request.getSession().setAttribute("S_MEMBER", memberVo);
			
			List<CtgrVO> ctgrList = ctgrService.selectAllCtgr();
			request.getSession().setAttribute("ctgrList", ctgrList);
			
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}
		
		// 쿠키정보
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			logger.debug("name : {}, value : {}", cookie.getName(), cookie.getValue());
			cookie.getName();
			cookie.getValue();
		}
		 
		Cookie cookie = new Cookie("SERVERCOOKIE", "COOKIEVALUE");
		cookie.setMaxAge(60*60*24);
		
		response.addCookie(cookie);
		
	
	}

}
