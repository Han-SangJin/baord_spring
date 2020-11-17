package kr.or.ddit.category.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.category.dao.CtgrDaoI;
import kr.or.ddit.category.model.CtgrVO;

public class CtgrDaoTest extends ModelTestConfig {
	
	@Resource(name="ctgrDao")
	private CtgrDaoI ctgrDao;
	
	@Test
	public void selectAllCtgrTest() {
		/***Given***/

		/***When***/
		List<CtgrVO> list = ctgrDao.selectAllCtgr();
		
		/***Then***/
		assertTrue(list.size() > 10);
	}

	@Test
	public void insertCtgrTest() {
		/***Given***/
		String ctgr_name = "테스트코드게시판";
		CtgrVO ctgrVo = new CtgrVO();
		ctgrVo.setCtgr_name(ctgr_name);

		/***When***/
		int insertcnt = ctgrDao.insertCtgr(ctgrVo);

		/***Then***/
		assertEquals(1, insertcnt);
	}
	
	
	@Test
	public void updateCtgrTest() {
		/***Given***/
		CtgrVO ctgrVo = new CtgrVO();
		ctgrVo.setCtgr_seq1(85);
		ctgrVo.setCtgr_use(2);

		/***When***/
		int updatecnt = ctgrDao.updateCtgr(ctgrVo);
		
		/***Then***/
		assertEquals(1, updatecnt);
	}
	

}
