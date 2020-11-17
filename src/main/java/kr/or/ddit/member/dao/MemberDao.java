package kr.or.ddit.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

@Repository("memberDao") 
public class MemberDao implements MemberDaoI {
	
//	private String memId;		// 아이디		MEM_ID
//	private String memPass;		// 비밀번호	MEM_PASS
//	private Date memRegdt;		// 생성일		MEM_REGDT
	
	// select 
	// 한건 : selectOne
	// 여러건 : selctList
	
	@Override
	public MemberVO getMember(String mem_id) {
		SqlSession sqlSession = MybatisUtil.getSession();
		MemberVO memberVo = sqlSession.selectOne("member.getMember", mem_id);
		
		sqlSession.close();
		return memberVo;
	}
	

}
