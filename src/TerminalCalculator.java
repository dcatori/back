import java.util.Scanner;

public class TerminalCalculator {
    private static String numero1;
    private static String numero2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número que será somada, e tecle enter: ");
        numero1 = sc.nextLine();
        System.out.print("Digite o segundo número que será somada, e tecle enter: ");
        numero2 = sc.nextLine();
        System.out.println(String.format("O resultado da soma é: %d", Integer.valueOf(numero1) + Integer.valueOf(numero2)));

        sc.close();
    }
}
