package kr.or.ddit.member.service;
import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.model.MemberVO;

public class memberserviceTest extends ModelTestConfig {
	
	@Resource(name="memberService")
	private MemberServiceI memberService;
	
	
	
	// MemberVo getMember(String userId);
	@Test
	public void getMember_SUCCESS_Test() {
		/***Given***/
		String mem_id = "a001";
		
		/***When***/
		MemberVO memberVo = memberService.getMember(mem_id);
		
		/***Then***/
		assertNotEquals(null, memberVo.getMem_id());
	}
	
	@Test
	public void getMember_FAIL_Test() {
		/***Given***/
		String userid = "sem";
		
		/***When***/
		MemberVO memberVo = memberService.getMember(userid);
		
		/***Then***/
		assertEquals(null, memberVo);
	}
	
	
	
}
