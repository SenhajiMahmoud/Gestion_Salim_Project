		scheduler.config.first_hour = 8;
		scheduler.config.last_hour = 23;
//		scheduler.config.multi_day = true;
//		scheduler.config.touch = "force";
		
		var step = 30;
		var format = scheduler.date.date_to_str("%H:%i");
		
		scheduler.config.hour_size_px=(60/step) * 22;
		
		scheduler.templates.hour_scale = function(date)
		{
			var html="";
			for (var i=0; i<60/step; i++){
				html+="<div style='height:22px;line-height:22px;'>" + format(date)+"</div>";
				date = scheduler.date.add(date, step, "minute");
			}
			return html;
		}  
		
		scheduler.config.xml_date = "%Y-%m-%d %H:%i";
		scheduler.init('calendrier', new Date(), "week");
		LoadEvents();