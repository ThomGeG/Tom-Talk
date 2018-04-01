$.ajaxSetup({
	beforeSend : function(xhr, settings) {
		if(settings.type == "POST" || settings.type == "PUT" || settings.type == "DELETE") {
			if(!(/^http:.*/.test(settings.url) || /^https:.*/.test(settings.url))) {
				// Only send the token to relative URLs i.e. locally.
				xhr.setRequestHeader("X-XSRF-TOKEN", Cookies.get('XSRF-TOKEN'));
			}
		}
	}
});
	
$.get("/user", function(user) {
	
	//Update app information
	$("#user").html(user.name);
	$(".unauthenticated").hide();
	$(".authenticated").show();
	
	//Log into live-chat.
	connect("/topic/chat");
	
});

var logout = function() {

	//Logout of the application.
	$.post("/logout", function() {
		$("#user").html("");
		$(".unauthenticated").show();
		$(".authenticated").hide();
	});
	
	//Logout of/Disconnect from the live-chat.
	disconnect();
	
	return true;
	
}