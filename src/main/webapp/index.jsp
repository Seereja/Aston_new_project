<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Index JSP</title>
</head>
<body>
<h1>Test</h1>
<p>
    <%
        java.util.Date now = new java.util.Date();
        String s = "Текущая дата: " + now;
    %>
    <%= s %>
</p

<br/>
<br/>

<a href="child">Many to many</a>

<br/>
<br/>

<a href="teacher">One to Many</a>

</body>
</html>