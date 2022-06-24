package br.com.fantonio.sigepi.model.tablemodel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import br.com.fantonio.sigepi.model.Certificado;
import br.com.fantonio.sigepi.util.Conversor;

public class CertificadoTableModel extends AbstractTableModel {
    
    private List<Certificado> linhas;   
    
    /* Array de Strings com o nome das colunas. */
    private String[] colunas = new String[] {
        "Titular", "Segmento", "Categoria", "Mídia", 
        "Certificadora", "Expedição", "Vencimento", "Dias restantes"            
    };

    /* Cria um ClienteTableModel vazio. */
    public CertificadoTableModel() {
        linhas = new ArrayList<Certificado>();        
    }

    /* Cria um ClienteTableModel carregado com
     * a lista de Cliente especificada. */
    public CertificadoTableModel(List<Certificado> listaDeCertificado) {
        linhas = new ArrayList<Certificado>(listaDeCertificado);
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
        Certificado certificado = linhas.get(rowIndex);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");        
        
        // Retorna o campo referente a coluna especificada.
        // Aqui é feito um switch para verificar qual é a coluna
        // e retornar o campo adequado. As colunas sãoas mesmas
        // que foram especificadas no array "colunas".
        switch (columnIndex) {
            
            // Seguindo o exemplo: "Tipo","Data de Cadastro", "Nome", "Idade"};
            case 0:
                return certificado.getTitular().getNome();
            case 1:
                return certificado.getSegmento();
            case 2:
                return certificado.getCategoria();
            case 3:
                return certificado.getMidia();
            case 4:
                return certificado.getCertificadora();
            case 5:
                return sdf.format(new Date(certificado.getExpedicao().getTimeInMillis())); 
            case 6:
                return sdf.format(new Date(certificado.getVencimento().getTimeInMillis()));
            case 7:
                if (certificado.isVencido()) {
                    return "VENCIDO";                   
                } else {
                    Calendar vencimento = Calendar.getInstance();
                    vencimento.setTimeInMillis(certificado.getVencimento().getTimeInMillis());
                    Calendar atual = Calendar.getInstance();
                    
                    switch (vencimento.compareTo(atual)) {                        
                        case -1: 
                            return "VENCIDO";
                        case  0: 
                            return "VENCIDO";
                        case  1: 
                            return Conversor.DiferencaEntreDatas(atual, vencimento);                            
                    }
                }                
            default:
                // Isto não deveria acontecer...
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    //modifica na linha e coluna especificada
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Certificado certificado = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

        switch (columnIndex) { // Seta o valor do campo respectivo
            case 0:
                certificado.getTitular().setNome(aValue.toString());
            case 1:
                certificado.setSegmento(aValue.toString());
            case 2:
                certificado.setCategoria(aValue.toString());           
            case 3:
                certificado.setMidia(aValue.toString());
            case 4:
                certificado.setCertificadora(aValue.toString());
            case 5: 
                certificado.setExpedicao((Calendar)aValue);
            case 6:
                certificado.setVencimento((Calendar)aValue);                
            default:
                JOptionPane.showMessageDialog(null, "Deu pane no método setValueAt no tableModel");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
     }

    //modifica na linha especificada
    public void setValueAt(Certificado aValue, int rowIndex) {
        Certificado certificado = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

        certificado.getTitular().setNome(aValue.getTitular().getNome());
        certificado.setSegmento(aValue.getSegmento());
        certificado.setCategoria(aValue.getCategoria());
        certificado.setMidia(aValue.getMidia());
        certificado.setCertificadora(aValue.getCertificadora());
        certificado.setExpedicao(aValue.getExpedicao());
        certificado.setVencimento(aValue.getVencimento());
        certificado.setVencido(aValue.isVencido());
        
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3); 
        fireTableCellUpdated(rowIndex, 4);
        fireTableCellUpdated(rowIndex, 5);
        fireTableCellUpdated(rowIndex, 6);
        fireTableCellUpdated(rowIndex, 7);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }        

    public Certificado getCertificado(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public int getIdAt(int rowIndex) {
        Certificado certificado = linhas.get(rowIndex);
        return certificado.getId();
    }
    
    /* Adiciona um registro. */
    public void addCertificado(Certificado certificado) {
        // Adiciona o registro.
        linhas.add(certificado);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }    
    
    /* Remove a linha especificada. */
    public Certificado removeCertificado(int indiceLinha) {
        Certificado certificado = linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
        return certificado;
    }   
   

    /* Adiciona uma lista de Cliente ao final dos registros. */
    public void addListaDeCertificado(List<Certificado> certificados) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        linhas.addAll(certificados);
        
        int tamanhoAtual = getRowCount() -1;

        fireTableRowsInserted(tamanhoAntigo, tamanhoAtual );
    }
    
    public void atualizarCertificado(Certificado certificado) {
        for (int i=0;i<linhas.size();i++) {
            if (linhas.get(i).getId() == certificado.getId()) {
                
                linhas.get(i).getTitular().setNome(certificado.getTitular().getNome());
                linhas.get(i).setSegmento(certificado.getSegmento());
                linhas.get(i).setCategoria(certificado.getCategoria());
                linhas.get(i).setMidia(certificado.getMidia());
                linhas.get(i).setCertificadora(certificado.getCertificadora());
                linhas.get(i).setExpedicao(certificado.getExpedicao());
                linhas.get(i).setVencimento(certificado.getVencimento());
                linhas.get(i).setVencido(certificado.isVencido());
                
                fireTableRowsUpdated(i, i);
            }
        }        
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
    
    public void atualizarModelo(List<Certificado> listaDeCertificado ) {
        limpar();
        addListaDeCertificado(listaDeCertificado);
    }
    
    public void todosRegistros(List<Certificado> listaDeCertificado) {
        atualizarModelo(listaDeCertificado);
    }
    
    public void somenteVencidos(List<Certificado> listaDeCertificado) {
        atualizarModelo(listaDeCertificado);
        Iterator iterator = linhas.iterator();
        while (iterator.hasNext()) {
            Certificado cert = (Certificado) iterator.next();
            if (!cert.isVencido()) {
                iterator.remove();
            }
        }
    }
    
    public void somenteValidos(List<Certificado> listaDeCertificado) {
        atualizarModelo(listaDeCertificado);
        Iterator iterator = linhas.iterator();
        while (iterator.hasNext()) {
            Certificado cert = (Certificado) iterator.next();
            if (cert.isVencido()) {
                iterator.remove();
            }
        }        
    }
}