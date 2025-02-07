package com.kh.jstl;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.person.Person;

/**
 * Servlet implementation class CoreBasicServlet
 */
@WebServlet("/jstl/coreBasics.do")
public class CoreBasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoreBasicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Person> list = Arrays.asList(
	               new Person("honggd", "홍길동", '남', 35, true),
	               new Person("sinsa", "신사임당", '여', 58, true),
	               new Person("ygs123", "유관순", '여', 16, false)            
	            );
	      request.setAttribute("personList", list);
	      
	      Map<String, Object> map = new HashMap<>();
	      map.put("coffee", "카푸치노");
	      map.put("num", 3.456);
	      map.put("now", System.currentTimeMillis());
	      request.setAttribute("map", map);
	      
	      request.getRequestDispatcher("/jstl/coreBasics.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
