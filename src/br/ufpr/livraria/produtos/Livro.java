package br.ufpr.livraria.produtos;


import br.ufpr.livraria.Autor;

public abstract class Livro implements Produto {
    
    private String nome;
    private String descricao;
    private double valor;
    private String isbn;
    
    private Autor autor;
    
    Livro() {
        System.out.println("Novo livro criado.");
    }
    
    Livro(Autor autor) {
        this();
        this.autor = autor;
    }

    public void mostrarDetalhes() {
        System.out.println("Mostrar detalhes do livro");
        System.out.println("Nome .....: " + nome);
        System.out.println("Descrição.: " + descricao);
        System.out.println("Valor ....: " + valor);
        System.out.println("ISBN......: " + isbn);
        System.out.println("---");
        
        if (this.temAutor()) {
            autor.mostrarDetalhes();
        }
        
        
        
    }
    
    boolean temAutor() {
        return !(this.autor == null);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    @Override
    public int compareTo(Produto p) {
        return Double.compare(this.getValor(), p.getValor());
    }
    
}
