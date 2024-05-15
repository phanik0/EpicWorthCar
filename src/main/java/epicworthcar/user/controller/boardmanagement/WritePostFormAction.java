package epicworthcar.user.controller.boardmanagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import epicworthcar.user.model.boards.BoardsDao;
import epicworthcar.user.model.boards.BoardsRequestDto;
import epicworthcar.user.model.boards.BoardsResponseDto;
import epicworthcar.user.model.users.UserDao;
import epicworthcar.user.model.users.UserResponseDto;

/**
 * Servlet implementation class WriteFormAction
 */

public class WritePostFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WritePostFormAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		System.out.println(123);
		HttpSession session = request.getSession();
		UserResponseDto user = (UserResponseDto) session.getAttribute("user");
		String id = user.getId();
		BoardsRequestDto boardsDto = new BoardsRequestDto(title, body, id);
		BoardsDao boardsDao = BoardsDao.getInstance();
		
		BoardsResponseDto boards = boardsDao.writePost(boardsDto);
		if (boards == null)
			response.sendRedirect("/writePostForm");
		else
			response.sendRedirect("/boardListFormAction");

	}

}
