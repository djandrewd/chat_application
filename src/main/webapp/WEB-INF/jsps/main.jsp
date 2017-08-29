<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chat application</title>
    <link type="text/css" href="styles.css" rel="stylesheet">
</head>
<body>
<p>Chat window</p>
<div id="wrapper">
    <div id="chatbox">
        <table id="messages">
            <c:forEach var="message" items="${messages}">
                <tr>
                    <td hidden>${message.id}</td>
                    <td><b>${message.user}</b></td>
                    <td>${message.text}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <form name="message" action="" method="post" id="message">
        <input name="usermsg" type="text" id="usermsg" size="63"/>
        <input name="submitmsg" type="submit" id="submitmsg" value="Send"/>
    </form>
</div>

<script type="text/javascript"
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        const ws = new WebSocket("ws://localhost:8080/chat");
        ws.onmessage = function (event) {
            let message = JSON.parse(event.data);
            let text = message.text;
            let user = message.user;
            let id = message.id;

            let row = $("<tr>");
            row.append($("<td>").attr('hidden', 'true').text(id));
            row.append($("<td>").append($("<b>").text(user)));
            row.append($("<td>").text(text));

            $("#messages").append(row);
        };

        $('#submitmsg').click(function () {
            let input = $('#usermsg');
            let chat = '${chat}';
            let message = input.val();
            ws.send(JSON.stringify({
                'chat': chat,
                'text': message
            }));
            input.val('');
            return false;
        })
    })
</script>

</body>
</html>
