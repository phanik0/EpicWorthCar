package epicworthcar.user.model;

public class CarsRequestDto {
	private String license_number;
	private String name;
	private String brand_code;
	private String model;
	private String color;
	private String engine;
	private String rental_fee;
	private String booked_dates;
	private String type;
	
	public CarsRequestDto() {
		
	}
	
	
	public CarsRequestDto(String license_number, String name, String brand_code, String model, String color,
			String engine, String rental_fee, String booked_dates, String type) {
		super();
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
	public String getLicense_number() {
		return license_number;
	}
	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand_code() {
		return brand_code;
	}
	public void setBrand_code(String brand_code) {
		this.brand_code = brand_code;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getRental_fee() {
		return rental_fee;
	}
	public void setRental_fee(String rental_fee) {
		this.rental_fee = rental_fee;
	}
	public String getBooked_dates() {
		return booked_dates;
	}
	public void setBooked_dates(String booked_dates) {
		this.booked_dates = booked_dates;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
