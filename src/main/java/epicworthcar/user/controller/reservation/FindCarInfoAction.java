package epicworthcar.user.controller.reservation;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epicworthcar.user.model.cars.CarsDao;
import epicworthcar.user.model.cars.CarsResponseDto;

/**
 * Servlet implementation class ReserveFormAction
 */

public class FindCarInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCarInfoAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("123");
		request.setCharacterEncoding("UTF-8");
		   String carCode = request.getParameter("carCode");
	        System.out.println(carCode);
	        
	        
	        CarsResponseDto car = CarsDao.getInstance().findCarById(carCode); 
	        
	        
	        request.setAttribute("car", car);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/reserve/reserveForm.jsp");
	        dispatcher.forward(request, response);
	}

}
