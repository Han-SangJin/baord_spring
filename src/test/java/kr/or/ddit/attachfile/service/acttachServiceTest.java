package kr.or.ddit.attachfile.service;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.attachfile.model.AttachVO;

public class acttachServiceTest extends ModelTestConfig  {

	@Resource(name="attachService")
	private AttachServiceI attachService;
	
	
	
//	List<AttachVO> selectAllAttach(int board_seq1);
	@Test
	public void selectAllAttachTest() {
		/***Given***/
		int board_seq1 = 189;
		
		/***When***/
		List<AttachVO> list = attachService.selectAllAttach(board_seq1);
		
		/***Then***/
		assertTrue(list.size() >= 1);
		
	}
	
	
//	int insertAttach(List<AttachVO> attachList);
	@Test
	public void insertAttachTest() {
		/***Given***/
		AttachVO attach = new AttachVO(189,"D:\\upload\\moon.png","moon.png");
		
		List<AttachVO> attachList = new ArrayList<AttachVO>();
		attachList.add(attach);
		
		/***When***/
		int listCnt = attachService.insertAttach(attachList);
		
		/***Then***/
		assertTrue(listCnt >= 1);
	}
		
		
//	int updateBoard(List<AttachVO> attachList);
	@Test
	public void updateAttachTest() {
		/***Given***/
		AttachVO attach = new AttachVO(101,"D:\\upload\\moon.png","moon.png");
		
		List<AttachVO> attachList = new ArrayList<AttachVO>();
		attachList.add(attach);
		
		/***When***/
		int listCnt = attachService.updateBoard(attachList);
		
		/***Then***/
		assertTrue(listCnt >= 1);
	}
	
	
	
//	int deleteAttach(List<AttachVO> attachList);
	public void deleteAttachTest() {
		/***Given***/
		AttachVO attach = new AttachVO(96,"D:\\upload\\","");
		
		List<AttachVO> attachList = new ArrayList<AttachVO>();
		attachList.add(attach);
		
		/***When***/
		int listCnt = attachService.deleteAttach(attachList);
		
		/***Then***/
		assertTrue(listCnt >= 1);
	}
	
	
	
//	AttachVO selectAttach(int file_seq1);
	@Test
	public void selectAttachTest() {
		/***Given***/
		int file_seq1 = 101;
		
		/***When***/
		AttachVO attach = attachService.selectAttach(file_seq1);
		
		/***Then***/
		assertNotEquals(null, attach);
	}
	
	
	
	
	
}
