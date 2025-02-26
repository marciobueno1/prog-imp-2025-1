import java.util.Scanner;

public class Exemplo04While {
  public static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    int num1, num2, qtdInterv;

    System.out.print("Digite um número inteiro: ");
    num1 = input.nextInt();

    System.out.print("Digite um número inteiro maior que " + num1 + ": ");
    num2 = input.nextInt();
    while (num2 <= num1) {
      System.out.println("Valor inválido!");
      System.out.print("Digite um número inteiro maior que " + num1 + ": ");
      num2 = input.nextInt();
    }

    qtdInterv = num2 - num1 + 1;
    System.out.println(
      "Existem " + qtdInterv + " números no intervalo de " +
      num1 + " a " + num2
    );
  }
}
