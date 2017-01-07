var events;
function init() {
	events =[
                 { start_date:"2016-12-26 9:00", end_date:"2016-12-26 12:00", text:"Prefecture Sarcelles"},
                 { start_date:"2016-12-26 14:00", end_date:"2016-12-26 16:00", text:"Leclerc"},
                 { start_date:"2016-12-27 9:00", end_date:"2016-12-27 12:00", text:"Prefecture Sarcelles"},
                 { start_date:"2016-12-27 14:00", end_date:"2016-12-27 23:00", text:"PDS_Notification"},
                 
            ];
		scheduler.config.first_hour = 8;
		scheduler.config.last_hour = 23;
		
		 
		 var step = 30;
		var format = scheduler.date.date_to_str("%H:%i");
		
		scheduler.config.hour_size_px=(60/step)*22;
		
		scheduler.templates.hour_scale = function(date){
			var html="";
			for (var i=0; i<60/step; i++){
				html+="<div style='height:22px;line-height:22px;'>"+format(date)+"</div>";
				date = scheduler.date.add(date,step,"minute");
			}
			return html;
		}  
		
		 
		
		scheduler.config.xml_date = "%Y-%m-%d %H:%i";
		scheduler.init('calendrier', new Date(), "week");
		LoadEvents();
}
	
	
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
        url : "http://localhost:8080/webSite/dd",
        success : function(){
        	scheduler.parse(events, "json");
        	}
    	});
	}
	
	