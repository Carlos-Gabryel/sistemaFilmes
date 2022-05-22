public class ListaCategorias {
    
    private NodeCategoria primeiro;
    private int qtd;
    private NodeCategoria ultimo;
    // métodos da classe (inserção ordenada na lista, remoção na lista, busca na lista, exibição da lista)

    public NodeCategoria getPrimeiro(){
        return primeiro;
    }

    public boolean isEmpty() {
        if (this.primeiro == null && this.qtd == 0 && this.ultimo == null) {
            return true;
        } else {
            return false;
        }
    }

    public NodeCategoria buscaMelhorada(String descricao) {
        if (this.isEmpty() != true) {
            NodeCategoria aux = this.primeiro;
            do {
                if (aux.getInfo().getDescricao().equals(descricao)) {
                    return aux;
                }
                aux = aux.getProx();
            } while (aux != this.primeiro);
        }
        return null;
    }

    public void inserirOrdenadoCrescente(NodeCategoria novoNode) {
        NodeCategoria encontrado = buscaMelhorada(novoNode.getInfo().getDescricao());
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
                NodeCategoria aux = this.primeiro;
                do {
                    if (aux.getInfo().compareTo(novoNode.getInfo()) > 0) {
                        // System.out.println("Filme já cadastrado. Inserção não efetuada!");
                        break;
                    } else {
                        aux = aux.getProx();
                    }
                } while (aux != this.primeiro);
                NodeCategoria anterior = aux.getAnt();
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