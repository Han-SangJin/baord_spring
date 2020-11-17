package kr.or.ddit.category.service;

import java.util.List;

import kr.or.ddit.category.model.CtgrVO;

public interface CtgrServiceI {

	CtgrVO getCtgr(int ctgr_seq1);
	
	List<CtgrVO> selectAllCtgr();
	
	int insertCtgr(CtgrVO ctgrVo);
	
	int updateCtgr(CtgrVO ctgrVo); 
}
  