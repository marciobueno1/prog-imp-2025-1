import java.util.Scanner;

public class Exemplo13 {
  private static Scanner input = new Scanner(System.in);
  private static final int QTD_PRODUTOS = 10;

  public static void main(String[] args) {
    int qtdProdutos = 0;
    Produto[] produtos = new Produto[QTD_PRODUTOS];
    qtdProdutos = cadastrarProdutos(produtos, qtdProdutos);
    System.out.println("-----------IMPRESSAO-----------");
    listarProdutos(produtos, qtdProdutos);
    insercaoDiretaPreco(produtos, qtdProdutos);
    System.out.println("-----------IMPRESSAO APÓS ORDENAÇÃO-----------");
    listarProdutos(produtos, qtdProdutos);
  }

  public static int cadastrarProdutos(Produto[] vp, int tam) {
    int qtd = tam, opcao = 1;
    while (opcao == 1 && qtd < vp.length) {
      vp[qtd] = new Produto();
      System.out.println("Digite o nome do produto");
      vp[qtd].nome = input.nextLine();
      System.out.println("Digite a descrição do produto");
      vp[qtd].descricao = input.nextLine();
      System.out.println("Digite preço do produto");
      vp[qtd].preco = input.nextDouble();
      System.out.println("Digite a quantidade em estoque deste produto");
      vp[qtd].qtdEstoque = input.nextInt();
      qtd += 1;
      System.out.println("Digite 1 para cadastrar novo produto e outro valor para encerrar!");
      opcao = input.nextInt();
      input.nextLine();
    }

    if (qtd == vp.length) {
      System.out.println("Vetor cheio, não é possível cadastrar mais nenhum produto!");
    }

    return qtd;
  }

  public static void listarProdutos(Produto[] vp, int tam) {
    for (int i = 0; i < tam; i += 1) {
      System.out.printf("(%s, %s, R$ %.2f, %d unidades)\n",
          vp[i].nome, vp[i].descricao, vp[i].preco, vp[i].qtdEstoque);
    }
  }

  public static void insercaoDiretaPreco(Produto[] vp, int tam) {
    Produto chave;
    int j;
    for (int i = 1; i <= tam - 1; i += 1) {
      chave = vp[i];
      j = i;
      while (j > 0 && chave.preco < vp[j - 1].preco) {
        vp[j] = vp[j - 1];
        j -= 1;
      }
      vp[j] = chave;
    }
  }
}
