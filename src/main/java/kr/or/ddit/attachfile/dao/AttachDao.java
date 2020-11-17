package kr.or.ddit.attachfile.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.ddit.attachfile.model.AttachVO;
import kr.or.ddit.db.MybatisUtil;

@Repository("attachDao")
public class AttachDao implements AttachDaoI {
	
	
	@Override
	public List<AttachVO> selectAllAttach(int board_seq1) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<AttachVO> attachList = sqlSession.selectList("attach.selectAllAttach", board_seq1);
		
		sqlSession.close();
		return attachList;
	}

	
	@Override
	public int deleteAttach(List<AttachVO> attachList) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int deleteCnt = sqlSession.delete("attach.deleteAttach", attachList);
		
		if(deleteCnt >= 1){
			sqlSession.commit();
		}else{
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}

	
	@Override
	public int insertAttach(List<AttachVO> attachList) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = 0;
		
		insertCnt = sqlSession.insert("attach.insertAttach", attachList);
		
		if(insertCnt >= 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
			
		sqlSession.close();
		return insertCnt;
	}

	
	@Override
	public int updateBoard(List<AttachVO> attachList) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int updateCnt = sqlSession.update("attach.updateAttach", attachList);
		
		if(updateCnt ==1){
			sqlSession.commit();
		}else{
			sqlSession.rollback();
		}
		sqlSession.close();
		return updateCnt;
	}
	
	
	@Override
	public AttachVO selectAttach(int file_seq1) {
		SqlSession sqlSession = MybatisUtil.getSession();
		AttachVO attachVo = sqlSession.selectOne("attach.selectAttach", file_seq1);
		
		if(!attachVo.equals("") && !attachVo.equals(null)){
			sqlSession.commit();
		}else{
			sqlSession.rollback();
		}
		sqlSession.close();
		return attachVo;
	}

}
