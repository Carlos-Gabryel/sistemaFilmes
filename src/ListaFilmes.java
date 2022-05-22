public class ListaFilmes {

    private NodeFilme primeiro;
    private int qtd;
    private NodeFilme ultimo;

    // métodos da classe (inserção ordenada na lista, remoção na lista, busca na
    // lista, exibição da lista)
    public boolean isEmpty() {
        if (this.primeiro == null && this.qtd == 0 && this.ultimo == null) {
            return true;
        } else {
            return false;
        }
    }

    public NodeFilme buscaMelhorada(String titulo) {
        if (this.isEmpty() != true) {
            NodeFilme aux = this.primeiro;
            do {
                if (aux.getInfo().getTitulo().equals(titulo)) {
                    return aux;
                }
                aux = aux.getProx();
            } while (aux != this.primeiro);
        }
        return null;
    }

    public void inserirOrdenadoCrescente(NodeFilme novoNode) {
        NodeFilme encontrado = buscaMelhorada(novoNode.getInfo().getTitulo());
        if (encontrado == null) {
            if (this.isEmpty() == true) { // inserção na lista vazia
                this.primeiro = novoNode;
                this.ultimo = novoNode;
                this.qtd++;
            } else if (novoNode.getInfo().compareTo(this.primeiro.getInfo()) < 0) { // inserção antes do primeiro
                novoNode.setProx(this.primeiro);
                this.primeiro.setAnt(novoNode);
                this.primeiro = novoNode;
                this.qtd++;
            } else if (novoNode.getInfo().compareTo(this.ultimo.getInfo()) > 0) { // inserção após o último
                this.ultimo.setProx(novoNode);
                novoNode.setAnt(this.ultimo);
                this.ultimo = novoNode;
                this.qtd++;
            } else { // inserção no meio - depois do primeiro e antes do último
                NodeFilme aux = this.primeiro;
                do {
                    if (aux.getInfo().compareTo(novoNode.getInfo()) > 0) {
                        // System.out.println("Filme já cadastrado. Inserção não efetuada!");
                        break;
                    } else {
                        aux = aux.getProx();
                    }
                } while (aux != this.primeiro);
                NodeFilme anterior = aux.getAnt();
                anterior.setProx(novoNode);
                novoNode.setAnt(anterior);
                novoNode.setProx(aux);
                aux.setAnt(novoNode);
                this.qtd++;
                System.out.println("Filme inserido com sucesso!!");
            }
        }
    }
}