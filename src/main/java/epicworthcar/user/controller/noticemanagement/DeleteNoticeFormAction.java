package epicworthcar.user.controller.noticemanagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import epicworthcar.user.model.notice.NoticeDao;


/**
 * Servlet implementation class DeletePostFormAction
 */

public class DeleteNoticeFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteNoticeFormAction() {
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

		NoticeDao noticeDao = NoticeDao.getInstance();

		String number = request.getParameter("number");

		// 패스워드가 일치하면 -> 삭제 처리

		boolean result = noticeDao.deleteNotice(number);

		if (result) {
			System.out.println("탈퇴완료");

			response.sendRedirect("/boardListFormAction");
		} else {
			response.sendRedirect("/noticeForm");
			System.out.println("탈퇴실패");
		}
	}

}
