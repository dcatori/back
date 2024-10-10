package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.MySQLConnector;
import view.TelaLoginView;

public class LogarController {

    public static void logar() {
        String login = TelaLoginView.txtLogin.getText();
        String senha = String.valueOf(TelaLoginView.txtSenha.getPassword());

        String query = "SELECT * FROM tbl_teste WHERE email = ? AND senha = ?";

        try (Connection conexao = MySQLConnector.conectar(); PreparedStatement pstmt = conexao.prepareStatement(query)) {

            pstmt.setString(1, login);
            pstmt.setString(2, senha); // Ensure that senha is hashed before this step
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Login bem-sucedido
                TelaLoginView.notificacaoJLabel.setText("Login realizado com sucesso!");
                // Aqui você pode abrir a tela principal
            } else {
                // Login falhou
                TelaLoginView.notificacaoJLabel.setText("Login falhou! Verifique suas credenciais.");
            }
        } catch (SQLException e) {
            TelaLoginView.notificacaoJLabel.setText("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
