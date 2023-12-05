package br.senai.sp.jandira.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class CadastrarContatos implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        String message = "O servidor esta no arrr ...";

        exchange.sendResponseHeaders(200, message.length());
        OutputStream out = exchange.getResponseBody();

        try {
            out.write(message.getBytes());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            out.close();
        }

    }
}
