package vn.iotstar.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String fullname;
	private String email;
	private String image;
	private String username;
	private String password;
	private int roleid;
	private String phone;
	private Date createdate;
	public UserModel() {
		super();
	}
	
	public UserModel(String fullname, String email, String image, String username, String password, int roleid,
			String phone, Date createdate) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.image = image;
		this.username = username;
		this.password = password;
		this.roleid = roleid;
		this.phone = phone;
		this.createdate = createdate;
	}

	public UserModel(int id, String fullname, String email, String image, String username, String password, int roleid,
			String phone, Date createdate) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.image = image;
		this.username = username;
		this.password = password;
		this.roleid = roleid;
		this.phone = phone;
		this.createdate = createdate;
	}
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fullname=" + fullname + ", email=" + email + ", image=" + image
				+ ", username=" + username + ", password=" + password + ", roleid=" + roleid + ", phone=" + phone
				+ ", createdate=" + createdate + "]";
	}
}
