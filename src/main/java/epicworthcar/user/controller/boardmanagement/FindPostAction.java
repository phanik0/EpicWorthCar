package epicworthcar.user.controller.boardmanagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epicworthcar.user.model.boards.BoardsDao;
import epicworthcar.user.model.boards.BoardsResponseDto;
import epicworthcar.user.model.cars.CarsDao;
import epicworthcar.user.model.cars.CarsResponseDto;

/**
 * Servlet implementation class FindPostAction
 */

public class FindPostAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPostAction() {
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
	        
	        
	        BoardsResponseDto post = BoardsDao.getInstance().findPostByNumber(number); 
	        
	        
	        request.setAttribute("post", post);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/board/postForm.jsp");
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
	        
	        
	        BoardsResponseDto post = BoardsDao.getInstance().findPostByNumber(number); 
	        
	        
	        request.setAttribute("post", post);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/board/postForm.jsp");
	        dispatcher.forward(request, response);
	}

}
