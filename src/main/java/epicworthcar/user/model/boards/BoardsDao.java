package epicworthcar.user.model.boards;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import epicworthcar.user.model.cars.CarsDao;
import epicworthcar.user.model.cars.CarsResponseDto;
import epicworthcar.user.model.users.UserRequestDto;
import epicworthcar.user.model.users.UserResponseDto;
import epicworthcar.util.DBManager;

public class BoardsDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BoardsDao() {

	}

	private static BoardsDao instance = new BoardsDao();

	public static BoardsDao getInstance() {
		return instance;
	}

	public List<BoardsResponseDto> findBoardAll() {
		List<BoardsResponseDto> list = new ArrayList<BoardsResponseDto>();
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT title, body, number, id, write_date, update_date FROM board";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				String title = rs.getString(1);
				String body = rs.getString(2);
				String number = rs.getString(3);
				String id = rs.getString(4);
				Timestamp write_date = rs.getTimestamp(5);
				Timestamp update_date = rs.getTimestamp(6);

				BoardsResponseDto boards = new BoardsResponseDto(title, body, number, number, write_date, update_date);
				list.add(boards);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public BoardsResponseDto findPostByNumber(String number) {
		BoardsResponseDto post = null;

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT number, title , body,  id, write_date FROM board WHERE number=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String title = rs.getString(2);

				String body = rs.getString(3);

				String id = rs.getString(4);
				Timestamp write_date = rs.getTimestamp(5);
				post = new BoardsResponseDto(title, body, number, id, write_date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return post;
	}

	public BoardsResponseDto findPostByIdAndDate(String id, Timestamp write_date) {
		BoardsResponseDto post = null;

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT  title , body,  number FROM board WHERE number=? AND write_date = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setTimestamp(2, write_date);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				String title = rs.getString(3);
				String body = rs.getString(3);
				String number = rs.getString(4);
				post = new BoardsResponseDto(title, body, number, id, write_date);
				return post;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return post;
	}

	public BoardsResponseDto writePost(BoardsRequestDto boardsDto) {
		BoardsResponseDto post = null;

		try {
			conn = DBManager.getConnection();

			String sql = "INSERT INTO board (title,body,id) VALUES(?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardsDto.getTitle());
			pstmt.setString(2, boardsDto.getBody());
			pstmt.setString(3, boardsDto.getId());

			pstmt.execute();

			post = new BoardsResponseDto();
			return post;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;
	}

	public BoardsResponseDto updatePost(BoardsRequestDto boardsDto) {
		BoardsResponseDto post = null;

		try {
			conn = DBManager.getConnection();

			String sql = "UPDATE board SET title = ? ,body = ? ,update_date = ? WHERE number=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardsDto.getTitle());
			pstmt.setString(2, boardsDto.getBody());
			pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
			pstmt.setString(4, boardsDto.getNumber());
			
			pstmt.execute();

			return findPostByNumber(boardsDto.getNumber());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return post;
	}
	public boolean deletePost(String number) {
	
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM board WHERE number=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, number);
			pstmt.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return false;
	}
}
