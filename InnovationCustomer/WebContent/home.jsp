<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>home</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<h1>Home 1</h1>
<%String testParam = request.getParameter("test"); %>
<input type="text" value="<%=testParam%>"/>
</body>
</html>