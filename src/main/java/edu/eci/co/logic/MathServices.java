package edu.eci.co.logic;

import org.eclipse.jetty.util.ajax.JSON;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class MathServices {

    public static void main(String... args){
        port(getPort());
        get("lucas", (req,res) -> getResponse(Integer.parseInt(req.queryParams("v"))));
    }

    public static String getResponse(int v){
        JSON resp = new JSON();
        String val = String.valueOf(v);
        String series = getString(v);
        String str = "{" +
                 "operation: " + "Secuencia de Lucas,"+
                 "input: " + val +"," +
                 "output: " + series +
                "}";
        return str;
    }

    public static String getString(int v){
        StringBuilder str = new StringBuilder();
        for (int x = v;x >= 0; x--){
            str.append(String.valueOf(getSecuence(x)) + ",");
        }
        return str.toString();
    }

    public static int getSecuence(int val){
        if (val == 0){
            return 2;
        }if (val == 1){
            return 1;
        }
        return getSecuence(val - 2) + getSecuence(val - 1);
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 7654;
    }
}
