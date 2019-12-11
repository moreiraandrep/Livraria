package br.ufpr.livraria.tableModel;

import br.ufpr.livraria.Autor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AutorTableModel extends AbstractTableModel {
    
    private List<Autor> lista;
    private String[] colunas = {"Nome", "Email", "CPF"};
    
    public AutorTableModel() {
        lista = new ArrayList<>();
    }

    public List<Autor> getLista() {
        return lista;
    }

    public void setLista(List<Autor> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        if (linha >= this.getRowCount()) {
            return null;
        }
        Autor autor = this.lista.get(linha);
        switch(coluna){
            case 0: return autor.getNome();
            case 1: return autor.getEmail();
            case 2: return autor.getCpf();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }
       
}