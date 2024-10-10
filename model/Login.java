package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

    private String email;
    private String senha;

    public Login(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public boolean login() {
        Connection conn = MySQLConnector.conectar();
        String query = "SELECT * FROM tbl_teste WHERE email = ? AND senha = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, this.email);
            stmt.setString(2, this.senha);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Retorna true se houver um usuário correspondente

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
