import java.util.Scanner;

public class Contador {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Infome o primeiro valor:");
        int valor1 = scanner.nextInt();
        System.out.printf("Infome o primeiro valor:");
        int valor2 = scanner.nextInt();

        try {
            contar(valor1, valor2);
        } catch (Exception e) {
            System.out.println("Exceção: " + e.getMessage());
        }
    }

    public static void contar(int valor1, int valor2) throws ParametrosInvalidosException {
        if (valor1 > valor2)
            throw new ParametrosInvalidosException("O Segundo parâmetro de ser maior que o primerio");
        for (int i = valor1; i <= valor2; i++) {
            System.out.println("Imprimindo o número:" + i);
        }
    }
}
