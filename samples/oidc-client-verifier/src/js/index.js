import {client} from "./app.js";

function login() {
    client.createSigninRequest({}).then(function (req) {
        console.log("signin request", req, "<a href='" + req.url + "'>go signin</a>");
        window.location = req.url;
    }).catch(function (err) {
        console.error(err);
    });
}

document.getElementById("login").addEventListener("click", login);