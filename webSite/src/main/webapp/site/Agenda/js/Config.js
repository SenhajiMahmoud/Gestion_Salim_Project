function init() {
	 	
		scheduler.config.first_hour = 7;
		scheduler.config.last_hour = 23;
		var step = 30;
		var format = scheduler.date.date_to_str("%H:%i");
		
		scheduler.config.hour_size_px=(60/step)*22;
		scheduler.templates.hour_scale = function(date){
			html="";
			for (var i=0; i<60/step; i++){
				html+="<div style='height:22px;line-height:22px;'>"+format(date)+"</div>";
				date = scheduler.date.add(date,step,"minute");
			}
			return html;
		}
			scheduler.config.xml_date = "%Y-%m-%d %H:%i";
			scheduler.init('calendrier', new Date(), "week");
		//scheduler.load("data/events.xml");
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