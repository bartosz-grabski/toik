<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="accounts">Accounts Manager</a>
<div>
    <label>Message: </label><input type="text" id="msg" />
    <button onclick="sendMsg();">Send</button>
    <p id="response"></p>
</div>
<script type="text/javascript">
    var ws = new WebSocket('ws://localhost:8080/agh/websocket');
	
    ws.onopen = function() {
        alert('WebSocket connection established. Destination: '+ws.url)
    };
    	
    ws.onmessage = function(msg) {
        document.getElementById('response').innerHTML=msg.data;
    };

    function sendMsg() {
        ws.send(document.getElementById('msg').value);
    }
</script>
</body>
</html>
