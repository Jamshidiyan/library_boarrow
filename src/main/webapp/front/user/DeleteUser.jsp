<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="back">
<head>
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
        <h2>Delete Some User</h2>
    </div>
    <form action="UserEditAndDeleteServlet"
          method="post"
          style="padding-top: 3rem;">
        <div class="input-group">
            <label for="userID"></label>
            <input type="number"
                   id="userID"
                   name="userID"
                   class="input-field"
                   placeholder="UserID">
        </div>
        <div class="input-group register">
            <button id="delete">Delete <i class="fa-solid fa-arrow-right"></i></button>
        </div>
    </form>
</div>
</body>
</html>
