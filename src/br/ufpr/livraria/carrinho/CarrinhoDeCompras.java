package br.ufpr.livraria.carrinho;

import br.ufpr.livraria.excecoes.DescontoIndevidoException;
import br.ufpr.livraria.produtos.Produto;
import br.ufpr.livraria.produtos.Promocional;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private double total;
    private List<Produto> produtos;

    public CarrinhoDeCompras() {
        produtos = new ArrayList<>();
    }

    public void adiciona(Produto produto) {
        try {
            if (produtos.add(produto)) {
                total += produto.getValor();
                System.out.println("Adicionado: " + produto);
            }
        } catch (NullPointerException ex) {
            System.out.println("Ixi.. deu ruim!");
            System.out.println(ex.getMessage());
        }

    }

    public void remove(Produto produto) {
        if (produtos.remove(produto)) {
            total -= produto.getValor();
            System.out.println("Removido: " + produto);
        }
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void desconto(Promocional p, double porcentagem) 
            throws DescontoIndevidoException {
        
        if (porcentagem > 1) {
            throw new DescontoIndevidoException(
                    "Você não pode solicitar um desconto"
                            + " maior que 100%."
                      );
        }
        
        if (p.aplicaDescontoDe(porcentagem)) {
            System.out.println("Desconto aplicado ao produto: " + p);
        }
    }

    public double getTotal() {
        return this.total;
    }

}
