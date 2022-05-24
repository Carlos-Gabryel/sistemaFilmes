public class NodeFilme {

    private NodeFilme ant;
    private Filme info;
    private NodeFilme prox;

    public NodeFilme(Filme info) {
        this.info = info;
    }

    public NodeFilme(NodeFilme ant, Filme info, NodeFilme prox) {
        this.ant = ant;
        this.info = info;
        this.prox = prox;
    }

    public NodeFilme getAnt() {
        return this.ant;
    }

    public void setAnt(NodeFilme ant) {
        this.ant = ant;
    }

    public Filme getInfo() {
        return this.info;
    }

    public void setInfo(Filme info) {
        this.info = info;
    }

    public NodeFilme getProx() {
        return this.prox;
    }

    public void setProx(NodeFilme prox) {
        this.prox = prox;
    }

}