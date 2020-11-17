package kr.or.ddit.review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.review.model.ReviewVO;

@Repository("reviewDao")
public class ReviewDao implements ReviewDaoI {
	
	@Override
	public List<ReviewVO> selectAllReview(int board_seq1) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<ReviewVO> reviewList = sqlSession.selectList("review.selectAllReview", board_seq1);
		
		sqlSession.close();
		return reviewList;
	}

	@Override
	public int deleteReview(int revw_seq1) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int deleteCnt = sqlSession.update("review.deleteReview", revw_seq1);
		
		if(deleteCnt ==1){
			sqlSession.commit();
		}else{
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}

	
	@Override
	public int insertReview(ReviewVO reviewVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = 0;

		insertCnt = sqlSession.insert("review.insertReview", reviewVo);
		
		if(insertCnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
			
		sqlSession.close();
		return insertCnt;
	}
	

}
