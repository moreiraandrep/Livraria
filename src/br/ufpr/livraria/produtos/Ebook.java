package br.ufpr.livraria.produtos;


import br.ufpr.livraria.Autor;

public class Ebook extends Livro implements Promocional {
    
    private String waterMark;

    public Ebook(Autor autor) {
        super(autor);
    }

    public String getWaterMark() {
        return waterMark;
    }

    public void setWaterMark(String waterMark) {
        this.waterMark = waterMark;
    }
    
    @Override
    public boolean aplicaDescontoDe(double porcentagem) {
        if (porcentagem > 0.15) {
            return false;
        }
        double desconto = 
                this.getValor() * porcentagem;
        this.setValor(this.getValor() - desconto);
        
        return true;
    }

    @Override
    public String toString() {
        return "Ebook: " + this.getNome();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Ebook)) return false;
        Ebook outro = (Ebook) obj;
        return this.getNome().equals(outro.getNome());
    }
    
    @Override
    public int hashCode() {
        int hash = 1;
        int primo = 11;
        hash *= primo + 
         (this.getNome() == null ? 0 : this.getNome().hashCode());
        hash *= primo +
         (this.getDescricao() == null ? 0 : 
                              this.getDescricao().hashCode());
        return hash;
    }
    
    
    
}
