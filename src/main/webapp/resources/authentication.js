/**
 * Created by vorh on 4/17/17.
 */




function send() {

    var username = document.getElementById('username');
    var password = document.getElementById('password');
    alert(document.cookie);
    let url = '/login';
    alert(getCsrf());

    var data = new FormData();
    data.append('username', username.value);
    data.append('password', password.value);
    data.append('X-XSRF-TOKEN', getCsrf());

    var http = new XMLHttpRequest();
    http.open('GET', url);
    http.setRequestHeader('X-XSRF-TOKEN', getCsrf());
    http.send(data);


    let response = http.response;

    alert(response.value)

}
function getCsrf() {
    let cookie = document.cookie;
    return cookie.replace(/.*\w-.*=/,'');
}
