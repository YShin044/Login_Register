<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.form-container {
	background-color: white;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	width: 300px;
	text-align: center;
}

h3.alert {
	color: red;
	margin-bottom: 15px;
}

.img_container {
	margin-bottom: 20px;
}

.avatar {
	width: 100px;
	height: 100px;
	border-radius: 50%;
	object-fit: cover;
}

label {
	display: block;
	margin: 10px 0 5px;
	text-align: left;
}

input[type="text"], input[type="password"] {
	width: calc(100% - 20px);
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

button {
	background-color: #007BFF;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	width: 100%;
	margin-bottom: 10px;
	font-size: 16px;
	transition: background-color 0.3s;
}

button:hover {
	background-color: #0056b3;
}

.container {
	margin-top: 15px;
}

.cancelbtn {
	background-color: #f44336;
}

.cancelbtn:hover {
	background-color: #c62828;
}

.password {
	display: block;
	margin-top: 10px;
}

.signup-btn {
	background-color: #28a745;
	color: white;
	padding: 10px;
	border-radius: 5px;
	border: none;
	width: 100%;
	font-size: 16px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.signup-btn:hover {
	background-color: #218838;
}

@media (max-width: 400px) {
	.form-container {
		width: 90%;
	}
}
</style>
</head>
<body>
	<div class="form-container">
		<form action="/SignIn/login" method="post">
			<c:if test="${alert != null }">
				<h3 class="alert">${alert}</h3>
			</c:if>
			<div class="img_container">
				<img src="" alt="Avatar" class="avatar">
			</div>
			<div class="container">
				<label for="username"><b>Username</b></label> 
				<input type="text" placeholder="Enter username" name="username">

				<label for="password"><b>Password</b></label> 
				<input type="password" placeholder="Enter password" name="password">

				<button type="submit">Log in</button>
				<label>
					<input type="checkbox" checked="checked" name="remember"> Remember me
				</label>
			</div>
			<div class="container" style="background-color: #f1f1f1">
				<button type="button" class="cancelbtn">Cancel</button>
				<span class="password">Forgot <a href="#">password</a></span>
			</div>
		</form>
		
		<!-- Sign up button inside the same container -->
		<div class="signup-container">
			<a href="${pageContext.request.contextPath}/register">
				<button type="button" class="signup-btn">Sign up</button>
			</a>
		</div>
	</div>
</body>
</html>
