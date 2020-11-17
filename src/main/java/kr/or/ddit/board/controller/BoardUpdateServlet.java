package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.attachfile.model.AttachVO;
import kr.or.ddit.attachfile.service.AttachService;
import kr.or.ddit.attachfile.service.AttachServiceI;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

@WebServlet("/boardupdateservlet")
@MultipartConfig
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceI boardService;
	private AttachServiceI attchService;
	
	BoardVo boardVo;
	List<AttachVO> attachList;
	AttachVO attachVo;
	String path = "";
	String real = "";
	
	  
 	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		attchService = new AttachService();
	}
 	
 	// 수정할 정보를 업데이트 페이지로 가져옴
 	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		request.setCharacterEncoding("utf-8");
 		
 		// 업데이트 jsp 에서 카테고리 번호와 게시판 번호를 가지고 와서
 		// 그번호에 맞는 게시판의 정보를 다시 불러온다.
 		
 		// 게시글 내용
 		int board_seq1 = Integer.parseInt(request.getParameter("board_seq1"));
 		boardVo = boardService.selectBoard(board_seq1);
 		
 		// 파일 목록
 		attachList = attchService.selectAllAttach(board_seq1);
 		
		
 		// 가져온 정보를 업데이트 화면에 뿌려줌
		request.setAttribute("boardVo", boardVo);
		request.setAttribute("attachList", attachList);
 		request.getRequestDispatcher("/board/updateBoard.jsp").forward(request, response);
	}
	
 	
 	// 수정한 정보를 DB에 저장
	//	int file_seq1;				// 파일 번호
	//	String file_name;			// 파일 key값 부여한 이름
	//	String file_real_name;		// 파일 원래이름
 	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		request.setCharacterEncoding("utf-8");
 		
 		int board_seq1 = Integer.parseInt(request.getParameter("board_seq1"));
 		System.out.println("board_seq1 + " +board_seq1);
 		String board_title = (String) request.getParameter("board_title");
 		System.out.println("board_title + " +board_title);
 		String board_cont = request.getParameter("board_cont");
 		System.out.println("board_cont + " +board_cont);
 		int attachsize = Integer.parseInt(request.getParameter("attachsize"));
 		// 게시판 정보 등록
 		BoardVo boardVo = new BoardVo(board_seq1,board_title,board_cont);
 		int boardCnt = boardService.updateBoard(boardVo);
 		System.out.println("attachsize : " +attachsize);
 		System.out.println("boardCnt : = "+boardCnt);
 		
 		
 		String arr1 = request.getParameter("arr");
		String[] cntarray = arr1.split(",");
		int[] ctarray = {0,0,0,0,0};
		int intcnt = 0;
		
		// String 형 arr를 int형으로 바꿈
		for(int i=0; i<cntarray.length; i++) {
			ctarray[i] = Integer.parseInt(cntarray[i]);
			System.out.println("ctarray[i] : " + ctarray[i]);
		}
		
		
		// ctarray 길이 계산
		for(int i=0; i<ctarray.length; i++) {
			if(ctarray[i] > 0) {
				intcnt++;
			}
		}
 		
 		System.out.println(intcnt);
 		
 		
 		// 파일이 없으면 실행하지 않음
		if(intcnt <= 0) {
			System.out.println("수정 파일 없음");
			
			
		// 파일이 있는 경우에만 실행	
		}else {
 		
			// 파일정보 보내기
			List<AttachVO> attUpList = new ArrayList<>();
			
			int u = 0;
			int y = 0;
			for (Part profile : request.getParts()) {
				String file_real_name = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
				System.out.println("y  :  " +y);
				y++;
				String ext = (".").concat(FileUploadUtil.getExtension(file_real_name));
				String fileName = UUID.randomUUID().toString();
				String file_name = ""; 
				
				if(profile.getSize() > 0) {
					file_name = "D:\\attachfile\\" + fileName + ext;
					profile.write(file_name);
				}
				
				
				if (profile.getSize()>0 && !file_name.equals("") && !file_real_name.equals("") ){
					String arr = request.getParameter("arr");
					String[] array = arr.split(",");
					
					System.out.println("arr : " + arr);
					
					System.out.println("u : " + u);
					System.out.println("array : " + array[0]);
					System.out.println("file_name : " + file_name);
					System.out.println("file_real_name : " + file_real_name);
					
					
					List attList = new ArrayList();
					for(int i=0; i<ctarray.length; i++) {
						if(ctarray[i] > 0) {
							attList.add(ctarray[i]);
						}
					}
					
					for(int i=0; i<attList.size(); i++) {
						System.out.println(attList.get(i));
						AttachVO attachVo = new AttachVO(Integer.parseInt(attList.get(i).toString()),file_name,file_real_name);
						attUpList.add(attachVo);
					}
					
					
				
//					
//					if(Integer.parseInt(array[0].toString())>0 && u==0){
//					}
//					if(Integer.parseInt(array[1].toString())>0 && u==1){
//						AttachVO attachVo = new AttachVO(Integer.parseInt(array[1].toString()),file_name,file_real_name);
//						attUpList.add(attachVo);
//					}
//					if(Integer.parseInt(array[2].toString())>0 && u==2){
//						AttachVO attachVo = new AttachVO(Integer.parseInt(array[2].toString()),file_name,file_real_name);
//						attUpList.add(attachVo);
//					}
//					if(Integer.parseInt(array[3].toString())>0 && u==3){
//						AttachVO attachVo = new AttachVO(Integer.parseInt(array[3].toString()),file_name,file_real_name);
//						attUpList.add(attachVo);
//					}
//					if(Integer.parseInt(array[4].toString())>0 && u==4){
//						AttachVO attachVo = new AttachVO(Integer.parseInt(array[4].toString()),file_name,file_real_name);
//						attUpList.add(attachVo);
//					}
					// 파일 갯수만큼 회전 수 세기
					u++;
				}
		    }
			
			// 파일 정보 업뎃
			int attachCnt = attchService.updateBoard(attUpList);
			 
			
//			if(boardCnt >= 1 && attachCnt >= 1){
////			response.sendRedirect(request.getContextPath() + "/board/boardselectservlet?board_seq1=" + board_seq1);
//				request.getRequestDispatcher("/reviewselectallservlet?board_seq1="+board_seq1).forward(request, response);
//			}else {
//				doGet(request,response);
//			}
		}
		// http://localhost/reviewselectallservlet?board_seq1=27
		
		
		
		// 파일삭제
		String delarr = request.getParameter("delarr");
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
			int attachCnt = attchService.deleteAttach(delList);
		}
		
		if(boardCnt >= 1){
				request.getRequestDispatcher("/reviewselectallservlet?board_seq1="+board_seq1).forward(request, response);
		}else {
			doGet(request,response);
		}
		
	}
}
