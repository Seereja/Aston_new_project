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

<a href="child">ChildController</a>

<br/>
<br/>

<a href="section">SectionController</a>

</body>
</html>