package model;

import java.sql.Connection;
import java.sql.Statement;

public class CriarBancoDadosModel {

    public static void main(String[] args) {
        Connection conexao = null;
        Statement stmSqlCriarBancoDeDados = null;

        try {
            // Tenta conectar ao banco de dados
            conexao = MySQLConnector.conectar();
            if (conexao != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            } else {
                System.out.println("Falha ao conectar ao banco de dados.");
                return; // Sai se a conexão falhar
            }

            String strSqlCriarBancoDeDados = "CREATE DATABASE IF NOT EXISTS `db_teste`;";

            stmSqlCriarBancoDeDados = conexao.createStatement();
            stmSqlCriarBancoDeDados.executeUpdate(strSqlCriarBancoDeDados);

            System.out.println("Banco de dados criado com sucesso!");
        } catch (Exception e) {
            System.out.println("Ops! Ocorreu o erro: " + e);
        } finally {
            // Fechar recursos
            try {
                if (stmSqlCriarBancoDeDados != null) {
                    stmSqlCriarBancoDeDados.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao fechar recursos: " + e);
            }
        }
    }
}
