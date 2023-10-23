<%--
  Created by IntelliJ IDEA.
  User: Mahdi
  Date: 10/21/2023
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="back"
      lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Library</title>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <meta name="description" content="Register user using Servlet"/>
    <link rel="stylesheet" type="text/css" href="../../resources/style/add-user-styles.css"/>
    <link rel="stylesheet" href="../../resources/style/main.css"/>
</head>
<body>
<img class="background"
     src="../../resources/image/library.jpg"
     alt="library">
<div class="add-card">
    <div class="heading">
        <h2>User Info</h2>
    </div>
    <form action="UserEditAndDeleteServlet" method="Get">
        <div class="input-group">
            <label for="userid"></label>
            <input type="number"
                   id="userid"
                   name="userID"
                   class="input-field"
                   placeholder="UserID">
        </div>
        <div class="input-group">
            <label for="username"></label>
            <input type="text"
                   id="username"
                   name="userName"
                   class="input-field"
                   placeholder="UserName">
        </div>

        <div class="input-group">
            <label>
                <input type="number"
                       max="120"
                       name="userAge"
                       class="input-field"
                       placeholder="Age">
            </label>
        </div>

        <div class="input-group register">
            <button id="register">Update <i class="fa-solid fa-arrow-right"></i></button>
        </div>
    </form>
</div>

<footer>
    Created With ❤️ by <a href="https://instagram.com/_bh.oopendra" target="_black">Mahdi</a>
</footer>

</body>
</html>
