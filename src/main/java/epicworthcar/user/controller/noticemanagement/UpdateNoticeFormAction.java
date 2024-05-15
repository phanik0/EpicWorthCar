package epicworthcar.user.controller.noticemanagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import epicworthcar.user.model.notice.NoticeDao;
import epicworthcar.user.model.notice.NoticeRequestDto;
import epicworthcar.user.model.notice.NoticeResponseDto;


/**
 * Servlet implementation class UpdatePostFormAction
 */

public class UpdateNoticeFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoticeFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				request.setCharacterEncoding("UTF-8");
				String number = request.getParameter("number");
				String title = request.getParameter("title");
				String body = request.getParameter("body");
				System.out.println(123);
			
				NoticeRequestDto noticeDto = new NoticeRequestDto();
				NoticeDao noticeDao = NoticeDao.getInstance();
				noticeDto.setBody(body);
				noticeDto.setTitle(title);
				noticeDto.setNumber(number);
				NoticeResponseDto notice = noticeDao.updateNotice(noticeDto);
				if (notice == null)
					response.sendRedirect("/updateForm");
				else
					response.sendRedirect("/boardsListFormAction");

	}

}
