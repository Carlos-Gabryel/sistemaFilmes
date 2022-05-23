import java.util.Scanner;

public class RemoverFilme {

    public static void removerFilme(ListaCategorias listaCategorias) {
        if (listaCategorias.isEmpty()) {
            System.out.println("Lista de categorias vazia.");
        } else {
            Scanner input = new Scanner(System.in);
            System.out.println("Digite o nome do Filme.");
            String titulo = input.nextLine();
            NodeCategoria buscado = validarTitulo(titulo, listaCategorias);
            if (buscado == null) {
                System.out.println("Filme não encontrado!");
                return;
            }
            buscado.getInfo().removerFilmeEspecifico(titulo);
            System.out.println("Filme removido com sucesso!");
        }
    }

    public static NodeCategoria validarTitulo(String titulo, ListaCategorias listaCategorias) {

        if (listaCategorias.isEmpty()) {
            return null;
        }
        NodeCategoria aux = listaCategorias.getPrimeiro();

        do {
            NodeFilme buscado = aux.getInfo().getLista().buscaMelhorada(titulo);
            if (buscado != null) {
                return aux;
            }
            aux = aux.getProx();
        } while (aux != listaCategorias.getPrimeiro());
        return null;
    }

}
