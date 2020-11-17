package kr.or.ddit.review.dao;

import java.util.List;

import kr.or.ddit.review.model.ReviewVO;

public interface ReviewDaoI {
	
	List<ReviewVO> selectAllReview(int board_seq1);
	
	int deleteReview(int review_seq1);
	
	int insertReview(ReviewVO reviewVo);
	
}
 