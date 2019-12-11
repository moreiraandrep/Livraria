package br.ufpr.livraria.produtos;


import br.ufpr.livraria.Autor;

public class MiniLivro extends Livro {
    
    public MiniLivro(Autor autor){
        super(autor);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof MiniLivro)) return false;
        MiniLivro outro = (MiniLivro) obj;
        return this.getNome().equals(outro.getNome());
    }
    
    @Override
    public int hashCode() {
        int hash = 1;
        int primo = 13;
        hash *= primo + 
         (this.getNome() == null ? 0 : this.getNome().hashCode());
        hash *= primo +
         (this.getDescricao() == null ? 0 : 
                              this.getDescricao().hashCode());
        return hash;
    }

}
