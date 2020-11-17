package kr.or.ddit.board.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.classic.Logger;
import kr.or.ddit.attachfile.model.AttachVO;
import kr.or.ddit.attachfile.service.AttachService;
import kr.or.ddit.attachfile.service.AttachServiceI;
import kr.or.ddit.board.controller.FileUploadUtil;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.review.model.ReviewVO;
import kr.or.ddit.review.service.ReviewServiceI;

@RequestMapping("/board")
@MultipartConfig
@Controller
public class BoardController {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(BoardController.class);
	
	@Autowired	// ioc.xml내용 자동으로 불러옴
	
	@Resource(name="boardService")
	BoardServiceI boardService;
	
	@Resource(name="reviewService")
	ReviewServiceI ReviewService;
	
	@Resource(name="attachService")
	AttachServiceI attachService;


	@RequestMapping(path = "/boardselectall", method = RequestMethod.GET)	
	public String boardSelectAll(HttpSession session, Model model, BoardVo boardVo, int ctgr_seq1,
									@RequestParam(name="page", required = true, defaultValue = "1") String page_str,
									@RequestParam(name="pageSize", required = true, defaultValue = "10") String pageSize_str){

		
		logger.debug("Board-Controller.boardselectall()");
		PageVO pageVo = new PageVO();
		pageVo.setPage(Integer.parseInt(page_str));
		pageVo.setPageSize(Integer.parseInt(pageSize_str));
		pageVo.setCtgr_seq1(ctgr_seq1);
		session.setAttribute("ctgr_seq1", ctgr_seq1);
		Map<String, Object> map = boardService.selectBoardPageList(pageVo);

		logger.debug("boardselectall() - map : " + map);
		session.setAttribute("selectAllBoard", map.get("selectAllBoard"));
		model.addAttribute("pages", map.get("pages"));
		model.addAttribute("page", Integer.parseInt(page_str));
		model.addAttribute("pageSize", Integer.parseInt(pageSize_str));
		model.addAttribute("boardVo", boardVo);
		
		return "board/selectAllBoard";
	}
	
	
	
	@RequestMapping(path = "/selectBoard", method = RequestMethod.GET)	
	public String selectBoard(HttpSession session, Model model, BoardVo boardVo, int board_seq1) {
		
		board_seq1 = boardVo.getBoard_seq1();
		boardVo = boardService.selectBoard(board_seq1);
		session.setAttribute("ctgr_seq1",boardVo.getCtgr_seq1());
		model.addAttribute("board_seq1",boardVo.getBoard_seq1());
		model.addAttribute("boardVo", boardVo);
		session.setAttribute("mem_id",boardVo.getMem_id());
		logger.debug("BoardController - boardSelectAll - Board -{} : ", boardVo);
		
		
		List<ReviewVO> reviewList = ReviewService.selectAllReview(boardVo.getBoard_seq1());
		logger.debug("BoardController - boardSelectAll - reviewList -{} : ", reviewList);
		List<AttachVO> attachList = attachService.selectAllAttach(boardVo.getBoard_seq1());
		logger.debug("BoardController - boardSelectAll - attachList -{} : ", attachList);
		
		model.addAttribute("reviewList",reviewList);
		model.addAttribute("attachList",attachList);
		
			
		return "board/selectBoard";
	}
	
	
	
