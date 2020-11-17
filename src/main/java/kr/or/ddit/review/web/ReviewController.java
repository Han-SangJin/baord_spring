package kr.or.ddit.review.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.qos.logback.classic.Logger;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.web.BoardController;
import kr.or.ddit.review.model.ReviewVO;
import kr.or.ddit.review.service.ReviewServiceI;

@RequestMapping("/review")
@Controller
public class ReviewController {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(BoardController.class);
	
	@Autowired	// ioc.xml내용 자동으로 불러옴
	
	@Resource(name="reviewService")
	ReviewServiceI reviewService;
	
	
	
	@RequestMapping(path = "/reviewinsert", method = RequestMethod.GET)	
	protected String reviewinsert(String revw_cont, String mem_id, int board_seq1) {
		
 		ReviewVO reviewVo = new ReviewVO(revw_cont,mem_id,board_seq1);
 		int insertCnt = reviewService.insertReview(reviewVo);
 		
 		return "redirect:/board/selectBoard?board_seq1=" + board_seq1;
	}
	
	
	
	
	@RequestMapping(path = "/reviewdelete", method = RequestMethod.GET)
	protected String reviewdelete(int revw_seq1, int board_seq1) {
 		
 		int insertCnt = reviewService.deleteReview(revw_seq1);
 		
 		return "redirect:/board/selectBoard?board_seq1=" + board_seq1;
 	}
	
	
	
	
	
	
	
	
	
}
