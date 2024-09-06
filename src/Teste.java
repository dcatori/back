import java.util.Scanner;

public class Teste {

        String parmegiana, salada, coquinha, suco, prato;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escolha seu prato ou sua bebida entre: Parmegiana, Salada, Coquinha ou Suco:");
        String prato = sc.nextLine();
     
        switch (prato) {
            case "parmegiana":
                System.out.println("Parabéns, tu escolheu um puta prato");
                break;
            case "salada":
                System.out.println("Tu é fresco, você escolheu salada: "); 
                break;
             case "coquinha":
                System.out.println("Congrats, você escolheu uma coquinha gelada");  
                break;
             case "suco":
                System.out.println("Você escolheu suco, tu é um falso fit: "); 
                break;     
            default:
                System.out.println("Você informou algo que não existe aqui: ");
                
        }
        sc.close();
    }
}