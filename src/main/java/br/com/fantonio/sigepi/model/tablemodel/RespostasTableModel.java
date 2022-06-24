package br.com.fantonio.sigepi.model.tablemodel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.com.fantonio.sigepi.model.Pessoa;
import br.com.fantonio.sigepi.model.Resposta;

public class RespostasTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    
    /* Lista de Cliente que representam as linhas. */
    private List<Resposta> linhas;   
    
    /* Array de Strings com o nome das colunas. */
    private String[] colunas = new String[] {
        "Início","Término","Pessoa","Descrição" 
    };

    /* Cria um ClienteTableModel vazio. */
    public RespostasTableModel() {
        linhas = new ArrayList<Resposta>();        
    }

    /* Cria um ClienteTableModel carregado com
     * a lista de Cliente especificada. */
    public RespostasTableModel(List<Resposta> respostas) {
        linhas = respostas;        
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
        Resposta resposta = linhas.get(rowIndex);
                 
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");

        switch (columnIndex) {
            case 0:
                return sdf1.format(resposta.getInicio().getTime()) + " - " +
                       sdf2.format(resposta.getInicio().getTime());
            case 1:
                if (resposta.getTermino() == null) {
                    return "Agindo";
                } else {
                    return sdf1.format(resposta.getTermino().getTime()) + " - " +
                           sdf2.format(resposta.getTermino().getTime()) ;
                }                                  
            case 2:
                return resposta.getRespondente();
            case 3:
                if (resposta.getTermino() == null) {
                    return "Agindo";
                } else {
                    return resposta.getDescricao();
                }
            default:
                // Isto não deveria acontecer...
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    //modifica na linha e coluna especificada
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Resposta resposta = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

        switch (columnIndex) { // Seta o valor do campo respectivo
            case 0:
                resposta.setInicio((Calendar)aValue);
            case 1:                
                resposta.setTermino((Calendar)aValue);
            case 2:
                resposta.setRespondente((Pessoa) aValue);
            case 3:
                resposta.setDescricao(aValue.toString());
            default:
             // Isto não deveria acontecer...             
        }
        fireTableCellUpdated(rowIndex, columnIndex);
     }

    //modifica na linha especificada
    public void setValueAt(Resposta aValue, int rowIndex) {
        Resposta resposta = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado
// "Início","Término","Pessoa","Intervenção","Descrição" 
        resposta.setInicio(aValue.getInicio());
        resposta.setTermino(aValue.getTermino());   
        resposta.setRespondente(aValue.getRespondente());
        resposta.setDescricao(aValue.getDescricao());
        
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }        

    public Resposta getRespostaEJB(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public Long getIdAt(int rowIndex) {
        Resposta resposta = linhas.get(rowIndex);
        return resposta.getId();
    }    

    /* Adiciona um registro. */
    public void addRespostaEJB(Resposta resposta) {
        // Adiciona o registro.
        linhas.add(resposta);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);        
    }

    /* Especial para a RespostaTableModel, não copiar */
    public void refreshLastRow() {
        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);        
    }
    
    /* Remove a linha especificada. */
    public Resposta removeResposta(int indiceLinha) {
        Resposta resposta = linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
        return resposta;
    }
    
    public Resposta removeResposta(Resposta respostaARemover) {
        int indiceLinha = -1; 
        
        for (int k = 0; k < linhas.size(); k++ ){
            if (respostaARemover.equals(linhas.get(k))) {
                indiceLinha = k;
                break;
            }
        }
        return removeResposta(indiceLinha);        
        
    }

    /* Adiciona uma lista de Cliente ao final dos registros. */
    public void addListaDeResposta(List<Resposta> resposta) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        linhas.addAll(resposta);

        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
   
    public void atualizarModelo(List<Resposta> listaDeResposta ) {
        limpar();
        addListaDeResposta(listaDeResposta);
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