(function() {

    function getResponse(e) {
        e.preventDefault();

        var login = document.getElementsByName("login")[0].value;
        var pass = document.getElementsByName("password")[0].value;

        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200 ){
                document.getElementById("submitAlert").innerHTML=this.responseText;
            }else if (this.readyState == 4 && this.status == 302 ){
                window.location.replace(this.responseText);
            }


        };
        xhttp.open("POST", "/log", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("login="+login+"&password="+pass);


    }


    document.getElementById("login-form").addEventListener("submit", getResponse);
})();

