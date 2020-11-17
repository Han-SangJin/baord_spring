package kr.or.ddit.attachfile.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.attachfile.model.AttachVO;
import kr.or.ddit.attachfile.service.AttachService;
import kr.or.ddit.attachfile.service.AttachServiceI;

@WebServlet("/attachselectallservlet")
public class AttachSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AttachServiceI attachService;
	
	  
 	@Override
	public void init() throws ServletException {
 		attachService = new AttachService();
	}
 	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_seq1 = Integer.parseInt(request.getParameter("board_seq1"));
		System.out.println("board_seq1 : " + board_seq1);
		request.setAttribute("board_seq1", board_seq1);
		
		List<AttachVO> attachList = attachService.selectAllAttach(board_seq1);
		System.out.println("attachList.size() : " +attachList.size());
		
		 
		request.setAttribute("reviewList", request.getAttribute("reviewList"));	// 댓글 목록
		System.out.println("request.getAttribute(\"reviewList\")" + request.getAttribute("reviewList"));
		request.setAttribute("board_seq1", request.getAttribute("board_seq1"));	// 게시판 번호
		System.out.println("request.getAttribute(\"board_seq1\")" + request.getAttribute("board_seq1"));
		request.setAttribute("attachList", attachList); // 파일 목록
		System.out.println("request.getAttribute(\"attachList\")" + attachList);
		request.getRequestDispatcher("/boardselectservlet").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
