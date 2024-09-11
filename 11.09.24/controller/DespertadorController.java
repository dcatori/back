package controller;

import model.DespertadorModel;

public class DespertadorController {

    public static String[] verAcao(){
        return DespertadorModel.verDespertador();

    }

    public static String acaoDoDorminhoco(int respostaDoDorminhoco){
        String resposta;

        switch (respostaDoDorminhoco) {
            case 1:
                resposta = "Poha deixa eu dormir mais um pouco";
                break;
            case 2:
                resposta = "Caraca ja deu o horario dessa budega? Deixa acordar!!";
                break;    
            default:
                resposta = "Não tem essa opção neste despertador";
                break;

        }
        return resposta;
        
    }
    
}
