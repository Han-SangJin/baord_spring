package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.attachfile.model.AttachVO;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.review.model.ReviewVO;

@WebServlet("/boardselectservlet")
public class BoardSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardServiceI boardService;
	
	  
 	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
 	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int board_seq1 = Integer.parseInt(request.getParameter("board_seq1"));
		System.out.println("boardselectservlet board_seq1 : " + board_seq1);
		BoardVo boardVo = boardService.selectBoard(board_seq1);
		
		
		if(board_seq1 > 0) {	
			int ctgr_seq1 = Integer.parseInt(request.getParameter("board_seq1"));
			request.setAttribute("ctgr_seq1", ctgr_seq1);
		}
		
		request.setAttribute("parent_seq1", request.getAttribute("parent_seq1"));	// 부모키 번호
		System.out.println(request.getAttribute("parent_seq1"));
		request.setAttribute("board_dep", request.getAttribute("board_dep"));	// 원글 번호
		System.out.println(request.getAttribute("board_dep"));
		
		
		request.setAttribute("ctgr_seq1", request.getAttribute("ctgr_seq1"));	// 카테고리 번호
		System.out.println(request.getAttribute("ctgr_seq1"));
		request.setAttribute("board_seq1",request.getAttribute("board_seq1"));	// 게시판 번호
		System.out.println(request.getAttribute("board_seq1"));
		request.setAttribute("reviewList",request.getAttribute("reviewList"));	// 댓글 목록
		System.out.println(request.getAttribute("reviewList"));
		request.setAttribute("attachList",request.getAttribute("attachList"));	// 파일 목록
		System.out.println(request.getAttribute("attachList"));
		request.setAttribute("boardVo", boardVo);	// 게시글 내용
		System.out.println(boardVo); 
		request.getRequestDispatcher("/board/selectBoard.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
