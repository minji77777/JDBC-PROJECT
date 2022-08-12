
package com.store.member;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.store.app.Application;
import com.store.common.DAO;

public class MemberService extends DAO {

	Scanner scn = new Scanner(System.in);
	public static Member MemberInfo = null;
	LocalDate today = LocalDate.now();

	// 회원등록
	public void registerMember() {

		Member member = new Member();

		

		System.out.println("회원ID> ");
		String id = scn.nextLine();

		System.out.println("회원 PW> ");
		String pw = scn.nextLine();

		System.out.println("연락처> ");
		String tel = scn.nextLine();

		System.out.println("주소> ");
		String addr = scn.nextLine();
		
		

		
		member.setMemberId(id);
		member.setMemberPw(pw);
		member.setMemberAddr(tel);	
		member.setMemberTel(addr);
		
		
		
		int result = MemberManagement.getInstance().register(member);

		if (result == 1) {
			System.out.println("회원가입 성공");
		} else if (result == 0) {
			System.out.println("회원가입 실패");
		}

	}

	// 로그인
	public void login() {
		Member member = null;

		System.out.println("회원 ID>");
		String id = scn.nextLine();

		System.out.println("회원 PW>");
		String pw = scn.nextLine();

		member = MemberManagement.getInstance().login(id);

		try {
			if (member != null) {
				MemberInfo = member;

			} else {
				System.out.println("등록되지 않은 아이디 입니다.");
				new Application();

			}

			if (member.getMemberPw().equals(pw)) {
				MemberInfo = member;

			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");

				new Application();
			}

		} catch (Exception e) {

		}return;
		
	}

	// 삭제
	public void delete() {

		System.out.println("삭제할 비밀번호의 ID >");
		String Id = scn.nextLine();

		int result = MemberManagement.getInstance().deleteMember(Id);

		if (result == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}

	}

	// 리뷰
	public void review() {

		System.out.println("닉네임을 입력해주세요>");
		String nickname = scn.nextLine();

		System.out.println("치킨 점수 (5점 만점) > ");
		int star = Integer.parseInt(scn.nextLine());

		System.out.println("치킨 맛을 평가해주세요♥>");
		String customerReview = scn.nextLine();

		System.out.println("===============================");
		System.out.print(nickname + " ");
		System.out.println(today);
		switch (star) {
		case 1:
			System.out.println("★☆☆☆☆");
			break;
		case 2:
			System.out.println("★★☆☆☆");
			break;
		case 3:
			System.out.println("★★★☆☆");
			break;
		case 4:
			System.out.println("★★★★☆");
			break;
		case 5:
			System.out.println("★★★★★");
			break;
		}
		System.out.println(customerReview);
		System.out.println("===============================");
		
		
		
	}
	
	
	
	

	// 회원 정보 변경
	public void update() {

		Member member = new Member();

		//System.out.println("변경할 PW의 ID를 입력하시오>>");
		//String changeId = scn.nextLine();
		
		

		System.out.println("변경할 PW을 입력하시오>>");
		String changePw = scn.nextLine();
		
		
		 member.setMemberPw(changePw);

		int result = MemberManagement.getInstance().updateMember(member);

		if (result == 1) {
			System.out.println("PW 변경 성공");
		} else {
			System.out.println("PW 변경 실패");
		}

	}

	// 전체 조회
	public void serachAll() {
		List<Member>list = MemberManagement.getInstance().customerAll(MemberService.MemberInfo.getMemberId());

		System.out.println(" 회원ID    회원PW      주소        연락처            권한       ");
		 System.out.println("─────────────────────────────────────────────────────────");
		 
		 for(Member mm : list) {
		 
		 System.out.println(mm.getMemberId()+"     "+mm.getMemberPw()+"     "+mm.getMemberAddr()+"  "+mm.getMemberTel()+"    "+mm.getRole());
		  
		
		 }

	}

	

	// 로그인
	public void doLogin() {
		Member member = new Member();

		System.out.println("ID>");
		String id = scn.nextLine();

		System.out.println("PW>");
		String pw = scn.nextLine();

		member = MemberManagement.getInstance().loginInfo(id);

		// DB 조회한 정보와 내가 입력한 PW 비교
		if (member.getMemberPw().equals(pw)) {
			MemberInfo = member;

		} else {
			System.out.println("로그인 실패");
		}

	}

}
