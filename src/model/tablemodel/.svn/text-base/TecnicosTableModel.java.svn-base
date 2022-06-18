package model.tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Pessoa;

public class TecnicosTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    
    /* Lista de Cliente que representam as linhas. */
    private List<Pessoa> linhas;   
    
    /* Array de Strings com o nome das colunas. */
    private String[] colunas = new String[] {
        "Técnico","Chamados atribuídos" 
    };

    /* Cria um ClienteTableModel vazio. */
    public TecnicosTableModel() {
        linhas = new ArrayList<Pessoa>();        
    }

    /* Cria um ClienteTableModel carregado com
     * a lista de Cliente especificada. */
    public TecnicosTableModel(List<Pessoa> listaDeTecnico) {
        linhas = new ArrayList<Pessoa>(listaDeTecnico);
    }

    /* Retorna a quantidade de colunas. */
    @Override
    public int getColumnCount() {
        // EstÃ¡ retornando o tamanho do array "colunas".
        return colunas.length;
    }

    /* Retorna a quantidade de linhas. */
    @Override
    public int getRowCount() {
        // Retorna o tamanho da lista de Cliente.
        return linhas.size();
    }


    @Override
    public String getColumnName(int columnIndex) {
        // Retorna o conteÃºdo do Array que possui o nome das colunas
        return colunas[columnIndex];
    } 

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            Pessoa tecnico = linhas.get(rowIndex);

        // Retorna o campo referente a coluna especificada.
        // Aqui é feito um switch para verificar qual é a coluna
        // e retornar o campo adequado. As colunas sãoas mesmas
        // que foram especificadas no array "colunas".
        switch (columnIndex) {

            // Seguindo o exemplo: "Tipo","Data de Cadastro", "Nome", "Idade"};
            case 0:
                return tecnico.getNome();
            case 1:
                return tecnico.getChamadosEmAberto();
            default:
                // Isto não deveria acontecer...
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    //modifica na linha e coluna especificada
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Pessoa tecnico = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

        switch (columnIndex) { // Seta o valor do campo respectivo
            case 0:
                tecnico.setNome(aValue.toString());
            case 1:
                tecnico.setChamadosEmAberto((Integer)aValue);
            default:
             // Isto não deveria acontecer...             
        }
        fireTableCellUpdated(rowIndex, columnIndex);
     }

    //modifica na linha especificada
    public void setValueAt(Pessoa aValue, int rowIndex) {
        Pessoa tecnico = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

        tecnico.setNome(aValue.getNome());
        tecnico.setChamadosEmAberto(aValue.getChamadosEmAberto());
           
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }        

    public Pessoa getTecnico(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public int getIdAt(int rowIndex) {
        Pessoa tecnico = linhas.get(rowIndex);
        return tecnico.getId();
    }
    
    /* Adiciona um registro. */
    public void addTecnico(Pessoa tecnico) {
        // Adiciona o registro.
        linhas.add(tecnico);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /* Remove a linha especificada. */
    public Pessoa removeTecnico(int indiceLinha) {
        Pessoa tecnico = linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
        return tecnico;
    }

    /* Adiciona uma lista de Cliente ao final dos registros. */
    public void addListaDeTecnico(List<Pessoa> tecnico) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        linhas.addAll(tecnico);

        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
    
    public void atualizarTecnico(Pessoa tecnico) {
        for (int i=0;i<linhas.size();i++) {
            if (linhas.get(i).getId() == tecnico.getId()) {
                
                linhas.get(i).setNome(tecnico.getNome());
                linhas.get(i).setLogin(tecnico.getLogin());
                linhas.get(i).setTipo(tecnico.getTipo());
                linhas.get(i).setCpf(tecnico.getCpf());               
                
                fireTableRowsUpdated(i, i);
            }
        }        
    }
    
    public void atualizarModelo(List<Pessoa> listaDeTecnico ) {
        limpar();
        addListaDeTecnico(listaDeTecnico);
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