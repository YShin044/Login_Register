package vn.iotstar.services;

import vn.iotstar.models.UserModel;

public interface IUserService {
	public UserModel login(String user, String pass);

	UserModel findByUserName(String username);


	public void logout();

	public void insert(UserModel a);

	boolean register(String fullname, String email, String username, String password, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
	boolean updatePassword(int id,String newpass);

}
