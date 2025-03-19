import java.util.Scanner;

public class Exemplo06 {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        double[] notas = new double[5];
        double somatorio, media;
        double nota;
        int pos;

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

        // encontrar um valor dentro do array
        System.out.print("\nDigite uma nota a ser pesquisada: ");
        nota = input.nextDouble();
        while (nota >= 0.0) {
            pos = busca(notas, nota);
            if (pos != -1) {
                System.out.println("A nota " + nota +
                        " foi encontrada na " + (pos + 1) + "ª posição");
            } else {
                System.out.println("A nota " + nota + " não foi encontrada");
            }
            System.out.print("\nDigite uma nota a ser pesquisada (< 0.0 para finalizar): ");
            nota = input.nextDouble();
        }
    }

    public static int busca(double[] v, double x) {
        for (int i = 0; i < v.length; i += 1) {
            if (v[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
