package epicworthcar.user.model.users;

import java.sql.Timestamp;



public class UserResponseDto {

	private String id;
	private String name;
	private String resident_number;
	private String phone;
	private boolean admin;
	private String email;
	private Timestamp reg_Date;
	private Timestamp update_Date;
	public UserResponseDto() {
		
	}
	
	public UserResponseDto(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.name = user.getName();
		this.resident_number = user.getResident_number();
		this.phone = user.getPhone();
		this.admin = user.isAdmin();
	}
	public UserResponseDto(String id, String name, String resident_number, String phone, boolean admin, String email) {
		super();
		this.id = id;
		this.name = name;
		this.resident_number = resident_number;
		this.phone = phone;
		this.admin = admin;
		this.email = email;
	}
	
	
	public UserResponseDto(String id, String name, String resident_number, String phone, boolean admin, String email,
			Timestamp reg_Date, Timestamp update_Date) {
		super();
		this.id = id;
		this.name = name;
		this.resident_number = resident_number;
		this.phone = phone;
		this.admin = admin;
		this.email = email;
		this.reg_Date = reg_Date;
		this.update_Date = update_Date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResident_number() {
		return resident_number;
	}
	public void setResident_number(String resident_number) {
		this.resident_number = resident_number;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getReg_Date() {
		return reg_Date;
	}
	public void setReg_Date(Timestamp reg_Date) {
		this.reg_Date = reg_Date;
	}
	public Timestamp getUpdate_Date() {
		return update_Date;
	}
	public void setUpdate_Date(Timestamp update_Date) {
		this.update_Date = update_Date;
	}
	
	
	
}
