package epicworthcar.user.model.cars;

public class Cars {
	
	private String code;
	private String license_number;
	private String name;
	private String brand_code;
	private String model;
	private String color;
	private String engine;
	private String rental_fee;
	private String booked_dates;
	private String type;
	
	
	public Cars(String code, String license_number, String name, String brand_code, String model,  String type,String color, String engine,
			String rental_fee, String booked_dates) {
		super();
		this.code = code;
		this.license_number = license_number;
		this.name = name;
		this.brand_code = brand_code;
		this.model = model;
		this.color = color;
		this.engine = engine;
		this.rental_fee = rental_fee;
		this.booked_dates = booked_dates;
		this.type = type;
	}
	
	public String getCode() {
		return code;
	}

	public String getLicense_number() {
		return license_number;
	}
	public String getName() {
		return name;
	}
	public String getBrand_code() {
		return brand_code;
	}
	public String getModel() {
		return model;
	}
	public String getColor() {
		return color;
	}
	public String getEngine() {
		return engine;
	}
	public String getRental_fee() {
		return rental_fee;
	}
	public String getBooked_dates() {
		return booked_dates;
	}
	public String getType() {
		return type;
	}
	
	
	
}
