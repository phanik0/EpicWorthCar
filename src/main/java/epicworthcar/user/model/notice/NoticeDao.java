package epicworthcar.user.model.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import epicworthcar.util.DBManager;

public class NoticeDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private NoticeDao() {

	}

	private static NoticeDao instance = new NoticeDao();

	public static NoticeDao getInstance() {
		return instance;
	}

	public List<NoticeResponseDto> findNoticeAll() {
		List<NoticeResponseDto> list = new ArrayList<NoticeResponseDto>();
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT title, body, number, id, write_date, update_date FROM notice";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				String title = rs.getString(1);
				String body = rs.getString(2);
				String number = rs.getString(3);
				String id = rs.getString(4);
				Timestamp write_date = rs.getTimestamp(5);
				Timestamp update_date = rs.getTimestamp(6);

				NoticeResponseDto notice = new NoticeResponseDto(title, body, number, number, write_date, update_date);
				list.add(notice);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public NoticeResponseDto findNoticeByNumber(String number) {
		NoticeResponseDto notice = null;

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT number, title , body,  id, write_date FROM notice WHERE number =?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String title = rs.getString(2);

				String body = rs.getString(3);

				String id = rs.getString(4);
				Timestamp write_date = rs.getTimestamp(5);
				notice = new NoticeResponseDto(title, body, number, id, write_date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return notice;
	}

	public NoticeResponseDto findNoticeByIdAndDate(String id, Timestamp write_date) {
		NoticeResponseDto notice = null;

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT  title , body,  number FROM notice WHERE number=? AND write_date = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setTimestamp(2, write_date);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				String title = rs.getString(3);
				String body = rs.getString(3);
				String number = rs.getString(4);
				notice = new NoticeResponseDto(title, body, number, id, write_date);
				return notice;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return notice;
	}

	public NoticeResponseDto writeNotice(NoticeRequestDto noticeDto) {
		NoticeResponseDto notice = null;

		try {
			conn = DBManager.getConnection();

			String sql = "INSERT INTO notice (title,body,id) VALUES(?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeDto.getTitle());
			pstmt.setString(3, noticeDto.getBody());
			pstmt.setString(3, noticeDto.getId());

			pstmt.execute();

			notice = findNoticeByIdAndDate(noticeDto.getId(), new Timestamp(new Date().getTime()));
			return notice;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;
	}

	public NoticeResponseDto updateNotice(NoticeRequestDto noticeDto) {
		NoticeResponseDto notice = null;

		try {
			conn = DBManager.getConnection();

			String sql = "UPDATE notice SET title = ? ,body = ? ,update_date = ? WHERE number=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeDto.getTitle());
			pstmt.setString(2, noticeDto.getBody());
			pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
			pstmt.setString(4, noticeDto.getNumber());
			
			pstmt.execute();

			return findNoticeByNumber(noticeDto.getNumber());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return notice;
	}
	public boolean deleteNotice(String number) {
	
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM notice WHERE number=?";
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
