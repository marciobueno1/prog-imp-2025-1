import java.util.Scanner;

public class Exemplo06 {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        double[] notas = new double[5];
        double media;
        digitacaoNotas(notas);
        impressaoNotas(notas);
        media = calcularMedia(notas);
        System.out.println("\nA média da turma é " + media);
        System.out.println("\nNotas maior ou igual a média da turma\n");
        impressaoNotasMaiorIgualValor(notas, media);
        System.out.println("\nNotas maior ou igual a 7.0\n");
        impressaoNotasMaiorIgualValor(notas, 7.0);
        buscarNotasEnquantoNotaNaoNegativa(notas);
    }

    public static void digitacaoNotas(double[] v) {
        for (int i = 0; i < v.length; i += 1) {
            System.out.print("Digite a " + (i + 1) + "ª nota: ");
            v[i] = input.nextDouble();
        }
    }

    public static void impressaoNotas(double[] v) {
        System.out.println("\nNotas Digitadas:");
        for (int i = 0; i < v.length; i += 1) {
            System.out.println((i + 1) + "ª nota: " + v[i]);
        }
    }

    public static double calcularMedia(double[] v) {
        double somatorio = 0.0;
        for (int i = 0; i < v.length; i += 1) {
            somatorio += v[i];
        }
        return somatorio / v.length;
    }

    public static void impressaoNotasMaiorIgualValor(double[] v, double valor) {
        for (int i = 0; i < v.length; i += 1) {
            if (v[i] >= valor) {
                System.out.println((i + 1) + "ª nota: " + v[i]);
            }
        }
    }

    public static void buscarNotasEnquantoNotaNaoNegativa(double notas[]) {
        double nota;
        int pos;
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
