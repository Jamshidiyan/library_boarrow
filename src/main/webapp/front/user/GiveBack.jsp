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
        <h2>GiveBack some Book</h2>
    </div>
    <form action="BookServlet"
          method="PUT"
          style="padding-top: 3rem;">
        <div class="input-group">
            <label for="bookName"></label>
            <input type="text"
                   id="bookName"
                   name="bookName"
                   class="input-field"
                   placeholder="BookName">
        </div>
        <div class="input-group register">
            <button id="register">Update <i class="fa-solid fa-arrow-right"></i></button>
        </div>
    </form>
</div>

</body>
</html>
