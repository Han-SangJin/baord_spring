package kr.or.ddit.attachfile.repasitory;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.attachfile.dao.AttachDaoI;
import kr.or.ddit.attachfile.model.AttachVO;
import kr.or.ddit.member.dao.MemberDaoI;

public class acttachDaoTest extends ModelTestConfig  {

	@Resource(name="attachDao")
	private AttachDaoI attachDao;
	
	
	
	
//	List<AttachVO> selectAllAttach(int board_seq1);
	@Test
	public void selectAllAttachTest() {
		/***Given***/
		int board_seq1 = 189;
		
		/***When***/
		List<AttachVO> list = attachDao.selectAllAttach(board_seq1);
		
		/***Then***/
		assertTrue(list.size() >= 1);
		
	}
}
