package kr.or.ddit.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.review.model.ReviewVO;
import kr.or.ddit.review.service.ReviewService;
import kr.or.ddit.review.service.ReviewServiceI;

@WebServlet("/reviewselectallservlet")
public class ReviewSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReviewServiceI reviewService;
	
	  
 	@Override
	public void init() throws ServletException {
		reviewService = new ReviewService();
	}
 	
 	
 	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_seq1 = Integer.parseInt(request.getParameter("board_seq1"));
		System.out.println("board_seq1 : " + board_seq1);
		request.setAttribute("board_seq1", board_seq1);
		
		List<ReviewVO> reviewList = reviewService.selectAllReview(board_seq1);
		System.out.println("reviewList.size() : " +reviewList.size());
		
		request.setAttribute("reviewList", reviewList);
		request.getRequestDispatcher("/attachselectallservlet").forward(request, response);
	}
 	
 	
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
 	

}
