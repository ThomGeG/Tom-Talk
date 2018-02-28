var stompClient = null;

function setConnected(connected) {

	//Toggle connect/disconnect buttons.
    $("#connect").prop("disabled", 		connected);
    $("#disconnect").prop("disabled", 	!connected);
    
    $("#send").prop("disabled", !connected);
	$("#message_body").prop("disabled",	!connected);

	if(connected) {
		$("#chat").show();
		$("#connection_status").html("Connected!")
    }
    else {
        $("#chat").hide();
        $("#connection_status").html("Disconnected!")
    }

    $("#greetings").html("");

}

function connect(destination) {

    var socket = new SockJS("/gs-guide-websocket");
    stompClient = Stomp.over(socket);
    
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe(destination, function (json) {
            appendMessageToChat(JSON.parse(json.body));
        });
    });

}

function disconnect() {

    if (stompClient !== null) {
        stompClient.disconnect();
    }

    setConnected(false);
    console.log("Disconnected");

}

function submit_message() {
    stompClient.send("/chat", {}, JSON.stringify({'body': $("#message_body").val()}));
    $("#message_body").val("");
}

function appendMessageToChat(message) {
	
	$("#chat_messages").append("<tr><td>" + message.body + "</td></tr>");
	
	//Scroll to the bottom of the chat history on message sent.
	$('#chat_container').scrollTop($('#chat_container').prop("scrollHeight"));

}

$(function () {

    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    
    $("#connect").click(function() 		{ connect("/ws/chat"); });
    $("#disconnect").click(function()	{ disconnect(); });
    $("#send").click(function() 		{ submit_message(); });
    
	//Redefine 'enter' keys behaviour in the textarea to submit the form rather than write a newline.
	//Shift + enter now performs that role as like many other chat apps.
	$("#message_body").keypress(function(e) {
		if(e.which == 13 && !e.shiftKey) { //keypressed == 'enter' && shift is not held down.
			submit_message();
			e.preventDefault();
		}
	});

});