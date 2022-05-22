public class Filme implements Comparable <Filme> {
    
    private String titulo; // exemplo: “O Rei Leão”
    private String genero; // exemplo: “Musical infantil”
    private String classificacao; // exemplo: “Livre”
    private int anoLancamento; // exemplo: 1994

    public Filme(String titulo, String genero, String classificacao, int anoLancamento) {
        this.titulo = titulo;
        this.genero = genero;
        this.classificacao = classificacao;
        this.anoLancamento = anoLancamento;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClassificação() {
        return this.classificacao;
    }

    public void setClassificação(String classificacao) {
        this.classificacao = classificacao;
    }

    public int getAno() {
        return this.anoLancamento;
    }

    public void setAno(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public int compareTo(Filme filme) {
        
        return this.titulo.compareTo(filme.titulo);
    }

    @Override
    public String toString() {
        return "{" +
            " titulo='" + getTitulo() + "'" +
            ", genero='" + getGenero() + "'" +
            ", classificação='" + getClassificação() + "'" +
            ", anoLancamento='" + getAno() + "'" +
            "}";
    }
    
    }