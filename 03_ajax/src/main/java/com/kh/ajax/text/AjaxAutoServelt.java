package com.kh.ajax.text;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxAutoServelt
 */
@WebServlet("/auto")
public class AjaxAutoServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final List<String> list = 
	         Arrays.asList(
	               "강종성",                                                                                             
	               "김경태",                                                                                             
	               "김상훈",                                                                                             
	               "김영미",                                                                                             
	               "김윤수",                                                                                             
	               "김주연 (93)",                                                                                             
	               "김주연 (97)",                                                                                             
	               "김한성",                                                                                             
	               "박요한",                                                                                             
	               "박정현",                                                                                             
	               "배기원",                                                                                             
	               "서민성",                                                                                             
	               "손세라",                                                                                             
	               "송민성",                                                                                             
	               "송준호",                                                                                             
	               "윤기상",                                                                                             
	               "이승우",                                                                                             
	               "이운산",                                                                                             
	               "이원영",                                                                                             
	               "이재성",                                                                                             
	               "장호재",                                                                                             
	               "전유진",                                                                                             
	               "정문주",                                                                                             
	               "주소민",                                                                                             
	               "천호현",                                                                                             
	               "최민순",                                                                                             
	               "최한성",                                                                                             
	               "황윤진",
	               "남윤지", 
	               "전은우 기여미"
	            );
	   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxAutoServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 사용자 입력값 추출
		String search = request.getParameter("search");
		
		//2. 업무로직
		List<String> result = new ArrayList<>();
		for( String name : list ) {
			if(name.contains(search)) {
				result.add(name);
			}
		}
		
		response.setContentType("text/csv; charset=utf-8");
		PrintWriter out = response.getWriter();
		for(String name : result) {
			out.println(name);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
