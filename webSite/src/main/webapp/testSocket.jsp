<!DOCTYPE html>
<html>
<head>
    <title>PizzNotification</title>
    <link rel="stylesheet" href="site/Notification/css/animate.css" />
	<link rel="stylesheet" href="site/Notification/css/style.css" />
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.0.3/sockjs.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    
    <script type="text/javascript">
        var stompClient = null;

        function connect() {
        	
            var socket = new SockJS('http://localhost:8080/web-site/hello.h');
            stompClient = Stomp.over(socket);
           
            stompClient.connect({}, function(frame){
            	stompClient.subscribe('/topic/notification', function(Notiff) {
            		affiche(JSON.parse(Notiff.body).content);
				});
            });
        }
        
        function affiche(Notification){
        	var s =Notification.split(',');

        	$('.notiff').notif({title: s[0], content:s[1], icon:'&#128276;', timeout:2000});
        	
        }

        function disconnect() {
        	if(stompClient != null){
        		stompClient.disconnect();	
        	}
            console.log("Disconnected");
        }

      function sendMessage(){
    	   stompClient.send('/app/hello',{}, JSON.stringify({ 'name': 'Mahmoud', 'message': 'sen' }));
       }
      
    </script>
</head>
<body onload="disconnect();" > 
        <button id="connect" onclick="connect();">Connect</button>
        <button id="send" onclick="sendMessage();">Send</button>
        <button id="disconnect" onclick="disconnect();">Disconnect</button>
        
        <div class="notiff" ></div>
        
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        
		<script src="site/Notification/js/mustache.js"></script>
		<script src="site/Notification/js/notif.js"></script>
</body>
</html>