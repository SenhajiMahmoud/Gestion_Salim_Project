	var events;

	function show_minical(){
		if (scheduler.isCalendarVisible())
			scheduler.destroyCalendar();
		else
			scheduler.renderCalendar({
				position:"dhx_minical_icon",
				date:scheduler._date,
				navigation:true,
				handler:function(date,calendar){
					scheduler.setCurrentView(date);
					scheduler.destroyCalendar()
				}
			});
	}
	 
	function LoadEvents() { 
		$.ajax({
			type:"GET",
			url: "http://localhost:8080/webSite/winwin/events/dd/1",
			}).then(
	    		function(events){
//	    			alert(events);
	    			scheduler.parse(events,"json");
	    	});
 
	}
	
//	scheduler.attachEvent("onDragEnd",function(eventId,event){
//		alert(event);
//	})
	
	