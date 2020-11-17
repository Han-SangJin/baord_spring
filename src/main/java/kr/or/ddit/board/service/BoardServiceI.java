package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.common.model.PageVO;

public interface BoardServiceI {

	BoardVo selectBoard(int board_seq1);
	
	List<BoardVo> selectAllBoard(int ctgr_seq1);
	
	Map<String, Object> selectBoardPageList(PageVO pageVo);
	
	int selectBoardTotalCnt(int ctgr_seq1);
	
	int insertBoard(BoardVo boardVo);

	int inBoard(BoardVo boardVo);
	
	int deleteBoard(int board_seq1);
	
	int updateBoard(BoardVo boardVo);
	
	
}
 