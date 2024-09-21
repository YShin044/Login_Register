package vn.iotstar.controllers;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.implement.UserService;



@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // Thiết lập mã hóa
	    resp.setContentType("text/html");
	    resp.setCharacterEncoding("UTF-8");
	    req.setCharacterEncoding("UTF-8");

	    // Lấy các giá trị từ form
	    String fullname = req.getParameter("fullname");
	    String username = req.getParameter("username");
	    String email = req.getParameter("email");
	    String phone = req.getParameter("phone");
	    String password = req.getParameter("password");
	    String cfpassword = req.getParameter("confirmPassword");
	    String alertMsg = "";
	    
	    // Lấy ngày hiện tại
	    Date currentDate = new Date(System.currentTimeMillis());

	    // Tạo đối tượng UserService để sử dụng các phương thức kiểm tra
	    IUserService a = new UserService();

	    // Kiểm tra các điều kiện nhập
	    if (fullname.isEmpty() || username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || cfpassword.isEmpty()) {
	        alertMsg = "Vui lòng điền đầy đủ thông tin";
	    } else if (a.checkExistEmail(email)) {
	        alertMsg = "Email đã tồn tại";
	    } else if (a.checkExistPhone(phone)) {
	        alertMsg = "Số điện thoại đã tồn tại";
	    } else if (a.checkExistUsername(username)) {
	        alertMsg = "Username đã tồn tại";
	    } else if (!password.equals(cfpassword)) {
	        alertMsg = "Mật khẩu xác nhận không khớp";
	    } 

	    // Nếu có bất kỳ cảnh báo nào, hiển thị thông báo và dừng tiến trình
	    if (!alertMsg.isEmpty()) {
	        req.setAttribute("alert", alertMsg);
	        req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
	    } else {
	        // Tất cả điều kiện hợp lệ, tiến hành thêm người dùng mới vào cơ sở dữ liệu
	        a.insert(new UserModel(fullname, email, "", username, password, 1, phone, currentDate));
	        
	        // Chuyển hướng đến trang đăng nhập
	        resp.sendRedirect(req.getContextPath() + "/login");
	    }
	}

}


