import java.util.Scanner;

public class Exemplo12 {
  public static final int TAM = 10;
  public static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    String nome;
    int pos;
    Pessoa[] pessoas = new Pessoa[TAM];

    for (int i = 0; i < pessoas.length; i += 1) {
      System.out.println("\n-------DIGITAÇÃO DADOS PESSOA " + (i + 1) + "-------");
      pessoas[i] = new Pessoa();
      lerPessoa(pessoas[i]);
    }

    System.out.println("\n\n-------IMPRESSÃO-------");
    for (int i = 0; i < pessoas.length; i += 1) {
      imprimirPessoa(pessoas[i]);
    }

    int indiceMaisAlta = buscarPessoaMaisAlta(pessoas, pessoas.length);
    System.out.print("A pessoa mais alta é ");
    imprimirPessoa(pessoas[indiceMaisAlta]);

    double mediaIdade = calcularMediaIdade(pessoas, pessoas.length);
    System.out.println("A média de idade destas pessoas é " + mediaIdade);

    metodoBolhaPorIdade(pessoas, pessoas.length);

    System.out.println("\n\n-------IMPRESSÃO APÓS ORDENAÇÃO BOLHA POR IDADE-------");
    for (int i = 0; i < pessoas.length; i += 1) {
      imprimirPessoa(pessoas[i]);
    }

    // metodoBolhaPorNome(pessoas, pessoas.length);

    // System.out.println("\n\n-------IMPRESSÃO APÓS ORDENAÇÃO BOLHA POR NOME-------");
    // for (int i = 0; i < pessoas.length; i += 1) {
    //   imprimirPessoa(pessoas[i]);
    // }

    // System.out.println("\n\n----------Busca binária por nome----------");
    // System.out.print("Digite um nome para ser buscado: ");
    // nome = input.nextLine();
    // pos = buscaBinariaPorNome(pessoas, pessoas.length, nome);
    // if (pos != -1) {
    //   System.out.print("Pessoa encontrada: ");
    //   imprimirPessoa(pessoas[pos]);
    // } else {
    //   System.out.println("Pessoa não encontrada!");
    // }
  }

  public static void lerPessoa(Pessoa p) {
    System.out.print("Digite o nome: ");
    p.nome = input.nextLine();
    System.out.print("Digite a idade: ");
    p.idade = input.nextInt();
    System.out.print("Digite o peso: ");
    p.peso = input.nextDouble();
    System.out.print("Digite a altura: ");
    p.altura = input.nextDouble();
    input.nextLine();
  }

  public static void imprimirPessoa(Pessoa p) {
    double imc = calcularIMC(p);
    System.out.printf("(%s, %d anos, %.1f kg, %.1f m, IMC = %.1f)\n",
        p.nome, p.idade, p.peso, p.altura, imc);
  }

  public static double calcularIMC(Pessoa p) {
    return p.peso / (p.altura * p.altura);
  }

  public static int buscarPessoaMaisAlta(Pessoa[] v, int tam) {
    int indiceMaisAlta = 0;
    for (int i = 1; i < tam; i += 1) {
      if (v[i].altura > v[indiceMaisAlta].altura) {
        indiceMaisAlta = i;
      }
    }
    return indiceMaisAlta;
  }

  public static double calcularMediaIdade(Pessoa[] v, int tam) {
    double soma = 0.0;
    if (tam <= 0) {
      return 0.0;
    }
    for (int i = 0; i < tam; i += 1) {
      soma += v[i].idade;
    }
    return soma / tam;
  }

  public static void metodoBolhaPorIdade(Pessoa[] v, int tam) {
    int fim = tam - 2, pos = 0;
    boolean trocou = true;
    Pessoa chave;
    while (trocou) {
      trocou = false;
      for (int i = 0; i <= fim; i++) {
        if (v[i].idade > v[i + 1].idade) {
          chave = v[i];
          v[i] = v[i + 1];
          v[i + 1] = chave;
          pos = i;
          trocou = true;
        }
      }
      fim = pos - 1;
    }
  }
  
  public static int buscaBinariaPorIdade(Pessoa[] v, int tam, int x) {
    int inicio = 0, fim = tam - 1, meio;
    while (inicio <= fim) {
        meio = (inicio + fim) / 2;
        if (x == v[meio].idade) {
            return meio;
        } else if (x < v[meio].idade) {
            fim = meio - 1;
        } else {
            inicio = meio + 1;
        }
    }
    return -1;
  }

  public static void metodoBolhaPorNome(Pessoa[] v, int tam) {
    int fim = tam - 2, pos = 0;
    boolean trocou = true;
    Pessoa chave;
    while (trocou) {
      trocou = false;
      for (int i = 0; i <= fim; i++) {
        if (v[i].nome.toUpperCase().compareTo(v[i + 1].nome.toUpperCase()) > 0) {
          chave = v[i];
          v[i] = v[i + 1];
          v[i + 1] = chave;
          pos = i;
          trocou = true;
        }
      }
      fim = pos - 1;
    }
  }

  public static int buscaBinariaPorNome(Pessoa[] v, int tam, String x) {
    int inicio = 0, fim = tam - 1, meio;
    while (inicio <= fim) {
        meio = (inicio + fim) / 2;
        if (x.toUpperCase().compareTo(v[meio].nome.toUpperCase()) == 0) {
            return meio;
        } else if (x.toUpperCase().compareTo(v[meio].nome.toUpperCase()) < 0) {
            fim = meio - 1;
        } else {
            inicio = meio + 1;
        }
    }
    return -1;
  }
}