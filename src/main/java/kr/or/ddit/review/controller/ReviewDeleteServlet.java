package kr.or.ddit.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.review.service.ReviewService;
import kr.or.ddit.review.service.ReviewServiceI;

@WebServlet("/reviewdeleteservlet")
public class ReviewDeleteServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private ReviewServiceI reviewService;
	
	  
 	@Override
	public void init() throws ServletException {
 		reviewService = new ReviewService();
	}
 	
 	
 	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		int revw_seq1 = Integer.parseInt(request.getParameter("revw_seq1"));
 		int board_seq1 = Integer.parseInt(request.getParameter("board_seq1"));
 		
 		
 		int insertCnt = reviewService.deleteReview(revw_seq1);
		
		 
		if(insertCnt == 1){
			request.getSession().setAttribute("revw_seq1", revw_seq1);
	 		request.getSession().setAttribute("board_seq1", board_seq1);
		}
			
		// 1건이 아닐때 : 비정상 - 사용자가 데이터를 다시 업력할 수 있도록 등록페이지로 이동
		
		else {
			doGet(request,response);
		}
 		
 		
 		request.getRequestDispatcher("/reviewselectallservlet").forward(request, response);
 	}
 	
 	
 	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
