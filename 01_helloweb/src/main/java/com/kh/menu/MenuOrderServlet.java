package com.kh.menu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuOrderServlet
 */
@WebServlet("/menuOrder.do")
public class MenuOrderServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       if(req.getMethod().equals("GET")) doGet(req, res);
       else doPost(req, res );
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1. 사용자 입력값 처리
      String main_menu = request.getParameter("main_menu");
      String side_menu = request.getParameter("side_menu");
      String drink_menu = request.getParameter("drink_menu");
      
      //2. 출력확인
      //System.out.println(main_menu + side_menu + drink_menu);
      
      //3. 계산
      int price = 0;
      switch(main_menu) {
      case "한우버거" : price += 5000; break;
      case "밥버거" : price += 4500; break;
      case "치즈버거" : price += 4000; break;      
      }
      
      switch(side_menu) {
      case "감자튀김" : price += 1500; break;
      case "어니언링" : price += 1700; break;
      }
      
      switch(drink_menu) {
      case "콜라" :
      case "사이다" : price +=1000; break;
      case "커피" : price += 1500; break;
      case "밀크쉐이크" : price += 2500; break;
      }
      
      request.setAttribute("price", price);
      
      request.getRequestDispatcher("/menu/menuOrder.jsp").forward(request, response);
   }
   
   
}