package controller;
import java.util.*;
import model.*;
import view.*;

public class DespertadorController extends DespertadorView {
    public static String[] verOpcoes() {
        return DespertadorModel.mostrarOpcoes();
    }

    public static String acaoDespertador(int opcaoUsuario) {
        String resposta = "";
        Scanner scnAdiar = new Scanner(System.in);
        int respostaAdiar;
        switch (opcaoUsuario) {
            case 1:
                System.out.println(ANSI_GREEN + "Digite o número da opção abaixo e tecle Enter:" + ANSI_RESET);
                for (int a = 0; a < adiamentos.length; a++) {
                    System.out.println(
                        String.format(
                            ANSI_YELLOW + "[%d] >> adiar %d minutos" + ANSI_RESET, 
                            a + 1, 
                            adiamentos[a]
                        )
                    );
                }
                respostaAdiar = scnAdiar.nextInt();
                adiar = adiamentos[respostaAdiar - 1];

                resposta = ANSI_BLUE + "Ok! Alarme adiado em: " + adiar + " minutos." + ANSI_RESET;
                minutoDespertar += adiar;
                if (minutoDespertar > 59) {
                    minutoDespertar = 59;
                }
                break;

            case 2:
                System.out.println(ANSI_CYAN + "Ok! Alarme parado." + ANSI_RESET);
                System.exit(0);
                break;

            default:
                resposta = ANSI_WHITE + "Opção inválida." + ANSI_RESET;
                break;
        }
        scnAdiar.close();
        return resposta;
    }

    public static void getHMS() {
        date = new Date();
        calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        horaAtual = calendar.get(Calendar.HOUR_OF_DAY);
        minutoAtual = calendar.get(Calendar.MINUTE);
        segundoAtual = calendar.get(Calendar.SECOND);
    }
}
