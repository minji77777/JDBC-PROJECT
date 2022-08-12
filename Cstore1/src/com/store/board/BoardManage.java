package com.store.board;


import java.util.ArrayList;
import java.util.List;

import com.store.common.DAO;

public class BoardManage extends DAO {

	// 싱글톤
	private static BoardManage bm = new BoardManage();

	private BoardManage() {

	}

	public static BoardManage getInstance() {
		return bm;
	}

	// 공지사항 리스트
	public int getBoardList(Board b) {
		
	
		int result = 0;
		try {
			conn();
			String sql = "insert into board(member_id,content,write_date) values('admin',?,?)";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getContent());
			pstmt.setString(2, b.getWriteDate());
			
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;		
	}	
	
	
	//공지사항 보기
	public List<Board> getBoardList(){
		List<Board> list = new ArrayList<>();
		Board board = null;
		try {
			conn();
			String sql = "select * from board";
			stmt=conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				board = new Board();
				board.setMemberId(rs.getString("member_id"));
				board.setContent(rs.getString("content"));				
				board.setWriteDate(rs.getString("write_date"));
				
				list.add(board);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {   
	
			disconnect();
		}
		return list;
	}

	

		
	

	
	}



