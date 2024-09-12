package view;
import controller.*;
import java.util.*;

public class DespertadorView {
    public static int horaDespertar;
    public static int minutoDespertar;
    public static int segundoDespertar;
    public static int adiar = 10; // minutos
    public static int[] adiamentos = {5, 10, 15};

    public static Date date = null;
    public static Calendar calendar = null;

    public static int horaAtual;
    public static int minutoAtual;
    public static int segundoAtual;

    public static String ANSI_RESET = "\u001B[0m";
    public static String ANSI_GREEN = "\u001B[32m";
    public static String ANSI_YELLOW = "\u001B[33m";
    public static String ANSI_CYAN = "\u001B[36m";
    public static String ANSI_WHITE = "\u001B[37m";
    public static String ANSI_BLUE = "\u001B[374";

    public static void main(String[] args) {
        boolean sair = false;

        Scanner scnDespertador = new Scanner(System.in);
        int respostaUsuario;
        Scanner scnConfigurar = new Scanner(System.in);

        DespertadorController.getHMS();

        System.out.println(
            String.format(
                "Agora são: %d:%d:%d.", 
                horaAtual, 
                minutoAtual, 
                segundoAtual
            )
        );

        System.out.println(ANSI_CYAN + "Digite abaixo a hora que você deseja configurar o despertador e tecle Enter:" + ANSI_RESET);
        horaDespertar = scnConfigurar.nextInt();

        System.out.println(ANSI_GREEN + "Digite abaixo o minuto que você deseja configurar o despertador e tecle Enter:" + ANSI_RESET);
        minutoDespertar = scnConfigurar.nextInt();

        System.out.println(ANSI_YELLOW + "Digite abaixo o segundo que você deseja configurar o despertador e tecle Enter:" + ANSI_RESET);
        segundoDespertar = scnConfigurar.nextInt();

        while (sair == false) {
            DespertadorController.getHMS();

            System.out.println(
                String.format(
                    ANSI_BLUE + " Agora são: %d:%d:%d. " + ANSI_RESET +  ANSI_BLUE + " O próximo alarme irá despertar às %d:%d:%d" + ANSI_RESET, 
                    horaAtual, 
                    minutoAtual, 
                    segundoAtual, 
                    horaDespertar, 
                    minutoDespertar, 
                    segundoDespertar
                )
            );

            if (
                horaAtual >= horaDespertar && 
                minutoAtual >= minutoDespertar && 
                segundoAtual >= segundoDespertar
            ) {
                System.out.println(ANSI_BLUE + " ACORDA DJANHO, DESPERTADOR ESTÁ TOCANDO!!" + ANSI_RESET);
                System.out.println(ANSI_BLUE + " OQ TU VAI FAZER?? " + ANSI_RESET);
                String[] opcoes = DespertadorController.verOpcoes();

                for (int c = 0; c < opcoes.length; c++) {
                    System.out.println(
                        String.format(
                            "[%d] >> %s", 
                            c + 1, 
                            opcoes[c]
                        )
                    );
                }

                respostaUsuario = scnDespertador.nextInt();
                System.out.println(DespertadorController.acaoDespertador(respostaUsuario));
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print("\033[H\033[2J");  
            System.out.flush();
        }

        scnDespertador.close();
        scnConfigurar.close();
    }
}