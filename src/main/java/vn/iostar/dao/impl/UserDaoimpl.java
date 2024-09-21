package vn.iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.configs.DBconnectMySQL;
import vn.iostar.dao.intUserDao;
import vn.iostar.models.UserModel;

public class UserDaoimpl extends DBconnectMySQL implements intUserDao{
	
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll(){
			
		String sql ="select * from users";
		
		List<UserModel> list = new ArrayList<>();
		
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add(new UserModel(
						rs.getInt("idUsers"),
						rs.getString("Username"),
						rs.getString("password"),
						rs.getString("Email"),
						rs.getString("Fullname"),
						rs.getString("images")
						)
				);
			} 
		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//		public void insert(UserModel user){
//			
//		}
//			String sql ="INSERT INTO user(id, username, email, password, images, fullname) VALUE (?, ?, ?, ?, ?, ?)";
//			try {
//				conn = super.getDatabaseConnection();
//				ps = conn.prepareStatement(sql);
//
//		ps.setInt(1,getidUsers());
//		ps.setString(2,getUsername());
//		ps.setString(3,getpassword());
//		ps.setString(4,getEmail());
//		ps.setString(5,getFullname());
//		ps.setString(6,getimages());
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return null;
//}
	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		
	}
	   public static void main(String[] args) {
		 
		   UserDaoimpl userDao = new UserDaoimpl();
		   
		   userDao.insert(new UserModel(4,"vylt","vylt@gmail.com","123","","Luong Tuan Vy"));
		   
		   List<UserModel> list = userDao.findAll();
		   
		   for (UserModel user:list) {
			   System.out.println(user);
		   }
	   }
		 
}
