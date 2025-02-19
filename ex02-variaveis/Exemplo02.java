import java.util.Scanner;

public class Exemplo02 {
  public static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
    int num1 = 10, num2;
    double num3 = 3.15, num4;

    System.out.print("Digite um número inteiro: ");
    num2 = input.nextInt();

    System.out.print("Digite um número real: ");
    num4 = input.nextDouble();

    System.out.println("Número 1 = " + num1);  
    System.out.println("Número 2 = " + num2);
    System.out.println("Número 3 = " + num3);
    System.out.println("Número 4 = " + num4);
  }  
}
