import java.util.Scanner;

public class Main {
    public static final int TAM = 100;
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int opcao, qtdCat = 0, qtdProd = 0;
        Categoria[] categorias = new Categoria[TAM];
        Produto[] produtos = new Produto[TAM];
        do {
            System.out.println("\nM E N U");
            System.out.println("1 - Cadastrar Categoria");
            System.out.println("2 - Imprimir Categorias");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Imprimir Produtos");
            System.out.println("\nDigite a sua opção (0 p/ finalizar): ");
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    qtdCat = cadastrarCategoria(categorias, qtdCat);
                    break;
                case 2:
                    imprimirCategorias(categorias, qtdCat);
                    break;
                case 3:
                    qtdProd = cadastrarProduto(produtos, qtdProd);
                    break;
                case 4:
                    imprimirProdutos(produtos, qtdProd, categorias, qtdCat);
                    break;
                default:
                    if (opcao != 0) {
                        System.out.println("Opção inválida!\n");
                    }
            }
        } while(opcao != 0);
    }

    private static void imprimirCategorias(Categoria[] v, int qtd) {
        System.out.println("-----IMPRESSÃO CATEGORIAS-----");
        for (int i = 0; i < qtd; i += 1) {
            System.out.printf("(%d, %s)\n", v[i].codigo, v[i].nome);
        }
    }

    public static int buscarCategoria(Categoria[] v, int qtd, int x) {
        for (int i = 0; i < qtd; i += 1) {
            if (x == v[i].codigo) {
                return i;
            }
        }
        return -1;
    }

    public static int cadastrarCategoria(Categoria[] v, int qtd) {
        if (qtd >= v.length) {
            System.out.println("Vetor de categorias está cheio!");
            return qtd;
        }

        v[qtd] = new Categoria();
        do {
            System.out.println("Digite o código da categoria, precisa ser único: ");
            v[qtd].codigo = input.nextInt();
        } while (buscarCategoria(v, qtd, v[qtd].codigo) != -1);
        input.nextLine(); // ignorar o ENTER que sobrou do nextInt() anterior

        System.out.println("Digite o nome da categoria: ");
        v[qtd].nome = input.nextLine();

        return qtd + 1;
    }

    public static int buscarProduto(Produto[] v, int qtd, int x) {
        for (int i = 0; i < qtd; i += 1) {
            if (x == v[i].codigo) {
                return i;
            }
        }
        return -1;
    }

    public static int cadastrarProduto(Produto[] v, int qtd) {
        if (qtd >= v.length) {
            System.out.println("Vetor de produtos está cheio!");
            return qtd;
        }

        v[qtd] = new Produto();
        do {
            System.out.println("Digite o código do produto, precisa ser único: ");
            v[qtd].codigo = input.nextInt();
        } while (buscarProduto(v, qtd, v[qtd].codigo) != -1);
        input.nextLine(); // ignorar o ENTER que sobrou do nextInt() anterior

        System.out.println("Digite o titulo do produto: ");
        v[qtd].titulo = input.nextLine();

        System.out.println("Digite a descrição do produto: ");
        v[qtd].descricao = input.nextLine();

        System.out.println("Digite a categoria do produto: ");
        v[qtd].categoria = input.nextInt();

        System.out.println("Digite o preço do produto: ");
        v[qtd].preco = input.nextInt();

        return qtd + 1;
    }

    private static void imprimirProdutos(Produto[] vp, int qtdProd, Categoria[] vc, int qtdCat) {
        System.out.println("-----IMPRESSÃO PRODUTOS-----");
        for (int i = 0; i < qtdProd; i += 1) {
            int pos = buscarCategoria(vc, qtdCat, vp[i].categoria);
            String categoria = "Desconhecida";
            if (pos != -1) {
                categoria = vc[pos].nome;
            }
            System.out.printf("(%d, %s, %s, %s, R$ %.2f)\n",
                    vp[i].codigo,
                    vp[i].titulo,
                    vp[i].descricao,
                    categoria,
                    vp[i].preco / 100.0);
        }
    }
}