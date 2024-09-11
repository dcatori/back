package view;
import controller.DespertadorController;
import java.util.*;




public class DespertadorView {

    private static int acaoDoLouco;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int horaAtual;
        int minutoAtual;
        int segundoAtual;

        int horaDespertar = 15;
        int minutoDespertar = 11;
        int segundoDespertar = 0;

        Timer timer = new Timer();

        Date date = null;
        Calendar calendar = null;
        boolean sair = false;
        int adiar = 10; // segundos

        

        while (sair == false) {
            date = new Date();
            calendar = GregorianCalendar.getInstance();
            calendar.setTime(date);
            horaAtual = calendar.get(Calendar.HOUR_OF_DAY);
            minutoAtual = calendar.get(Calendar.MINUTE);
            segundoAtual = calendar.get(Calendar.SECOND);

            if (horaAtual >= horaDespertar && minutoAtual >= minutoDespertar && segundoAtual >= segundoDespertar) {
                System.out.println("DESPERTADOR TOCANDO DEMONHO!! O QUE VAI FAZER??");

            }
            System.out.println(String.format("Agora são: %d:%d:%d", horaAtual, minutoAtual, segundoAtual));

            String[] acao = DespertadorController.verAcao();
            for (int v = 0; v < acao.length; v++) {
              System.out.println(String.format("[%d] >> %s", v + 1, acao[v]));
            }

            acaoDoLouco = sc.nextInt();
            System.out.println(DespertadorController.acaoDoDorminhoco(acaoDoLouco));

            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.print("\033[H\033[2J");  
            System.out.flush();
        }


        sc.close();
    }
}