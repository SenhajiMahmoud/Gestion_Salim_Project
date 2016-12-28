(function($){
	//ecrire un plugin
	$.fn.notif = function(options){
		
		var setting = { html : '<div class= "notification animated fadeInRight {{cls}}">\
				            <div class="left">\
				            <div class="icon">{{{icon}}}</div>\
				        </div>\
				        <div class="right">\
				            <h2>{{title}}</h2>\
				            <p>{{content}}</p>\
				        </div>\
				    </div>',
			timeout: false
				}
		
		var options = $.extend(setting, options)

		return this.each(function(){
			var $this = $(this);
			var $notif = $(Mustache.render(options.html, options));
			var $notifs = $('> .notifications', this);
			if($notifs.length == 0){
				$notifs = $('<div class="notifications animated flipInX" />');
				$this.prepend($notifs);
			}
			if(options.timeout){
				setTimeout(function(){
					$notif.trigger('click');
				}, options.timeout)
			}
			$notifs.append($notif);
			$notif.click(function(event){
				event.preventDefault();
				$notif.addClass('fadeOutLeft').delay(200).slideUp(300, function(){
					if($notif.siblings().length ==0){
						$notifs.remove();
					}
					$notif.remove();
				});
			})
		})
		
	}
	
	//$('.add').click(function(event){
		
		//event.preventDefault();
	//	$('body').notif({title:"monTitre", content:'monContenu', icon:'&#128276;', timeout:2000});

	//})
	
	
})(jQuery)