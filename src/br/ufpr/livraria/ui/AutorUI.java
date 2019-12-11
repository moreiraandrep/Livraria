package br.ufpr.livraria.ui;

import br.ufpr.livraria.Autor;
import br.ufpr.livraria.tableModel.AutorTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.PKIXRevocationChecker;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class AutorUI extends JFrame {
    
    private JButton botaoNovo;
    private JButton botaoEditar;
    private JButton botaoExcluir;
    private JButton botaoSalvar;
    private JButton botaoCancelar;
    private JButton botaoFechar;
    
    private JTextField campoNome;
    private JTextField campoEmail;
    private JTextField campoCpf;
    
    private JTable tabela;
    private AutorTableModel modelo;
    
    public AutorUI() {
        this.setTitle("Cadastro de Autores");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        
        desenhaPainelAcoes();
        desenhaPainelDados();
        desenhaPainelRegistros();
        habilitaEdicao(false);
        inicializaTabela();
    }
    
    private void desenhaPainelAcoes() {
        JPanel painelAcoes = new JPanel();
        painelAcoes.setBorder(new TitledBorder("Ações"));
        painelAcoes.setPreferredSize(new Dimension(800, 60));
        
        botaoNovo = new JButton("Novo");
        botaoEditar = new JButton("Editar");
        botaoExcluir = new JButton("Excluir");
        botaoSalvar = new JButton("Salvar");
        botaoCancelar = new JButton("Cancelar");
        botaoFechar = new JButton("Fechar");
        
        painelAcoes.add(botaoNovo);
        painelAcoes.add(botaoEditar);
        painelAcoes.add(botaoExcluir);
        painelAcoes.add(botaoSalvar);
        painelAcoes.add(botaoCancelar);
        painelAcoes.add(botaoFechar);
        
        botaoNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                habilitaEdicao(true);
            }
        });
        
        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                habilitaEdicao(false);
            }
        });
        
        botaoFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoBotaoFechar(e);
            }
        });
        
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoBotaoSalvar(e);
            }
        });
        
        botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            acaoBotaoEditar(e);
            }
        });
        
        botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoBotaoExcluir(e);
            }
        });
        
        this.add(painelAcoes, BorderLayout.NORTH);
    }
    
    private void desenhaPainelDados() {
        JPanel painelDados = new JPanel();
        painelDados.setBorder(new TitledBorder("Dados"));
        painelDados.setPreferredSize(new Dimension(800, 140));
        
        JLabel rotuloNome = new JLabel("Nome:");
        campoNome = new JTextField(30);
        
        JLabel rotuloEmail = new JLabel("Email:");
        campoEmail = new JTextField(30);
        
        JLabel rotuloCpf = new JLabel("CPF:");
        campoCpf = new JTextField(30);
        
        painelDados.add(rotuloNome);
        painelDados.add(campoNome);
        painelDados.add(rotuloEmail);
        painelDados.add(campoEmail);
        painelDados.add(rotuloCpf);
        painelDados.add(campoCpf);
        
        
        this.add(painelDados, BorderLayout.CENTER);
    }
    
    private void desenhaPainelRegistros() {
        JPanel painelRegistros = new JPanel();
        painelRegistros.setBorder(new TitledBorder("Registros"));
        painelRegistros.setPreferredSize(new Dimension(800, 400));
        
        modelo = new AutorTableModel();
        tabela = new JTable(modelo);
        tabela.setPreferredScrollableViewportSize(new Dimension(780,350));
        
        JScrollPane scroll = new JScrollPane(tabela);
        painelRegistros.add(scroll);
        
        this.add(painelRegistros, BorderLayout.SOUTH);
    }
    
    private void acaoBotaoFechar(ActionEvent e) {
        this.dispose();
    }
    
    private void habilitaEdicao(boolean habilitado) {
        botaoSalvar.setEnabled(habilitado);
        botaoCancelar.setEnabled(habilitado);
        
        botaoNovo.setEnabled(!habilitado);
        botaoEditar.setEnabled(!habilitado);
        botaoExcluir.setEnabled(!habilitado);
        botaoFechar.setEnabled(!habilitado);
        
        campoNome.setEnabled(habilitado);
        campoEmail.setEnabled(habilitado);
        campoCpf.setEnabled(habilitado);
    }
    
    private void inicializaTabela() {
        for (int i = 0; i < 30; i++) {
            String nome = "Autor "+ i;
            String email = "autor" + i + "@gmail.com";
            String cpf = "123" + i;
            modelo.getLista().add(new Autor(nome, email, cpf));
        }
    }
    
    private void acaoBotaoSalvar(ActionEvent e) {
        String nome = campoNome.getText();
        String email = campoEmail.getText();
        String cpf = campoCpf.getText();
        
        modelo.getLista().add(new Autor(nome, email, cpf));
        tabela.repaint();
        
        habilitaEdicao(false);
        
    }
    
    private void acaoBotaoEditar(ActionEvent e) {
        try {
            int linha = tabela.getSelectedRow();
            
            Autor autor = modelo.getLista().get(linha);
            campoNome.setText(autor.getNome());
            campoEmail.setText(autor.getEmail());
            campoCpf.setText(autor.getCpf());
            
            habilitaEdicao(true);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Selecione um registro");
        }
    }
    
    private void acaoBotaoExcluir(ActionEvent e) {
        try {
            int linha = tabela.getSelectedRow();
            int excluir
                    = JOptionPane.showConfirmDialog(this, "Excluir?",
                            "Confirme", JOptionPane.YES_NO_OPTION);
            if (excluir == 0) {
                modelo.getLista().remove(linha);
                tabela.repaint();
            }
        } catch (ArrayIndexOutOfBoundsException  ex) {
            JOptionPane.showMessageDialog(this, "Selecione um registro");
        }
    }
    
}