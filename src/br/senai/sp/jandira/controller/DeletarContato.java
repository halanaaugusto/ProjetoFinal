package br.senai.sp.jandira.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

public class DeletarContato implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        ContatosController contatosController = new ContatosController();

        // Obtém o nome do contato a ser excluído da URL
        String path = exchange.getRequestURI().getPath();
        String nomeContato = extractNomeContato(path);

        String mensagemDeletarContato = "";

        // Chama o método para deletar o contato no banco de dados
        boolean contatoDeletado = contatosController.deletarContato(nomeContato);

        // Prepara a mensagem de resposta
        if (contatoDeletado) {
            mensagemDeletarContato = "Contato deletado com sucesso";
        } else {
            mensagemDeletarContato = "Contato não encontrado";
        }

        // Configura a resposta HTTP
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        exchange.sendResponseHeaders(200, mensagemDeletarContato.length());
        OutputStream out = exchange.getResponseBody();

        try {
            out.write(mensagemDeletarContato.getBytes());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            out.close();
        }
    }

    private String extractNomeContato(String path) {
        // Obtém o nome do contato a partir da URL
        String[] parts = path.split("/");
        return parts[parts.length - 1];
    }
}
