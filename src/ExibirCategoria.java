import java.util.Scanner;

public class ExibirCategoria {
    public static void mostrarCategoria(ListaCategorias listaCategorias) {
        if (!listaCategorias.isEmpty()) {
            Categoria categoria = validarCategoria(listaCategorias);
            if (categoria == null) {
                System.out.println("Categoria não encontrada!");
            } else {
                System.out.println();
                NodeFilme aux = categoria.getLista().getPrimeiro();
                do {
                    System.out.println(aux.getInfo());
                    aux = aux.getProx();
                } while (aux != categoria.getLista().getPrimeiro());
            }
        } else {
            System.out.println("Lista de categorias vazia!");
        }
    }

    public static Categoria validarCategoria(ListaCategorias listaCategorias) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a categoria que o filme será adicionado:");
        String categoria = input.nextLine();
        NodeCategoria buscado = listaCategorias.buscaMelhorada(categoria);
        if (buscado == null) {
            return null;
        }
        return buscado.getInfo();

    }

}
