package epicworthcar.user.controller.boardmanagement;

import java.io.IOException;
import java.util.List;

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
import epicworthcar.user.model.notice.NoticeDao;
import epicworthcar.user.model.notice.NoticeResponseDto;

/**
 * Servlet implementation class BoardListFormAction
 */

public class BoardListFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardListFormAction() {
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
		List<BoardsResponseDto> boardList = BoardsDao.getInstance().findBoardAll();
		List<NoticeResponseDto> noticeList = NoticeDao.getInstance().findNoticeAll();
		request.setAttribute("boardList", boardList);
		request.setAttribute("noticeList", noticeList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/board/boardListForm.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
