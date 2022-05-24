import java.util.Scanner;

import javax.print.attribute.SupportedValuesAttribute;

public class AddFilme {

    public static void addFilme(ListaCategorias listaCategorias) {
        Scanner input = new Scanner(System.in);

        Categoria categoria = validarCategoria(listaCategorias);

        System.out.println("Digite o nome do Filme.");
        String titulo = input.nextLine();
        if (!validarTitulo(titulo, listaCategorias)) {
            System.out.println("Filme já cadastrado!");
            return;
        }
        System.out.println("Digite o genero do Filme.");
        String genero = input.nextLine();

        System.out.println("Digite a classificação do Filme");
        String classificacao = input.nextLine();

        System.out.println("Digite o ano de lançamento do Filme.");
        int anoLancamento = input.nextInt();
        while (!validarAnoLancamento(anoLancamento)) {
            System.out.println("Ano de lançamento inválido, digite novamente o ano de lançamento do Filme:");
            anoLancamento = input.nextInt();
        }

        Filme novoFilme = new Filme(titulo, genero, classificacao, anoLancamento);
        categoria.addNovoFilme(novoFilme);
        System.out.println("Filme cadastrado com sucesso!");
    }

    public static Categoria validarCategoria(ListaCategorias listaCategorias) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a categoria que o filme será adicionado:");
        String categoria = input.nextLine();
        NodeCategoria buscado = listaCategorias.buscaMelhorada(categoria);
        if (buscado == null) {
            System.out.println("Categoria não encontrada!Criando uma nova categoria...");
            Categoria novaCategoria = new Categoria(categoria);
            buscado = new NodeCategoria(novaCategoria);
            listaCategorias.inserirOrdenadoCrescente(buscado);
        }
        return buscado.getInfo();

    }

    public static boolean validarTitulo(String titulo, ListaCategorias listaCategorias) {

        if (listaCategorias.isEmpty()) {
            System.out.println("Lista de categorias vazia.");
            return false;
        }
        NodeCategoria aux = listaCategorias.getPrimeiro();

        do {
            NodeFilme buscado = aux.getInfo().getLista().buscaMelhorada(titulo);
            if (buscado != null) {
                return false;
            }
            aux = aux.getProx();
        } while (aux != listaCategorias.getPrimeiro());
        return true;
    }

    public static boolean validarAnoLancamento(int anoLancamento) {
        return anoLancamento >= 1895 && anoLancamento <= 2050;
    }

    public static void addDiretamente(NodeCategoria nodeCategoria, Filme filme) {
        nodeCategoria.getInfo().addNovoFilme(filme);
    }
}
