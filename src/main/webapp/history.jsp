<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 20.01.2017
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="main.java.LinearCalculator" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
    <title>История вычислений</title>
</head>
<body>
<input type="button" onclick="parent.location='index.jsp'" value="Назад">
<%
    ResultSet results = LinearCalculator.getInstance().selectFromResults();
    while(results.next()) { %>
<p><%= results.getString("RESULT") %></p>
<%  }
%>
</body>
</html>
