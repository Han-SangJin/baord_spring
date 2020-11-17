package kr.or.ddit.review.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.review.dao.ReviewDao;
import kr.or.ddit.review.dao.ReviewDaoI;
import kr.or.ddit.review.model.ReviewVO;

@Service("reviewService")
public class ReviewService implements ReviewServiceI {
	
	@Resource(name="reviewDao")
	private ReviewDaoI reviewDao;
	
	public ReviewService() {
		reviewDao = new ReviewDao();
	}
	
	@Override
	public List<ReviewVO> selectAllReview(int board_seq1) {
		return reviewDao.selectAllReview(board_seq1);
	}

	
	@Override
	public int deleteReview(int revw_seq1) {
		SqlSession sqlSession = MybatisUtil.getSession();
		return reviewDao.deleteReview(revw_seq1);
	}

	
	@Override
	public int insertReview(ReviewVO reviewVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		return reviewDao.insertReview(reviewVo); 
	}
}
