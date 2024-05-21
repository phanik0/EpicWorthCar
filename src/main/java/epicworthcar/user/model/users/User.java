package epicworthcar.user.model.users;

import java.sql.Timestamp;

public class User {
	private String id;
	private String password;
	private String name;
	private String resident_number;
	private String phone;
	private boolean admin;
	private String email;
	private Timestamp reg_Date;
	private Timestamp update_Date;
	
	public User() {
		
	}
	
	
	public User(String id, String password, String name, String resident_number, String phone, boolean admin,
			String email, Timestamp reg_Date, Timestamp update_Date) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.resident_number = resident_number;
		this.phone = phone;
		this.admin = admin;
		this.email = email;
		this.reg_Date = reg_Date;
		this.update_Date = update_Date;
	}
	public User(String id, String password, String name, String resident_number, String phone, boolean admin,
			String email, Timestamp reg_Date) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.resident_number = resident_number;
		this.phone = phone;
		this.admin = admin;
		this.email = email;
		this.reg_Date = reg_Date;
		
	}
	public User(String id,  String name, String resident_number, String phone, boolean admin,
			String email, Timestamp reg_Date) {
		super();
		this.id = id;
		this.name = name;
		this.resident_number = resident_number;
		this.phone = phone;
		this.admin = admin;
		this.email = email;
		this.reg_Date = reg_Date;
		
	}
	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getResident_number() {
		return resident_number;
	}

	public String getPhone() {
		return phone;
	}

	public boolean isAdmin() {
		return admin;
	}

	public String getEmail() {
		return email;
	}

	public Timestamp getReg_Date() {
		return reg_Date;
	}

	public Timestamp getUpdate_Date() {
		return update_Date;
	}
	
	
	
}
