import java.util.Random;

public class Exemplo08 {
  public static final int TAM = 100;
  public static Random geradorAleat = new Random(5);

  public static void main(String[] args) {
    double[] numeros = new Double[TAM];
    preencherAleatorio2(numeros);
    System.out.println("VETOR CRIADO (01)");
    imprimir(numeros);
    insercaoDireta(numeros, numeros.length);
    System.out.println("VETOR APÓS INSERÇÃO DIRETA");
    imprimir(numeros);
    preencherAleatorio2(numeros);
    System.out.println("VETOR CRIADO (02)");
    imprimir(numeros);
    selecaoDireta(numeros, numeros.length);
    System.out.println("VETOR APÓS SELEÇÃO DIRETA");
    imprimir(numeros);
  }

  public static void insercaoDireta(double[] v, int n) {
    int j;
    double chave;
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

  public static void selecaoDireta (double[] v, int n) {
    int menor;
    double aux;
    for (int i = 0; i < n - 1; i += 1) {
      menor = i;
      for (int j = i + 1; j <= n - 1; j += 1) {
        if (v[j] < v[menor]) {
          menor = j;
        }
      }
      aux = v[i];
      v[i] = v[menor];
      v[menor] = aux;
    }
  }

  public static void imprimir(double[] v) {
    for (int i = 0; i < v.length; i += 1) {
      System.out.printf("%.2f ", v[i]);
      if ((i + 1) % 20 == 0) {
        System.out.println();
      }
    }
  }

  public static void preencherAleatorio2(double[] v) {
    int pos;
    double aux;
    for (int i = 0; i < v.length; i += 1) {
      v[i] = i + 1;
    }
    for (int i = 0; i < v.length; i += 1) {
      pos = geradorAleat.nextDouble(TAM);
      aux = v[i];
      v[i] = v[pos];
      v[pos] = aux;
    }
  }
}