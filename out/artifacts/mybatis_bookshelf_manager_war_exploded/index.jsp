<%--
  Created by IntelliJ IDEA.
  User: zht08
  Date: 2023/3/20
  Time: 7:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h1>功能选项</h1>
<table>
    <tr>
        <th>序号</th>
        <th>所属模块</th>
        <th>功能</th>
    </tr>
    <tr>
        <td>01</td>
        <td>book</td>
        <td><a href="${pageContext.request.contextPath}/book/selectAllBooks">查看全部book</a></td>
    </tr>
    <tr>
        <td>02</td>
        <td>book</td>
        <td><a href="javascript:void(0)" id="sleOneBook">查询book</a></td>
        <script>
            document.getElementById("sleOneBook").addEventListener("click", function(event) {
                event.preventDefault(); // 防止超链接默认跳转行为
                var num = prompt("请输入数值："); // 弹出输入框
                if (num !== null) { // 如果用户点击了确定
                    window.location.href = "<%=request.getContextPath()%>/book/selectOne?id=" + encodeURIComponent(num); // 跳转到带参数的URL
                }
            });
        </script>
    </tr>
    <tr>
        <td>03</td>
        <td>book</td>
        <td><a href="./pages/bookAdd.jsp">添加book</a></td>
    </tr>
<%--    <tr>
        <td>04</td>
        <td>book</td>
        <td><a href="javascript:void(0)" id="delBook">删除book</a></td>
        <script>
            document.getElementById("delBook").addEventListener("click", function(event) {
                event.preventDefault(); // 防止超链接默认跳转行为
                var num = prompt("请输入数值："); // 弹出输入框
                if (num !== null) { // 如果用户点击了确定
                    window.location.href = "<%=request.getContextPath()%>/book/delBook?delId=" + encodeURIComponent(num); // 跳转到带参数的URL
                }
            });
        </script>
    </tr>--%>
    <tr>
        <td>05</td>
        <td>book</td>
        <td><a href="./pages/bookEdit.jsp">修改</a></td>
    </tr>
    <tr>
        <td>06</td>
        <td>book</td>
        <td><a href="">绑定使用人</a></td>
    </tr>
    <tr>
        <td>07</td>
        <td>user</td>
        <td><a href="">查询使用者</a></td>
    </tr>
    <tr>
        <td>08</td>
        <td>user</td>
        <td><a href="">修改user信息</a></td>
    </tr>
    <tr>
        <td>09</td>
        <td>user</td>
        <td><a href="">添加user</a></td>
    </tr>
    <tr>
        <td>10</td>
        <td>user</td>
        <td><a href="">修改user</a></td>
    </tr>
</table>
</body>
</html>
