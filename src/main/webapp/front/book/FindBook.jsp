<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
    <i class="header">Find User</i>
    <form action="BookServlet"
          method="GET"
          style="padding-bottom: 2rem;
          margin-top: 4rem;">
        <div class="input-group">
            <label for="bookName"></label>
            <input
                    type="text"
                    id="bookName"
                    name="bookName"
                    class="input-field"
                    placeholder="BookName">
        </div>

        <div class="input-group register">
            <button id="register">Register<i class="fa-solid fa-arrow-right"></i></button>
        </div>
    </form>
</div>

</body>
</html>
