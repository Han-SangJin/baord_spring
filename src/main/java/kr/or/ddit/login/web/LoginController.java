package kr.or.ddit.login.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.category.model.CtgrVO;
import kr.or.ddit.category.service.CtgrServiceI;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;

// @WebServlet 혹은 web.xml url-mapping을 통해 url 등록

@SessionAttributes("rangers")
@RequestMapping("/login")
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired	// ioc.xml내용 자동으로 불러옴
	ApplicationContext context;
	
	
	@Resource(name="memberService")
	MemberServiceI memberService;
	
	@Resource(name="ctgrService")
	CtgrServiceI ctgrService;
	  

	
	
							/* --- View Resolver --- */
	
	// http://localhost/login/json
	// ranger() ==> Model 객체에 rangers라는 이름의 속성이 저장됨 ==> json()
	// Model 객체 송성이 존재 (rangers)
	@RequestMapping("/json")
	public String json() {
		
		return "jsonView";	// <bean id="jsonView" class="MappingJackson2JsonView"/>
				
				// view resolver를 두개 등록함
				// 1. beanNameViewResolver
				//    viewName 해당하는 빈이 있는지 찾음
				//    만약 해당하는 빈(View)이 있으면 해당 view 결과를 생성
				//    beanNameViewResolver에서 찾지 못했을 경우
				// 2. internalResourceViewResolver
				//	  prefix, surfix 설정에 따라 /WEB-INF/views/jsonView.jsp
				//    internalResourceViewResolver는 view 이름에 해당하는
				//    자원이 존재하는지, 존재하지 않는지 체크하지 않고 무조건 forwarding
				//    ** viewResolver 우선순위를 가장 후순위로 미뤄야함
	}
	
	
	
	
	
	// localhost/login/view 요청시 처리되는 메소드
	// 요청 메소드가 GET 일때만 처리  method= RequestMethod.GET
	// 요청 메소드 복수개 설정  {RequestMethod.GET, RequestMethod.POST}
	@RequestMapping(path = "/view", method = RequestMethod.GET)	
	public String getView() {
		logger.debug("LoginController.getView()");
		return "login/view";	// 이동할 url 리턴 
	}
	
	
	 
	// 파라미터 이름과 동일한 이름의 메소드 인자를 선언하면 스프링 프레임워크가 자동으로 바인딩 해준다.
	// 값을 담을 수 있는 객체를 메소드 인자로 선언한 경우에도 필드명과 파라미터 명이 동일하면 자동으로 바인딩 처리를 해준다
	// 이때 값을 담는 객체를 스프링 프레임워크에서는 command 객체라고 명명한다.
	// form 으로 전송한 데이터를 받는 객체 = command 객체
	
	
	// Model : view 객체에서 응답을 생성할 때 참조할 데이터를 담는 객체
	//		jsp/servlet 기반의 request 역할을 담당
	@RequestMapping(path="/process", params= {"mem_id"})							//login/process 로 값이 들어온다	   // 값 jsp에서 가져옴
	public String process(String mem_id, String mem_pass, MemberVO memberVo, HttpSession session, Model model) {	// RequestParam 으로 변수 명이 다를때 파라미터를 특정 변수에 할당 할 수 있다
		
		
		//logger로 id, pass 값 띄워줌
		logger.debug("LoginCOntroller.process() {} / {} / {}", mem_id, mem_pass, memberVo);	
		logger.debug("user_id : {}", mem_id);	
		
		// bean Dao에서 멤버 조회
//		MemberServiceI memberService = context.getBean("memberService", MemberServiceI.class); context 를 계속 만들어줘야 해서 의존성생김
		MemberVO dbMember = memberService.getMember(mem_id);
		logger.debug("dbMember : {}", dbMember);
		
		 
		// db에서 조회한 사용자 정보가 존재하면 ==> main.jsp 로 이동
		// db에서 조회한 사용자 정보가 존쟂하지 않으면 ==> login.jsp 로 이동
		//dbMember.getPass().equals(pass)
			 
		if(dbMember != (null) && memberVo.getMem_pass().equals(dbMember.getMem_pass()) ) {
			// prefix : /WEB-INF/views/
			// surfix : .jsp
			session.setAttribute("S_MEMBER", memberVo);
			
			List<CtgrVO> ctgrList = ctgrService.selectAllCtgr();
			session.setAttribute("ctgrList", ctgrList);
			
			// jsp/servlet 기반에서 사용한 코드 : request.setAttribute("to_day", new  Date());
			model.addAttribute("to_day", new Date());
			return "main";
				
		}else {
			model.addAttribute("msg","fail");
			return "login/view";
		}
			
	}
	
	
	// localhost/login/unt/xx
	@RequestMapping("/unt/{unt_cd}")
	public String untMain(@PathVariable("unt_cd") String unt_cd) {
		logger.debug("unt_cd : {}", unt_cd);
		return "main";
	}
	
	
	                                                                                                                                                                                                          
	// localhost/login/mavView
	@RequestMapping("/mavView")
	public ModelAndView mavView(@ModelAttribute("rangers") List<String> rangers,
								@ModelAttribute("test") MemberVO memberVo) {
								
		ModelAndView mav = new ModelAndView();
		
		logger.debug("mavView rangers : {}", rangers);
		// view name 설정
		mav.setViewName("main");
		
		mav.getModel().put("msg", "success");
		mav.getModelMap().addAttribute("msg", "fail");
		
		return mav;
	}
	
	
}