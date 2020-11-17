package kr.or.ddit.board.model;

import java.sql.Date;

public class BoardVo {
	
	
	int board_seq1;			//	board_seq1		게시판 시퀸스
	int parent_seq1;		//	parent_seq1		게시판의 부모 시퀸스값
	String board_title;		//	board_title		제목
	String board_cont;		//	board_cont		내용
	Date board_date;		//	board_date		작성일
	int board_dep;			//	board_dep		깊이 
	int board_del;			//  BOARD_DEL		게시판 삭제여부
	String mem_id;			//	mem_id			작성자 아이디
	int ctgr_seq1;			//	ctgr_seq1		카테고리 번호

	
	public BoardVo() {
		
	}
	
	
	public BoardVo(String board_title, String board_cont, int board_dep, int board_del, String mem_id, int ctgr_seq1) {
		this.board_title = board_title;
		this.board_cont = board_cont;
		this.board_dep = board_dep;
		this.board_del = board_del;
		this.mem_id = mem_id;
		this.ctgr_seq1 = ctgr_seq1;
		
	}
	
	 
	public BoardVo(String board_title, String board_cont, String mem_id, int ctgr_seq1) {
		this.board_title = board_title;
		this.board_cont = board_cont;
		this.mem_id = mem_id;
		this.ctgr_seq1 =ctgr_seq1; 
	}
	
	
	public BoardVo(int board_seq1, int parent_seq1, String board_title, String board_cont, Date board_date,
			int board_dep, int board_del, String mem_id, int ctgr_seq1) {
		this.board_seq1 = board_seq1;
		this.parent_seq1 = parent_seq1;
		this.board_title = board_title;
		this.board_cont = board_cont;
		this.board_date = board_date;
		this.board_dep = board_dep;
		this.board_del = board_del;
		this.mem_id = mem_id;
		this.ctgr_seq1 = ctgr_seq1;
	}
	
	// 새글 쓰는 경우
	public BoardVo(int board_seq1, String board_title, String board_cont) {
		this.board_seq1 = board_seq1;
		this.board_title = board_title;
		this.board_cont = board_cont;
	}


	public BoardVo(String board_title, String board_cont, String mem_id, int ctgr_seq1, int parent_seq1, int board_dep) {
		this.board_title = board_title;
		this.board_cont = board_cont;
		this.ctgr_seq1 = ctgr_seq1;
		this.parent_seq1 = parent_seq1;
		this.board_dep = board_dep;
	}

	// 답글다는 경우
	public BoardVo(String board_title, String board_cont, String mem_id, int ctgr_seq1, int board_dep) {
		this.board_title = board_title;
		this.board_cont = board_cont;
		this.mem_id = mem_id;
		this.ctgr_seq1 = ctgr_seq1;
		this.board_dep = board_dep;
	}

	
	public BoardVo(int parent_seq1, String board_title, String board_cont, int board_dep, String mem_id, int ctgr_seq1) {
		this.parent_seq1 = parent_seq1;
		this.board_title = board_title;
		this.board_cont = board_cont;
		this.board_dep = board_dep;
		this.mem_id = mem_id;
		this.ctgr_seq1 = ctgr_seq1;
	}


	public int getBoard_seq1() {
		return board_seq1;
	}
	public void setBoard_seq1(int board_seq1) {
		this.board_seq1 = board_seq1;
	}
	public int getParent_seq1() {
		return parent_seq1;
	}
	public void setParent_seq1(int parent_seq1) {
		this.parent_seq1 = parent_seq1;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_cont() {
		return board_cont;
	}
	public void setBoard_cont(String board_cont) {
		this.board_cont = board_cont;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	public int getBoard_dep() {
		return board_dep;
	}
	public void setBoard_dep(int board_dep) {
		this.board_dep = board_dep;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getCtgr_seq1() {
		return ctgr_seq1;
	}
	public void setCtgr_seq1(int ctgr_seq1) {
		this.ctgr_seq1 = ctgr_seq1;
	}
	public int getBoard_del() {
		return board_del;
	}
	public void setBoard_del(int board_del) {
		this.board_del = board_del;
	}
	
	
	@Override
	public String toString() {
		return "BoardVO [board_seq1=" + board_seq1 + ", parent_seq1=" + parent_seq1 + ", board_title=" + board_title
				+ ", board_cont=" + board_cont + ", board_date=" + board_date + ", board_dep=" + board_dep + ", mem_id="
				+ mem_id + ", ctgr_seq1=" + ctgr_seq1 + ", board_del=" + board_del + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((board_cont == null) ? 0 : board_cont.hashCode());
		result = prime * result + ((board_date == null) ? 0 : board_date.hashCode());
		result = prime * result + board_del;
		result = prime * result + board_dep;
		result = prime * result + board_seq1;
		result = prime * result + ((board_title == null) ? 0 : board_title.hashCode());
		result = prime * result + ctgr_seq1;
		result = prime * result + ((mem_id == null) ? 0 : mem_id.hashCode());
		result = prime * result + parent_seq1;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardVo other = (BoardVo) obj;
		if (board_cont == null) {
			if (other.board_cont != null)
				return false;
		} else if (!board_cont.equals(other.board_cont))
			return false;
		if (board_date == null) {
			if (other.board_date != null)
				return false;
		} else if (!board_date.equals(other.board_date))
			return false;
		if (board_del != other.board_del)
			return false;
		if (board_dep != other.board_dep)
			return false;
		if (board_seq1 != other.board_seq1)
			return false;
		if (board_title == null) {
			if (other.board_title != null)
				return false;
		} else if (!board_title.equals(other.board_title))
			return false;
		if (ctgr_seq1 != other.ctgr_seq1)
			return false;
		if (mem_id == null) {
			if (other.mem_id != null)
				return false;
		} else if (!mem_id.equals(other.mem_id))
			return false;
		if (parent_seq1 != other.parent_seq1)
			return false;
		return true;
	}
	
	

	
	
}
