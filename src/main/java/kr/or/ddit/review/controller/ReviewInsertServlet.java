package kr.or.ddit.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.review.model.ReviewVO;
import kr.or.ddit.review.service.ReviewService;
import kr.or.ddit.review.service.ReviewServiceI;

@WebServlet("/reviewinsertservlet")
public class ReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReviewServiceI reviewService;
	
	  
 	@Override
	public void init() throws ServletException {
		reviewService = new ReviewService();
	}
 	
 	
 	@Override
 	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
 		doPost(request, response);
 	}
 	
 	
 	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		request.setCharacterEncoding("utf-8");
 		String revw_cont = request.getParameter("revw_cont");
 		System.out.println("reviewinsertservlet : " + revw_cont);
 		String mem_id = request.getParameter("mem_id"); 
 		int board_seq1 = Integer.parseInt(request.getParameter("board_seq1"));
 		
 		 
 		ReviewVO reviewVo = new ReviewVO(revw_cont,mem_id,board_seq1);
 		int insertCnt = reviewService.insertReview(reviewVo);
 		
 		
 		if(insertCnt == 1){
			request.getRequestDispatcher("/reviewselectallservlet").forward(request, response);
		}else {
			doGet(request,response);
		}
 		
	}

}
