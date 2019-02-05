var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    } else {
        $("#conversation").hide();
    }
    $("#isPrimeField").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        $('#status-area').flash_message({
            text: 'WebSocket connected!',
            how: 'append'
        });
        stompClient.subscribe('/topic/responseField', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
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

function sendName() {

}

function showGreeting(message) {
    $("#responseField").append(message);
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#sendIsPrime").click(function () {
        stompClient.send("/app/isPrime", {}, JSON.stringify({'name': $("#name").val()}));
    });
    $("#sendIsPalindrome").click(function () {
        stompClient.send("/app/isPalindrome", {}, JSON.stringify({'name': $("#name").val()}));
    });
    $("#sendFibonaccisUnder").click(function () {
        stompClient.send("/app/fibonaccisUnder", {}, JSON.stringify({'name': $("#name").val()}));
    });
    $("#sendReverseNumber").click(function () {
        stompClient.send("/app/reverseNumber", {}, JSON.stringify({'name': $("#name").val()}));
    });
    $("#sendLargestPrimeFactor").click(function () {
        stompClient.send("/app/largestPrimeFactor", {}, JSON.stringify({'name': $("#name").val()}));
    });
    $("#euler1Button").click(function () {
        stompClient.send("/app/euler1Button", {}, JSON.stringify({'name': $("#name").val()}));
    });
    $("#euler2Button").click(function () {
        stompClient.send("/app/euler2Button", {}, JSON.stringify({'name': $("#name").val()}));
    });
    $("#euler3Button").click(function () {
        stompClient.send("/app/euler3Button", {}, JSON.stringify({'name': $("#name").val()}));
    });
    $("#euler4Button").click(function () {
        stompClient.send("/app/euler4Button", {}, JSON.stringify({'name': $("#name").val()}));
    });
});
