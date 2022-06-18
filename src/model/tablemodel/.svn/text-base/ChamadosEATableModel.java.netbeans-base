package model.tablemodel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Chamado;
import model.Pessoa;
import model.Resposta;

public class ChamadosEATableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    
    /* Lista de Cliente que representam as linhas. */
    private List<Chamado> linhas;   
    
    /* Array de Strings com o nome das colunas. */
    private String[] colunas = new String[] {
        "Id","Aberto em","Última resposta","Solicitante","Técnico atribuído", "Chamado" 
    };

    /* Cria um ClienteTableModel vazio. */
    public ChamadosEATableModel() {
        linhas = new ArrayList<Chamado>();        
    }

    /* Cria um ClienteTableModel carregado com
     * a lista de Cliente especificada. */
    public ChamadosEATableModel(List<Chamado> chamados) {
        linhas = chamados;        
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
        Chamado chamado = linhas.get(rowIndex);
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
        String ultimaResposta = "Não posicionado";        
        
        if (chamado.getRespostas() != null) {
            if (!chamado.getRespostas().isEmpty()) {
                Resposta resposta = chamado.getRespostas().get(chamado.getRespostas().size()-1);
                if (!resposta.isAgindo()) {
                    ultimaResposta = sdf1.format(resposta.getTermino().getTime()) + " - " +
                    sdf2.format(resposta.getTermino().getTime());
                } else {
                    ultimaResposta = "agindo";
                }
            }
       } 
            
         
        // Retorna o campo referente a coluna especificada.
        // Aqui é feito um switch para verificar qual é a coluna
        // e retornar o campo adequado. As colunas sãoas mesmas
        // que foram especificadas no array "colunas".
        switch (columnIndex) {

            // Seguindo o exemplo: "Tipo","Data de Cadastro", "Nome", "Idade"};
            case 0:
                return String.valueOf(chamado.getId());
            case 1:
                return sdf1.format(chamado.getDtAbertura().getTime()) + " - " +
                       sdf2.format(chamado.getDtAbertura().getTime());                                  
            case 2:
                return ultimaResposta;
            case 3:
                return chamado.getSolicitante().getNome();                
            case 4:
                if (chamado.getUltimoAtribuido() == null) {
                    return "Aguardando atribuição";
                } else {
                    return chamado.getUltimoAtribuido().getNome();
                }
            case 5:
                return chamado.getDescricao();
            default:
                // Isto não deveria acontecer...
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    //modifica na linha e coluna especificada
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Chamado chamado = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

        switch (columnIndex) { // Seta o valor do campo respectivo
            case 0:
                chamado.setId((Long) aValue);
            case 1:                
                chamado.setDtAbertura((Calendar)aValue);
            case 2:
                chamado.setDtEncerramento((Calendar) aValue);
            case 3:
                chamado.setSolicitante((Pessoa) aValue);
            case 4:
                chamado.setUltimoAtribuido((Pessoa) aValue);
            case 5:
                chamado.setDescricao(aValue.toString());
            default:
             // Isto não deveria acontecer...             
        }
        fireTableCellUpdated(rowIndex, columnIndex);
     }

    //modifica na linha especificada
    public void setValueAt(Chamado aValue, int rowIndex) {        
        Chamado chamado = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

        chamado.setId(aValue.getId());
        chamado.setDtAbertura(aValue.getDtAbertura());
        chamado.setDtEncerramento(aValue.getDtEncerramento());
        chamado.setSolicitante(aValue.getSolicitante());
        chamado.setUltimoAtribuido(aValue.getUltimoAtribuido());
        chamado.setDescricao(aValue.getDescricao());
           
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3); 
        fireTableCellUpdated(rowIndex, 4);
        fireTableCellUpdated(rowIndex, 5); 
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }        

    public Chamado getChamado(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public Long getIdAt(int rowIndex) {
        Chamado chamado = linhas.get(rowIndex);
        return chamado.getId();
    }    

    /* Adiciona um registro. */
    public void addChamado(Chamado chamado) {
        // Adiciona o registro.
        linhas.add(chamado);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);        
    }

    /* Remove a linha especificada. */
    public Chamado removeChamado(int indiceLinha) {
        Chamado chamado = linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
        return chamado;
    }
    
    public Chamado removeChamado(Chamado chamadoARemover) {
        int indiceLinha = -1; 
        
        for (int k = 0; k < linhas.size(); k++ ){
            if (chamadoARemover.equals(linhas.get(k))) {
                indiceLinha = k;
                break;
            }
        }
        return removeChamado(indiceLinha);        
        
    }

    /* Adiciona uma lista de Cliente ao final dos registros. */
    public void addListaDeChamado(List<Chamado> chamado) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        linhas.addAll(chamado);

        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
   
    public void atualizarModelo(List<Chamado> listaDeChamado ) {
        limpar();
        addListaDeChamado(listaDeChamado);
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