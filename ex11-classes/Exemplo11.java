import java.util.Scanner;

public class Exemplo11 {
  public static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    Pessoa p1 = new Pessoa(), p2 = new Pessoa();
    System.out.println("-------DIGITAÇÃO DADOS PESSOA 1-------");
    lerPessoa(p1);
    System.out.println("-------DIGITAÇÃO DADOS PESSOA 2-------");
    lerPessoa(p2);

    System.out.println("-------IMPRESSÃO-------");
    imprimirPessoa(p1);
    imprimirPessoa(p2);
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
    // System.out.println(p);
  }

  public static double calcularIMC(Pessoa p) {
    return p.peso / (p.altura * p.altura);
  }
}