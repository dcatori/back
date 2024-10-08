package model;

import java.sql.Connection;
import java.sql.ResultSet;

import view.TelaLoginView;
import view.CadastrarView;

public class CadastrarModel {

    cadJButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    try {
                        Connection conexao = MySQLConnector.conectar();
                        String strSqlPesquisarEmail = "select * from `" + db + "`.`" + tbl + "` where `email` = '" + emailCadastrarTextField.getText() + "';";
                        Statement stmSqlPesquisarEmail = conexao.createStatement();
                        ResultSet rstPesquisarEmail = stmSqlPesquisarEmail.executeQuery(strSqlPesquisarEmail);
                        if (rstPesquisarEmail.next()) {
                            notificacaoJLabel.setText("Ops! Parece que há um cadastro com esse email. Porfavor, verifique e tente novamente com outro email.");
                            stmSqlPesquisarEmail.close();
                        } else {
                            String strSqlCadastrarRegistro = "insert into `" + db + "`.`" + tbl + "` (`nome`,`email`,`senha`) values ('" + nomeCadastrarJTextField.getText() + "','" + emailCadastrarTextField.getText() + "','" + String.valueOf(senhaCadastrarPasswordField.getPassword()) +"');";
                            Statement stmSqlCadastrarRegistro = conexao.createStatement();
                            stmSqlCadastrarRegistro.addBatch(strSqlCadastrarRegistro);
                            stmSqlCadastrarRegistro.executeBatch();
                            stmSqlCadastrarRegistro.close();
                            notificacaoJLabel.setText("Cadastro realizado com sucesso!");
                            TelaLoginView.notificacaoJLabel.setText("Cadastro realizado com sucesso!");
                            TelaLoginView.telaLogin.setVisible(true);
                            dispose(); // fechar a própria tela, sem fechar a tela anterior
                        }
                    } catch (Exception e) {
                        notificacaoJLabel.setText("Não foi possível realizar o cadastro. Por favor, verifique e tente novamente.");
                    }
                }
    
}
