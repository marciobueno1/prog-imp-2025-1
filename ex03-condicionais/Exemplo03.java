import java.util.Scanner;

public class Exemplo03 {
  public static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    int num;
    System.out.print("Digite um número inteiro: ");
    num = input.nextInt();
    System.out.println("Você digitou o número " + num);
    if (num < 0) {
      System.out.println("O número " + num + " é negativo!");
    } else if (num == 0) {
      System.out.println("O número " + num + " é neutro!");
    } else {
      System.out.println("O número " + num + " é positivo!");
    }
  }
}