package com.store.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderFoodService {
	

		Scanner scn = new Scanner(System.in);
		OrderFood of = new OrderFood();

		List<OrderFood> list = new ArrayList<>();

		// 치킨 메뉴 조회
		public void seeMenu() {

			List<OrderFood> list = OrderFoodManage.getInstance().seeMenu();

			System.out.println("*********치킨메뉴**********");
			System.out.println();

			for (OrderFood of : list) {
				System.out.println(of.getNo() + " . " + of.getMenuName() + " = " + of.getPrice() + "원");
			}

		}

		// 주문하기(회원)
		public void order() {
			OrderFood of = new OrderFood();
			
			seeMenu();
			System.out.println(); //줄바꿈
			
			System.out.println(" 주문할 치킨 번호 >> ");
			int no = Integer.parseInt(scn.nextLine());
			

			System.out.println("주문수량>>");
			int count = Integer.parseInt(scn.nextLine());
			
			of.setNo(no);
			of.setCount(count);
			
			int result = OrderFoodManage.getInstance().orderMenu(no);
			
			if(result ==1) {
				System.out.println("주문 완료");
			}else {
				System.out.println("주문 실패");
			}
	

			if (1 <= no && no <= 6) {

				System.out.println("   주문내역     ");
				System.out.println("────────────────────────────────────");
				
			
//				System.out.printf("   %s    %d마리  총 주문 금액: %d원 " , of.getMenuName(), of.getCount() , of.getAmount());
				System.out.println( "" + of.getMenuName() + " " + of.getCount() + " " + of.getAmount());
				}
			}
		

		
		// 주문조회하기(사장님)
		public void seeAll() {
			OrderFood of = new OrderFood();
			System.out.println("고객ID   치킨   수량   구매일");
			System.out.println("---------------------------");
			System.out.println(of.getMemberId() + of.getMenuName() + of.getCount() + of.getOrderDate());
		}
			
			
			//총 매출
			public void money() {
				OrderFood of = new OrderFood();
				System.out.println("─────────────────────────");
				System.out.println(OrderFoodManage.getInstance().money());
				
				
			}
			

}
