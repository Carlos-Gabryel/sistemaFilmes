import java.util.Scanner;

public class ExibirFilme {

    public static void exibirFilme(ListaCategorias listaCategorias) {
        if (!listaCategorias.isEmpty()) {
            Scanner input = new Scanner(System.in);

            System.out.println("Digite o nome de um filme:");
            String titulo = input.nextLine();

            Filme achado = validarTitulo(titulo, listaCategorias);
            if (achado == null) {
                System.out.println("Filme nào eencontrado");
                return;
            }
            System.out.println(achado);
        } else {
            System.out.println("Lista de categorias vazia.");
        }
    }

    public static Filme validarTitulo(String titulo, ListaCategorias listaCategorias) {

        if (!listaCategorias.isEmpty()) {
            NodeCategoria aux = listaCategorias.getPrimeiro();

            do {
                NodeFilme buscado = aux.getInfo().getLista().buscaMelhorada(titulo);
                if (buscado != null) {
                    return aux.getInfo().getLista().buscaMelhorada(titulo).getInfo();

                }
                aux = aux.getProx();
            } while (aux != listaCategorias.getPrimeiro());
            return null;
        }
        return null;
    }
}
