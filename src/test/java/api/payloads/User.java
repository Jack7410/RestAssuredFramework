package api.payloads;

public class User {
	
	
	int id;
	String username;
	String firstname;
	String lastname;
	String email;
	String passoword;
	String phone;
	int userstatus=0;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassoword() {
		return passoword;
	}
	public void setPassoword(String passoword) {
		this.passoword = passoword;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUserstatus() {
		return userstatus;
	}
	public void setUserstatus(int userstatus) {
		this.userstatus = userstatus;
	}

}
