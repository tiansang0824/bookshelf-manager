<%@ page import="org.tian.pojo.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zht08
  Date: 2023/3/20
  Time: 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>bookSelection</title>
</head>
<body>
<h1>book目录</h1>
<hr>
<%
    List<Book> books = (List<Book>)request.getSession().getAttribute("books");

    for (Book b:
         books) {
        %>
    <%=b.toString()%>
<%--    <p>id: <%=b.getBookId()%></p>
    <p>name: <%=b.getBookName()%></p>
    <p>auth: <%=b.getBookAuthor()%></p>
    <p>des: <%=b.getBookDescription()%></p>--%>
<hr>
<%
    }
%>


</body>
</html>
