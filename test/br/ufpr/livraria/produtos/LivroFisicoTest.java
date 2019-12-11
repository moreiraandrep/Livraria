package br.ufpr.livraria.produtos;

import br.ufpr.livraria.Autor;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LivroFisicoTest {
    
    Autor a;
    LivroFisico lf1;
    LivroFisico lf2;
    
    public LivroFisicoTest() {
        a = new Autor();
        a.setNome("Fulano de Tal");
        a.setEmail("fulano@tal.com.br");
    }
    
    @Before
    public void setUp() {
        lf1 = new LivroFisico(a);
        lf1.setValor(50);
        lf1.setNome("Livro sobre Java");
        
        lf2 = new LivroFisico(a);
        lf2.setNome("Livro sobre jUnit");
        lf2.setValor(40);
    }

    @Test
    public void testAplicaDescontoDe() {
        assertTrue("Esperando um valor verdadeiro: ", 
                lf1.aplicaDescontoDe(0.2));
        
        assertFalse("Esperando um valor falso: ",
                lf2.aplicaDescontoDe(0.5));
    }
    
    @Test
    public void testGetTaxaImpressao() {
        assertEquals("Esperando 2.5: ", 2.5, 
                lf1.getTaxaImpressao(), 0);
        
        assertEquals("Esperando 2: ", 2,
                lf2.getTaxaImpressao(), 0);
        
        assertNotEquals("Diferente", 5, 
                lf1.getTaxaImpressao(), 0);
    }
}
