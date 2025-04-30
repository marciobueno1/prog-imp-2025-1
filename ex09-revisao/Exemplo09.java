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
      System.out.println("6. Buscar menor valor par do vetor");
      System.out.println("7. Imprimir tabela de frequência");
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

        case 6:
          int posMenorPar1 = menorPar(vetor1, qtdVetor1);
          int posMenorPar2 = menorParVersao2(vetor1, qtdVetor1);
          if (posMenorPar1 != -1) {
            System.out.println("[1] Menor par está na posição " + posMenorPar1 + " do vetor");
          } else {
            System.out.println("[1] Não tem nenhum par no vetor");
          }
          if (posMenorPar2 != -1) {
            System.out.println("[2] Menor par está na posição " + posMenorPar2 + " do vetor");
          } else {
            System.out.println("[2] Não tem nenhum par no vetor");
          }
          break;
        
        case 7:
          imprimirDuplicados(vetor1, qtdVetor1);
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

  public static int menorPar(int[] v, int n) {
    int i = 0, posMenorPar;
    while (i < n && v[i] % 2 != 0) {
      i += 1;
    }
    if (i == n) {
      return -1;
    }
    posMenorPar = i;
    for (i = i + 1; i < n; i += 1) {
      if (v[i] % 2 == 0 && v[i] < v[posMenorPar]) {
        posMenorPar = i;
      }
    }
    return posMenorPar;
  }

  public static int menorParVersao2(int[] v, int n) {
    int posMenorPar = 0;
    for (int i = 1; i < n; i += 1) {
      if (v[i] % 2 == 0 && (v[i] < v[posMenorPar] || v[posMenorPar] % 2 != 0)) {
        posMenorPar = i;
      }
    }
    if (v[posMenorPar] % 2 == 0) {
      return posMenorPar;
    }
    return -1;
  }

  public static void imprimirDuplicados(int[] v, int n) {
    int qtd = 1;
    insercaoDireta(v, n);
    System.out.println("NUM\tQTD");
    for (int i = 1; i < n; i += 1) {
      if (v[i] == v[i - 1]) {
        qtd += 1;
      } else {
        System.out.println(v[i - 1] + "\t" + qtd);
        qtd = 1;
      }
    }
    System.out.println(v[n - 1] + "\t" + qtd);
  }
}
