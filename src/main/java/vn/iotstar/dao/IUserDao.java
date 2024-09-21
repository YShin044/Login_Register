package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	List<UserModel> findAll();
	UserModel findById(int id);
	boolean insert(UserModel a);
	UserModel findByUserName(String username);
	UserModel findByEmail(String email);
	UserModel findByPhone(String phone);
	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
}
