package kr.or.ddit.category.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.ddit.category.model.CtgrVO;
import kr.or.ddit.db.MybatisUtil;

@Repository("ctgrDao")
public class CtgrDao implements CtgrDaoI {
	
	// select 
	// 한건 : selectOne
	// 여러건 : selctList
	
	@Override
	public List<CtgrVO> selectAllCtgr() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<CtgrVO> ctgrList =  sqlSession.selectList("ctgr.selectAllCtgr");
		 
		sqlSession.close();
		return ctgrList;
	}
	
	@Override
	public int insertCtgr(CtgrVO ctgrVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int insertCnt = 0;

		try{
			insertCnt = sqlSession.insert("ctgr.insertCtgr", ctgrVo);
			System.out.println(ctgrVo.getCtgr_name());
			System.out.println(ctgrVo.getCtgr_use());
		}catch(Exception e){
			
		}

		if(insertCnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int updateCtgr(CtgrVO ctgrVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int updateCnt = sqlSession.delete("ctgr.updateCtgr", ctgrVo);
		
		if(updateCnt ==1){
			sqlSession.commit();
		}else{
			sqlSession.rollback();
		}
		sqlSession.close();
		return updateCnt;
	}

	@Override
	public CtgrVO getCtgr(int ctgr_seq1) {
		SqlSession sqlSession = MybatisUtil.getSession();
		CtgrVO ctgrVo = sqlSession.selectOne("ctgr.getCtgr", ctgr_seq1);
		
		sqlSession.close();
		return ctgrVo;
	}

	
	

}
