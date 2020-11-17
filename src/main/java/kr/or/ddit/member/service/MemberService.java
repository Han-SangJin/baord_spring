package kr.or.ddit.member.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

@Service("memberService")
public class MemberService implements MemberServiceI {
	
//	private String memId;		// 아이디		MEM_ID
//	private String memPass;		// 비밀번호	MEM_PASS
//	private Date memRegdt;		// 생성일		MEM_REGDT
		
	
	@Resource(name="memberDao")
	private MemberDaoI memberDao;
	
	
	// service 기본 생성자
	public MemberService() {
		
	}

	// service 기본 생성자
	public MemberService(MemberDaoI memberDao) {
		this.memberDao = memberDao;
	}

	
	@Override
	public MemberVO getMember(String mem_id) {
		return memberDao.getMember(mem_id);
	}
	
}
