package edu.eci.co.proxy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class ServicesProxy {

    private static final String[] servers = new String[]{"http://ec2-3-89-207-251.compute-1.amazonaws.com:7654/lucas?v=", "http://ec2-52-54-107-167.compute-1.amazonaws.com:7654/lucas?v="};
    private static int currentServer = 0;



    public static void main(String... args){
        port(getPort());
        get("index", (req,res) -> getIndex());
        get("lucas", (req,res) -> getAns(req.queryParams("v")));
    }

    public static int getServer(){
        if (currentServer == 1){
            currentServer = 0;
            return currentServer;
        }
        currentServer = 1;
        return currentServer;
    }

    public static String getAns(String petition){
        try {
            System.out.println(servers[getServer()]);
            return HttpConnection.getValue(servers[getServer()] + petition);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
                        <h1>Form para la funcion lucas</h1>
                        <form action="/hello">
                            <label for="name">valor:</label><br>
                            <input type="text" id="name" name="name" value=""><br><br>
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
