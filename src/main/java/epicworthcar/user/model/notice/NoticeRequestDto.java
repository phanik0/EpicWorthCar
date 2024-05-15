package epicworthcar.user.model.notice;

import java.sql.Timestamp;

public class NoticeRequestDto {
	private String title;
	private String body;
	private String number;
	private String id;
	private Timestamp write_date;
	private Timestamp update_date;
	
	public NoticeRequestDto() {
		
	}
	public NoticeRequestDto(String title, String body, String number, String id, Timestamp write_date,
			Timestamp update_date) {
		super();
		this.title = title;
		this.body = body;
		this.number = number;
		this.id = id;
		this.write_date = write_date;
		this.update_date = update_date;
	}
	public NoticeRequestDto(String title, String body, String id) {
		super();
		this.title = title;
		this.body = body;
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	public Timestamp getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}

}
