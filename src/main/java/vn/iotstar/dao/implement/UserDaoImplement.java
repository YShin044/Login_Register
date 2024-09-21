package vn.iotstar.dao.implement;

import java.sql.Connection;
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
		String sql = "INSERT INTO user(id,fullname,email,image,username,password,roleid,phone,createdate) VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getId());
			ps.setString(2, a.getFullname());
			ps.setString(3, a.getEmail());
			ps.setString(4, a.getImage());
			ps.setString(5, a.getUsername());
			ps.setString(6, a.getPassword());
			ps.setInt(7, a.getRoleid());
			ps.setString(8, a.getPhone());
			ps.setDate(9, a.getCreatedate());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return false;
	}
	

	
	public static void main(String[] args) {
		IUserDao userdao = new UserDaoImplement();
		//UserModel b = new UserModel(2,"david nguyễn","david123@gmai.com",null,"david","123");
		//userdao.insert(b);
//		List<UserModel> list = userdao.findAll();
//		
//		for (UserModel user : list) {
//			System.out.println(user);
//		}
		try {
			UserModel a = userdao.findByUserName("quochuy123");
			System.out.println(a);
			
		}catch(Exception e){
			e.printStackTrace();
		}
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
}
