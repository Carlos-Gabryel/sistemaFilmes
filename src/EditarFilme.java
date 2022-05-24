import java.util.Scanner;

public class EditarFilme {
    public static void editarFilme(ListaCategorias listaCategorias) {
        if (!listaCategorias.isEmpty()) {
            Scanner input = new Scanner(System.in);

            System.out.println("Digite o nome do filme a ser editado:");
            String titulo = input.nextLine();

            NodeCategoria achado = validarTitulo(titulo, listaCategorias);
            if (achado == null) {
                System.out.println("Filme não encontrado!");
                return;
            }
            Filme filme = achado.getInfo().getLista().buscaMelhorada(titulo).getInfo();
            escolherDado(filme, listaCategorias, achado);
            System.out.println("Dados alterados com sucesso!");
        } else {
            System.out.println("Lista de categorias vazia!");
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

    public static void escolherDado(Filme filme, ListaCategorias listaCategorias, NodeCategoria nodeCategoria) {
        Scanner input = new Scanner(System.in);

        System.out.println("1 - Título");
        System.out.println("2 - Gênero");
        System.out.println(" 3 - Classificação");
        System.out.println("4 - Ano de lançamento");
        System.out.println("Qual dado deseja alterar?");

        byte option = input.nextByte();
        input.nextLine();
        switch (option) {
            case 1 -> {
                System.out.println("Digite o novo nome do filme: ");
                String titulo = input.nextLine();
                if (validarTitulo(titulo, listaCategorias) != null) {
                    System.out.println("Filme já cadastrado.\n");
                } else {
                    Filme novoFilme = new Filme(titulo, filme.getGenero(), filme.getClassificacao(), filme.getAno());
                    RemoverFilme.removerDiretamente(nodeCategoria, filme);
                    AddFilme.addDiretamente(nodeCategoria, novoFilme);
                }
            }
            case 2 -> {
                System.out.println("Digite o novo gênero do filme: ");
                String genero = input.nextLine();
                filme.setGenero(genero);
            }
            case 3 -> {
                System.out.println("Digite a nova classificação do filme: ");
                String classificacao = input.nextLine();
                filme.setClassificacao(classificacao);
            }
            case 4 -> {
                System.out.println("Digite o novo ano de lançamento do filme: ");
                int anoLancamento = input.nextInt();
                while (!AddFilme.validarAnoLancamento(anoLancamento)) {
                    System.out.println("Ano de lançamento inválido, digite o novo ano de lançamento do filme: ");
                    anoLancamento = input.nextInt();
                }
                filme.setAno(anoLancamento);
            }
            default -> System.out.println("Opção inválida.");
        }
    }

}
