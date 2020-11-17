package kr.or.ddit.category.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import kr.or.ddit.category.dao.CtgrDao;
import kr.or.ddit.category.dao.CtgrDaoI;
import kr.or.ddit.category.model.CtgrVO;
import kr.or.ddit.db.MybatisUtil;

@Service("ctgrService")
public class CtgrService implements CtgrServiceI {
	
//	private String memId;		// 아이디		MEM_ID
//	private String memPass;		// 비밀번호	MEM_PASS
//	private Date memRegdt;		// 생성일		MEM_REGDT
	
	@Resource(name="ctgrDao")
	private CtgrDaoI ctgrDao;
	
	public CtgrService() {
		ctgrDao = new CtgrDao();
	}
	
	   
	@Override
	public List<CtgrVO> selectAllCtgr() {
		return ctgrDao.selectAllCtgr();
	}


	@Override
	public int insertCtgr(CtgrVO ctgrVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		return ctgrDao.insertCtgr(ctgrVo);
	}


	@Override
	public int updateCtgr(CtgrVO ctgrVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		return ctgrDao.updateCtgr(ctgrVo);
	}
	
	
	@Override
	public CtgrVO getCtgr(int ctgr_seq1) {
		return ctgrDao.getCtgr(ctgr_seq1);
	}
	
}
