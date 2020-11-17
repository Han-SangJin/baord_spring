package kr.or.ddit.category.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.category.model.CtgrVO;

public class CtgrServiceTest extends ModelTestConfig {
	
//	private String memId;		// 아이디		MEM_ID
//	private String memPass;		// 비밀번호	MEM_PASS
//	private Date memRegdt;		// 생성일		MEM_REGDT

	
	@Resource(name="ctgrService")
	private CtgrServiceI ctgrService;
	
	
	@Test
	public void selectAllCtgrTest() {
		/***Given***/

		/***When***/
		List<CtgrVO> list = ctgrService.selectAllCtgr();
		
		/***Then***/
		assertEquals(18, list.size());
	}

	@Test
	public void insertCtgrTest() {
		/***Given***/
		String ctgr_name = "테스트코드게시판";
		CtgrVO ctgrVo = new CtgrVO();
		ctgrVo.setCtgr_name(ctgr_name);

		/***When***/
		int insertcnt = ctgrService.insertCtgr(ctgrVo);

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
		int updatecnt = ctgrService.updateCtgr(ctgrVo);
		
		/***Then***/
		assertEquals(1, updatecnt);
	}
	
}
