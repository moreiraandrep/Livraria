package br.ufpr.livraria.produtos;


import br.ufpr.livraria.Autor;

public class LivroFisico extends Livro implements Promocional {
    
    public LivroFisico(Autor autor) {
        super(autor);
    }
    
    public double getTaxaImpressao() {
        return this.getValor() * 0.05;
    }
    
    @Override
    public boolean aplicaDescontoDe(double porcentagem) {
        if (porcentagem > 0.3) {
            return false;
        }
        double desconto = this.getValor() * porcentagem;
        this.setValor(this.getValor() - desconto);
        return true;
    }


    @Override
    public String toString() {
        return "Livro Fisico: " + this.getNome();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof LivroFisico)) return false;
        LivroFisico outro = (LivroFisico) obj;
        return this.getNome().equals(outro.getNome());
    }

    @Override
    public int hashCode() {
        int hash = 1;
        int primo = 7;
        hash *= primo + 
         (this.getNome() == null ? 0 : this.getNome().hashCode());
        hash *= primo +
         (this.getDescricao() == null ? 0 : 
                              this.getDescricao().hashCode());
        return hash;
    }
    
    
    
    
    
}
