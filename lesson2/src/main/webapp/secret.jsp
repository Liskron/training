<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Secret Page</title>
</head>
<body>
<div>Main content</div>
<%=request.getAttribute("account")%>
</body>
</html>
