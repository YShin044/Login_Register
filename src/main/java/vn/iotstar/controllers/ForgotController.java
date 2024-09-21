package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.implement.UserService;
@WebServlet(urlPatterns = "/forgot")
public class ForgotController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/view/forgot.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
	    resp.setCharacterEncoding("UTF-8");
	    req.setCharacterEncoding("UTF-8");
	    IUserService service = new UserService();
	    // Lấy các giá trị từ form
	    String username = req.getParameter("username");
	    String email = req.getParameter("email");
	    String phone = req.getParameter("phone");
	    String password = req.getParameter("newPassword");
	    String cfpassword = req.getParameter("confirmPassword");
	    String alertMsg = "";
	    if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || cfpassword.isEmpty()) { 
	        alertMsg = "Vui lòng điền đầy đủ thông tin";
	        req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
	    }
	    UserModel a = service.findByUserName(username);
	    if(service.findByUserName(username) == null) {
	    	alertMsg = "không tìm thấy username";
	    	req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
	    }
	    if(!a.getPhone().equals(phone)) {
	    	alertMsg = "số điện thoại không trùng khớp";
	        
	    }
	    else if(!a.getEmail().equals(email)) {
	    	alertMsg = "email không trùng khớp";
	        
	    }
	    else if (!cfpassword.equals(password)) {
	    	alertMsg = "mật khẩu không trùng khớp";
	    }
	    if (!alertMsg.isEmpty()) {
	        req.setAttribute("alert", alertMsg);
	        req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
	    } else {
	        // Tất cả điều kiện hợp lệ, tiến hành thêm người dùng mới vào cơ sở dữ liệu
	        service.updatePassword(a.getId(), password);
	        
	        // Chuyển hướng đến trang đăng nhập
	        resp.sendRedirect(req.getContextPath() + "/login");
	    }
	    
	    	
	    
	    
	}

}
