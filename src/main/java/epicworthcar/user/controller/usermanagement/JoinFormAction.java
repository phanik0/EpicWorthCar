package epicworthcar.user.controller.usermanagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epicworthcar.user.model.users.UserDao;
import epicworthcar.user.model.users.UserRequestDto;
import epicworthcar.user.model.users.UserResponseDto;

/**
 * Servlet implementation class JoinFormAction
 */

public class JoinFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public JoinFormAction() {
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

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String resident_number = first + "-" + last;
		System.out.println(resident_number);
		String phone = request.getParameter("phone");
	//	String admin = request.getParameter("admin");
		String admin = "false";
		// Backend 에서 전달받은 데이터에 대한 유효성 검증
		boolean isValid = true;

		if (id == null || id.equals("")) {
			isValid = false;
			System.out.println("1");
		}
		else if (password == null || password.equals("")) {
			isValid = false;
			System.out.println("2");

		}
		else if (name == null || name.equals("")) {
			isValid = false;
			System.out.println("3");
		}
		else if (resident_number == null || resident_number.equals("")) {
			isValid = false;
			System.out.println("4");
		}
//		else if (admin == null || admin.equals(""))
//			isValid = false;
		else if (phone == null || phone.equals("")) {
			isValid = false;
			System.out.println("5");
		}

		// Processing Page 에서는 사용자에게 보여주는 화면을 작성하지 않음
		// 요청에 대한 응답 처리를 작성
		// 1) 페이지 이동 처리 (흐름을 제어)
		if (isValid) {
			// 연동된 데이터 베이스로부터
			// 유저의 정보를 조회 하고,
			// 중복에 대한 검증을 한 후에
			// 가입 처리 후, 페이지 이동

			UserRequestDto userDto = new UserRequestDto(id, password, name, resident_number, phone, admin, email);

			UserDao userDao = UserDao.getInstance();
			UserResponseDto user = userDao.createUser(userDto);

			if (user == null) {
				// 실패
				response.sendRedirect("/join");
			} else {
				// 성공
				System.out.println("user : " + user);

				response.sendRedirect("/login");
			}
		} else {
			response.sendRedirect("/join");
			System.err.println("error");
		}

	}

}
