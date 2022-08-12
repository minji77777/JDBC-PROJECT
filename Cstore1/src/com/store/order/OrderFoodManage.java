package com.store.order;


import java.util.ArrayList;
import java.util.List;

import com.store.common.DAO;


	
	public class OrderFoodManage extends DAO {
		
		private static OrderFoodManage OFM = null; 
		private OrderFoodManage() {  //다른데서 생성 못하도록 생성자 막아둠
			
		}
		
		public static OrderFoodManage getInstance() {
			if(OFM == null) {
				OFM = new OrderFoodManage();
			}
			return OFM;
		}
		
		//치킨 메뉴 조회
		public List<OrderFood> seeMenu() {
			
			List<OrderFood> list = new ArrayList<>();
			OrderFood of = null;
			
			try {
				conn();
				String sql = "select NO,MENU_NAME,PRICE from ORDERFOOD";
				stmt=conn.createStatement();
				rs = stmt.executeQuery(sql);
						
				
//				pstmt = conn.prepareStatement(sql);
//				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					of = new OrderFood();
					of.setNo(rs.getInt("no"));
					of.setMenuName(rs.getString("menu_name"));
					of.setPrice(rs.getInt("price"));
			
					list.add(of);
				}
						
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
					
			return list;
	}

		//치킨 주문하기
		public String orderMenu(String no) {
			
			OrderFood of = null;
			try {
				conn();					
					
				int result = 0;
				String sql1 = "select MENU_NAME,PRICE, count, PRICE*COUNT as amount FROM ORDERFOOD where no = ?" ;
				
				pstmt = conn.prepareStatement(sql1);	
				result = pstmt.executeQuery();
				
				 pstmt.setString(1, rs.getNString("no"));
				
					
					if(rs.next()) {
						of = new OrderFood();
						
						of.setMenuName(rs.getString("menuName"));
						of.setPrice(rs.getInt("price"));
						of.setCount(rs.getInt("count"));
						of.setAmount(rs.getInt("amount"));
						result = pstmt.executeUpdate();
					
					//insert
					if(result ==1) {
					String sql2 ="insert into OrderFood (menu_name,price,count,amount) values(?,?,?,?)";
					
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, of.getMenuName());
					pstmt.setInt(2, of.getPrice());
					pstmt.setInt(3, of.getCount());
					pstmt.setInt(4, of.getAmoun-                       t());
					
					int result = pstmt.executeUpdate();

					
					}	
					}
							
				} catch (Exception e) {
					e.printStackTrace();
					
				} finally {
					disconnect();
				}
				
				return result;
				
		}
		
		//주문조회
		public List<OrderFood> seeAll() {
			
			List<OrderFood> list = new ArrayList<>();
			OrderFood of = null;
			
			try {
				conn();
				String sql = "select o.no, m.member_id, o.menu_name, o.count, o.order_date "
						+ "from member m, orderfood o "
						+ "where m.member_id = o.member_id";
				stmt=conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					of = new OrderFood();
					of.setNo(rs.getInt("no"));
					of.setMemberId(rs.getString("member_id"));
					of.setMenuName(rs.getString("menu_name"));
					of.setPrice(rs.getInt("price"));
					of.setCount(rs.getInt("count"));
					of.setOrderDate(rs.getString("order_date"));
			
					list.add(of);
				}
						
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
					
			return list;
		
		}
		
		//총매출(사장-날짜별로)
		public List<OrderFood> money() {
			
			List<OrderFood> list = new ArrayList<>();
			OrderFood of = null;
			
			try {
				conn();
				String sql = "select sum(price*count)  from orderfood ";
				
				stmt=conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					of = new OrderFood();
					
					of.setPrice(rs.getInt("price"));
					of.setCount(rs.getInt("count"));
					
			
					list.add(of);
				}
						
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
					
			return list;
		
		}
	}


