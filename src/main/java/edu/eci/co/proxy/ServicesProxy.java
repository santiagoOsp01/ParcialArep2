package edu.eci.co.proxy;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class ServicesProxy {

    private static final String[] servers = new String[]{"http://localhost:7654/lucas?v=", "http://localhost:7654/lucas?v="};



    public static void main(String... args){
        port(getPort());
        get("index", (req,res) -> getIndex());
        get("lucas", (req,res) -> getAns(req.queryParams("v")));
    }

    public static String getAns(String petition){
        HttpConnection.getValue("http://localhost:7654/lucas?v=" + petition);
    }

    public static String getIndex(){
        return """
                <!DOCTYPE html>
                <html>
                    <head>
                        <title>Parcial Arep</title>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    </head>
                    <body>
                        <h1>Form para la funcion get</h1>
                        <form action="/hello">
                            <label for="name">Name:</label><br>
                            <input type="text" id="name" name="name" value="John"><br><br>
                            <input type="button" value="Submit" onclick="loadGetMsg()">
                        </form>\s
                        <div id="getrespmsg"></div>
                                
                        <script>
                            function loadGetMsg() {
                                let nameVar = document.getElementById("name").value;
                                const xhttp = new XMLHttpRequest();
                                xhttp.onload = function() {
                                    document.getElementById("getrespmsg").innerHTML =
                                    this.responseText;
                                }
                                xhttp.open("GET", "/lucas?v="+nameVar);
                                xhttp.send();
                            }
                        </script>
                    </body>
                </html>""";
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
