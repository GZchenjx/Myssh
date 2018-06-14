<%--
  Created by IntelliJ IDEA.
  User: CHEN JX
  Date: 2017/12/6
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=path %>/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path %>/assets/css/bootstrap-table.css">
</head>
<body>
<table data-toggle="table" data-url="<%=path %>/teacher/pager_criteria1?limit=1&offset=4">
    <thead>
    <tr>
        <th data-field="id">ID</th>
        <th data-field="name">名称</th>
        <th data-field="phone">手机号</th>
    </tr>
    </thead>
</table>
</body>
<script src="<%=path %>/assets/js/jquery.min.js"></script>
<script src="<%=path %>/assets/js/bootstrap.min.js"></script>
<script src="<%=path %>/assets/js/bootstrap-table.js"></script>
<script src="<%=path %>/assets/js/bootstrap-table-zh-CN.js"></script>

</html>
