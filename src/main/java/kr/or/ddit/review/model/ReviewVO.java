package kr.or.ddit.review.model;

import java.sql.Date;

public class ReviewVO {

	private int revw_seq1;		// 리뷰 시퀸스 번호
	private String revw_cont;	// 리뷰 내용
	private Date revw_dt;		// 리뷰 작성날짜
	private int revw_del;		// 리뷰 삭제
	private String mem_id;		// 리뷰 작성 아이디
	private int board_seq1;		// 리뷰가 달린 게시글의 번호
	
	
	public ReviewVO() {
		
	}
	
	
	public ReviewVO(String revw_cont, String mem_id, int board_seq1) {
		this.revw_cont = revw_cont;
		this.mem_id = mem_id;
		this.board_seq1 = board_seq1;
	}
	
	
	public int getRevw_seq1() {
		return revw_seq1;
	}
	public void setRevw_seq1(int revw_seq1) {
		this.revw_seq1 = revw_seq1;
	}
	public String getRevw_cont() {
		return revw_cont;
	}
	public void setRevw_cont(String revw_cont) {
		this.revw_cont = revw_cont;
	}
	public Date getRevw_dt() {
		return revw_dt;
	}
	public void setRevw_dt(Date revw_dt) {
		this.revw_dt = revw_dt;
	}
	public int getRevw_del() {
		return revw_del;
	}
	public void setRevw_del(int revw_del) {
		this.revw_del = revw_del;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getBoard_seq1() {
		return board_seq1;
	}
	public void setBoard_seq1(int board_seq1) {
		this.board_seq1 = board_seq1;
	}
	
	
	
	@Override
	public String toString() {
		return "ReviewVO [revw_seq1=" + revw_seq1 + ", revw_cont=" + revw_cont + ", revw_dt=" + revw_dt + ", revw_del="
				+ revw_del + ", mem_id=" + mem_id + ", board_seq1=" + board_seq1 + "]";
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + board_seq1;
		result = prime * result + ((mem_id == null) ? 0 : mem_id.hashCode());
		result = prime * result + ((revw_cont == null) ? 0 : revw_cont.hashCode());
		result = prime * result + revw_del;
		result = prime * result + ((revw_dt == null) ? 0 : revw_dt.hashCode());
		result = prime * result + revw_seq1;
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
		ReviewVO other = (ReviewVO) obj;
		if (board_seq1 != other.board_seq1)
			return false;
		if (mem_id == null) {
			if (other.mem_id != null)
				return false;
		} else if (!mem_id.equals(other.mem_id))
			return false;
		if (revw_cont == null) {
			if (other.revw_cont != null)
				return false;
		} else if (!revw_cont.equals(other.revw_cont))
			return false;
		if (revw_del != other.revw_del)
			return false;
		if (revw_dt == null) {
			if (other.revw_dt != null)
				return false;
		} else if (!revw_dt.equals(other.revw_dt))
			return false;
		if (revw_seq1 != other.revw_seq1)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
