<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Register new user</title>
</head>
<body>
<form method="post" action="register" id="register-form">
    <div>
        <label>Login</label>
        <input type="text" id="login" name="login"/>
    </div>
    <div>
        <label>Username</label>
        <input type="text" id="username" name="username"/>
    </div>
    <div>
        <label>Password</label>
        <input type="password" id="password" name="password"/>
    </div>
    <div>
        <label>Group</label>
        <s:checkboxes path="groups" items="${groups}"/>
    </div>
    <div>
        <input type="submit" value="Register">
    </div>
</form>
</body>
</html>
