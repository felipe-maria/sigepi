/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fantonio.sigepi.util;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import javax.swing.ImageIcon;

/**
 *
 * @author Felipe
 */
public class Conversor {
 
    
    public static byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        // Get the size of the file
        long length = file.length();

        // You cannot create an array using a long type.
        // It needs to be an int type.
        // Before converting to an int type, check
        // to ensure that file is not larger than Integer.MAX_VALUE.
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
               && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;
     }
     
     public static ImageIcon getImageIconFromByte(byte[] foto) throws Exception {
        if (foto != null) {
            try {
                ImageIcon imageIcon = new ImageIcon(foto);
                Image imagem = imageIcon.getImage().getScaledInstance(140, 140, 1);
                imageIcon.setImage(imagem);
                return imageIcon;
            } catch(Exception e) {
                e.printStackTrace();
                throw new Exception("Erro ao setar a imagem no objeto JIFPessoa");
           }
        } else {
            return null;
        }
     }
     
     
     /*
      * Método encontrado no fórum javafree.uol e adaptado conforme minha necessidade
      * http://javafree.uol.com.br/topic-875440-Calculando-o-numero-de-dias-entre-duas-datas.html
      * Crédito para FilipeNevola e blaine.
      */     
     public static int DiferencaEntreDatas(Calendar ini, Calendar fim) {  
        long dt1 = ini.getTimeInMillis();  
        long dt2 = fim.getTimeInMillis();  
        return (int) (((dt2 - dt1) / 86400000)+1);  
     }  
}
