package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.common.model.PageVO;

public interface BoardDaoI {

	BoardVo selectBoard(int board_seq1);
	
	List<BoardVo> selectAllBoard(int ctgr_seq1);
	
	List<BoardVo> selectBoardPageList(SqlSession sqlSession, PageVO pageVo);
	
	int selectBoardTotalCnt(SqlSession sqlSession, int ctgr_seq1);
	 
	int insertBoard(BoardVo boardVo);
	
	int inBoard(BoardVo boardVo);
	
	int deleteBoard(int board_seq1);
	
	int updateBoard(BoardVo boardVo);

}
