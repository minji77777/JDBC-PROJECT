package com.store.app;

import java.util.Scanner;

import com.store.board.BoardService;
import com.store.member.MemberManagement;
import com.store.member.MemberService;
import com.store.order.OrderFoodService;

public class ManageMent {

	Scanner scn = new Scanner(System.in);
	MemberManagement mm = new MemberManagement();
	MemberService ms = new MemberService();
	OrderFoodService ofs = new OrderFoodService();
	BoardService bs = new BoardService();

	int menuNo = 0;

	public ManageMent() {
		chicken();
	}

	private void chicken() {
		while(true) {			
			menuInfo();
			if(MemberService.MemberInfo.getRole().equals("1")) { //회원
				
				if(menuNo==1) { 	//회원정보 변경
					ms.update();
					
				}
				  else if (menuNo == 2) { //메뉴보기
					  ofs.seeMenu();
				} else if ( menuNo == 3 ) {//주문하기
					ofs.order();
				} else if ( menuNo == 4 ) {//리뷰등록
					ms.review();
				} else if ( menuNo == 5 ) {//공지사항 보기
					bs.seeBoard();
				} else if ( menuNo == 7 ) {// 종료
					System.out.println("종료합니다.");
					break;
				} 

			} else if(MemberService.MemberInfo.getRole().equals("0")) { //관리자
				
				if (menuNo == 1) { //회원등록
					ms.registerMember();
				} else if ( menuNo == 2 ) { //전체회원 조회
					ms.serachAll();
				} else if ( menuNo == 3 ) { //회원 삭제
					ms.delete();
				} else if ( menuNo == 4 ) { //주문조회
					ofs.seeAll();
				} else if ( menuNo == 5 ) {//총매출
					ofs.money();
				} else if ( menuNo == 6 ) {//공지사항
					bs.addBoard();
				} 

		}
		
	}
}

	private void menuInfo() {
		if (MemberService.MemberInfo.getRole().equals("1")) { // 1 : 회원
			System.out.println("──────────────────────────────  <회원>  ──────────────────────────────────────────────");
			System.out.println(" 1.회원정보 변경 | 2.메뉴보기 | 3.주문하기 | 4.리뷰 | 5. 공지사항 | 7. 종료 ");
			System.out
					.println("───────────────────────────────────────────────────────────────────────────────────── ");

		} else if (MemberService.MemberInfo.getRole().equals("0")) { // 0 : 관리자(사장)
			System.out.println("*************************  <관리자>  **************************************************");
			System.out.println("  1.회원 등록 | 2.회원 조회 | 3.회원 삭제 | 4.주문조회 | 5.총 매출 | 6.공지사항   ");
			System.out
					.println("**************************************************************************************");

		}
		
		System.out.println("입력> ");
		menuNo = Integer.parseInt(scn.nextLine());

	}
}
