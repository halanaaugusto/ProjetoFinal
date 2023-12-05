package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Conexao;
import br.senai.sp.jandira.model.Contato;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContatosController {

    Conexao conexao = new Conexao();

    Connection connection = conexao.getConnection();

    public String consultarContatos() throws SQLException {
        Statement statement = connection.createStatement();
        String queryConsulta = "SELECT * FROM contatos";

        ResultSet resultSet = statement.executeQuery(queryConsulta);

        List<Contato> listContato = new ArrayList<>();

        while (resultSet.next()){
            Contato contato = new Contato();
            contato.setId(resultSet.getInt("id"));
            contato.setNome(resultSet.getString("nome"));
            contato.setEmail(resultSet.getString("email"));
            contato.setFoto(resultSet.getString("foto"));
            contato.setFavorito(resultSet.getBoolean("favorito"));
            contato.setTelefone(resultSet.getLong("telefone"));
            listContato.add(contato);
        }

        Gson gson = new Gson();
        String json = gson.toJson(listContato);
        return json;

    }

    public void pesquisarContato(){

    }

    public boolean deletarContato(String nomeContato){

        return false;
    }

    public void cadastrarContato(){

    }

}
