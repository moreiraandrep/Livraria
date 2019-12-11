package br.ufpr.livraria.principal;


import br.ufpr.livraria.produtos.Ebook;
import br.ufpr.livraria.produtos.LivroFisico;
import br.ufpr.livraria.carrinho.CarrinhoDeCompras;
import br.ufpr.livraria.Autor;
import br.ufpr.livraria.excecoes.DescontoIndevidoException;
import br.ufpr.livraria.produtos.MiniLivro;
import br.ufpr.livraria.produtos.Produto;
import br.ufpr.livraria.ui.AutorUI;
import java.util.Collections;
import java.util.List;


public class CadastroDeLivros {

    public static void main(String[] args) {
//        Autor autor = new Autor();
//        autor.setNome("Rodrigo Turini");
//        autor.setCpf("123.456.789-00");
//        autor.setEmail("rodrigo@turini.com");
//        
//        LivroFisico livro = new LivroFisico(autor);
//        
//        
//        
//        livro.setNome("Java 8 na Prática");
//        livro.setDescricao("Novos recursos da linguagem");
//        livro.setValor(59.90);
//        livro.setIsbn("978-85-66250-46-6");
//
//        
//        //livro.setAutor(autor);
//
//        if (livro.aplicaDescontoDe(0.9)) {
//            System.out.println("Valor do livro com desconto: "
//                    + livro.getValor());
//        } else {
//            System.out.println("Não foi possível aplicar"
//                    + " este desconto");
//        }
//        
//        //livro.valor -= livro.valor * 1.50;
//
//        livro.mostrarDetalhes();
//
//        
//        Autor outroAutor = new Autor();
//        outroAutor.setNome("Paulo Silveira");
//        outroAutor.setCpf("999.888.777-66");
//        outroAutor.setEmail("paulo@silveira.com");
//        
//        LivroFisico outroLivro = new LivroFisico(outroAutor);
//        outroLivro.setNome("Java 8 na Prática - Reciclável");
//        outroLivro.setDescricao("Crie seus primeiros programas");
//        outroLivro.setValor(49.90);
//        outroLivro.setIsbn("978-85-66250-22-0");
//
//        
//        //outroLivro.setAutor(outroAutor);
//
//        outroLivro.mostrarDetalhes();
//        
//        Ebook ebook = new Ebook(autor);
//        ebook.setNome("Java para iniciantes");
//        ebook.setValor(19.90);
//        
//        LivroFisico lf = new LivroFisico(autor);
//        lf.setNome("Java para iniciantes: impresso");
//        lf.setValor(44.90);
//        
//        ebook.mostrarDetalhes();
//        lf.mostrarDetalhes();
//        
//        CarrinhoDeCompras cc = new CarrinhoDeCompras();
//        cc.adiciona(livro);
//        cc.adiciona(outroLivro);
//        cc.adiciona(ebook);
//        
//        try {
//            cc.desconto(lf, 1.05);
//        } catch(DescontoIndevidoException ex) {
//            System.out.println("Ocorreu um erro ao tentar aplicar o desconto");
//            System.out.println(ex.getMessage());
//        }
//        
//        
//        cc.adiciona(lf);
//        
//        System.out.printf("Total gasto: %.2f\n", cc.getTotal());
//        
//        List<Produto> produtos = cc.getProdutos();
//        
//        System.out.println("Produtos antes da ordenação");
//        for (Produto p : produtos) {
//            System.out.println("Produto: " + p);
//            System.out.println("Valor: " + p.getValor());
//            System.out.println("-------------------------");
//        }
//        
//        Collections.sort(produtos);
//        
//        System.out.println("Produtos após a ordenação");
//        for (Produto p : produtos) {
//            System.out.println("Produto: " + p);
//            System.out.println("Valor: " + p.getValor());
//            System.out.println("-------------------------");
//        }
//        
//        MiniLivro ml = null;
//        //cc.adiciona(ml);

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AutorUI janela = new AutorUI();
            }
        });
        
    }

}
