package kr.or.ddit.attachfile.service;

import java.util.List;

import kr.or.ddit.attachfile.model.AttachVO;
import kr.or.ddit.board.model.BoardVo;

public interface AttachServiceI {

	List<AttachVO> selectAllAttach(int board_seq1);
	
	int deleteAttach(List<AttachVO> attachList);

	int insertAttach(List<AttachVO> attachList);

	int updateBoard(List<AttachVO> attachList);

	AttachVO selectAttach(int file_seq1);

}
