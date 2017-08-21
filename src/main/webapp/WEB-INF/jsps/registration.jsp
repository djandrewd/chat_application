<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register new user</title>
</head>
<body>
    <form method="post" action="/register">
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
        <label>
            Group
            <select name="group" id="group">
            </select>
        </label>
        <div>
            <input type="hidden"
                   name="${_crsf.parameterName}"
                   value="${_csrf.token}"/>
            <input type="submit" value="Register">
        </div>

    </form>
</body>
</html>
