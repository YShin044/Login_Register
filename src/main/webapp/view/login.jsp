<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/SignIn/login" method="post">
		<c:if test="${alert != null }">
			<h3 class="alert alert danger">${alert}</h3>
		</c:if> 
		<div class="img_container">
			<img src="" alt="Avatar" class="avatar">
		</div>
		<div class="container">
			<label for="username"><b>Username</b></label> <input type="text"
				placeholder="enter username" name="username" required> <br>
			<label for="password"><b>Password</b></label> <input type="password"
				placeholder="enter password" name="password" required>
			<button type="submit">Login</button>
			<label> <input type="checkbox" checked="checked"
				name="remember">remember me
			</label>
		</div>
		<div class="container" style="background-color: #f1f1f1">
			<button type="button" class="cancelbtn">Cancel</button>
			<span class="password">forgot <a href="#">password</a></span>
		</div>
	</form>

</body>
</html>