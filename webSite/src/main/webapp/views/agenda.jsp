<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<title>Agenda</title>

<link rel="stylesheet" href="site/Agenda/css/dhtmlxscheduler.css" type="text/css" media="screen" title="no title" charset="utf-8">
<script src="site/Agenda/js/dhtmlxscheduler.js" type="text/javascript" charset="utf-8"></script>

<script src="site/Agenda/js/dhtmlxscheduler_limit.js" type="text/javascript" charset="utf-8"></script>
<script src="site/Agenda/js/dhtmlxscheduler_minical.js" type="text/javascript" charset="utf-8"></script>
<script src="site/Agenda/js/locale_fr.js" charset="utf-8"></script>
<link rel="stylesheet" href="site/Agenda/css/style.css" type="text/css" media="screen" />
<script src="site/Agenda/js/jquerymin.js" type="text/javascript"></script>
</head>

<body onload="init();">
	<div id="calendrier" class="dhx_cal_container" style='width: 100%; height: 100%;'>
		<div class="dhx_cal_navline">
		
		    <div class="dhx_cal_prev_button">&nbsp;</div>
			<div class="dhx_cal_next_button">&nbsp;</div>
			<!-- <div class="dhx_cal_today_button"></div>  --> 
			
			<div class="dhx_cal_date"></div>
			
			<div class="dhx_minical_icon" id="dhx_minical_icon" onclick="show_minical()">&nbsp;</div>
			
			<!-- <div class="dhx_cal_tab" name="workweek_tab" style="right:280px;"></div>
			<div class="dhx_cal_tab" name="decade_tab" style="right:345px;"></div>
			<div class="dhx_cal_tab" name="day_tab" style="right: 204px;"></div>
			<div class="dhx_cal_tab" name="week_tab" style="right: 140px;"></div>
			<div class="dhx_cal_tab" name="month_tab" style="right: 76px;"></div>   -->
			
		</div>
		<div class="dhx_cal_header"></div>
		<div class="dhx_cal_data"></div>
	</div>
	
</body>
<script src="site/Agenda/js/Config.js" type="text/javascript" charset="utf-8"></script>
</html>