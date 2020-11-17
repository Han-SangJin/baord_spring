package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoI;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;

@Service("boardService")
public class BoardService implements BoardServiceI {

	@Resource(name="boardDao")
	private BoardDaoI boardDao;
	  
	public BoardService() {
		boardDao = new BoardDao();
	}
	
	
	@Override
	public BoardVo selectBoard(int board_seq1) {
		return boardDao.selectBoard(board_seq1);
	}
	
	@Override
	public List<BoardVo> selectAllBoard(int ctgr_seq1) {
		return boardDao.selectAllBoard(ctgr_seq1);
	}
	  
	@Override
	public Map<String, Object> selectBoardPageList(PageVO pageVo) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int ctgr_seq1 = pageVo.getCtgr_seq1();
		System.out.println("selectBoardPageList ctgr_seq1 : " +ctgr_seq1);
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<BoardVo> list = boardDao.selectBoardPageList(sqlSession,pageVo);
		for(BoardVo post : list) {
			System.out.println(post.getBoard_title());
			post.setBoard_title(post.getBoard_title().replaceAll(" ", "&nbsp;"));
//			System.out.println(post.getBoard_title().replaceAll(" ", "&nbsp;"));
		}
		System.out.println("실행안되는거같은데");
		map.put("selectAllBoard", boardDao.selectBoardPageList(sqlSession,pageVo));
		 
		
//		for(BoardVO post : list) {
//			System.out.println(post.getBoard_title().replaceAll(" ", "&nbsp;"));
//			
//			post.setTitle(post.getTitle().replaceAll(" ", "&nbsp;"));
//			if(("F").equals(post.getStatus())) {
//				String oldTitle = post.getTitle();
//				String newTitle = oldTitle.substring(0, oldTitle.lastIndexOf("─")+1);
//				newTitle += "[삭제된 게시글입니다]";
//				post.setTitle(newTitle);
//			}
//		}
		
		
			 
		// 15건 ==(페이지사이즈 7)==> 3페이지
		// 15/7 ==  2.14.. ==(올림)==> 3페이지 
		int totalCnt = boardDao.selectBoardTotalCnt(sqlSession, ctgr_seq1);
		int pages = (int)Math.ceil((double)totalCnt/10);
		System.out.println("pages" + pages);
		map.put("pages", pages);
		
		sqlSession.close();
		return map;
	} 
 
	@Override
	public int selectBoardTotalCnt(int ctgr_seq1) {
		SqlSession sqlSession = MybatisUtil.getSession();
		return boardDao.selectBoardTotalCnt(sqlSession, ctgr_seq1);
	}
	
	@Override
	public int insertBoard(BoardVo boardVo) {
		return boardDao.insertBoard(boardVo); 
	}
	
	@Override
	public int inBoard(BoardVo boardVo) {
		return boardDao.inBoard(boardVo); 
	}
	
	@Override
	public int deleteBoard(int board_seq1) {
		return boardDao.deleteBoard(board_seq1);
	}
	
	@Override
	public int updateBoard(BoardVo boardVo) {
		return boardDao.updateBoard(boardVo);
	}





}
