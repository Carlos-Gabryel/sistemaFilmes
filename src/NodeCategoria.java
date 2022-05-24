public class NodeCategoria {

    private NodeCategoria ant;
    private Categoria info; // exemplo: “Filmes de ação”
    private NodeCategoria prox;

    public NodeCategoria(Categoria info) {
        this.info = info;
    }

    public NodeCategoria getAnt() {
        return this.ant;
    }

    public void setAnt(NodeCategoria ant) {
        this.ant = ant;
    }

    public Categoria getInfo() {
        return this.info;
    }

    public void setInfo(Categoria info) {
        this.info = info;
    }

    public NodeCategoria getProx() {
        return this.prox;
    }

    public void setProx(NodeCategoria prox) {
        this.prox = prox;
    }

}