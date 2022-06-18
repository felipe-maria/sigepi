/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Felipe
 */
public class ValidadorCPF {
    
    public static boolean validarCPF(final String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            return false;
        }
        
        String strAux;
        String digitoEnviado;
        String digitoComputado;
                
        strAux = StringUtils.remove(cpf, ".");
        strAux = StringUtils.remove(strAux, "-");
        
        digitoEnviado = StringUtils.substring(strAux, 9);
        
        strAux = StringUtils.substring(strAux, 0, 9);
              
        Integer digito1;
        Integer digito2;
              
        int aux;
        int soma = 0;
        for (int i = 0; i < strAux.length(); i++) {
            Character caux = strAux.charAt(i);
            aux = Integer.valueOf(caux.toString());
            soma = soma + aux * (i+1);
        }
        digito1 = soma % 11;
        if (digito1 == 10) {
            digito1 = 0; 
        }
        
        strAux = strAux + digito1;
        soma = 0;
        for (int i = 0; i < strAux.length(); i++) {
            Character caux = strAux.charAt(i);
            aux = Integer.valueOf(caux.toString());
            soma = soma + aux * (i);
        }
        digito2 = soma % 11;
        if (digito2 == 10) {
            digito2 = 0; 
        }

        digitoComputado = digito1.toString() + digito2.toString();
        
        if (digitoComputado.equals(digitoEnviado)) {
            return true;
        } else {
            return false;
        }
    }
}
