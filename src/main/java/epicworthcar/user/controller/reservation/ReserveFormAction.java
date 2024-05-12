package epicworthcar.user.controller.reservation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epicworthcar.user.model.cars.CarsDao;
import epicworthcar.user.model.cars.CarsRequestDto;
import epicworthcar.user.model.cars.CarsResponseDto;

/**
 * Servlet implementation class ReserveFormAction
 */

public class ReserveFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveFormAction() {
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
		System.out.println("123");
		request.setCharacterEncoding("UTF-8");
		   String startDay = request.getParameter("startDay");
		   String endDay = request.getParameter("endDay");
		   String carCode = request.getParameter("carCode");
		   
	        System.out.println(startDay);
	        System.out.println(endDay);
	        
	        CarsDao carsDao = CarsDao.getInstance();
	        
	        CarsResponseDto car = carsDao.findCarById(carCode);
	        
	        if(startDay != null && endDay != null) {
	        	car = carsDao.createReserve(carCode,startDay, endDay);
	        }
//	        
//	        
//	        request.setAttribute("car", car);
//	        
//	        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/reserve/reserveForm.jsp");
//	        dispatcher.forward(request, response);
	}
	
	

}
