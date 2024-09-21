<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Home Page</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        h1 {
            margin-bottom: 30px;
            font-size: 2.5em;
            color: #007BFF;
        }
        button {
            padding: 12px 24px;
            font-size: 18px;
            cursor: pointer;
            border: none;
            border-radius: 5px;
            background-color: #007BFF;
            color: white;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #0056b3;
        }
        @media (max-width: 600px) {
            h1 {
                font-size: 2em;
            }
            button {
                font-size: 16px;
                padding: 10px 20px;
            }
        }
    </style>
</head>
<body>
    <h1>Welcome to Your Home Page</h1>
    <form action="home/logout" method="post">
        <button type="submit">Log Out</button>
    </form>
</body>
</html>