import java.util.Random;

public class Exemplo05 {
  public static Random geradorAleat = new Random(5);

  public static void main(String[] args) {
    int somatorio = 0;
    for (int i = 1; i <= 10; i += 1) {
      // int aleatorio = (int) Math.floor(Math.random() * 6) + 1;
      int aleatorio = geradorAleat.nextInt(6) + 1;
      System.out.println(aleatorio);
      somatorio += aleatorio;
    }
    System.out.println("Somatorio = " + somatorio);
  }
}