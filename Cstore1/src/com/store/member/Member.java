package com.store.member;

public class Member {
	
	
		//필드
		private String memberId; //회원 아이디
		private String memberPw; //회원 비밀번호
		private String memberAddr; // 회원 주소
		private String memberTel; // 회원 전화번호 
		private String role; // 권한 0. 가게사장 1. 고객
		private String review;
		
		//게터,세터
		public String getMemberId() {
			return memberId;
		}
		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}
		public String getMemberPw() {
			return memberPw;
		}
		public void setMemberPw(String memberPw) {
			this.memberPw = memberPw;
		}
		public String getMemberAddr() {
			return memberAddr;
		}
		public void setMemberAddr(String memberAddr) {
			this.memberAddr = memberAddr;
		}
		public String getMemberTel() {
			return memberTel;
		}
		public void setMemberTel(String memberTel) {
			this.memberTel = memberTel;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		
		public String getReview() {
			return review;
		}
		public void setReview(String review) {
			this.review = review;
		}
		@Override
		public String toString() {
			return "  " + memberId + "          " + memberPw + "    " + memberAddr
					+ "     " + memberTel + "    " + role + "  " + review + "  ";
		}
		
					
		}
		
		
		



