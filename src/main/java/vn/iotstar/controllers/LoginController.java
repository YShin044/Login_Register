package vn.iotstar.controllers;

import java.io.IOException;

import org.eclipse.tags.shaded.org.apache.xalan.xsltc.compiler.util.InternalError;

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
import vn.iotstar.utils.constant;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet{
	IUserService service = new UserService();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// lấy tham số từ view
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String act = req.getParameter("act");
		String uname = req.getParameter("username");
		String pws = req.getParameter("password");
		boolean rememberme = false;
		String remember = req.getParameter("remember");
		
		// kiểm tra tham số
		if ("on".equals(remember)) {
			rememberme = true;
		}
		String alertMsg = "";
		if (uname.isEmpty() || pws.isEmpty()) {
			alertMsg = "please enter the password or username";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/view/login.jsp").forward(req,resp);
			return;
		}
		//xử lý bài toán
		UserModel user = service.login(uname, pws);
		if (user!=null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			if (rememberme) {
				saveRememberme(resp,uname);
			}
			resp.sendRedirect(req.getContextPath() + "/waiting");
		}else {
			alertMsg = "wrong pass or user";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
		}
	}
	private void saveRememberme(HttpServletResponse resp, String uname) {
		// TODO Auto-generated method stub
		Cookie cookie = new Cookie(constant.COOKIE_REMEMBER,uname);
		cookie.setMaxAge(30*60);
		resp.addCookie(cookie);
	}
}
