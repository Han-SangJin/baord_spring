package kr.or.ddit.attachfile.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import kr.or.ddit.attachfile.dao.AttachDao;
import kr.or.ddit.attachfile.dao.AttachDaoI;
import kr.or.ddit.attachfile.model.AttachVO;
import kr.or.ddit.db.MybatisUtil;

@Service("attachService")
public class AttachService implements AttachServiceI {

	@Resource(name="attachDao")
	private AttachDaoI attachDao;
	
	public AttachService() {
		attachDao = new AttachDao();
	}
	
	
	@Override
	public List<AttachVO> selectAllAttach(int board_seq1) {
		return attachDao.selectAllAttach(board_seq1);
	}
	
	@Override
	public int deleteAttach(List<AttachVO> attachList) {
		return attachDao.deleteAttach(attachList); 
	}

	@Override
	public int insertAttach(List<AttachVO> attachList) {
		return attachDao.insertAttach(attachList);
	}


	@Override
	public int updateBoard(List<AttachVO> attachList) {
		return attachDao.updateBoard(attachList);
	}


	@Override
	public AttachVO selectAttach(int file_seq1) {
		return attachDao.selectAttach(file_seq1);
	}
	
}
