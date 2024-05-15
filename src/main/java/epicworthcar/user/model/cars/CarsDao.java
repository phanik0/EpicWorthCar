package epicworthcar.user.model.cars;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import epicworthcar.user.model.users.User;
import epicworthcar.util.DBManager;

public class CarsDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private CarsDao() {

	}

	private static CarsDao instance = new CarsDao();

	public static CarsDao getInstance() {
		return instance;
	}

	public List<CarsResponseDto> findCarAll() {
		List<CarsResponseDto> list = new ArrayList<CarsResponseDto>();
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT code, license_number, name, brand_code, model, type, color, engine, rental_fee, booked_dates FROM cars";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				String code = rs.getString(1);
				String license_number = rs.getString(2);
				String name = rs.getString(3);
				String brand_code = rs.getString(4);
				String model = rs.getString(5);
				String type = rs.getString(6);
				String color = rs.getString(7);
				String engine = rs.getString(8);
				String rental_fee = rs.getString(9);
				String booked_dates = rs.getString(10);

				CarsResponseDto cars = new CarsResponseDto(code, license_number, name, brand_code, model, type, color,
						engine, rental_fee, booked_dates);
				list.add(cars);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public CarsResponseDto createReserve(String carCode, String startDay, String endDay) {
		try {
			conn = DBManager.getConnection();

			// 예약 정보를 가져올 때는 현재 예약 정보를 먼저 확인합니다.
			String sqlSelect = "SELECT booked_dates FROM cars WHERE code=?";
			pstmt = conn.prepareStatement(sqlSelect);
			pstmt.setString(1, carCode);
			rs = pstmt.executeQuery();

			String bookedDatesJson = null;
			if (rs.next()) {
				bookedDatesJson = rs.getString("booked_dates");
			}

			// 현재 예약 정보에 새로운 예약 정보 추가
			ObjectMapper objectMapper = new ObjectMapper();
			ObjectNode bookedDatesNode = (ObjectNode)objectMapper.readTree(bookedDatesJson != null ? bookedDatesJson : "{}");
					


			for (LocalDate date = LocalDate.parse(startDay); !date.isAfter(LocalDate.parse(endDay)); date = date
					.plusDays(1)) {
				bookedDatesNode.put(date.toString(), "user1"); // 예약 사용자 이름은 "user1"로 가정
			}

			// 업데이트된 JSON 데이터를 데이터베이스에 저장
			String updatedBookedDatesJson = objectMapper.writeValueAsString(bookedDatesNode);
			String sqlUpdate = "UPDATE cars SET booked_dates=? WHERE code=?";
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setString(1, updatedBookedDatesJson);
			pstmt.setString(2, carCode);
			pstmt.executeUpdate();

			// 예약 정보를 포함한 차량 정보를 다시 가져옴
			return findCarById(carCode);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	}

	public CarsResponseDto findCarById(String code) {
		CarsResponseDto car = null;

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT code , license_number, name, brand_code, model,type, color , engine, rental_fee, booked_dates FROM cars WHERE code=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String license_number = rs.getString(2);
				System.out.println(license_number);
				String name = rs.getString(3);
				String brand_code = rs.getString(4);
				String model = rs.getString(5);
				String type = rs.getString(6);
				String color = rs.getString(7);
				String engine = rs.getString(8);
				String rental_fee = rs.getString(9);
				String booked_dates = rs.getString(10);
				String brand = findBrandByBrandCode(brand_code);
				car = new CarsResponseDto(code, license_number, name, brand_code, brand, model, type, color, engine,
						rental_fee, booked_dates);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return car;
	}

	public String findBrandByBrandCode(String brand_code) {
		String brand = "";
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT name FROM categories WHERE code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brand_code);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				brand = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return brand;
	}
}
