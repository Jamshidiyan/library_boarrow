<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html class="back">
<head>
    <title>Library</title>
    <link rel="stylesheet" href="../../resources/style/main.css"/>
</head>
<body>
<img class="background"
     src="../../resources/image/library.jpg"
     alt="library">
<div class="card">
    <i class="header">User Page</i>
    <div class="button-container-row">
        <a class="button-row-user"
           href="AddUser.jsp">
            <img class="image-row"
                 src="../../resources/image/add.png"
                 alt="add">
            <i class="text">Add</i>
        </a>
        <a class="button-row-user"
           href="DeleteUser.jsp">
            <img class="image-row"
                 src="../../resources/image/delete.png"
                 alt="delete">
            <i class="text">Delete</i>
        </a>
        <a class="button-row-user"
           href="FindUser.jsp">
            <img class="image-row"
                 src="../../resources/image/search.png"
                 alt="search">
            <i class="text">Find</i>
        </a>
        <a class="button-row-user"
           href="EditUser.jsp">
            <img class="image-row"
                 src="../../resources/image/update.png"
                 alt="update">
            <i class="text">Update</i>
        </a>
        <a class="button-row-user"
           href="Borrow.jsp">
            <img class="image-row"
                 src="../../resources/image/borrow.png"
                 alt="borrow">
            <i class="text">Borrow</i>
        </a>
        <a class="button-row-user"
           href="GiveBack.jsp">
            <img class="image-row"
                 src="../../resources/image/borrow.png"
                 alt="give-back"
                 style="rotate: 180deg;">
            <i class="text">Give Back</i>
        </a>
    </div>
</div>
</body>
</html>
