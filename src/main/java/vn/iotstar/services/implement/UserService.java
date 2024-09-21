package vn.iotstar.services.implement;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.implement.UserDaoImplement;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService {
	IUserDao userdao = new UserDaoImplement();

	@Override
	public UserModel login(String user, String pass) {
		// TODO Auto-generated method stub
		UserModel User = this.findByUserName(user);
		if (User != null && User.getPassword().equals(pass)) {
			return User;
		}
		return null;
	}

	@Override
	public UserModel findByUserName(String username) {
		// TODO Auto-generated method stub
		return userdao.findByUserName(username);
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(UserModel a) {
		userdao.insert(a);
	}

	@Override
	public boolean register(String fullname, String email, String username, String password, String phone) {
		if (userdao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userdao.insert(new UserModel(fullname,email,"", username, password,1, phone, date));
		return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return userdao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		return userdao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return userdao.checkExistPhone(phone);
	}

	@Override
	public boolean updatePassword(int id, String newpass) {
		// TODO Auto-generated method stub
		return userdao.updatePassword(id, newpass);
	}

}
