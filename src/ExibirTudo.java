public class ExibirTudo {
    public static void exibirTudo(ListaCategorias listaCategorias) {
        if (!listaCategorias.isEmpty()) {
            System.out.println();
            NodeCategoria auxCategoria = listaCategorias.getPrimeiro();
            do {
                NodeFilme listaPrimeiro = auxCategoria
                        .getInfo()
                        .getLista()
                        .getPrimeiro();
                NodeFilme auxFilme = listaPrimeiro;
                do {
                    System.out.println(auxFilme.getInfo());
                    auxFilme = auxFilme.getProx();
                } while (auxFilme != listaPrimeiro);

                auxCategoria = auxCategoria.getProx();
            } while (auxCategoria != listaCategorias.getPrimeiro());
        } else {
            System.out.println("\nLista de categorias vazia.");
        }
    }
}
