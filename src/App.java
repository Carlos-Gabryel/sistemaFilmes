import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ListaCategorias categorias = new ListaCategorias();

        System.out.println("Aplicação iniciada.\n");

        byte option = 1;
        while (option != 0) {
            menu();
            option = input.nextByte();
            switch (option) {
                case 0 -> System.out.println("\nAplicação encerrada.");
                case 1 -> AddFilme.addFilme(categorias);
                case 2 -> RemoverFilme.removerFilme(categorias);
                case 3 -> ExibirFilme.exibirFilme(categorias);
                case 4 -> EditarFilme.editarFilme(categorias);
                case 5 -> ExibirTudo.exibirTudo(categorias);
                case 6 -> ExibirCategoria.mostrarCategoria(categorias);
                default -> System.out.println("\nOpção inválida.\n");
            }
        }
    }

    public static void menu() {
        System.out.println("Opções");
        System.out.println("1 - Cadastrar um filme");
        System.out.println("2 - Remover um filme");
        System.out.println("3 - Exibir dados de um filme");
        System.out.println("4 - Editar dados de um filme");
        System.out.println("5 - Exibir dados de todos os filmes");
        System.out.println("6 - Exibir dados de todos os filmes de uma categoria");
        System.out.println("0 - Sair do programa");
        System.out.print("Informe a opção desejada: ");
    }
}