	@RequestMapping(path = "/insertview", method = RequestMethod.GET)	
	public String insertview(int ctgr_seq1, int parent_seq1) {
		
		return "board/insertBoard";
	}
	
	
	@RequestMapping(path = "/boardinsert", method = RequestMethod.POST)	
	public String BoardInsert(HttpSession session, Model model, HttpServletRequest reuqest,
							String board_title, String board_cont, int ctgr_seq1,
							@RequestParam(name="parent_seq1", required = true, defaultValue = "0") String parent_seq,
							@RequestParam(name="board_dep", required = true, defaultValue = "0") String board_dep1,
							@RequestParam(name="board_seq1", required = true, defaultValue = "0") String board_seq,
							@RequestParam(name="filecnt", required = true, defaultValue = "0") String filecn,
							@RequestPart("file_real_name") MultipartFile file) throws IllegalStateException, IOException, ServletException {
							
		
		logger.debug("boardVo : {}",boardVo);
		
		
		MemberVO mem = new MemberVO();
		mem = (MemberVO) session.getAttribute("S_MEMBER");
		String mem_id = mem.getMem_id();
		
		int filecnt = Integer.parseInt(filecn);
		System.out.println(filecnt);
		
		
		int parent_seq1 = Integer.parseInt(parent_seq);
		System.out.println(parent_seq1);
		
		if(board_dep1.equals(null) || board_dep1.equals("")) {
			int board_dep = 0;
			System.out.println("board_dep : " + board_dep);
		}
		
		if(board_seq.equals(null) || board_seq.equals("")) {
			int board_seq1 = 0;
			System.out.println("board_dep : " + board_seq1);
		}
		
		// 게시판 정보 가져오기
		if(board_title.equals(null) || board_title.equals("")) {
			board_title = "(제목 없음)";
		}
		if(board_cont.equals(null) || board_cont.equals("")) {
			board_cont = "(내용 없음)";
		}
		
		
		// 게시판 정보 등록
		
		
		int insertCnt = 0;
		// 새글 작성하는 경우
		if(parent_seq1 == 0) {
			parent_seq1 = 0;
			boardVo = new BoardVo(board_title,board_cont,mem_id,ctgr_seq1,parent_seq1);
		
			logger.debug("BoardInsert - boardVo : {} ",boardVo);
			int inserCnt = boardService.insertBoard(boardVo);
			System.out.println("inserCnt : " + inserCnt);
		
		// 답글 작성하는 경우
		}else {
			System.out.println("board_dep :::: " + Integer.parseInt(board_dep1));
			System.out.println("board_seq1 :::: " + Integer.parseInt(board_seq));
			parent_seq1 = Integer.parseInt(board_seq);
			int board_dep = Integer.parseInt(board_seq);
			
			boardVo = new BoardVo(parent_seq1,board_title,board_cont,board_dep,mem_id,ctgr_seq1);
			int inCnt = boardService.inBoard(boardVo);
			System.out.println("inCnt : " + inCnt);
		}
			

		
		// 파일정보 보내기
		
		if(filecnt>0) {
			
			List<AttachVO> attachList = new ArrayList<>();
			for(int i=0; i<filecnt; i++) {
				
				String real_Filename = "D:\\upload\\" + file.getOriginalFilename();
				System.out.println(real_Filename);
				System.out.println(file.getOriginalFilename());
				File uploadFile = new File(real_Filename);
				
				try {
					file.transferTo(uploadFile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				
				 
				AttachVO attachVo = new AttachVO(real_Filename,file.getOriginalFilename());
				attachList.add(attachVo);
				
				// 파일 정보 등록
				logger.debug("attachList : {}", attachList);
			}
			int fileCnt = attachService.insertAttach(attachList);
		}
			
		// 글작성 성공시 페이지 이동
		return "redirect:boardselectall?ctgr_seq1="+ctgr_seq1;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(path = "/boarddelete", method = RequestMethod.GET)	
	public String boarddelete(int board_seq1, int ctgr_seq1) {
		
		
		int insertCnt = boardService.deleteBoard(board_seq1);
		
		 
		if(insertCnt == 1){
			
			return "redirect:boardselectall?ctgr_seq1="+ctgr_seq1;
		}else {
			
			return "board/selectBoard";
		}
	}
	
	
	
	


	
	
	
	
	
	
	
	BoardVo boardVo;
	List<AttachVO> attachList;
	AttachVO attachVo;
	String path = "";
	String real = "";
	
	@RequestMapping(path = "/selectupdate", method = RequestMethod.GET)
	protected String selectupdate(Model model, int board_seq1) {
 		
 		// 업데이트 jsp 에서 카테고리 번호와 게시판 번호를 가지고 와서
 		// 그번호에 맞는 게시판의 정보를 다시 불러온다.
 		
 		// 게시글 내용
 		boardVo = boardService.selectBoard(board_seq1);
 		
 		// 파일 목록
 		attachList = attachService.selectAllAttach(board_seq1);
 		
 		// 가져온 정보를 업데이트 화면에 뿌려줌
 		model.addAttribute("boardVo", boardVo);
 		model.addAttribute("attachList", attachList);
 		
 		return "board/updateBoard";
	}
	
 	
 	// 수정한 정보를 DB에 저장
	//	int file_seq1;				// 파일 번호
	//	String file_name;			// 파일 key값 부여한 이름
	//	String file_real_name;		// 파일 원래이름
	@RequestMapping(path = "/boardupdate", method = RequestMethod.POST)
	protected String boardupdate(HttpSession session,int board_seq1,String board_title,String board_cont
								 ,int attachsize,String arr,String delarr,
										@RequestPart("file_real_name") MultipartFile file[]) {
 		
 		// 게시판 정보 등록
 		BoardVo boardVo = new BoardVo(board_seq1,board_title,board_cont);
 		int boardCnt = boardService.updateBoard(boardVo);
 		
 		String arr1 = arr;
		String[] cntarray = arr1.split(",");
		int[] ctarray = {0,0,0,0,0};
		int intcnt = 0;
		
		
		// 0이아닌 게시판갯수 세기
		int arcnt = 0;
		for(int i=0; i<ctarray.length; i++) {
			ctarray[i] = Integer.parseInt(cntarray[i]);
			if(ctarray[i]>0) {
				arcnt++;
			}
		}
		
		System.out.println(arcnt);
		
		
		if(arcnt >0) {
		
		List filelist = new ArrayList();
		
		// String 형 arr를 int형으로 바꿈
		for(int i=0; i<file.length; i++) {
			
			ctarray[i] = Integer.parseInt(cntarray[i]);
			System.out.println("ctarray[i] : " + ctarray[i]);
		
			if(!file[i].getOriginalFilename().equals("")) {
				
				String file_real_name = file[i].getOriginalFilename();
				System.out.println("file_real_name : " + file_real_name);
				
				String file_name = "D:\\upload\\" + file[i].getOriginalFilename();
				System.out.println("file_name : " +file_name);
				
				File uploadFile = new File(file_name);
				
				try {
					file[i].transferTo(uploadFile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			
				AttachVO attachV = new AttachVO(ctarray[i],file_name,file_real_name);
				System.out.println("attachV : " + attachV );
				logger.debug("attachV : {}", attachV);
				
				filelist.add(attachV);
			}
		}
		
			// 파일 정보 업뎃
		int attachCnt = attachService.updateBoard(filelist);

		}
		
		
		
		// 파일삭제
		String[] delarray = delarr.split(",");
		int[] dellarray = {0,0,0,0,0};
		int delcnt = 0;
		int dellcnt = 0;
		List<AttachVO> delList = new ArrayList();
		
		// String 형 delarray를 int형으로 바꿈
		for(int i=0; i<delarray.length; i++) {
			dellarray[i] = Integer.parseInt(delarray[i]);
			if(dellarray[i] > 0) {
				AttachVO attachVo = new AttachVO(Integer.parseInt(delarray[i]));
				delList.add(dellcnt,attachVo);
				dellcnt++;
			}	
		}
		
		// dellarray 길이 계산
		for(int i=0; i<dellarray.length; i++) {
			if(dellarray[i] > 0) {
				delcnt++;
			}
		}
		
		if(delcnt <= 0 ) {
			// delcnt = 0 이면 아무것도 하지 않는다.
			System.out.println("삭제파일 없음");
		}else {
			
			System.out.println("delcnt : " + delcnt);
			System.out.println("delarray.length : "+delarray.length);
			System.out.println(dellarray[0]);
			System.out.println(dellarray[1]);
			System.out.println("delList.size() : " + delList.size());
			System.out.println("delList.size() : " + delList.get(0).getFile_seq1());
			int delCnt = attachService.deleteAttach(delList);
		}
		
		int ctgr_seq1 = (int) session.getAttribute("ctgr_seq1");
		
		if(intcnt >= 1){
			return "redirect:/board/selectBoard?board_seq1=" + board_seq1;
		}else {
			return "redirect:/board/selectBoard?board_seq1=" + board_seq1;
		}
		
	}
 	
 	
 	
 	
}
