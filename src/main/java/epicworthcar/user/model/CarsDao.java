package epicworthcar.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

public List<CarsResponseDto> findCarAll(){
	List<CarsResponseDto> list = new ArrayList<CarsResponseDto>();
	try {
		conn = DBManager.getConnection();
		String sql = "SELECT license_number, name, brand_code, model, type, color, engine, rental_fee, booked_dates FROM cars";
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		while(rs.next()) {
			String license_number = rs.getString(1);
			String name = rs.getString(2);
			String brand_code = rs.getString(3);
			String model = rs.getString(4);
			String type = rs.getString(5);
			String color = rs.getString(6);
			String engine = rs.getString(7);
			String rental_fee = rs.getString(8);
			String booked_dates = rs.getString(9);
			
			CarsResponseDto cars = new CarsResponseDto(license_number, name, brand_code, model, type, color, engine, rental_fee, booked_dates);
			list.add(cars);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
}
