package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.UserDao;
import user.model.UserRequestDto;
import user.model.UserResponseDto;

/**
 * Servlet implementation class UpdateUserFormAction
 */
public class UpdateUserFormAction extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public UpdateUserFormAction() {
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
//      request.setCharacterEncoding("UTF-8");
//
//      UserDao userDao = UserDao.getInstance();
//
//      HttpSession session = request.getSession();
//
//      UserResponseDto user = (UserResponseDto) session.getAttribute("user");
//
//      String password = request.getParameter("password");
//
//      // 입력된 패스워드 검증 후,
//      if (userDao.findUserByIdAndPassword(user.getId(), password) != null) {
//         UserRequestDto userDto = new UserRequestDto();
//
//         userDto.setId(user.getId());
//         userDto.setPassword(password);
//
//         String newPassword = request.getParameter("password-new");
//         String email = request.getParameter("email");
//
//         String telecom = request.getParameter("telecom");
//         String phone = request.getParameter("phone");
//
//         if (user.getEmail() != null && !user.getEmail().equals(email)) {
//            userDto.setEmail(email);
//            user = userDao.updateUserEmail(userDto);
//         }
//
//         if(!user.getTelecom().equals(telecom) || !user.getPhone().equals(phone)) {
//             userDto.setTelecom(telecom);
//             userDto.setPhone(phone);
//             user = userDao.updateUserPhone(userDto);
//          }
//         
//         if (!newPassword.equals("") && !newPassword.equals(password)) {
//             user = userDao.updateUserPassword(userDto, newPassword);
//          } else {
//             System.err.println("새 비밀번호 오류");
//             String.format("%s", newPassword);
//          }
//
//      }
//      session.setAttribute("user", user);
//      response.sendRedirect("/mypage");

   }

}