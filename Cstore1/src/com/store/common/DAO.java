package com.store.common;


import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DAO {
	// DAO (Data Access Object) :db에 접근하는 객체
	//싱글톤
//	
//	//1. 자기자신으로 만든 인스턴스
//	private static DAO dao = null;
//	//2. 생성자
//	private DAO() {
//	}
//	//3. 1번에 만든 인스턴스 사용
//	public static DAO getInstance() {
//		if(dao == null) {
//			return new DAO();
//			
//		}else 
//			return new DAO();
//	}
		
	
	
	
	

	// java <-> DB 연결할 때 쓰는 객체
	protected Connection conn = null;
	// select(조회) 결과 값 반환 받는 객체
	protected ResultSet rs = null;
	// 쿼리문을 담고 쿼리문을 실행하는 객체 (밑의 2가지 방법)  
	protected PreparedStatement pstmt = null; // 1  dml일때 
	protected Statement stmt = null; // 2번째 방법 sql일때 유리
	
	Properties pro = new Properties()
			;

	String driver = "oracle.jdbc.driver.OracleDriver"; // 고정
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "test";
	String pw = "1234";

	public void conn() {
		try {
			// 1. driver로딩
			Class.forName(driver);
			// 2. db 연결
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconnect() { //db 닫아주기 (연 순서와 반대로 닫아주기)
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	private void getProperties() {
		try {
			FileReader resource = new FileReader("src/config/db.properties");
			pro.load(resource);
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			id = pro.getProperty("id");
			pw = pro.getProperty("pw");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
}
}


