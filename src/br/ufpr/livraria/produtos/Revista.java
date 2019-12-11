package br.ufpr.livraria.produtos;


import br.ufpr.livraria.Editora;

public class Revista implements Produto, Promocional {
    
    private String nome;
    private String descricao;
    private double valor;
    private Editora editora;

    @Override
    public boolean aplicaDescontoDe(double porcentagem) {
        if (porcentagem > 0.1) {
            return false;
        }
        double desconto = this.getValor() * porcentagem;
        this.setValor(this.getValor() - desconto);
        return true;
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

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Revista)) return false;
        Revista outro = (Revista) obj;
        return this.getNome().equals(outro.getNome());
    }
    
    @Override
    public int hashCode() {
        int hash = 1;
        int primo = 17;
        hash *= primo + 
         (this.getNome() == null ? 0 : this.getNome().hashCode());
        hash *= primo +
         (this.getDescricao() == null ? 0 : 
                              this.getDescricao().hashCode());
        return hash;
    }
    
    @Override
    public int compareTo(Produto p) {
        return Double.compare(this.getValor(), p.getValor());
    }
    
    
}
