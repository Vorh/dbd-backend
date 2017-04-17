/**
 * Created by vorh on 4/17/17.
 */




function send() {

    var username = document.getElementById("username");
    var password = document.getElementById("password");

    let url = "/verification?" +
        "username=" + username.value + "&" +
        "password=" + password.value;
    alert(url);

    var http = new XMLHttpRequest();
    http.open("GET", url, true);
    http.send();

    let response = http.response;

    alert(response.value)

}
