package epicworthcar.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class DeleteFormAction
 */
public class DeleteFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFormAction() {
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
//		HttpSession session = request.getSession();
//		
//		request.setCharacterEncoding("UTF-8");
//
//		UserDao userDao = UserDao.getInstance();
//
//		UserResponseDto user = (UserResponseDto) session.getAttribute("user");
//
//		String id = user.getId();
//		String password = request.getParameter("password");
//
//		// 패스워드가 일치하면 -> 삭제 처리 
//		UserRequestDto userDto = new UserRequestDto();
//
//		userDto.setId(id);
//		userDto.setPassword(password);
//
//		boolean result = userDao.deleteUser(userDto);
//
//		if(result) {
//			System.out.println("탈퇴완료");
//			session.removeAttribute("user");
//			response.sendRedirect("/");
//		} else {	
//			response.sendRedirect("/deleteUserForm");
//			System.out.println("탈퇴실패");
//		}
	}

}
