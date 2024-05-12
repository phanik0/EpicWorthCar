package epicworthcar.user.model.cars;

public class CarsResponseDto {
	private String license_number;
	private String name;
	private String brand_code;
	private String model;
	private String color;
	private String engine;
	private String rental_fee;
	private String booked_dates;
	private String type;
	
	
	
	public CarsResponseDto(String license_number, String name, String brand_code, String model, String type, String color,
			String engine, String rental_fee, String booked_dates) {
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
	
	
	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBrand_code(String brand_code) {
		this.brand_code = brand_code;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public void setRental_fee(String rental_fee) {
		this.rental_fee = rental_fee;
	}
	public void setBooked_dates(String booked_dates) {
		this.booked_dates = booked_dates;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s/%s/%s/%s", this.license_number, this.name, this.model,this.booked_dates);
	}
}
