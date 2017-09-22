 var stompClient = null;

function connect() {
		var socket = new SockJS('http://localhost:90/webSite/winwin/hello');
	    	stompClient = Stomp.over(socket);
	           
	        stompClient.connect({}, function(frame){
	        stompClient.subscribe('/topic/notification', function(Notiff) {
	        	console.log(Notiff);
	            		affiche(JSON.parse(Notiff.body).content);
					});	
	            });
	        }
	        
function affiche(Notification){
		var s =Notification.split(',');

	    $('.notiff').notif({title: s[0], content:s[1], icon:'&#128276;', timeout:2000});
	        	
	        }
        