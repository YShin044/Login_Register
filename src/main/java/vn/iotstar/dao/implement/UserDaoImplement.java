package vn.iotstar.dao.implement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vn.iotstar.configs.DBconnectMySql;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImplement extends DBconnectMySql implements IUserDao{
	public Connection conn = null;// ket noi database
	public PreparedStatement ps = null;// cau lenh truy van sql
	public ResultSet rs = null;
	@Override
	public List<UserModel> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from user";
		List<UserModel>l = new ArrayList<>();
		try {
			conn = super.getConnection(); // kết nối database
			ps = conn.prepareStatement(sql);// thực hiện câu lệnh truy vấn
			rs = ps.executeQuery();//	thực hiện câu lệnh truy vấn
			while (rs != null && rs.next()) {
				l.add(
					new UserModel(
						rs.getInt("id"),
						rs.getString("fullname"),
						rs.getString("email"),
						rs.getString("image"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getInt("roleid"),
						rs.getString("phone"),
						rs.getDate("createdate")));
			}
			return l;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user WHERE id=?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImage(rs.getString("image"));
				user.setRoleid(rs.getInt("roleid"));
				user.setPhone(rs.getString("phone"));
				user.setCreatedate(rs.getDate("createdate"));
				return user; }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(UserModel a) {
		String sql = "INSERT INTO user(fullname,email,image,username,password,roleid,phone,createdate) VALUES(?,?,?,?,?,?,?,?)";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			//ps.setInt(1, a.getId());
			ps.setString(1, a.getFullname());
			ps.setString(2, a.getEmail());
			ps.setString(3, a.getImage());
			ps.setString(4, a.getUsername());
			ps.setString(5, a.getPassword());
			ps.setInt(6, a.getRoleid());
			ps.setString(7, a.getPhone());
			ps.setDate(8, a.getCreatedate());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return false;
	}
	

	
	public static void main(String[] args) {
		IUserDao userdao = new UserDaoImplement();
		Date currentDate = new Date(System.currentTimeMillis());
		System.out.println(userdao.insert(new UserModel("nguyễn văn B","B@gmail.com","","B123","123",1,
				"1234567890", currentDate)));
	}

	@Override
	public UserModel findByUserName(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user WHERE username = ? ";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			rs = ps.executeQuery();
			while (rs != null && rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImage(rs.getString("image"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedate(rs.getDate("createdate"));
				return user; }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findByEmail(String email) {
		String sql = "SELECT * FROM user WHERE email = ? ";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,email);
			rs = ps.executeQuery();
			while (rs != null && rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImage(rs.getString("image"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedate(rs.getDate("createdate"));
				return user; }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findByPhone(String phone) {
		String sql = "SELECT * FROM user WHERE phone = ? ";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,phone);
			rs = ps.executeQuery();
			while (rs != null && rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImage(rs.getString("image"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedate(rs.getDate("createdate"));
				return user; }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean checkExistEmail(String email) {
		IUserDao u = new UserDaoImplement();
		if (u.findByEmail(email) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		IUserDao u = new UserDaoImplement();
		if (u.findByEmail(username) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		IUserDao u = new UserDaoImplement();
		if (u.findByPhone(phone) != null) {
			return true;
		}
		return false;
	}
}
