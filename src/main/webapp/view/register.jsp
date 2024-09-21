<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng Ký</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 400px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        .alert {
            color: red;
            text-align: center;
            margin-bottom: 15px;
        }
        input[type="text"], input[type="email"], input[type="password"], input[type="tel"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box; /* Đảm bảo kích thước bao gồm padding */
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #5cb85c;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px;
        }
        button:hover {
            background-color: #4cae4c;
        }
        .note {
            text-align: center;
            margin-top: 15px;
        }
    </style>
</head>
<body>
    <h1>Đăng Ký</h1>

    <c:if test="${not empty alert}">
        <div class="alert">${alert}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/register" method="post">
        <input type="text" name="fullname" placeholder="Họ và tên" required>
        <input type="text" name="username" placeholder="Tên đăng nhập" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="tel" name="phone" placeholder="Số điện thoại" required>
        <input type="password" name="password" placeholder="Mật khẩu" required>
        <input type="password" name="confirmPassword" placeholder="Nhập lại mật khẩu" required>
        <button type="submit">Đăng Ký</button>
    </form>

    <div class="note">
        Bạn đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
    </div>
</body>
</html>