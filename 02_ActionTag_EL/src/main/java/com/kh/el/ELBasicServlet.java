package com.kh.el;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.person.Person;

/**
 * Servlet implementation class ELBasicServlet
 */
@WebServlet("/el/elBasics.do")
public class ELBasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ELBasicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 데이터들을 담을 수 있는 jsp내장 객체 종류 
		 * 1. ServletContext(application Scope)
		 *    한 애플리케이션 당 단 1개만 존재하는 객체 
		 *    이 영역에 데이터를 담으면 애플리케이션 전역에서 사용 가능.
		 *  
		 * 2. HttpSession (session scope)
		 *    한 브라우저당 1개 존재하는 객체 (클라이언트 당 한개씩 값을 반환해 준다. 각 클라이언트별로 다른 값 저장.)
		 *    이 영역에 데이터를 담으면 jsp/servlet단에서 모두 사용 가능.
		 *    값이 한번 담기면 서버가 멈추거나, 브라우저가 닫히기 전까지 사용 가능. 
		 *    (사용할 수 있는 사용자인지 session 안에 담아둔다.)
		 *    
		 * 3. HttpServletRequest (reuest scope)
		 * 	  (동적으로 바뀌는 데이터(게시판 상세보기, 게시글 목록 페이지 등) 담을 때 사용.-> 그떄그떄 바뀌는 데이터 request안에 담는다.)
		 * 	  요청 및 응답 시 매번 생성되는 객체 
		 * 	  이 영역에서 데이터를 담으면 request객체를 포워딩 받는 응답 jsp에서 사용 가능 
		 * 	  
		 * 4. PageContext(page scope)
		 *    선언한 jsp에서만 사용 가능 
		 *    
		 *  위 객체들을 활용하여 데이터를 담을 때는 .setAttribute(키, value)
		 *  					    꺼낼 때는 .getAttribute(키)
		 *  						지울 때는 .removeAttribute(키)
		 *    
		 * 
		 * 
		 * 
		 * */
		request.setAttribute("coffee","매머드커피");
		request.setAttribute("serverTime", System.currentTimeMillis());
		request.setAttribute("honngd", new Person("honngd", "홍길동", '남', 35, true));
		
		List<Object> list = Arrays.asList("abc", 12345,new Date());
		request.setAttribute("list", list);
		
		Map<String, Object> map = new HashMap();
		map.put("language", "java");
		map.put("Mrs.Jeon", new Person("Jeonn", "전은우", '여', 29, false));
		
		request.setAttribute("map", map);
		
		HttpSession session = request.getSession();
		session.setAttribute("book", "자바의 정석");
		//각 클라이언트마다 다른 값을 부여 
		
		ServletContext application = request.getServletContext();
		application.setAttribute("movie", "매드맥스");
		//모든 세션에서 동일하게 부여 
		
		
		request.getRequestDispatcher("/el/elBasics.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
