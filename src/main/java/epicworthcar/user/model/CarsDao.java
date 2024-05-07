package epicworthcar.user.model;

import java.util.ArrayList;
import java.util.List;

public class CarsDao {
private CarsDao() {
	
}
private static CarsDao instance = new CarsDao();

public static CarsDao getInstance() {
	return instance;
}

public List<CarsResponseDto> findCarAll(){
	List<CarsResponseDto> list = new ArrayList<CarsResponseDto>();
	
	return list;
}
}
