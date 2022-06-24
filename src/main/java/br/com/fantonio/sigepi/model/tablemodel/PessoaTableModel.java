package br.com.fantonio.sigepi.model.tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.com.fantonio.sigepi.model.Pessoa;

public class PessoaTableModel extends AbstractTableModel {
    
    private List<Pessoa> linhas;   
    
    private String[] colunas = new String[] {
        "Nome","Login", "Tipo de Usuário", "CPF" 
    };

    public PessoaTableModel(List<Pessoa> listaDePessoa) {
        linhas = new ArrayList<Pessoa>(listaDePessoa);
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    } 
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            Pessoa pessoa = linhas.get(rowIndex);

        switch (columnIndex) {

            case 0:
                return pessoa.getNome();
            case 1:
                return pessoa.getLogin();
            case 2:
                return pessoa.getTipo();
            case 3:
                return pessoa.getCpf();            
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    public Pessoa getPessoa(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public int getIdAt(int rowIndex) {
        Pessoa pessoa = linhas.get(rowIndex);
        return pessoa.getId();
    }
    
    /* Adiciona um registro. */
    public void addPessoa(Pessoa pessoa) {
        // Adiciona o registro.
        linhas.add(pessoa);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /* Remove a linha especificada. */
    public Pessoa removePessoa(int indiceLinha) {
        Pessoa pessoa = linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
        return pessoa;
    }

    /* Adiciona uma lista de Cliente ao final dos registros. */
    public void addListaDePessoa(List<Pessoa> pessoa) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        linhas.addAll(pessoa);

        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
    
    public void atualizarPessoa(Pessoa pessoa) {
        for (int i=0;i<linhas.size();i++) {
            if (linhas.get(i).getId() == pessoa.getId()) {
                
                linhas.get(i).setNome(pessoa.getNome());
                linhas.get(i).setLogin(pessoa.getLogin());
                linhas.get(i).setTipo(pessoa.getTipo());
                linhas.get(i).setCpf(pessoa.getCpf());               
                
                fireTableRowsUpdated(i, i);
            }
        }        
    }
    
    public void atualizarModelo(List<Pessoa> listaDePessoa ) {
        limpar();
        addListaDePessoa(listaDePessoa);
    }

    /* Remove todos os registros. */
    public void limpar() {
        linhas.clear();

        fireTableDataChanged();
    }
   
}