package br.com.fantonio.sigepi.util;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import br.com.fantonio.sigepi.model.Pessoa;


public class TitularComboModel extends DefaultComboBoxModel {  
  
   private List<Pessoa> pessoas;  
     
   public TitularComboModel(List<Pessoa> pessoas) {  
      this.pessoas = pessoas;  
   }  
     
   @Override  
   public void addElement(Object anObject) {  
      this.pessoas.add((Pessoa)anObject);  
      //notifica o combo que o modelo foi alterado.  
      this.fireIntervalAdded(this, 0, 0);  
   }  
   
   @Override
   public Object getElementAt(int index) {  
      return this.pessoas.get(index);  
   }  
  
   @Override
   public Object getSelectedItem() {  
      return super.getSelectedItem();  
   }  
  
   @Override
   public int getSize() {  
      return this.pessoas.size();  
   }  
}  