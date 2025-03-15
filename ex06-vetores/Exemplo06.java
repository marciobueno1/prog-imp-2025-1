import java.util.Scanner;

public class Exemplo06 {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        double[] notas = new double[5];
        double somatorio, media;

        // Digitação de todas as notas
        for (int i = 0; i < notas.length; i += 1) {
            System.out.print("Digite a " + (i + 1) + "ª nota: ");
            notas[i] = input.nextDouble();
        }

        // Impressão das notas digitadas
        System.out.println("\nNotas Digitadas:");
        for (int i = 0; i < notas.length; i += 1) {
            System.out.println((i + 1) + "ª nota: " + notas[i]);
        }

        // Cálculo da média
        somatorio = 0.0;
        for (int i = 0; i < notas.length; i += 1) {
            somatorio += notas[i];
        }
        media = somatorio / notas.length;
        System.out.println("\nA média da turma é " + media);

        // Impressão das notas acima da média da turma
        for (int i = 0; i < notas.length; i += 1) {
            if (notas[i] > media) {
                System.out.println((i + 1) + "ª nota: " + notas[i]);
            }
        }
    }
}
