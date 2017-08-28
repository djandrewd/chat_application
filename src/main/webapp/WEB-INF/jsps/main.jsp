<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat application</title>
    <link type="text/css" href="styles.css" rel="stylesheet">
</head>
<body>
<p>Chat window</p>
<div id="wrapper">
    <var id="name" hidden>public</var>
    <div id="chatbox">
        <table id="messages">
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
            row.append($("<td>").append($("<b>").text(user)));
            row.append($("<td>").text(text));

            $("#messages").append(row);
        };

        $('#submitmsg').click(function () {
            let input = $('#usermsg');
            let chat = $('#name').text();
            let message = input.val();
            ws.send(JSON.stringify({
                'chat': chat,
                'message': message
            }));
            input.val('');
            return false;
        })
    })
</script>

</body>
</html>
