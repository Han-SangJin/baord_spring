package kr.or.ddit.member.repository;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest extends ModelTestConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDaoTest.class);
	
	@Resource(name="memberDao")
	private MemberDaoI memberDao;
	

	
	// MemberVo getMember(String userId);
	@Test
	public void getMember_SUCCESS_Test() {
		/***Given***/
		String mem_id = "a001";
		
		/***When***/
		MemberVO memberVo = memberDao.getMember(mem_id);
		
		/***Then***/
		assertNotEquals(null, memberVo.getMem_id());
	}
	
	
	@Test
	public void getMember_FAIL_Test() {
		/***Given***/
		String userid = "sem";
		
		/***When***/
		MemberVO memberVo = memberDao.getMember(userid);
		
		/***Then***/
		assertEquals(null, memberVo);
	}
	

}
