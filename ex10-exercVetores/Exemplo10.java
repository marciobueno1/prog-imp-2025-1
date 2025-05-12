public class Exemplo10 {
  public static void main(String[] args) {
    int[] vetor = new int[] { 8, 13, 21, 34, 55, 89 };
    // int[] vetor = new int[] { 1, 2, 3, 3, 5 };
    // int[] vetor = new int[] { 1, 1, 2, 3, 5 };
    imprimirVetor(vetor, vetor.length);
    reverter(vetor, vetor.length);
    imprimirVetor(vetor, vetor.length);
    reverter(vetor, vetor.length);
    if (validarFibonacci(vetor, vetor.length)) {
      System.out.println("É parte de uma sequência de fibonnaci!");
    } else {
      System.out.println("Não é parte de uma sequência de fibonnaci!");
    }
  }

  public static void reverter(int[] v, int n) {
    for (int i = 0; i < n / 2; i += 1) {
      int aux =  v[i];
      v[i] = v[n - 1 - i];
      v[n - 1 - i] = aux;
    }
  }
  
  public static void imprimirVetor(int[] v, int n) {
    for (int i = 0; i < n; i += 1) {
      System.out.print(v[i] + "\t");
    }
    System.out.println();
  }

  public static boolean validarFibonacci(int[] v, int n) {
    int penult = 0, ultima = 1, atual, i = 0;

    if (n > 0) {
      if (v[0] == 0) {
        if (n > 1 && v[1] != 1) {
          return false;
        }
        i += 2;
      } else if (v[0] == 1) {
        if (n > 1 && v[1] != 1) {
          if (v[1] != 2) {
            return false;
          } else {
            i -= 1;
          }
        }
        i += 1;
      }
    }

    while (i < n) {
      atual = penult + ultima;
      if (atual > v[i]) {
        return false;
      } else if (atual == v[i]) {
        i += 1;
      } else if (i != 0 && atual != v[i]) {
        return false;
      }
      penult = ultima;
      ultima = atual;
    }

    return true;
  } 
}
