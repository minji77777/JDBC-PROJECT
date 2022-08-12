package com.store.board;

public class Board {
	
	
		
		private int no;
		private String memberId;
		private String content;
		private String writeDate;
		
		
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		
		
		public String getMemberId() {
			return memberId;
		}
		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getWriteDate() {
			return writeDate;
		}
		public void setWriteDate(String writeDate) {
			this.writeDate = writeDate;
		}
		public Board( String memberId, String content, String writeDate) {
			
			
			this.memberId = memberId;
			this.content = content;
			this.writeDate = writeDate;
		}
		
		public Board() {};
		

}

