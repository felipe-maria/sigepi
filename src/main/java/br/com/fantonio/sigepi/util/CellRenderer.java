/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fantonio.sigepi.util;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class CellRenderer extends DefaultTableCellRenderer {  

/* 
 * Código retirado de fórum:
 * http://www.guj.com.br/java/55750-jtable---centralizar-o-conteudo-de-uma-celula
 */  
private static final long   serialVersionUID    = 1L;  

    public CellRenderer()   
    {  
        super();  
    }  

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,  
            boolean isSelected, boolean hasFocus, int row, int column) { 
        
        this.setHorizontalAlignment(CENTER);  

        return super.getTableCellRendererComponent(table, value, isSelected,  
                hasFocus, row, column);  
    }  
}  

