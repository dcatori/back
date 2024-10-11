package model;

import controller.InterfaceController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginModel {

    public static boolean loginUsuario(String login, String senha) {
        try {
            Connection conexao = MySQLConnectorModel.conectar();
            String strSqlLogin = "select * from `" + InterfaceController.dbPadrao + "`.`" + InterfaceController.tblPadrao + "`" + " where `email` = '" + login + "' and `senha` = '" + senha + "';";
            Statement stmSqlLogin = conexao.createStatement();
            ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
            if (rstSqlLogin.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }

    }
}
