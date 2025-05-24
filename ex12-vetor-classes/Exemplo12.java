import java.util.Scanner;

public class Exemplo12 {
  public static final int TAM = 5;
  public static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
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
}