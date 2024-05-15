package epicworthcar.user.controller.noticemanagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epicworthcar.user.model.notice.NoticeDao;
import epicworthcar.user.model.notice.NoticeResponseDto;



/**
 * Servlet implementation class FindPostAction
 */

public class FindNoticeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindNoticeAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String number = request.getParameter("number");
	       System.out.println(number);
	       System.out.println(123);
	        
	        
	        NoticeResponseDto notice = NoticeDao.getInstance().findNoticeByNumber(number); 
	        
	        
	        request.setAttribute("notice", notice);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/board/noticeForm.jsp");
	        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   String number = request.getParameter("number");
	       System.out.println(number);
	       System.out.println(123);
	        
	        
	        NoticeResponseDto notice = NoticeDao.getInstance().findNoticeByNumber(number); 
	        
	        
	        request.setAttribute("notice", notice);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/board/noticeForm.jsp");
	        dispatcher.forward(request, response);
	}

}
