package kr.or.ddit.category.model;

public class CtgrVO {
	
	
	int ctgr_seq1;		// 카테고리 번호
	String ctgr_name;	// 카테고리 이름
	int ctgr_use;		// 카테고리 사용여부
	
	
	
	public CtgrVO() {
	}
		
	
	public CtgrVO(String ctgr_name, int ctgr_use) {
		this.ctgr_name = ctgr_name;
		this.ctgr_use = ctgr_use;
	}
	 
	public CtgrVO(int ctgr_seq1, String ctgr_name, int ctgr_use) {
		this.ctgr_seq1 = ctgr_seq1;
		this.ctgr_name = ctgr_name;
		this.ctgr_use = ctgr_use;
	}
	
	public CtgrVO(int ctgr_seq1, int ctgr_use) {
		this.ctgr_seq1 = ctgr_seq1;
		this.ctgr_use = ctgr_use;
	}
 

	public int getCtgr_seq1() {
		return ctgr_seq1;
	}
	public void setCtgr_seq1(int ctgr_seq1) {
		this.ctgr_seq1 = ctgr_seq1;
	}
	public String getCtgr_name() {
		return ctgr_name;
	}
	public void setCtgr_name(String ctgr_name) {
		this.ctgr_name = ctgr_name;
	}
	public int getCtgr_use() {
		return ctgr_use;
	}
	public void setCtgr_use(int ctgr_use) {
		this.ctgr_use = ctgr_use;
	}
	
	
	@Override
	public String toString() {
		return "CtrgVO [ctgr_seq1=" + ctgr_seq1 + ", ctgr_name=" + ctgr_name + ", ctgr_use=" + ctgr_use + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ctgr_name == null) ? 0 : ctgr_name.hashCode());
		result = prime * result + ctgr_seq1;
		result = prime * result + ctgr_use;
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
		CtgrVO other = (CtgrVO) obj;
		if (ctgr_name == null) {
			if (other.ctgr_name != null)
				return false;
		} else if (!ctgr_name.equals(other.ctgr_name))
			return false;
		if (ctgr_seq1 != other.ctgr_seq1)
			return false;
		if (ctgr_use != other.ctgr_use)
			return false;
		return true;
	}
	
	
	

	
	
}
