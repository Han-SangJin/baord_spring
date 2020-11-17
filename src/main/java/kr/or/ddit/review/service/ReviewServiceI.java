package kr.or.ddit.review.service;

import java.util.List;

import kr.or.ddit.review.model.ReviewVO;

public interface ReviewServiceI {

	List<ReviewVO> selectAllReview(int board_seq1);
	
	int deleteReview(int revw_seq1);

	int insertReview(ReviewVO reviewVo);
}
 