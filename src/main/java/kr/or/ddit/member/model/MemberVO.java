package kr.or.ddit.member.model;

import java.sql.Date;

public class MemberVO {
	
	
	private String mem_id;		// 아이디		MEM_ID
	private String mem_pass;		// 비밀번호	MEM_PASS
	private Date mem_regdt;		// 생성일		MEM_REGDT

	
	public MemberVO() {
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public Date getMem_regdt() {
		return mem_regdt;
	}
	public void setMem_regdt(Date mem_regdt) {
		this.mem_regdt = mem_regdt;
	}
	

	@Override
	public String toString() {
		return "MemberVO [mem_id=" + mem_id + ", mem_pass=" + mem_pass + ", mem_regdt=" + mem_regdt + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mem_id == null) ? 0 : mem_id.hashCode());
		result = prime * result + ((mem_pass == null) ? 0 : mem_pass.hashCode());
		result = prime * result + ((mem_regdt == null) ? 0 : mem_regdt.hashCode());
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
		MemberVO other = (MemberVO) obj;
		if (mem_id == null) {
			if (other.mem_id != null)
				return false;
		} else if (!mem_id.equals(other.mem_id))
			return false;
		if (mem_pass == null) {
			if (other.mem_pass != null)
				return false;
		} else if (!mem_pass.equals(other.mem_pass))
			return false;
		if (mem_regdt == null) {
			if (other.mem_regdt != null)
				return false;
		} else if (!mem_regdt.equals(other.mem_regdt))
			return false;
		return true;
	}
	 
}
