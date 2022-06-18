package model.tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Email;

public class EmailTableModel extends AbstractTableModel {
 
    private List<Email> linhas;       
  
    private String[] colunas = new String[] {
        "Endereço","Descrição" 
    };
     
    public EmailTableModel(List<Email> listaDeEmail) {
        linhas = new ArrayList<Email>(listaDeEmail);
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
            Email email = linhas.get(rowIndex);

        switch (columnIndex) {

            case 0:
                return email.getEndereco();
            case 1:
                return email.getDescricao();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    //modifica na linha especificada
    public void setValueAt(Email aValue, int rowIndex) {
        Email email = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

        email.setEndereco(aValue.getEndereco());
        email.setDescricao(aValue.getDescricao());
           
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }        

    public Email getEmail(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public int getIdAt(int rowIndex) {
        Email email = linhas.get(rowIndex);
        return email.getId();
    }    

    /* Adiciona um registro. */
    public void addEmail(Email email) {
        // Adiciona o registro.
        linhas.add(email);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);        
    }

    /* Remove a linha especificada. */
    public Email removeEmail(int indiceLinha) {
        Email email = linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
        return email;
    }

    /* Adiciona uma lista de Cliente ao final dos registros. */
    public void addListaDeEmail(List<Email> email) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        linhas.addAll(email);

        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
    
    public void atualizarEmail(Email email) {
        for (int i=0;i<linhas.size();i++) {
            if (linhas.get(i).getId() == email.getId()) {
                
                linhas.get(i).setEndereco(email.getEndereco());
                linhas.get(i).setDescricao(email.getDescricao());
                
                fireTableRowsUpdated(i, i);
            }
        }        
    }
    
    public void atualizarModelo(List<Email> listaDeEmail ) {
        limpar();
        addListaDeEmail(listaDeEmail);
    }

    /* Remove todos os registros. */
    public void limpar() {
        linhas.clear();

        fireTableDataChanged();
    }

    /* Verifica se este table model esta vazio. */
    public boolean isEmpty() {
        return linhas.isEmpty();
    }    
    
}