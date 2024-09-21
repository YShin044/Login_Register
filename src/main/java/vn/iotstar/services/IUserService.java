package vn.iotstar.services;

import vn.iotstar.models.UserModel;

public interface IUserService {
	public UserModel login(String user, String pass);
	UserModel findByUserName(String username);
	public UserModel register();
}
