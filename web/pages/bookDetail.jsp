<%@ page import="org.tian.pojo.Book" %><%--
  Created by IntelliJ IDEA.
  User: zht08
  Date: 2023/3/20
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>bookDetail</title>
</head>
<body>
<h1>book详情</h1>
<hr>
<%
  Book book = (Book) request.getAttribute("book");
  out.println(book.toString());
%>

</body>
</html>
