package epicworthcar.user.controller.noticemanagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import epicworthcar.user.model.notice.NoticeDao;
import epicworthcar.user.model.notice.NoticeRequestDto;
import epicworthcar.user.model.notice.NoticeResponseDto;
import epicworthcar.user.model.users.User;

/**
 * Servlet implementation class WriteFormAction
 */

public class WriteNoticeFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WriteNoticeFormAction() {
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
		User user = (User)session.getAttribute("user");
		String id = user.getId();
		
		NoticeRequestDto noticeDto = new NoticeRequestDto(title, body, id);
		NoticeDao noticeDao = NoticeDao.getInstance();

		NoticeResponseDto boards = noticeDao.writeNotice(noticeDto);
		if (boards == null)
			response.sendRedirect("/writeForm");
		else
			response.sendRedirect("/boardsListFormAction");

	}

}
