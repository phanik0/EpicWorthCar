package epicworthcar.user.model.boards;

import java.sql.Timestamp;

public class Boards {
private String title;
private String body;
private String number;
private String id;
private Timestamp write_date;
private Timestamp update_date;

public Boards(String title, String body, String number, String id, Timestamp write_date, Timestamp update_date) {
	super();
	this.title = title;
	this.body = body;
	this.number = number;
	this.id = id;
	this.write_date = write_date;
	this.update_date = update_date;
}
public String getTitle() {
	return title;
}
public String getBody() {
	return body;
}
public String getNumber() {
	return number;
}
public String getId() {
	return id;
}
public Timestamp getWrite_date() {
	return write_date;
}
public Timestamp getUpdate_date() {
	return update_date;
}

}
