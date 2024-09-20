package controller;
import java.util.*;
import model.*;
import view.*;

public class DespertadorController extends DespertadorView {
    public static String[] verOpcoes() {
        return DespertadorModel.mostrarOpcoes();
    }

    public static void acaoDespertador(int opcaoUsuario) {
        if (adiamentoAtual < 3) {
            switch (opcaoUsuario) {
                case 1:
                    if (mostrarOpcoesAdiamentos()) {
                        if ((minutoAtual + adiar) > 59) {
                            horaDespertar++;
                            if (horaDespertar > 23) {
                                horaDespertar = 0;
                            }
                            minutoDespertar = (minutoAtual + adiar) - 59;
                        } else {
                            minutoDespertar = minutoAtual + adiar;
                        }
                        adiamentoAtual++;
                        exibirAlarmeAdiado(adiar);
                    } else {
                        break;
                    }
                    break;

                case 2:
                    sairDoSistema();
                    break;

                default:
                    mostrarOpcaoInvalida();
                    break;
            }
        } else {
            sairDoSistema();
        }
    }
    

    public static String horaFaltante(int horaAtual, int minutoAtual, int segundoAtual, int horaDespertar, int minutoDespertar) {
        
        int tempoAtual = 0;
        tempoAtual += (segundoAtual);
        tempoAtual += (minutoAtual * 60);
        tempoAtual += (horaAtual * 3600);
        
        int tempoDespertar = 0;
        tempoDespertar += (minutoDespertar * 60);
        tempoDespertar += (horaDespertar * 3600);

        tempoDespertar -= tempoAtual;
        
        int horaFalta = Math.floorDiv(tempoDespertar, 3600);
        tempoDespertar -= (horaFalta * 3600);
        int minutoFalta = Math.floorDiv(tempoDespertar, 60);
        tempoDespertar -= (minutoFalta * 60);
        int segundoFalta = tempoDespertar;

        return String.format("%02d:%02d:%02d", horaFalta, minutoFalta, segundoFalta);
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