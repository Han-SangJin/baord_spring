package kr.or.ddit.board.repository;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.dao.MemberDaoI;

public class MemberDaoTest extends ModelTestConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDaoTest.class);
	
	@Resource(name="memberDao")
	private MemberDaoI memberDao;
	
}
