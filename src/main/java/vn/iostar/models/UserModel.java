package vn.iostar.models;

import java.io.Serializable;

public class UserModel implements Serializable {

	private static final long serialVersionUID = -3230993579516877897L;
		private int idUsers;
		private String Username;
		private String Email;
		private String password;
		private String Fullname;
		private String images;
		
		public UserModel() {
			super();
		}

		public UserModel(int idUsers, String username, String email, String password, String fullname, String images) {
			super();
			this.idUsers = idUsers;
			Username = username;
			Email = email;
			this.password = password;
			Fullname = fullname;
			this.images = images;
		}

		public int getIdUsers() {
			return idUsers;
		}

		public void setIdUsers(int idUsers) {
			this.idUsers = idUsers;
		}

		public String getUsername() {
			return Username;
		}

		public void setUsername(String username) {
			Username = username;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFullname() {
			return Fullname;
		}

		public void setFullname(String fullname) {
			Fullname = fullname;
		}

		public String getImages() {
			return images;
		}

		public void setImages(String images) {
			this.images = images;
		}

		@Override
		public String toString() {
			return "UserModel [idUsers=" + idUsers + ", Username=" + Username + ", Email=" + Email + ", password="
					+ password + ", Fullname=" + Fullname + ", images=" + images + "]";
		}
		
		
		
}
