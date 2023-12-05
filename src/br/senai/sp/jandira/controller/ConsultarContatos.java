package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Contato;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

public class ConsultarContatos implements HttpHandler {

    public void handle(HttpExchange exchange) throws IOException {
        ContatosController contatosController = new ContatosController();

        try {
            message = contatosController.consultarContatos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
