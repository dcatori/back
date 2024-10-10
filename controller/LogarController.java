package controller;

public class LogarController {

    public static boolean logar(String username, char[] password) {
        // Implementar lógica de validação
        // Aqui você deve implementar a lógica de autenticação (exemplo simples)
        if (username.equals("admin") && new String(password).equals("senha")) {
            return true; // Retorna verdadeiro se o login for bem-sucedido
        }
        return false; // Retorna falso caso contrário
    }
}
