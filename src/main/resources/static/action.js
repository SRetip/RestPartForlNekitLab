function registr() {
    let login = document.getElementById("log").value;
    let password = document.getElementById("pw").value;


    var json = new XMLHttpRequest();
    var url = "http://localhost:8080/kazinich/register";
    json.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var user = JSON.parse(this.responseText);
            sessionStorage.setItem('id', user.id);
            sessionStorage.setItem('balance', user.balance);
            sessionStorage.setItem('login', user.login);
        }
    };
    json.open("POST", url);
    json.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    json.send(JSON.stringify({"login": login, "password": password}));

}


function jopa() {
    window.location.href = "index.html";
}

function login() {
    // let login = document.getElementById("log").value;DOTO
    // let password = document.getElementById("pw").value;DOTO


    var json = new XMLHttpRequest();
    var url = "http://localhost:8080/kazinich/login";
    json.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var user = JSON.parse(this.responseText);
            sessionStorage.setItem('id', user.id);
            sessionStorage.setItem('balance', user.balance);
            sessionStorage.setItem('login', user.login);
        }
    };
    json.open("POST", url);
    json.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    json.send(JSON.stringify({"login": login, "password": password}));
}

function increaceBalance(count) {
    var json = new XMLHttpRequest();
    var url = "http://localhost:8080/kazinich/increaseBalance";
    json.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var user = JSON.parse(this.responseText);
            sessionStorage.setItem('id', user.id);
            sessionStorage.setItem('balance', user.balance);
            sessionStorage.setItem('login', user.login);
        }
    };
    json.open("POST", url);
    json.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    json.send(JSON.stringify({
        "login": sessionStorage.getItem("login"),
        "balance": sessionStorage.getItem("balance"),
        "count": count
    }));
}

function decreaceBalance(count) {
    var json = new XMLHttpRequest();
    var url = "http://localhost:8080/kazinich/decreaseBalance";
    json.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var user = JSON.parse(this.responseText);
            sessionStorage.setItem('id', user.id);
            sessionStorage.setItem('balance', user.balance);
            sessionStorage.setItem('login', user.login);
        }
    };
    json.open("POST", url);
    json.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    json.send(JSON.stringify({
        "login": sessionStorage.getItem("login"),
        "balance": sessionStorage.getItem("balance"),
        "count": count
    }));
}