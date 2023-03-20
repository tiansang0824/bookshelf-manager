<%--
  Created by IntelliJ IDEA.
  User: zht08
  Date: 2023/3/20
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addBook</title>
</head>
<body>
<h1>添加book</h1>

<form action="<%=request.getContextPath()%>/book/boundUser">
  <label>bookId: <input type="text" name="bookId"></label>
  <label>bookName: <input type="text" name="bookName"></label>
  <label>bookDes: <input type="text" name="bookAuthor"></label>
  <label>bookName: <input type="text" name="bookDescription"></label>
  <br>
  <label>userId: <input type="text" name="userId"></label>
  <label>userName: <input type="text" name="userName"></label>
  <input type="submit">
</form>
</body>
</html>
