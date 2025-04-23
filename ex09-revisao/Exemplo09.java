import java.util.Scanner;

public class Exemplo09 {
  public static final int TAM = 100;
  public static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    int[] vetor1 = new int[TAM];
    int qtdVetor1 = 0, opcao, num, pos;
    do {
      System.out.println("MENU");
      System.out.println("1. Inserir Valor no vetor");
      System.out.println("2. Imprimir Vetor");
      System.out.println("3. Ordenar o Vetor");
      System.out.println("4. Pesquisar no Vetor");
      System.out.println("5. Calcular a média");
      System.out.print("Digite sua opção (0 p/ sair): ");
      opcao = input.nextInt();

      switch (opcao) {
        case 1:
          qtdVetor1 = inserirVetor(vetor1, qtdVetor1);
          break;
      
        case 2:
          imprimirVetor(vetor1, qtdVetor1);
          break;

        case 3:
          insercaoDireta(vetor1, qtdVetor1);
          imprimirVetor(vetor1, qtdVetor1);
          break;

        case 4:
          insercaoDireta(vetor1, qtdVetor1);
          System.out.print("Digite o número a ser pesquisado: ");
          num = input.nextInt();
          pos = buscaBinaria(vetor1, qtdVetor1, num);
          if (pos != -1) {
            System.out.println("Achou o número " + num + " na posição " + (pos + 1));
          } else {
            System.out.println("Não achou o número " + num + " no vetor!");
          }
          break;
          
        case 5:
          System.out.println("A média do vetor é " + calcularMedia(vetor1, qtdVetor1));
          break;

        default:
          if (opcao != 0) {
            System.out.println("Opção Inválida!");
          }
          break;
      }
    } while (opcao != 0);
  }

  public static int inserirVetor(int[] v, int n) {
    if (n < v.length) {
      System.out.print("Digite um valor: ");
      v[n] = input.nextInt();
      n += 1;
    } else {
      System.out.println("Vetor cheio, não pode inserir mais elementos");
    }
    return n;
  }

  public static void imprimirVetor(int[] v, int n) {
    for (int i = 0; i < n; i += 1) {
      System.out.print(v[i] + "\t");
    }
    System.out.println();
  }

  public static void insercaoDireta(int[] v, int n) {
    int j;
    int chave;
    for (int i = 1; i <= n - 1; i += 1) {
      chave = v[i];
      j = i - 1;
      while (j >= 0 && v[j] > chave) {
        v[j + 1] = v[j];
        j = j - 1;
      }
      v[j + 1] = chave;
    }
  }

  public static int buscaBinaria(int[] v, int n, int x) {
    int inicio = 0, fim = n - 1, meio;
    while (inicio <= fim) {
        meio = (inicio + fim) / 2;
        if (x == v[meio]) {
            return meio;
        } else if (x < v[meio]) {
            fim = meio - 1;
        } else {
            inicio = meio + 1;
        }
    }
    return -1;
  }

  public static double calcularMedia(int[] v, int n) {
    int soma = 0;
    
    if (n == 0) {
      return 0.0;
    }

    for (int i = 0; i < n; i += 1) {
      soma += v[i];
    }
    return (double) soma / (double) n;
  }
}
