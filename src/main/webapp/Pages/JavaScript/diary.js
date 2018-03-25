(function() {

    function getResponse(e) {
        e.preventDefault();


        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200 ){
                document.getElementById("submitAlert").innerText=this.responseText;
            }else if (this.readyState == 4 && this.status == 302 ){
                window.location.replace(this.responseText);
            }


        };
        xhttp.open("POST", "/log", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send();


    }


    document.getElementById("login-form").addEventListener("submit", getResponse);
})();

