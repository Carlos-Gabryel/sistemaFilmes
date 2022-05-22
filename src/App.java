import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        ListaCategorias categorias = new ListaCategorias();

        System.out.println("Aplicação iniciada.\n");

        byte option = 1;
        while (option != 0) {
            Thread.sleep(1000);

            menu();
            option = input.nextByte();
            switch (option) {
                case 0 -> System.out.println("\nAplicação encerrada.");
                case 1 -> addFilme.AddFilme(categorias);
                //                case 2 -> ;
                //                case 3 -> ;
                //                case 4 -> ;
                //                case 5 -> ;
                //                case 6 -> ;
                default -> System.out.println("\nOpção inválida.\n");
            }
        }
    }

    public static void menu() {
        System.out.print(
            """
                0 - Encerrar a aplicação;
                1 - Cadastrar um filme;
                2 - Remover um filme;
                3 - Exibir dados de um filme;
                4 - Editar dados de um filme;
                5 - Exibir dados de todos os filmes;
                6 - Exibir dados de todos os filmes de uma categoria;
                
                Escolha uma opção:\040"""
        );
    }
}
