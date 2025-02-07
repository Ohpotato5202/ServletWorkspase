package com.kh.ajax.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.ajax.member.model.vo.Member;

/**
 * Servlet implementation class AjaxXmlServlet
 */
@WebServlet("/xml")
public class AjaxXmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxXmlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Member> list = new ArrayList<>();
		list.add(new Member("hwan" , "황제성","hwang.jpg"));
		list.add(new Member("julia" , "쥴리아 로버츠","juliaRoberts.jpg"));
		list.add(new Member("gone" , "김고은","김고은.jpg"));
		list.add(new Member("daft" , "다프트펑크","daftpunk.jpg"));
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/xml/member.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
