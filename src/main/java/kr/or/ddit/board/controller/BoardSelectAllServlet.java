package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.common.model.PageVO;

@WebServlet("/boardselectallservlet")
public class BoardSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardServiceI boardService;
	
	  
 	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
 	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//page
		String page_str = request.getParameter("page");
		int page = page_str == null ? 1 : Integer.parseInt(page_str);
		request.setAttribute("page", page);
		System.out.println("page : " + page);
		
		//pageSize
		String pageSize_str = request.getParameter("pageSize");
		System.out.println("pageSize_str : " + pageSize_str);
		int pageSize = pageSize_str == null ? 10 : Integer.parseInt(pageSize_str);
		request.setAttribute("pageSize", pageSize);
		System.out.println("pageSize : " + pageSize);
		
		// ctge_seq1
		int ctgr_seq1 = Integer.parseInt(request.getParameter("ctgr_seq1"));
		System.out.println("boardselectallservlet ctgr_seq1 : " +ctgr_seq1);
		request.setAttribute("ctgr_seq1", ctgr_seq1);
			    
		// pageVo : page, pageSize
		PageVO pageVo = new PageVO(page, pageSize, ctgr_seq1);
		
		// 결과를 화면(브라우져)에 출력하기
		Map<String, Object> map = boardService.selectBoardPageList(pageVo);
		request.setAttribute("selectAllBoard", map.get("selectAllBoard"));
		request.setAttribute("pages", map.get("pages"));
		
		request.getRequestDispatcher("/board/selectAllBoard.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
} 
 