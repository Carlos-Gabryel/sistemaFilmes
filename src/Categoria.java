public class Categoria implements Comparable <Categoria> {

    private String descricao; // nome da categoria
    private ListaFilmes lista = new ListaFilmes(); // referência para a lista de filmes daquela categoria

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ListaFilmes getLista() {
        return this.lista;
    }

    public void setLista(ListaFilmes lista) {
        this.lista = lista;
    }
    
    @Override
    public int compareTo(Categoria categoria) {
        return this.descricao.compareTo(categoria.descricao);
    }

    public void addNovoFilme(Filme novoFilme){
        this.lista.inserirOrdenadoCrescente(new NodeFilme(novoFilme));
    }

    @Override
    public String toString() {
        return "{" +
            " descricao='" + getDescricao() + "'" +
            ", lista='" + getLista() + "'" +
            "}";
    }
    
    }