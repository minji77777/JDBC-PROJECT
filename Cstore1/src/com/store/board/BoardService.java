package com.store.board;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.store.common.DAO;


	
	
	public class BoardService extends DAO {

		Scanner scn = new Scanner(System.in);
		// 시간,날짜 write_date칼럼
		LocalDateTime now = LocalDateTime.now(); // 현재 날짜/시간
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss"));

//		BoardService bs = new BoardService();
		Board board = new Board();

		// 공지사항 추가
		public void addBoard() {
			Board board = new Board();
			
			
			System.out.println("내용입력>>");
			String content = scn.nextLine();
			
			System.out.println("날짜>");
			String date = scn.nextLine();
			
			board.setContent(content);
			board.setWriteDate(date);
			
			int result = BoardManage.getInstance().getBoardList(board);
			
			if(result ==1) {
				System.out.println("공지 등록 완료");
			}else {
				System.out.println("공지 등록 실패");
			}
			
		
		}

		
		//공지사항 보기
		public void seeBoard() {

			List<Board> list = new ArrayList<Board>();
			
			
			
			List<Board> l = BoardManage.getInstance().getBoardList();
			
			
		for(Board b : list)	{
			System.out.println();//가독성
			System.out.println("─────────────────────────────────");
			System.out.println("<공지사항> 총 " + list.size() + "건");
			System.out.println("─────────────────────────────────");
			System.out.println(  b.getContent() +"/"+ b.getMemberId() +"/"+ b.getWriteDate());
		

}
		}
	}
