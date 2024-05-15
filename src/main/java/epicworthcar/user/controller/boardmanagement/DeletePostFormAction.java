package epicworthcar.user.controller.boardmanagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import epicworthcar.user.model.boards.BoardsDao;
import epicworthcar.user.model.users.UserDao;
import epicworthcar.user.model.users.UserRequestDto;
import epicworthcar.user.model.users.UserResponseDto;

/**
 * Servlet implementation class DeletePostFormAction
 */

public class DeletePostFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletePostFormAction() {
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
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");

		BoardsDao boardsDao = BoardsDao.getInstance();

		String number = request.getParameter("number");

		// 패스워드가 일치하면 -> 삭제 처리

		boolean result = boardsDao.deletePost(number);

		if (result) {
			System.out.println("탈퇴완료");

			response.sendRedirect("/boardListFormAction");
		} else {
			response.sendRedirect("/postForm");
			System.out.println("탈퇴실패");
		}
	}

}
