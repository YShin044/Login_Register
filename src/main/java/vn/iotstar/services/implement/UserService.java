package vn.iotstar.services.implement;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.implement.UserDaoImplement;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService{
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
	public UserModel register() {
		// TODO Auto-generated method stub
		return null;
	}

}
