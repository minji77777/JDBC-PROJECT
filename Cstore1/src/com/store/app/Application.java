package com.store.app;

import java.util.Scanner;

import com.store.member.MemberService;

public class Application {
	
	   Scanner scn = new Scanner(System.in);
	   MemberService ms = new MemberService();
	   
	   int menuNo = 0;
	   
	   public Application() {
	      run();
	      
	   }

	   private void run() {
	      System.out.println("──────────────────────");
	      System.out.println("  1. 로그인 | 2. 종료 ");
	      System.out.println("──────────────────────");
	      try {
	      int menuNo = 0;
	      menuNo = Integer.parseInt(scn.nextLine());
	      switch (menuNo) {
	      case 1://로그인 하는 기능
	         ms.login();
	         
	         if(MemberService.MemberInfo != null) {
	            new ManageMent();
	         } 
	         
	      case 2:
	         System.out.println("종료합니다.");
	         break;
	      }
	        } catch(Exception e) {
	          // System.out.println("종료합니다.");
	        	e.printStackTrace();
	           
	        }
	      return;
	   }
	   
	   
	   
	   
	}
