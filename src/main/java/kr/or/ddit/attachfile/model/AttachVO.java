package kr.or.ddit.attachfile.model;

public class AttachVO {
//	FILE_SEQ1	NUMBER(38,0)
//	FILE_NAME	VARCHAR2(200 BYTE)
//	FILE_REAL_NAME	VARCHAR2(200 BYTE)
//	BOARD_SEQ1	NUMBER(38,0)
	
	int file_seq1;				// 파일 번호
	String file_name;			// 파일 key값 부여한 이름
	String file_real_name;		// 파일 원래이름
	int board_seq1;				// 게시판 번호 저장
	
	
		
	public AttachVO() {
		
	}
	
	public AttachVO(String file_name, String file_real_name) {
		this.file_name = file_name;
		this.file_real_name = file_real_name;
	}
	
	
	public AttachVO(int file_seq1, String file_name, String file_real_name) {
		this.file_seq1 = file_seq1;
		this.file_name = file_name;
		this.file_real_name = file_real_name;
	}

	public AttachVO(int file_seq1) {
		this.file_seq1 = file_seq1;
	}

	public AttachVO(String file_name, String file_real_name,int board_seq1) {
		this.board_seq1 = board_seq1;
		this.file_name = file_name;
		this.file_real_name = file_real_name;
	}
	
	public int getFile_seq1() {
		return file_seq1;
	}
	public void setFile_seq1(int file_seq1) {
		this.file_seq1 = file_seq1;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_real_name() {
		return file_real_name;
	}
	public void setFile_real_name(String file_real_name) {
		this.file_real_name = file_real_name;
	}
	public int getBoard_seq1() {
		return board_seq1;
	}
	public void setBoard_seq1(int board_seq1) {
		this.board_seq1 = board_seq1;
	}
	
	
	@Override
	public String toString() {
		return "AttachVO [file_seq1=" + file_seq1 + ", file_name=" + file_name + ", file_real_name=" + file_real_name
				+ ", board_seq1=" + board_seq1 + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + board_seq1;
		result = prime * result + ((file_name == null) ? 0 : file_name.hashCode());
		result = prime * result + ((file_real_name == null) ? 0 : file_real_name.hashCode());
		result = prime * result + file_seq1;
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
		AttachVO other = (AttachVO) obj;
		if (board_seq1 != other.board_seq1)
			return false;
		if (file_name == null) {
			if (other.file_name != null)
				return false;
		} else if (!file_name.equals(other.file_name))
			return false;
		if (file_real_name == null) {
			if (other.file_real_name != null)
				return false;
		} else if (!file_real_name.equals(other.file_real_name))
			return false;
		if (file_seq1 != other.file_seq1)
			return false;
		return true;
	}
	
	
	
	
}
