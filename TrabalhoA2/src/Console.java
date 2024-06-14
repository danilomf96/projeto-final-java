import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    private static Scanner leitor = new Scanner(System.in);

    public static int lerInt() {
        int valor = 0;

        while (true) {

            try {
                valor = leitor.nextInt();
                break;

            } catch (InputMismatchException e) {
                System.out.println("O valor digitado não e do tipo 'int' ");
                System.out.println("Digite novamente: ");
            } finally {
                leitor.nextLine();
            }
        }
        return valor;
    }

    public static float lerFloat() {
        float valor = 0;

        while (true) {
            try {
                valor = leitor.nextFloat();
                break;

            } catch (InputMismatchException e) {
                System.out.println("O valor digitado não e do tipo 'int' ");
                System.out.println("Digite novamente: ");
            } finally {
                leitor.nextLine();
            }
        }
        return valor;
    }

    public static double lerDouble() {
        double valor = 0;

        while (true) {

            try {
                valor = leitor.nextDouble();
                break;

            } catch (InputMismatchException e) {
                System.out.println("O valor digitado não e do tipo 'int' ");
                System.out.println("Digite novamente: ");
            } finally {
                leitor.nextLine();
            }
        }
        return valor;
    }

    public static String lerString() {
        return leitor.nextLine();
    }

}