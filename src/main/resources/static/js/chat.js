var stompClient = null;

function setConnected(isConnected) {
    
    $("#send_btn").prop("disabled", 	!isConnected);
	$("#message_body").prop("disabled",	!isConnected);

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

    if(stompClient !== null) {
        stompClient.disconnect();
    }

    setConnected(false);
    console.log("Disconnected");

}

function submit_message() {
    stompClient.send("/app/chat", {}, JSON.stringify({'body': $("#message_body").val()})); //Transmit contents of field.
    $("#message_body").val("");	//Blank field after.
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
    
    $("#send_btn").click(function() 		{ submit_message(); });
    
	//Redefine 'enter' keys behaviour in the textarea to submit the form rather than write a newline.
	//Shift + enter now performs that role as like many other chat apps.
	$("#message_body").keypress(function(e) {
		if(e.which == 13 && !e.shiftKey) { //keypressed == 'enter' && shift is not held down.
			e.preventDefault();
			submit_message();
		}
	});

});