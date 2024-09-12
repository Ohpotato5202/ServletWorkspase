package com.kh.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.vo.Board;


/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/board")//요청 보내고 받을 수 있는 서블릿 주소  url가용할 수 있게 해야한다. 
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		List<Board> list = (List<Board>) session.getAttribute("list");//null 값 반환하게 되므로
		if(list ==null) {
			list = new ArrayList<>();
			list.add(new Board(1, "kh게시판 1번 게시글", "admin", "zzzzz", new Date()));
			list.add(new Board(2, "kh게시판 2번글 ","admin","bbbbbbbbbbb", new Date()));
            list.add(new Board(3, "kh게시판 1번글 ","mkm","aaaaaaaaaaaaaaaaa", new Date()));
            list.add(new Board(4, "kh게시판 4번글 ","user01","이스터에그발견", new Date()));
            list.add(new Board(5, "kh게시판 5번글 ","user02","zzzzzzzzzzz", new Date()));
            session.setAttribute("list", list);
		}
		
		request.getRequestDispatcher("/board/board.jsp")
				.forward(request, response);
		
	}

}
